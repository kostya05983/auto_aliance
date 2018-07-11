package com.it_zoo.kostya05983.auto_aliance.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.it_zoo.kostya05983.auto_aliance.R
import kotlinx.android.synthetic.main.activity_choose_lease_auto.*

class ChooseLeaseAutoActivity : AbstractNavigation() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_lease_auto)
        nav_view_choose_lease_auto.setNavigationItemSelectedListener(this)
    }

    fun withDriverOnClick(view: View) {
        val intent = Intent(this,LeaseAutoActivityWithDriver::class.java)
        startActivity(intent)
    }

    fun withoutDriverOnClick(view:View) {
        val intent = Intent(this,LeaseAutoActivityWithoutDriver::class.java)
        startActivity(intent)
    }




}
