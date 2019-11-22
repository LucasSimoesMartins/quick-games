package com.lucassimoesmartins.quickgames

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var fragmentList: ArrayList<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUI()
    }

    private fun setUI() {
        fragmentList = ArrayList()
        fragmentList.add(RockPaperScissorsFragment())
        fragmentList.add(FlipACoinFragment())

        viewPager.adapter = ViewPagerAdapter(
            supportFragmentManager,
            fragmentList)

        tabLayout.setupWithViewPager(viewPager)
        setTabIcons()
    }

    private fun setTabIcons() {
        val tab0 = LayoutInflater.from(this).inflate(R.layout.custom_tab, null)
        tab0.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.rock)
        tabLayout.getTabAt(0)?.setCustomView(tab0)

        val tab1 = LayoutInflater.from(this).inflate(R.layout.custom_tab, null)
        tab1.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.head)
        tabLayout.getTabAt(1)?.setCustomView(tab1)
    }
}
