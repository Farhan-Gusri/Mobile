package com.example.mars_farhan3tie

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.Pertemuan10.FragmentMore
import com.example.mars_farhan3tie.pertemuan_9.NinthActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
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
    }
}