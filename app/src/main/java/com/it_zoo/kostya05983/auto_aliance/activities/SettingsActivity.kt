package com.it_zoo.kostya05983.auto_aliance.activities

import android.os.Bundle
import com.it_zoo.kostya05983.auto_aliance.R
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AbstractNavigation() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        nav_view_settings.setNavigationItemSelectedListener(this)
    }

}
