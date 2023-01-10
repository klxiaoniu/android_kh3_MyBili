package com.xiaoniu.mybili

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class upAdapter(val upList: List<up>,val detailTitle: TextView,val detailImg: ImageView) :
    RecyclerView.Adapter<upAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val upImage: ImageView = view.findViewById(R.id.upImage)
        val upName: TextView = view.findViewById(R.id.upName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val up = upList[position]
        holder.upImage.setImageResource(up.imageId)
        holder.upName.text = up.name
        holder.itemView.setOnClickListener {
            val position = holder.absoluteAdapterPosition
            val up = upList[position]
            //Toast.makeText(holder.itemView.context, "you clicked view ${up.name}", Toast.LENGTH_SHORT).show()
            //MainActivity().setDetailTitle(up.name)
            detailTitle.text = "${up.name}的动态信息"
            detailImg.setImageResource(R.drawable.pic_detail)
        }
        holder.itemView.setOnLongClickListener {
            val position = holder.absoluteAdapterPosition
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra("pos", position)
            it.context.startActivity(intent)
            true
        }
    }

    override fun getItemCount() = upList.size
}