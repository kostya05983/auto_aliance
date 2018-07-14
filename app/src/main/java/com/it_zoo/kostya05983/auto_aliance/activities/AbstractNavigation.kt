package com.it_zoo.kostya05983.auto_aliance.activities

import android.content.Intent
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.it_zoo.kostya05983.auto_aliance.R
import kotlinx.android.synthetic.main.activity_cities.*


abstract class AbstractNavigation : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        //handle navigation view item here
        when(item.itemId) {
            R.id.nav_lease_auto -> {
                val intent = Intent(this, ChooseLeaseAutoActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_buy_your_auto -> {
                val intent = Intent(this, BuyYourAutoActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_franchising -> {
                val intent = Intent(this, FranchisingActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_rent_car -> {
                val intent = Intent(this, RentCarActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_auto_parts -> {
                val intent = Intent(this, AutoPartsActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_view_choose_lease_auto -> {
                val intent = Intent(this,ChooseLeaseAutoActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_view_lease_car_with_driver -> {
                val intent = Intent(this, LeaseAutoActivityWithDriver::class.java)
                startActivity(intent)
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}