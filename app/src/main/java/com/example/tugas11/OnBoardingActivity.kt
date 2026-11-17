package com.example.tugas11

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.mars_farhan3tie.databinding.ActivityOnBoardingBinding

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ganti teks di bawah sesuai topik aplikasi kelompokmu
        val slides = listOf(
            OnBoardingItem("Selamat Datang", "Aplikasi layanan dan informasi terpadu dalam satu genggaman.", android.R.drawable.ic_menu_compass),
            OnBoardingItem("Fitur Lengkap & Cepat", "Navigasi grid modern yang memudahkan akses setiap menu.", android.R.drawable.ic_menu_agenda),
            OnBoardingItem("Siap Digunakan", "Tekan tombol Mulai untuk masuk ke halaman utama baru.", android.R.drawable.ic_menu_send)
        )

        binding.vpOnBoarding.adapter = OnBoardingAdapter(slides)

        binding.vpOnBoarding.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.btnNext.text = if (position == slides.lastIndex) "Mulai" else "Lanjut"
            }
        })

        binding.btnNext.setOnClickListener {
            val current = binding.vpOnBoarding.currentItem
            if (current < slides.lastIndex) {
                binding.vpOnBoarding.currentItem = current + 1
            } else {
                startActivity(Intent(this, HomeBaruActivity::class.java))
                finish()
            }
        }
    }
}