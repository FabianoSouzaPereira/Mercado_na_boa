package com.fabianospdev.mercadonaboa.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fabianospdev.mercadonaboa.R


class AdapterAddList(context: Context, private val clickListener: () -> Unit) :
    RecyclerView.Adapter<AdapterAddList.ViewHolder>() {
    private val mContext: Context = context
    private var mMutableList: MutableList<Any?> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.fragment_add_list, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Object = mMutableList[position]

        holder.itemView.setOnClickListener {
            clickListener()
        }

    }

    override fun getItemCount(): Int {
        return mMutableList.size
    }

    fun setData(mutableList: MutableList<Any?>) {
        mMutableList.clear()
        mMutableList.add(mutableList)
    }

    fun update() {
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // var name: com.google.android.material.textview.MaterialTextView = itemView.findViewById(R.id.listName)
    }
}