package com.it_zoo.kostya05983.auto_aliance.activities

import android.os.Bundle
import com.it_zoo.kostya05983.auto_aliance.R
import kotlinx.android.synthetic.main.activity_rent_car.*

class RentCarActivity : AbstractNavigation() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rent_car)
        nav_view_rent_car.setNavigationItemSelectedListener(this)
    }
}
