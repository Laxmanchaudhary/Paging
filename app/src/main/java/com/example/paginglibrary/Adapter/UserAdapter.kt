package com.example.paginglibrary.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.paginglibrary.Model.User
import com.example.paginglibrary.R

class UserAdapter: PagedListAdapter<User, UserAdapter.ViewHolder>(diffutul) {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.user_row,parent,false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.txt_username).text=getItem(position)!!.first_name.plus(" "+getItem(position)!!.last_name)
        holder.itemView.findViewById<TextView>(R.id.txt_useremail).text=getItem(position)!!.email

       var userimage= holder.itemView.findViewById<ImageView>(R.id.imageView)
        Glide.with(userimage.context).load(getItem(position)!!.avatar).into(userimage)


    }









    companion object{
        var diffutul=object :DiffUtil.ItemCallback<User>()
        {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                 return newItem.id==oldItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                 return  newItem==oldItem
            }

        }
    }



}


