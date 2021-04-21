package com.example.navigationdeeplinkapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigationdeeplinkapp.splash.SplashActivity

class DeeplinkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deeplink)
        handleDeeplink(intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleDeeplink(intent)
    }

    override fun onBackPressed() {
        //super.onBackPressed()
    }

    private fun handleDeeplink(intent: Intent?) {
        val action = intent?.action
        val data = intent?.data

        if (action == Intent.ACTION_VIEW && data != null) {

            if (Constants.isAppRunning == true) {
                MainActivity.open(this@DeeplinkActivity, data)
            } else {
                SplashActivity.open(this@DeeplinkActivity, data)
            }

        } else {
            finish()
        }
    }
}