package com.kotlin.demo.listener

import android.view.View

/**
 * Created by admin on 2017/8/11.
 */
class OnRecycleViewItemClickListener<T>(onItemViewClickListener : OnItemViewClickListener<T>?,entity : T ,  clickView : View?) : View.OnClickListener{

    var onItemViewClickListener : OnItemViewClickListener<T>? = onItemViewClickListener
    var entity : T = entity
    var clickView : View? = clickView

    override fun onClick(view: View?) {

        onItemViewClickListener!!.onItemViewClick(entity,clickView)

    }


}