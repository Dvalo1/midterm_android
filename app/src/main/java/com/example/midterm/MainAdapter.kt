package com.example.midterm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_post.view.*

class MainAdapter(val posts: Array<PostData>) : RecyclerView.Adapter<MainAdapter.CustomViewHolder>(), Filterable {

    override fun getItemCount(): Int {
        return posts.count()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.itemView.postTitleTextView.text = posts.get(position).title
        holder.itemView.postBodyTextView.text = posts.get(position).bodyText

    }

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun getFilter(): Filter {
       TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



}