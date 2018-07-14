package com.it_zoo.kostya05983.auto_aliance.activities

import android.app.DownloadManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.it_zoo.kostya05983.auto_aliance.R
import kotlinx.android.synthetic.main.activity_auto_parts.*


class AutoPartsActivity : AbstractNavigation() {

    var enqueue: Long = 0
    lateinit var downloadManager: DownloadManager
    lateinit var request: DownloadManager.Request


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_auto_parts)
        nav_view_auto_parts.setNavigationItemSelectedListener(this)
    }

    fun downloadAutoParts(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://yadi.sk/i/lQkGLNQ83Xrf8A"))
        startActivity(browserIntent)
    }

}
