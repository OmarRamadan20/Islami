package com.route.islami

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.databinding.ItemHadethTitleBinding

class HadethRecyclerAdapter(private val hadethList: List<Hadeth>) :
    RecyclerView.Adapter<HadethRecyclerAdapter.ViewHolder>() { // ktlint-disable max-line-length

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hadeth = hadethList[position]
        holder.bind(hadeth.title)
        onItemClickListener?.let { listener ->
            holder.itemView.setOnClickListener {
                listener.onItemClick(hadeth, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding: ItemHadethTitleBinding =
            ItemHadethTitleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = hadethList.size
    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onItemClick(item: Hadeth, position: Int)
    }

    class ViewHolder(private val itemBinding: ItemHadethTitleBinding) : RecyclerView.ViewHolder(
        itemBinding.root
    ) {
        fun bind(title: String) {
            itemBinding.title.text = title
        }
    }
}
