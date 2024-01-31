package com.example.minipojects.reading_notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.minipojects.R

class Notes(): RecyclerView.Adapter<Notes.MyViewHolder>() {

    class MyViewHolder(itemView : View) :  RecyclerView.ViewHolder(itemView)

    //Used in adapter class to avoid duplicates
    private val diffCallback = object : DiffUtil.ItemCallback<String> () {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this , diffCallback)

    var images : List<String>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_image,
                parent,
                false
            )
        )
    }

    private var onItemClickListener : ((String) -> Unit)? = null

    fun setOnItemClickListener(listener : (String) -> Unit) {
        onItemClickListener = listener
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val url = images[position]
        holder.itemView.apply {
            //
        }
        setOnItemClickListener {
            onItemClickListener?.let { click ->
                click(url)
            }
        }
    }

    override fun getItemCount(): Int {
        return images.size
    }
}