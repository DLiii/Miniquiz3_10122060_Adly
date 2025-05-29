package com.example.miniquiz3_10122060_adly

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var etBerat: TextInputEditText
    private lateinit var etTinggi: TextInputEditText
    private lateinit var btnHitung: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etBerat = findViewById(R.id.etBerat)
        etTinggi = findViewById(R.id.etTinggi)
        btnHitung = findViewById(R.id.btnHitung)

        btnHitung.setOnClickListener {
            val beratStr = etBerat.text.toString()
            val tinggiStr = etTinggi.text.toString()

            if (beratStr.isEmpty() || tinggiStr.isEmpty()) {
                Toast.makeText(this, "Harap isi semua data", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val berat = beratStr.toDouble()
            val tinggiCm = tinggiStr.toDouble()
            val tinggiM = tinggiCm / 100
            val bmi = berat / (tinggiM * tinggiM)

            val kategori = when {
                bmi < 18.5 -> "Kurus"
                bmi < 25 -> "Normal"
                bmi < 30 -> "Gemuk"
                else -> "Obesitas"
            }

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("NILAI_BMI", String.format("%.2f", bmi))
            intent.putExtra("KATEGORI", kategori)
            startActivity(intent)
        }
    }
}
