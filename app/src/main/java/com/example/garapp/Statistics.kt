package com.example.garapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.garapp.databinding.ActivityStatisticsBinding

class Statistics : AppCompatActivity() {
    private lateinit var binding : ActivityStatisticsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatisticsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentStatistics = FragmentStatistics()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_statistics_container,fragmentStatistics)
            .commit()
    }
}