package com.it_zoo.kostya05983.auto_aliance.activities

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.telephony.TelephonyManager
import android.view.*
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.it_zoo.kostya05983.auto_aliance.Mail
import com.it_zoo.kostya05983.auto_aliance.R
import com.it_zoo.kostya05983.auto_aliance.RentData
import kotlinx.android.synthetic.main.activity_rent_car.*
import kotlinx.android.synthetic.main.cell_rent_auto.*

class RentCarActivity : AbstractNavigation() {
    private val _mThumbIdsList: MutableList<RentData> = mutableListOf()
    private val mThumbIdsList: List<RentData> = _mThumbIdsList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_rent_car)
        fill()
        list_view_rent_cart.divider = null
        list_view_rent_cart.dividerHeight = 0
        nav_view_rent_car.setNavigationItemSelectedListener(this)
        list_view_rent_cart.adapter = TextBlockAdapter(this)
    }

    private fun fill() {
        _mThumbIdsList.add(RentData("Хороший заработок", "Дополнительный заработок составит от 15 000 до 60 000 рублей в месяц;"))
        _mThumbIdsList.add(RentData("Отслеживание по GPS", "Вы можете осуществлять GPS-мониторинг за своим автомобилем;"))
        _mThumbIdsList.add(RentData("Быстрое оформление", "Для оформления необходимы 2 документа — паспорт, свидетельство о регистрации автомобиля;"))
        _mThumbIdsList.add(RentData("Варианты аренды", "Варианты на выбор: аренда или аренда с правом выкупа-еще выгоднее;"))
        _mThumbIdsList.add(RentData("Сроки аренды автомобиля", "Срок аренды автомобиля от 3 месяцев до 36 месяцев;"))
        _mThumbIdsList.add(RentData("Защита от регистрации", "Арендуем автомобили с запретом на регистрационные действия;"))
    }

    fun rentCar(view: View) {
        val city = intent.getStringExtra("city")
        val alert = AlertDialog.Builder(this)

        alert.setTitle("Введите номер телефона")
        alert.setMessage("Номер телефона")

        val input = EditText(this)
        alert.setView(input)

        alert.setPositiveButton("Ок", DialogInterface.OnClickListener { dialog, whichButton ->
            val message = String.format("Город: %s\nЦель:Сдать свой автомобиль\nТелефон: %s",city,
                    input.text.toString())

            Thread(Runnable {
                val mail = Mail()
                mail.set_to(arrayOf("avtoalians.org@yandex.ru"))
                mail.send(message)
            }).start()

        })

        alert.setNegativeButton("Отмена", DialogInterface.OnClickListener { dialog, whichButton ->
            Toast.makeText(this, "Необходимо ввести номер телефона", Toast.LENGTH_SHORT).show()
        })

        alert.show()
    }

    inner class TextBlockAdapter(private val mContext: Context) : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var list: View
            if (convertView == null) {
                list = View(mContext)
                val inflater: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                list = inflater.inflate(R.layout.cell_rent_auto, parent, false)
            } else {
                list = convertView
            }
            val headerTextView = list.findViewById<TextView>(R.id.header_rent_car)
            headerTextView.text = mThumbIdsList[position].header
            val textTextView = list.findViewById<TextView>(R.id.text_rent_car)
            textTextView.text = mThumbIdsList[position].text

            return list;
        }

        override fun getItem(p0: Int): Any? = null

        override fun getItemId(p0: Int): Long = 0L

        override fun getCount(): Int = mThumbIdsList.size
    }

}
