package com.kotlin.demo.listener

import android.view.View

/**
 * Created by admin on 2017/8/11.
 */
interface OnItemViewClickListener<in T> {

      fun  onItemViewClick( t : T?, clickView : View?)

}