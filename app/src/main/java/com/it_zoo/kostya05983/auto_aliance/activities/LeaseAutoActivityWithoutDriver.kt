package com.it_zoo.kostya05983.auto_aliance.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.telephony.TelephonyManager
import android.view.*
import android.widget.*
import com.it_zoo.kostya05983.auto_aliance.R
import kotlinx.android.synthetic.main.activity_lease_auto_without_driver.*
import com.it_zoo.kostya05983.auto_aliance.DataCarFirstGrid
import com.it_zoo.kostya05983.auto_aliance.Mail

class LeaseAutoActivityWithoutDriver : AbstractNavigation() {
    private val _mThumbIdsFirstGrid: MutableList<DataCarFirstGrid> = mutableListOf();
    private val mThumbIdsFirstGrid: List<DataCarFirstGrid> = _mThumbIdsFirstGrid



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_lease_auto_without_driver)
        fill()

        grid_view_lease_car.adapter = CarViewAdapterFirstGrid(this)
        nav_view_lease_car_without_driver.setNavigationItemSelectedListener(this)
    }

    private fun fill() {
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Opel Astra J 1.4 AT 2015 г.в.", R.drawable.opel_astra_change, 1500)) // true
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Toyota Corolla new", R.drawable.toyota_corolla_change, 1800)) // true
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Toyota Camry new", R.drawable.camry_hybryd_se_change, 2300)) // true
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Toyota LC 200 new", R.drawable.toyota_land_cruiser_change, 7100)) // true
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Kia Optima new", R.drawable.kia_optima_change, 3300)) // true
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Kia Rio new", R.drawable.kia_rio_new_change, 1500)) // true
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Kia Ceed new", R.drawable.kia_seed_change, 1600))// true
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Toyota Prius", R.drawable.car_new_prius_change, 1500)) // true
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Hyundai I20  1.4 MT 2016 г.в. ", R.drawable.hyunday_i20_change, 1200)) // true
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Hyundai Solaris new ", R.drawable.car_solaris_change, 1500)) // true
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Hyundai Tucson new", R.drawable.hunday_tucson, 2200))// no have image of this car?//this image trouble!
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Kia Cerato new ", R.drawable.kia_serato_change, 1800))// true
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Toyota RAV4", R.drawable.car_toyota, 2300))// true
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Kia Sportage new", R.drawable.kio_sportage_change, 2500))//  true


    }

    fun orderWithoutDriver(view: View) {
        val city = intent.getStringExtra("city")
        val choice = intent.getStringExtra("choice")
        val button = view as Button
        val linearLayout = button.parent as LinearLayout
        val nameTextView = linearLayout.getChildAt(1) as TextView
        val priceTextView = linearLayout.getChildAt(2) as TextView
        //TODO формируем сообщение и отправляем
        val telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        if ( ContextCompat.checkSelfPermission( this, android.Manifest.permission.READ_PHONE_STATE ) == PackageManager.PERMISSION_GRANTED ) {
            val line1Number = telephonyManager.line1Number

            val message = String.format("Город: %s,\nВыбрано: %s,\nНазвание автомобиля: %s\nЦена: %s\nТелефон: %s",
                    city,choice,nameTextView.text,priceTextView.text,line1Number)
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


    inner class CarViewAdapterFirstGrid(private val mContext: Context) : BaseAdapter() {
        @SuppressLint("SetTextI18n")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var grid: View
            if (convertView == null) {
                grid = View(mContext)
                val inflater: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                grid = inflater.inflate(R.layout.cell_first_grid, parent, false)
            } else {
                grid = convertView
            }

            val imageView = grid.findViewById<ImageView>(R.id.grid_first_image_part)
            imageView.setImageResource(mThumbIdsFirstGrid[position].id)


            val nameTextView = grid.findViewById<TextView>(R.id.grid_first_name_car)
            nameTextView.text = mThumbIdsFirstGrid[position].name

            val priceTextView = grid.findViewById<TextView>(R.id.grid_first_price_car)
            priceTextView.text = String.format("%s руб./сут.",mThumbIdsFirstGrid[position].price)

            val button = grid.findViewById<Button>(R.id.grid_first_buy_button)


            return grid;
        }

        override fun getItem(p0: Int): Any? = null

        override fun getItemId(p0: Int): Long = 0L

        override fun getCount(): Int = mThumbIdsFirstGrid.size

    }



}
