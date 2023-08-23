package com.example.keries


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BaseHome : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_events -> {
                loadFragment(Events())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_schedule -> {
                loadFragment(Schedule())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_home -> {
                loadFragment(Home())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_shop -> {
                loadFragment(Shop())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_more -> {
                loadFragment(More())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_home)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        // Load the initial fragment (for example, HomeFragment)
        loadFragment(Home())
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}



