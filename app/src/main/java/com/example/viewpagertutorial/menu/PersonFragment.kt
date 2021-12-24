package com.example.viewpagertutorial.menu

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpagertutorial.R

class PersonFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_person, container,false)
    }

    private val TAG = "DemoFragment"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "Person Fragment created")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Person Fragment destroyed")
    }
}