package com.hithamhl.mvvmex2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hithamhl.mvvmex2.R
import com.hithamhl.mvvmex2.pojo.PostModel
import kotlinx.android.synthetic.main.post_item.view.*
import kotlin.coroutines.EmptyCoroutineContext.plus

class PostAdapter(val context:Context,var postList: ArrayList<PostModel>) :RecyclerView.Adapter<PostAdapter.PostHolder>(){





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {

        return PostHolder(LayoutInflater.from(context).inflate(R.layout.post_item,parent,false))
    }

    override fun getItemCount(): Int {
       return postList.size
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        this!!.postList?.get(position)?.let { holder.bind(it) }

    }

   fun setPostlist(allPost:List<PostModel>){
        postList= allPost as ArrayList<PostModel>
        notifyDataSetChanged()
    }




    class PostHolder(v:View):RecyclerView.ViewHolder(v),View.OnClickListener {
        val id=v.item_id
        val title=v.item_title
        val body=v.item_body

        fun bind(postItem:PostModel) {
            id.text=postItem.id.toString()
            title.text=postItem.title
            body.text=postItem.body
        }



        override fun onClick(v: View?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.


        }



    }



}