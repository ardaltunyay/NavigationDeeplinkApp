package com.example.navigationdeeplinkapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment)
            .navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Constants.appIsRunning = true
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("ARDA", "on new intent")
        handleDeeplink(intent)
    }

    private fun handleDeeplink(intent: Intent?) {
        intent?.data?.let {
            navController.navigate(it)
        }
    }

    companion object {
        fun open(context: Context, deeplinkURL: Uri? = null) {
            val intent = Intent(context, MainActivity::class.java).apply {
                data = deeplinkURL
            }
            context.startActivity(intent)
        }
    }
}