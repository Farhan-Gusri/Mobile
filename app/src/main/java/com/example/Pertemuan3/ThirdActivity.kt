package com.example.mars_farhan3tie.Pertemuan3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.Pertemuan3.ThirdResultActivity
import com.example.mars_farhan3tie.AuthActivity
import com.example.mars_farhan3tie.BaseActivity
import com.example.mars_farhan3tie.Pertemuan4.FourthActivity
import com.example.mars_farhan3tie.databinding.ActivityThirdBinding
import com.example.mars_farhan3tie.pertemuan_5.FifthActivity

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol Kirim ke ThirdResultActivity
        binding.btnKirim.setOnClickListener {
            val intent = Intent(this, ThirdResultActivity::class.java)
            startActivity(intent)
        }

        // Tombol Ke Pertemuan 4
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
            startActivity(intent)
        }

        // Tombol Ke Pertemuan 5
        binding.btnfi.setOnClickListener {
            val intent = Intent(this, FifthActivity::class.java)
            startActivity(intent)
        }

        // Tombol Ke Pertemuan 6 (BaseActivity dengan BottomNavigation)
        binding.btnToSixth.setOnClickListener {
            val intent = Intent(this, BaseActivity::class.java)
            startActivity(intent)
        }

        // Tombol Ke Halaman Login (AuthActivity)
        binding.btnToLogin.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }
    }
}