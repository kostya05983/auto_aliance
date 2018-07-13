package com.it_zoo.kostya05983.auto_aliance.activities

import android.os.Bundle
import com.it_zoo.kostya05983.auto_aliance.R
import kotlinx.android.synthetic.main.activity_buy_your_auto.*

class BuyYourAutoActivity : AbstractNavigation() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_your_auto)
        nav_view_buy_your_auto.setNavigationItemSelectedListener(this)
    }
}
