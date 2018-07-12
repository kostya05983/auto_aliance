package com.it_zoo.kostya05983.auto_aliance.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.it_zoo.kostya05983.auto_aliance.R
import kotlinx.android.synthetic.main.activity_cities.*

class CitiesActivity : AbstractNavigation() {
    private val _mThumbIdsList: MutableList<String> = mutableListOf()
    private val mThumbIdsList: List<String> = _mThumbIdsList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)
        fill()
        nav_view_cities.setNavigationItemSelectedListener(this)
        list_view_choose_city.adapter = CitiesAdapter(this)

    }

    private fun fill() {
        _mThumbIdsList.add("Новосибирск")
        _mThumbIdsList.add("Кемерово")
        _mThumbIdsList.add("Томск")
        _mThumbIdsList.add("Омск")
        _mThumbIdsList.add("Красноярск")
        _mThumbIdsList.add("Челябинск")
    }

    fun chooseCity(view:View) {
        val intent = Intent(this,ChooseLeaseAutoActivity::class.java)
        val textView = view as TextView
        intent.putExtra("city",textView.text)
        startActivity(intent)
    }

    inner class CitiesAdapter(private val mContext: Context): BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var list: View
            if (convertView == null) {
                list = View(mContext)
                val inflater: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                list = inflater.inflate(R.layout.cell_list_view_choose_city, parent, false)
            } else {
                list = convertView
            }
            val city = list.findViewById<TextView>(R.id.city_choose)
            city.text = mThumbIdsList[position]
            return list;
        }

        override fun getItem(p0: Int): Any? = null

        override fun getItemId(p0: Int): Long = 0L

        override fun getCount(): Int = mThumbIdsList.size
    }


}
