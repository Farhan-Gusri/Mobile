package com.example.mars_farhan3tie

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Home.photo.PhotoAdapter
import com.example.Note.NoteFragment
import com.example.Pertemuan10.FragmentMore
import com.example.Pertemuan11.TenthActivity
import com.example.data.api.CatFactApiClient
import com.example.data.api.PhotoApiClient
import com.example.mars_farhan3tie.Message.MessageFragment
import com.example.mars_farhan3tie.More.MoreFragment
import com.example.mars_farhan3tie.pertemuan_9.NinthActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var tvCatFact: TextView
    private lateinit var rvGallery: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        // Inisialisasi View untuk Cat Fact & Gallery
        tvCatFact = findViewById(R.id.tvCatFact)
        rvGallery = findViewById(R.id.rvGallery)

        // Panggil fungsi loadCatFact & loadPhoto saat halaman dibuka
        loadCatFact()
        loadPhoto()

        // Tombol Refresh
        val btnRefresh = findViewById<Button>(R.id.btnRefresh)
        btnRefresh.setOnClickListener {
            tvCatFact.text = "Loading cat fact..."
            loadCatFact()
        }

        // 1. Tombol ke AuthActivity
        val btnToAuth = findViewById<Button>(R.id.btnToAuth)
        btnToAuth.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        // 2. Tombol Pertemuan 6 (BaseActivity / Bottom Navigation)
        val btnPertemuan6: Button = findViewById(R.id.btnPertemuan6)
        btnPertemuan6.setOnClickListener {
            val intent = Intent(this, BaseActivity::class.java)
            startActivity(intent)
        }

        // 3. Tombol Pertemuan 9 (Widget & Layout Modern)
        val btnPertemuan9 = findViewById<Button>(R.id.btnPertemuan9)
        btnPertemuan9.setOnClickListener {
            val intent = Intent(this, NinthActivity::class.java)
            startActivity(intent)
        }

        // 4. Tombol Pertemuan 10 (ListView & Custom Adapter)
        val btnPertemuan10 = findViewById<Button>(R.id.btnPertemuan10)
        btnPertemuan10.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(android.R.id.content, FragmentMore())
                .addToBackStack(null)
                .commit()
        }

        val btnPertemuan11 = findViewById<Button>(R.id.btnPertemuan11)
        btnPertemuan11.setOnClickListener {
            val intent = Intent(this, TenthActivity::class.java)
            startActivity(intent)
        }

        val btnPertemuan11Tugas = findViewById<Button>(R.id.btnPertemuan11Tugas)
        btnPertemuan11Tugas.setOnClickListener {
            val intent = Intent(this, com.example.tugas11.OnBoardingActivity::class.java)
            startActivity(intent)
        }

        // 5. Konfigurasi 4 Menu Bottom Navigation di Halaman Utama
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavView)
        val fragmentContainer = findViewById<FrameLayout>(R.id.fragment_container)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    fragmentContainer.visibility = View.GONE
                    true
                }
                R.id.message -> {
                    fragmentContainer.visibility = View.VISIBLE
                    replaceFragment(MessageFragment())
                    true
                }
                R.id.note -> {
                    fragmentContainer.visibility = View.VISIBLE
                    replaceFragment(NoteFragment())
                    true
                }
                R.id.more -> {
                    fragmentContainer.visibility = View.VISIBLE
                    replaceFragment(MoreFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun loadCatFact() {
        lifecycleScope.launch {
            try {
                val response = CatFactApiClient.apiService.getCatFact()
                tvCatFact.text = "\"${response.fact}\""
            } catch (e: Exception) {
                tvCatFact.text = "Gagal mengambil fakta kucing."
            }
        }
    }

    private fun loadPhoto() {
        lifecycleScope.launch {
            try {
                val photos = PhotoApiClient.apiService.getPhotos()
                val adapter = PhotoAdapter(photos)
                rvGallery.adapter = adapter

                /** List Tampil Vertical */
                rvGallery.layoutManager = LinearLayoutManager(this@MainActivity)

                /** List Tampil Horizontal */
                // rvGallery.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)

                /** List Tampil Grid */
                // rvGallery.layoutManager = GridLayoutManager(this@MainActivity, 2)

            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "Gagal memuat gambar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}