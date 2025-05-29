package com.example.miniquiz3_10122060_adly

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlin.text.Typography.dagger

@AndroidEntryPoint
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvBMI = findViewById<TextView>(R.id.tvBMI)
        val tvKategori = findViewById<TextView>(R.id.tvKategori)

        val nilaiBMI = intent.getStringExtra("NILAI_BMI")
        val kategori = intent.getStringExtra("KATEGORI")

        val btnInfo = findViewById<Button>(R.id.btnInfo)
        btnInfo.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }


        tvBMI.text = "Nilai BMI Anda: $nilaiBMI"
        tvKategori.text = "Kategori BMI: $kategori"
    }
}
