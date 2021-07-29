package com.example.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAd(private val listner: NewsItemListner): RecyclerView.Adapter<NewsViewH>() {
    var items: ArrayList<NewsData> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        val viewHolder = NewsViewH(view)
        view.setOnClickListener{
            listner.onClickitem(items[viewHolder.adapterPosition])

        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsViewH, position: Int) {
        val  current = items[position]
        holder.textView.text=current.title
        holder.author.text=current.authar
        Glide.with(holder.itemView.context).load(current.urlToimage).into(holder.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun update(updateddata:ArrayList<NewsData>)
    {
        items.clear()
        items.addAll(updateddata)
        notifyDataSetChanged()
    }
}
class NewsViewH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textView : TextView = itemView.findViewById(R.id.newsTitle)
    val image :ImageView=itemView.findViewById(R.id.imageview)
    val author : TextView = itemView.findViewById(R.id.author)

}
interface NewsItemListner
{
    fun onClickitem(item:NewsData)
}