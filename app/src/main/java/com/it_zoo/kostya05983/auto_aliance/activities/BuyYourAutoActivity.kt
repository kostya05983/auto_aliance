package com.it_zoo.kostya05983.auto_aliance.activities

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.telephony.TelephonyManager
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
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
        val alert = AlertDialog.Builder(this)

        alert.setTitle("Введите номер телефона")
        alert.setMessage("Номер телефона")

        val input = EditText(this)
        alert.setView(input)

        alert.setPositiveButton("Ок", DialogInterface.OnClickListener { dialog, whichButton ->
            val message = String.format("Город: %s\nЦель:Купить мне автомобиль\nТелефон: %s",city,
                    input.text.toString())

            Thread(Runnable {
                val mail = Mail()
                mail.set_to(arrayOf("avtoalians.org@yandex.ru"))
                mail.send(message)
            }).start()

        })

        alert.setNegativeButton("Отмена", DialogInterface.OnClickListener { dialog, whichButton ->
            Toast.makeText(this, "Необходимо ввести номер телефона", Toast.LENGTH_SHORT).show()
        })

        alert.show()
    }
}
