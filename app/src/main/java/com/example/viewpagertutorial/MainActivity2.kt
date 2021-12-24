package com.example.viewpagertutorial

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagertutorial.adapter.SlideImageAdapter
import com.example.viewpagertutorial.model.Photo
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.coroutines.*
import java.lang.Runnable
import kotlin.math.abs


class MainActivity2 : AppCompatActivity() {
    var job: Job? = null
    private val TAG = "MainActivity2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val photoList = listOf(
            Photo(R.drawable.background),
            Photo(R.drawable.background2),
            Photo(R.drawable.background3),
            Photo(R.drawable.peaceful),
        )
        val adapter = SlideImageAdapter(photoList)
        viewPager2.adapter = adapter
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
//        viewPager2.currentItem = 2

        adapter.setOnClickItem(object : SlideImageAdapter.IOnClickItem{
            override fun onClickItem(motionEvent: MotionEvent) {
                when(motionEvent.action){
                    MotionEvent.ACTION_DOWN -> job?.cancel()
                    MotionEvent.ACTION_UP -> runBlocking {
                        job?.start()
                    }
                }
            }

        })

        var pagerTransformer = CompositePageTransformer().apply {
            //addTransformer(MarginPageTransformer(40))
            addTransformer { page, position ->
                val r = 1 - abs(position)
                page.scaleY = 0.85f + r * 0.15f
            }
        }
        viewPager2.setPageTransformer(pagerTransformer)


//        val pageCallback = object : ViewPager2.OnPageChangeCallback(){
//
//        }

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
//                slideHandler.removeCallbacks(slideRunnable)
//                slideHandler.postDelayed(slideRunnable,1000)
                job = GlobalScope.launch(Dispatchers.Main) {
                    if (viewPager2.currentItem == 3) {
                        delay(1000)
                        viewPager2.currentItem = 0
                    } else {
                        delay(1000)
                        viewPager2.currentItem += 1
                    }
                }
            }
        })
    }

    val slideHandler = Handler()

    private val slideRunnable = Runnable {
        run {
            viewPager2.currentItem += 1
        }
    }
}