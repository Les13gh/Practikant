package com.example.bottonnavig

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottonnavig.fragments.FavoriteFragment
import com.example.bottonnavig.fragments.HomeFragment
import com.example.bottonnavig.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val HomeFragment = HomeFragment()
        val favoriteFragment = FavoriteFragment()
        val SettingsFragment = SettingsFragment()

        makeCurrentFragment(HomeFragment)

       bottom_navigation.setOnNavigationItemSelectedListener {
           when (it.itemId){
               R.id.ic_home -> makeCurrentFragment(HomeFragment)
               R.id.ic_favorite -> makeCurrentFragment(favoriteFragment)
               R.id.ic_settings -> makeCurrentFragment(SettingsFragment)
           }
           true
       }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}
