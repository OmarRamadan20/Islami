package com.route.islami

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.route.islami.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
    }

    private fun initViews() {
        viewBinding.content
            .bottomNav
            .setOnItemSelectedListener { item ->
                val fragment: Fragment = when (item.itemId) {
                    R.id.navigation_quran -> {
                        QuranFragment()
                    }

                    R.id.navigation_hadeth -> {
                        HadethFragment()
                    }

                    R.id.navigation_tasbeh -> {
                        TasbehFragment()
                    }

                    R.id.navigation_radio -> {
                        RadioFragment()
                    }

                    else -> {
                        QuranFragment()
                    }
                }
                pushFragment(fragment)
                true
            }
        viewBinding.content.bottomNav
            .selectedItemId = R.id.navigation_quran
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
