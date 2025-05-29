package com.example.miniquiz3_10122060_adly

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvBMI = findViewById<TextView>(R.id.tvBMI)
        val tvKategori = findViewById<TextView>(R.id.tvKategori)

        val nilaiBMI = intent.getStringExtra("NILAI_BMI")
        val kategori = intent.getStringExtra("KATEGORI")

        tvBMI.text = "Nilai BMI: $nilaiBMI"
        tvKategori.text = "Kategori BMI: $kategori"
    }
}
