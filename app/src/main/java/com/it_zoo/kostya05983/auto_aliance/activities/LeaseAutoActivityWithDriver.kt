package com.it_zoo.kostya05983.auto_aliance.activities

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.*
import com.it_zoo.kostya05983.auto_aliance.DataCarSecondGrid
import com.it_zoo.kostya05983.auto_aliance.Mail
import com.it_zoo.kostya05983.auto_aliance.R
import kotlinx.android.synthetic.main.activity_lease_auto_with_driver.*
import android.telephony.TelephonyManager
import android.view.*


class LeaseAutoActivityWithDriver : AbstractNavigation() {
    private val _mThumbIdsSecondGrid: MutableList<DataCarSecondGrid> = mutableListOf()
    private val mThumbIdsSecondGrid: List<DataCarSecondGrid> = _mThumbIdsSecondGrid

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_lease_auto_with_driver)
        fill()

        grid_view_lease_car_with_driver.adapter = CarViewAdapterSecondGrid(this)
        nav_view_lease_car_with_driver.setNavigationItemSelectedListener(this)

    }

    fun fill() {

        _mThumbIdsSecondGrid.add(DataCarSecondGrid("Hyundai Solaris 2015", R.drawable.car_solaris_2_change, 650, 460)) //true
        _mThumbIdsSecondGrid.add(DataCarSecondGrid("Kia Rio Седан 2013 ", R.drawable.kia_hd_change, 650, 460)) //true
        _mThumbIdsSecondGrid.add(DataCarSecondGrid("Toyota Corolla new 2014", R.drawable.toyota_altis_change, 1050, 740)) //true
        _mThumbIdsSecondGrid.add(DataCarSecondGrid("Hyundai ix35 4WD 2013", R.drawable.car_ix35_changed, 1050, 800)) //true
        _mThumbIdsSecondGrid.add(DataCarSecondGrid("Nissan Juke 2013", R.drawable.mercedes_benz_change, 1050, 770)) //no have image
        _mThumbIdsSecondGrid.add(DataCarSecondGrid("Infiniti FX-37 2012", R.drawable.infinity_fx_5_change, 1750, 1550)) //true
        _mThumbIdsSecondGrid.add(DataCarSecondGrid("KIA Optima 2013", R.drawable.kia_optima_k5_change, 2100, 1900)) //true
        _mThumbIdsSecondGrid.add(DataCarSecondGrid("Toyota Camry 2013", R.drawable.camry_hybryd_se_change, 1350, 1250)) //true
        _mThumbIdsSecondGrid.add(DataCarSecondGrid("Toyota Camry New 2015", R.drawable.toyota_camry_hybrid_change, 1410, 1000)) //true
        _mThumbIdsSecondGrid.add(DataCarSecondGrid("Cadillac Escalade 2012", R.drawable.camry_hybryd_se_change, 2500, 1750)) //true
        _mThumbIdsSecondGrid.add(DataCarSecondGrid("Hyundai Genesis 2015", R.drawable.genesis_change, 2500, 2350)) //true
        _mThumbIdsSecondGrid.add(DataCarSecondGrid("Infiniti QX56 2013", R.drawable.infinity_change, 2700, 2350)) //true
        _mThumbIdsSecondGrid.add(DataCarSecondGrid("Mercedes-Benz G500", R.drawable.mercedes_benz_change, 2500, 2200)) //true
    }

    fun orderWithDriver(view: View) {
        val city = intent.getStringExtra("city")
        val choice = intent.getStringExtra("choice")
        val button = view as Button
        val linearLayout = button.parent as LinearLayout
        val nameTextView = linearLayout.getChildAt(1) as TextView
        val priceTextView = linearLayout.getChildAt(2) as TextView
        val telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        if ( ContextCompat.checkSelfPermission( this, android.Manifest.permission.READ_PHONE_STATE ) == PackageManager.PERMISSION_GRANTED ) {
            val line1Number = telephonyManager.line1Number

            val message = String.format("Город: %s,\nВыбрано: %s,\nНазвание автомобиля: %s\nЦена: %s\nТелефон: %s",
                    city,choice,nameTextView.text,priceTextView.text,line1Number)
            //TODO формируем сообщение и отправляем
            Thread(Runnable {
                val mail = Mail()
                mail.set_to(arrayOf("avtoalians.org@yandex.ru"))
                mail.send(message)

            }).start()
            ActivityCompat.requestPermissions( this, arrayOf( android.Manifest.permission.READ_PHONE_STATE) ,
                    2)
        } else {
            ActivityCompat.requestPermissions( this, arrayOf( android.Manifest.permission.READ_PHONE_STATE) ,
                    2)
        }
    }

    inner class CarViewAdapterSecondGrid(private val mContext: Context) : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var grid: View
            if( convertView == null) {
                grid = View(mContext)
                val inflater: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                grid = inflater.inflate(R.layout.cell_second_grid,parent,false)
            } else {
                grid = convertView
            }

            val imageView = grid.findViewById<ImageView>(R.id.grid_second_image_part)
            imageView.setImageResource(mThumbIdsSecondGrid[position].id)

            val nameTextView = grid.findViewById<TextView>(R.id.grid_second_name_car)
            nameTextView.text = mThumbIdsSecondGrid[position].name

            val priceTextView = grid.findViewById<TextView>(R.id.grid_second_price_car)
            priceTextView.text = String.format("Цена: %s руб/ч  (до 6 ч.) \n%s руб/ч (свыше 6 ч.)",mThumbIdsSecondGrid[position].priceToSix,mThumbIdsSecondGrid[position].priceAfterSix.toString())

            return grid
        }

        override fun getItem(p0: Int): Any? = null

        override fun getItemId(p0: Int): Long = 0L

        override fun getCount(): Int = mThumbIdsSecondGrid.size
    }
}
