package com.example.garapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.garapp.databinding.ActivityProfitsBinding

class Profits : AppCompatActivity() {
    private lateinit var binding : ActivityProfitsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfitsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentProfits = FragmentProfits()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_profits_container,fragmentProfits)
            .commit()
    }
}