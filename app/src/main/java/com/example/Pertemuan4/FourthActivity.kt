package com.example.mars_farhan3tie.Pertemuan4

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mars_farhan3tie.R // <-- Tambahkan baris ini

class FourthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        val btnKembali = findViewById<Button>(R.id.btnKembali)

        btnKembali.setOnClickListener {
            finish()
        }
    }
}