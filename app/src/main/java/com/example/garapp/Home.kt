package com.example.garapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.garapp.databinding.ActivityHomeBinding
import com.example.garapp.network.RetrofitClient
import com.google.android.material.navigation.NavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        //enableEdgeToEdge()
        setContentView(binding.root)
        val toolbar : androidx.appcompat.widget.Toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        val drawerLayout : DrawerLayout = binding.drawerLayout
        val navView : NavigationView = binding.navView

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, binding.toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        // Mostrar HomeFragment al inicio
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_main_container, HomeFragment())
                .commit()
        }

    }




    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        Log.d("HomeActivity","Menu Inflated")
        val switchItem = menu!!.findItem(R.id.switch_item)
        switchItem.setActionView(R.layout.switch_layout)
        val switchView = switchItem.actionView!!.findViewById<SwitchCompat>(R.id.switch_in_toolbar)
        switchView?.setOnCheckedChangeListener { buttonView, isChecked ->
            val sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("switch_state", isChecked)
            editor.apply()
            if (isChecked) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_main_container, ConnectedFragment())
                    .commit()
                //val intent = Intent(this, GarapperConnected::class.java)
                //startActivity(intent)
            }else{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_main_container, HomeFragment())
                    .commit()
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.switch_item -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        val drawerLayout : DrawerLayout = binding.drawerLayout
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
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
            R.id.logout->{
                RetrofitClient.apiService.logout().enqueue(object :Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if(response.isSuccessful){
                            val sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)
                            sharedPreferences.edit().remove("token").apply()

                            val intent = Intent(this@Home, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        }else{
                            Toast.makeText(this@Home, "Logout failed", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        // Maneja el error de red
                        Toast.makeText(this@Home, "Network error", Toast.LENGTH_SHORT).show()
                    }
                })

            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}