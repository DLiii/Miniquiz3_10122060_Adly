package com.latihan4.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.latihan4.bmicalculator.R
import dagger.hilt.android.AndroidEntryPoint
import com.latihan4.bmicalculator.viewmodel.BMIViewModel
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var etBerat: TextInputEditText
    private lateinit var etTinggi: TextInputEditText
    private lateinit var btnHitung: Button

    private val viewModel: BMIViewModel by viewModels()

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

            val hasil = viewModel.hitungBMI(berat, tinggiCm)

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("NILAI_BMI", hasil.nilai)
            intent.putExtra("KATEGORI", hasil.kategori)
            startActivity(intent)
        }
    }
}
