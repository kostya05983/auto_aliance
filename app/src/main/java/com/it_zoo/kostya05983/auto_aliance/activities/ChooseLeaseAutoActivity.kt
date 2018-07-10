package com.it_zoo.kostya05983.auto_aliance.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.it_zoo.kostya05983.auto_aliance.R

class ChooseLeaseAutoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_lease_auto)
    }

    fun withDriverOnClick() {
        val intent = Intent(this,LeaseAutoActivityWithDriver::class.java)
        startActivity(intent)
    }

    fun withoutDriverOnClick() {
        val intent = Intent(this,LeaseAutoActivityWithoutDriver::class.java)
        startActivity(intent)
    }




}
