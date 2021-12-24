package com.example.viewpagertutorial.adapter

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagertutorial.R
import com.example.viewpagertutorial.model.Photo
import kotlinx.android.synthetic.main.item_photo.view.*

class SlideImageAdapter(
    private val photoList: List<Photo>
)
    : RecyclerView.Adapter<SlideImageAdapter.SlideViewHolder>() {

    inner class SlideViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideViewHolder {
        return SlideViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_photo,
            parent,
            false
            )
        )
    }

    override fun onBindViewHolder(holder: SlideViewHolder, position: Int) {
        val photo = photoList[position]
        holder.itemView.apply {
            ivPhoto.setImageResource(photo.image)
            setOnTouchListener { view, motionEvent ->
                iOnClickItem?.onClickItem(motionEvent)
                true
            }
        }
    }

    override fun getItemCount(): Int = photoList.size

    var iOnClickItem : IOnClickItem? = null

    fun setOnClickItem(iOnClickItem : IOnClickItem){
        this.iOnClickItem = iOnClickItem
    }

    interface IOnClickItem{
        fun onClickItem(motionEvent: MotionEvent)
    }

}