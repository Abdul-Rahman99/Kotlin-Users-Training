package com.example.myapplicationkotlin.ui.adaptor

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationkotlin.R
import com.example.myapplicationkotlin.model.entity.User

class UserRecyclerView : RecyclerView.Adapter<UserRecyclerView.UserViewHolder>() {

    var onListItemClick: OnListItemClick? = null
    private var userList: List<User> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(userList: List<User>) {
        this.userList = userList
        notifyDataSetChanged()
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var iv_userImage: ImageView = itemView.findViewById(R.id.id_imageview_item)
        var tv_userName: TextView = itemView.findViewById((R.id.tv_item_username))
        var tv_message: TextView = itemView.findViewById((R.id.tv_item_messege))

        fun bind(user: User) {
            iv_userImage.setImageResource(user.imageId)
            tv_userName.text = user.name
            tv_message.text = user.message


            itemView.setOnClickListener{
                onListItemClick?.onItemClick(user)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_view, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user: User = userList.get(position)
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return userList.size
    }


}