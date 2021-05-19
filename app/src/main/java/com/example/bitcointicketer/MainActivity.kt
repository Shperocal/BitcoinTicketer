package com.example.bitcointicketer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.bitcointicketer.ui.main.ScreenSlidePagerAdapter


class MainActivity : AppCompatActivity() {

    /**
     * Using this reference to build view pager and swipe screen
     * gestures.
     *
     * https://developer.android.com/training/animation/screen-slide
     *
     * */


    private lateinit var mPager:ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        mPager = findViewById(R.id.pager)
        val pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
        mPager.adapter=pagerAdapter
    }

    override fun onBackPressed() {
        if(mPager.currentItem==0){
            super.onBackPressed()
        }else{
            mPager.currentItem=mPager.currentItem-1
        }
    }



}