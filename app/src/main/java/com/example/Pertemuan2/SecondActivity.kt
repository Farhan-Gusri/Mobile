//package com.example.Pertemuan2
//
//import android.content.Intent
//import android.os.Bundle
//import android.util.Log
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//import com.example.mars_farhan3tie.R
//
//class SecondActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
//        // 1. Ambil data Intent jika dikirim dari MainActivity
//        val dataKiriman = intent.getStringExtra("NAMA_USER")
//        if (dataKiriman != null) {
//            Toast.makeText(this, "Data diterima: $dataKiriman", Toast.LENGTH_SHORT).show()
//        }
//
//        val inputNama: EditText = findViewById(R.id.inputNoTujuan)
//        val btnSubmit: Button = findViewById(R.id.button)
//
//        btnSubmit.setOnClickListener {
//            val nama = inputNama.text.toString()
//            Log.i("Klik btnSubmit", "Tombol berhasil di tekan. Isi dari inputNama = $nama")
//
//            Toast.makeText(this, "Anda telah melakukan klik pada tombol Submit: $nama", Toast.LENGTH_SHORT).show()
//        }
//    }
//}