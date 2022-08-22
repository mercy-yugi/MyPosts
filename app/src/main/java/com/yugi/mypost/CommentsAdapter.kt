package com.yugi.mypost


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yugi.mypost.databinding.CommentListItemBinding


class CommentsAdapter(var commentList: List<Comment>) : RecyclerView.Adapter<CommentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var binding =
            CommentListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentsViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComment = commentList.get(position)
        with(holder.binding) {
            tvUserId2.text = currentComment.postId.toString()
            tvId.text = currentComment.id.toString()
            tvBody2.text = currentComment.body
            tvEmail.text = currentComment.email
            tvName.text = currentComment.name

        }
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

}


class CommentsViewHolder(var binding: CommentListItemBinding) : RecyclerView.ViewHolder(binding.root)
