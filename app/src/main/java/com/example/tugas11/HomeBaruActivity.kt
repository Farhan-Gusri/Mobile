package com.example.tugas11

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mars_farhan3tie.databinding.ActivityHomeBaruBinding

class HomeBaruActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBaruBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBaruBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Sesuaikan data list ini dengan topik aplikasi kelompokmu
        val listKonten = listOf(
            DataItem("Konten 1", "Deskripsi item pertama sesuai topik", android.R.drawable.ic_menu_info_details),
            DataItem("Konten 2", "Deskripsi item kedua sesuai topik", android.R.drawable.ic_menu_compass),
            DataItem("Konten 3", "Deskripsi item ketiga sesuai topik", android.R.drawable.ic_menu_agenda),
            DataItem("Konten 4", "Deskripsi item keempat sesuai topik", android.R.drawable.ic_menu_send)
        )

        binding.rvKonten.layoutManager = LinearLayoutManager(this)
        binding.rvKonten.adapter = CustomAdapter(listKonten)
    }
}