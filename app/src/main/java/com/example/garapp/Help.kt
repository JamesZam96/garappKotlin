package com.example.garapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.garapp.databinding.ActivityHelpBinding

class Help : AppCompatActivity() {
    private lateinit var binding : ActivityHelpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarHelp)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val fragmentHelp = FragmentHelp()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_help_container,fragmentHelp)
            .commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}