package com.example.bastardapps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.bastardapps.OnBoarding.OnBoardingActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sharedPref = getSharedPreferences("session_user", MODE_PRIVATE)

        lifecycleScope.launch {
            delay(2000) // Simulasi loading selama 2 detik

            val isOnboardingDone = sharedPref.getBoolean("onboarding_done", false)
            val isLogin = sharedPref.getBoolean("isLogin", false)

            lifecycleScope.launch {
                delay(2000)
                val intent = when {
                    isLogin -> Intent(this@SplashScreenActivity, BaseActivity::class.java)
                    isOnboardingDone -> Intent(this@SplashScreenActivity, AuthActivity::class.java)
                    else -> Intent(this@SplashScreenActivity, OnBoardingActivity::class.java)
                }
                startActivity(intent)
                finish()
            }
        }
    }
}