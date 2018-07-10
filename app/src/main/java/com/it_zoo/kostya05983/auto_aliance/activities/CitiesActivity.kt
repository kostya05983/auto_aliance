package com.it_zoo.kostya05983.auto_aliance.activities

import android.os.Bundle
import android.support.v4.view.GravityCompat
import com.it_zoo.kostya05983.auto_aliance.R
import kotlinx.android.synthetic.main.activity_cities.*

class CitiesActivity : AbstractNavigation() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)

//        nav_v
        nav_view_cities.setNavigationItemSelectedListener(this)
    }

//    override fun onBackPressed() {
//        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
//            drawer_layout.closeDrawer(GravityCompat.START)
//        } else {
//            super.onBackPressed()
//        }
//    }


}
