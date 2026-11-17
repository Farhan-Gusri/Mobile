package com.example.Pertemuan6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mars_farhan3tie.databinding.ActivitySixthBinding

class SixthActivity : AppCompatActivity() {

    // Deklarasi ViewBinding
    private lateinit var binding: ActivitySixthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi ViewBinding
        binding = ActivitySixthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar & Tombol Kembali
        binding.toolbar.title = "Pertemuan 6"
        binding.toolbar.setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        // Menampilkan fragment pertama secara default
        if (savedInstanceState == null) {
            replaceFragment(FirstFragment()) // Sesuaikan jika nama kelas kamu SatuFragment()
        }

        // Setup event click untuk mengganti fragment
        binding.btnFragment1.setOnClickListener {
            replaceFragment(FirstFragment())
        }

        binding.btnFragment2.setOnClickListener {
            replaceFragment(SecondFragment()) // Sesuaikan jika nama kelas kamu DuaFragment()
        }

        binding.btnFragment3.setOnClickListener {
            replaceFragment(ThirdFragment()) // Sesuaikan jika nama kelas kamu TigaFragment()
        }
    }

    // Definisi fungsi replaceFragment sesuai instruksi modul
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .addToBackStack(null)
            .commit()
    }
}