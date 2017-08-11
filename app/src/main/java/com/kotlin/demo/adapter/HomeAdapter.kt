package com.kotlin.demo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kotlin.demo.R
import com.kotlin.demo.bean.Item
import com.kotlin.demo.listener.OnItemViewClickListener
import com.kotlin.demo.listener.OnRecycleViewItemClickListener
import java.util.*

/**
 * Created by admin on 2017/8/11.
 */
class HomeAdapter<T>(context : Context,onItemViewClickListener : OnItemViewClickListener<Item>?) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    var context = context
    var onItemViewClickListener : OnItemViewClickListener<Item>? = onItemViewClickListener
    var items : MutableList<T> = ArrayList()

    fun addDataToList(items : List<T>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: HomeAdapter.HomeViewHolder?, position: Int) {
        var item : Item =  items.get(position) as Item
        holder?.name?.setText(item.name)

        var onRecycleViewItemClickListener : OnRecycleViewItemClickListener<Item> = OnRecycleViewItemClickListener<Item>(onItemViewClickListener,item, holder?.itemRecycleView)

        holder?.itemRecycleView?.setOnClickListener(onRecycleViewItemClickListener)
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeAdapter.HomeViewHolder {
        var view:View = LayoutInflater.from(context).inflate(R.layout.recycleview_item, parent,false)
        var holder = HomeViewHolder(view)
        return  holder
    }

    override fun getItemCount(): Int {
       return items?.size
    }

//    class HomeViewHolder : RecyclerView.ViewHolder {
//
//        constructor (view : View?) :super(view){
//            name = view?.findViewById<TextView>(R.id.name) as TextView
//        }
//
//        var name : TextView
//    }


    class HomeViewHolder(itemView:View?) : RecyclerView.ViewHolder(itemView) {

        var itemRecycleView:View? = itemView!!.findViewById<View>(R.id.itemView)
        var name:TextView? = itemView!!.findViewById<TextView>(R.id.name)
        var headImage: ImageView? = itemView!!.findViewById<ImageView>(R.id.headImage)
    }


}