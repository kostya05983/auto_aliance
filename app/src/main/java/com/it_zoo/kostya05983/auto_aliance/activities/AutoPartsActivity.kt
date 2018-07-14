package com.it_zoo.kostya05983.auto_aliance.activities

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.it_zoo.kostya05983.auto_aliance.R
import kotlinx.android.synthetic.main.activity_auto_parts.*

class AutoPartsActivity : AbstractNavigation() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_auto_parts)
        nav_view_auto_parts.setNavigationItemSelectedListener(this)

    }

}
