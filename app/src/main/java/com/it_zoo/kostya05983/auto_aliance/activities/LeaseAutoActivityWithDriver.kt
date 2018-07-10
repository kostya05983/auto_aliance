package com.it_zoo.kostya05983.auto_aliance.activities

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.it_zoo.kostya05983.auto_aliance.DataCarSecondGrid
import com.it_zoo.kostya05983.auto_aliance.R
import kotlinx.android.synthetic.main.activity_lease_auto_with_driver.*

class LeaseAutoActivityWithDriver : AbstractNavigation() {
    private val _mThumbIdsSecondGrid: MutableList<DataCarSecondGrid> = mutableListOf()
    private val mThumbIdsSecondGrid: List<DataCarSecondGrid> = _mThumbIdsSecondGrid

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
            priceTextView.text = String.format("Цена: %s руб/ч (до 6 ч.) | %s руб/ч (свыше 6 ч.)",mThumbIdsSecondGrid[position].priceToSix,mThumbIdsSecondGrid[position].priceAfterSix.toString())

            return grid
        }

        override fun getItem(p0: Int): Any? = null

        override fun getItemId(p0: Int): Long = 0L

        override fun getCount(): Int = mThumbIdsSecondGrid.size
    }
}
