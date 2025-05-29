package com.example.miniquiz3_10122060_adly.viewmodel

import androidx.lifecycle.ViewModel
import com.example.miniquiz3_10122060_adly.model.BMIResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BMIViewModel @Inject constructor() : ViewModel() {

    fun hitungBMI(berat: Double, tinggiCm: Double): BMIResult {
        val tinggiM = tinggiCm / 100
        val bmi = berat / (tinggiM * tinggiM)
        val kategori = when {
            bmi < 18.5 -> "Kurus"
            bmi < 25 -> "Normal"
            bmi < 30 -> "Gemuk"
            else -> "Obesitas"
        }
        return BMIResult(String.format("%.2f", bmi), kategori)
    }
}
