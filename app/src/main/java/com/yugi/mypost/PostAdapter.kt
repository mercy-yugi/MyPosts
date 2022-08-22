package com.yugi.mypost

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yugi.mypost.databinding.PostListItemBinding

class PostAdapter(var PostList:List<Post>):RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
     var binding=PostListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
       var currentPost=PostList.get(position)
        with(holder.binding){
            tvUserId.text=currentPost.userId.toString()
            tvID.text=currentPost.id.toString()
            tvTitle.text=currentPost.title
            tvBody.text=currentPost.body
            var context=holder.itemView.context
            holder.binding.cvPost.setOnClickListener{
                val intent=Intent(context,comments_activity::class.java)

                intent.putExtra("POST_ID",currentPost.id)
                context.startActivity(intent)
            }

        }
    }
    override fun getItemCount(): Int {
     return PostList.size
    }
}
class PostViewHolder(var binding:PostListItemBinding):
        RecyclerView.ViewHolder(binding.root)

