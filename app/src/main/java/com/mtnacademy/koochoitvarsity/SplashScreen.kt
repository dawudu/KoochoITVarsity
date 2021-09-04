package com.mtnacademy.koochoitvarsity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val _splash = findViewById<TextView>(R.id.splash);
//
//       _splash.setOnClickListener(new View)


        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        _splash.alpha = 0f
        _splash.animate().setDuration(2000).alpha(1f).withEndAction {

            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}