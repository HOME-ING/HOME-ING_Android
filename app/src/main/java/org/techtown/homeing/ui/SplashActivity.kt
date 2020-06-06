package org.techtown.homeing.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import org.techtown.homeing.R
import org.techtown.homeing.ui.login.LoginActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        handler.postDelayed({
            run {
                startActivity(Intent(application, LoginActivity::class.java))
                finish()
            }
        },3000)
    }

    override fun onBackPressed() {
    }
}
