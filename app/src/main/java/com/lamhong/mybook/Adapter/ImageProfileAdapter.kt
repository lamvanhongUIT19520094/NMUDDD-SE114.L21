package com.lamhong.mybook.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.lamhong.mybook.DetailPostFragment
import com.lamhong.mybook.FullScreenPictureActivity
import com.lamhong.mybook.Models.Post
import com.lamhong.mybook.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_bio_item_layout.view.*

class ImageProfileAdapter (private val mContext:Context, private val mPost: List<Post> , private val mWidth : Int)
    : RecyclerView.Adapter<ImageProfileAdapter.ViewHolder>(){


        inner class ViewHolder(@NonNull itemview: View) : RecyclerView.ViewHolder(itemview){
            var image_bio : ImageView = itemview.findViewById(R.id.image_item)

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view  = LayoutInflater.from(mContext).inflate(R.layout.image_bio_item_layout ,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val post: Post= mPost[position]
        Picasso.get().load(post.getpost_image()).placeholder(R.drawable.cty).into(holder.image_bio)
        holder.image_bio.layoutParams.height=mWidth
        holder.image_bio.setOnClickListener{
          /*  val pref = mContext.getSharedPreferences("PREFS", Context.MODE_PRIVATE).edit()
            pref.putString("postID",post.getpost_id())
            pref.apply()
            (mContext as FragmentActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, DetailPostFragment()).commit()

           */
            val intentFull= Intent(mContext, FullScreenPictureActivity::class.java)
            intentFull.putExtra("imageuri", post.getpost_image())
            mContext.startActivity(intentFull)
        }
    }

    override fun getItemCount(): Int {
       return mPost.size
    }
}