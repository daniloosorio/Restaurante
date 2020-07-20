package com.daniloosorio.restaurante2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity(), FragmentOne.OnDataPass{
    var back = arrayOf(0,0,0,0,0,0,0,0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolBar.setTitle("Hacienda")
        setSupportActionBar(toolBar)
        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        ViewPager.adapter=fragmentAdapter
        tabLayout.setupWithViewPager(ViewPager)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    override fun onDataPass(data:Array<Int>) {
        //Log.d("LOG","hello " + data)
        back=data
    }
}