package com.example.navigationdeeplinkapp.splash

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.navigationdeeplinkapp.MainActivity
import com.example.navigationdeeplinkapp.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        lifecycleScope.launch {
            delay(2000)
            MainActivity.open(this@SplashActivity, intent.data)
        }
    }

    companion object {
        fun open(context: Context, deeplinkURL: Uri? = null) {
            val intent = Intent(context, SplashActivity::class.java).apply {
                data = deeplinkURL
            }
            context.startActivity(intent)
        }
    }
}