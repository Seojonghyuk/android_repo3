package com.example.recyclerpj


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerpj.databinding.ItemViewBinding

class CustomAdapter(val dataList: MutableList<DataList>):RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemviewbinding:ItemViewBinding = ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  CustomViewHolder(itemviewbinding)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val itemviewbinding = (holder as CustomViewHolder).itemviewbinding
        itemviewbinding.tvName.text = dataList.get(position).tvName
        itemviewbinding.tvAge.text = dataList.get(position).tvAge
        itemviewbinding.tvMail.text = dataList.get(position).tvmail
        itemviewbinding.ivPicture.setImageResource(dataList.get(position).ivPicture)
        itemviewbinding.root.setOnClickListener {
            Toast.makeText(itemviewbinding.root.context,"${itemviewbinding.tvName.text}", Toast.LENGTH_SHORT).show()
        }
        itemviewbinding.root.setOnLongClickListener(object :View.OnLongClickListener{
            override fun onLongClick(v: View?): Boolean {
                Toast.makeText(itemviewbinding.root.context,"${itemviewbinding.tvName.text} 삭제완료", Toast.LENGTH_SHORT).show()
                dataList.removeAt(position)
                notifyDataSetChanged()
                return true
            }
        })
    }
    class CustomViewHolder(val itemviewbinding: ItemViewBinding): RecyclerView.ViewHolder(itemviewbinding.root)

}


