package com.example.mars_farhan3tie

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.mars_farhan3tie.Pertemuan4.FourthActivity

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        // 1. Inisialisasi Toolbar & Tombol Back
        val toolbar = findViewById<Toolbar>(R.id.toolbarLogin)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        // 2. Inisialisasi Komponen View
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLoginSubmit = findViewById<Button>(R.id.btnLoginSubmit)

        // 3. Aksi saat Tombol Masuk/Login diklik
        btnLoginSubmit.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (username.isEmpty()) {
                etUsername.error = "Username tidak boleh kosong!"
            } else if (password.isEmpty()) {
                etPassword.error = "Password tidak boleh kosong!"
            } else {
                Toast.makeText(this, "Login Berhasil! Halo $username", Toast.LENGTH_SHORT).show()

                // Pindah ke FourthActivity membawa data
                val intent = Intent(this, FourthActivity::class.java)
                intent.putExtra("name", username) // Mengirim username yang diinput
                intent.putExtra("from", "Rumbai")
                intent.putExtra("age", 25)
                startActivity(intent)

                // Tutup AuthActivity agar pengguna tidak kembali ke halaman login saat menekan tombol back HP
                finish()
            }
        }
    }
}