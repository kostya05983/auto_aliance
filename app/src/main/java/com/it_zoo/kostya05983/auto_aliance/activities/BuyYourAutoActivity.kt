package com.it_zoo.kostya05983.auto_aliance.activities

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.telephony.TelephonyManager
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.it_zoo.kostya05983.auto_aliance.Mail
import com.it_zoo.kostya05983.auto_aliance.R
import kotlinx.android.synthetic.main.activity_buy_auto_for_you.*

class BuyYourAutoActivity : AbstractNavigation() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_buy_auto_for_you)
        nav_view_buy_your_auto.setNavigationItemSelectedListener(this)
    }

    fun buyAutoCall(view: View) {
        val city = intent.getStringExtra("city")
        val telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            val line1Number = telephonyManager.line1Number

            val message = String.format("Город: %s\nЦель:Купить мне автомобиль\nТелефон: %s",city,
                    line1Number)
            Thread(Runnable {
                val mail = Mail()
                mail.set_to(arrayOf("avtoalians.org@yandex.ru"))
                mail.send(message)

            }).start()
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_PHONE_STATE),
                    2)
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_PHONE_STATE),
                    2)
        }
    }
}
