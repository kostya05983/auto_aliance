package com.it_zoo.kostya05983.auto_aliance.activities

import android.app.AlertDialog
import android.content.Intent
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.it_zoo.kostya05983.auto_aliance.R
import kotlinx.android.synthetic.main.activity_cities.*
import android.content.DialogInterface
import android.widget.EditText
import android.widget.Toast


abstract class AbstractNavigation : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        //handle navigation view item here
        when(item.itemId) {
            R.id.nav_lease_auto -> {
                val city = intent.getStringExtra("city")
                val intent = Intent(this, ChooseLeaseAutoActivity::class.java)
                intent.putExtra("city",city)
                startActivity(intent)
            }
            R.id.nav_buy_your_auto -> {
                val city = intent.getStringExtra("city")
                val intent = Intent(this, BuyYourAutoActivity::class.java)
                intent.putExtra("city",city)
                startActivity(intent)
            }
            R.id.nav_franchising -> {
                val city = intent.getStringExtra("city")
                val intent = Intent(this, FranchisingActivity::class.java)
                intent.putExtra("city",city)
                startActivity(intent)
            }
            R.id.nav_rent_car -> {
                val city = intent.getStringExtra("city")
                val intent = Intent(this, RentCarActivity::class.java)
                intent.putExtra("city",city)
                startActivity(intent)
            }
            R.id.nav_auto_parts -> {
                val city = intent.getStringExtra("city")
                val intent = Intent(this, AutoPartsActivity::class.java)
                intent.putExtra("city",city)
                startActivity(intent)
            }
            R.id.nav_view_choose_lease_auto -> {
                val city = intent.getStringExtra("city")
                val intent = Intent(this,ChooseLeaseAutoActivity::class.java)
                intent.putExtra("city",city)
                startActivity(intent)
            }
            R.id.nav_view_lease_car_with_driver -> {
                val city = intent.getStringExtra("city")
                val intent = Intent(this, LeaseAutoActivityWithDriver::class.java)
                intent.putExtra("city",city)
                startActivity(intent)
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun phoneNumber() {

    }
}