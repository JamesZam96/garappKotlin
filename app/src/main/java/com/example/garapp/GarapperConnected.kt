package com.example.garapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.garapp.databinding.ActivityGarapperConnectedBinding
import com.google.android.material.navigation.NavigationView

class GarapperConnected : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding : ActivityGarapperConnectedBinding
    private lateinit var toggleSwitch: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGarapperConnectedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarGarapperConnected)

        val drawerLayout : DrawerLayout = binding.drawerLayoutGarapperConnected
        val navView : NavigationView = binding.navView

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, binding.toolbarGarapperConnected,
            R.string.navigation_drawer_open,R.string.navigation_drawer_close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar,menu)


        return true
    }*/

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.profits -> {
                val intent = Intent(this, Profits::class.java)
                startActivity(intent)
            }
            R.id.statistics -> {
                val intent = Intent(this, Statistics::class.java)
                startActivity(intent)
            }
            R.id.help -> {
                val intent = Intent(this, Help::class.java)
                startActivity(intent)
            }
        }
        binding.drawerLayoutGarapperConnected.closeDrawer(GravityCompat.START)
        return true
    }
}