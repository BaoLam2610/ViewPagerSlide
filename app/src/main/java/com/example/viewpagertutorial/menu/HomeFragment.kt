package com.example.viewpagertutorial.menu

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.viewpagertutorial.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container,false)
    }

    private val TAG = "DemoFragment"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "Home Fragment created")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Home Fragment destroyed")
    }
}