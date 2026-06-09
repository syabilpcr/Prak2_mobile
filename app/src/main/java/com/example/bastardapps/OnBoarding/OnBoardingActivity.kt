package com.example.bastardapps.OnBoarding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.viewpager2.widget.ViewPager2
import com.example.bastardapps.AuthActivity
import com.example.bastardapps.R
import com.example.bastardapps.databinding.ActivityOnBoardingBinding
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val slides = listOf(
            OnBoardingFragment.newInstance(
                R.drawable.ic_onboarding_1,
                "Selamat Datang",
                "Aplikasi pembelajaran mobile Android terbaik untuk kamu."
            ),
            OnBoardingFragment.newInstance(
                R.drawable.ic_onboarding_2,
                "Belajar Kapan Saja",
                "Akses materi dan latihan dari mana saja dan kapan saja."
            ),
            OnBoardingFragment.newInstance(
                R.drawable.ic_onboarding_3,
                "Mulai Sekarang",
                "Daftarkan dirimu dan mulai perjalanan belajarmu hari ini!"
            )
        )

        val adapter = OnBoardingAdapter(this, slides)
        binding.viewPager.adapter = adapter
        binding.dotsIndicator.attachTo(binding.viewPager)

        // Tombol "Ayo Mulai" hanya muncul di slide terakhir
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == slides.size - 1) {
                    binding.btnAyoMulai.visibility = android.view.View.VISIBLE
                } else {
                    binding.btnAyoMulai.visibility = android.view.View.GONE
                }
            }
        })

        binding.btnAyoMulai.setOnClickListener {
            // Tandai onboarding sudah selesai
            getSharedPreferences("session_user", MODE_PRIVATE).edit {
                putBoolean("onboarding_done", true)
            }
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
        }
    }
}