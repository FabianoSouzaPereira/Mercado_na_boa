package com.fabianospdev.mercadonaboa.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fabianospdev.mercadonaboa.R
import com.fabianospdev.mercadonaboa.model.listas.ListShopping

class AdapterCardHome(context: Context, private val clickListener: () -> Unit): RecyclerView.Adapter<AdapterCardHome.ViewHolder>() {
    private val mContext: Context = context
    private var mListShopping: MutableList<ListShopping?> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.itemcard, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = mListShopping[position]

        holder.name.text = card?.name
        holder.data.text = card?.data
        holder.status.text = card?.statusList

        holder.cardView.setOnClickListener {
            clickListener()
        }
    }
    override fun getItemCount(): Int {
       return mListShopping.size
    }

    fun setData(listShopping: MutableList<ListShopping?>){
        mListShopping.clear()
        mListShopping.addAll(listShopping)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var card: View = itemView.findViewById(R.id.itemcard)
        var cardView: View = itemView.findViewById(R.id.materialcardView)
        var name: com.google.android.material.textview.MaterialTextView = itemView.findViewById(R.id.listName)
        var data: com.google.android.material.textview.MaterialTextView = itemView.findViewById(R.id.data)
        var status: com.google.android.material.textview.MaterialTextView = itemView.findViewById(R.id.status)
    }

}