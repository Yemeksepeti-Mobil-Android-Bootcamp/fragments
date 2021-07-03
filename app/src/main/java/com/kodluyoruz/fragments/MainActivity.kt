package com.kodluyoruz.fragments

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity(), INavigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add<ListFragment>(R.id.containerFragment)
            }
        }
    }

    override fun navigateDetailPage(name: String) {
        Log.v("Navigation", "$name")
        supportFragmentManager.commit {
            val bundle = Bundle()
            bundle.putString("HelloKodluyoruz", name)
            setReorderingAllowed(true)
            val fragment = DetailFragment()
            fragment.arguments = bundle
            add(R.id.containerFragment, fragment)
                .addToBackStack("detail$name")
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }
}