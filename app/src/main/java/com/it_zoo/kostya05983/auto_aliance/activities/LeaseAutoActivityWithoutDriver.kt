package com.it_zoo.kostya05983.auto_aliance.activities

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.it_zoo.kostya05983.auto_aliance.R
import kotlinx.android.synthetic.main.activity_lease_auto_without_driver.*
import com.it_zoo.kostya05983.auto_aliance.DataCarFirstGrid

class LeaseAutoActivityWithoutDriver : AbstractNavigation() {
    private val _mThumbIdsFirstGrid: MutableList<DataCarFirstGrid> = mutableListOf();
    private val mThumbIdsFirstGrid: List<DataCarFirstGrid> = _mThumbIdsFirstGrid



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lease_auto_without_driver)
        fill()

        grid_view_lease_car.adapter = CarViewAdapterFirstGrid(this)

        nav_view_lease_car_without_driver.setNavigationItemSelectedListener(this)

    }

    private fun fill() {
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Opel Astra J 1.4 AT 2015 г.в.", R.drawable.opel_astra, 1500))
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Toyota Corolla new", R.drawable.toyota_corolla, 1800))
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Toyota Camry new", R.drawable.camry_hybrid_se, 2300))
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Toyota LC 200 new", R.drawable.car_tayouta, 7100))
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Kia Optima new", R.drawable.camry_hybrid_se, 3300))
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Kia Rio new", R.drawable.camry_hybrid_se, 1500))
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Kia Ceed new", R.drawable.camry_hybrid_se, 1600))
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Toyota Prius", R.drawable.camry_hybrid_se, 1500))
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Hyundai I20  1.4 MT 2016 г.в. ", R.drawable.camry_hybrid_se, 1200))
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Hyundai Solaris new ", R.drawable.camry_hybrid_se, 1500))
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Hyundai Tucson new", R.drawable.camry_hybrid_se, 2200))
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Kia Cerato new ", R.drawable.camry_hybrid_se, 1800))
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Toyota RAV4", R.drawable.camry_hybrid_se, 2300))
        _mThumbIdsFirstGrid.add(DataCarFirstGrid("Kia Sportage new", R.drawable.camry_hybrid_se, 2500))


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
