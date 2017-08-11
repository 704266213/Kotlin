package com.kotlin.demo.bean

/**
 * Created by admin on 2017/8/10.
 */
open class BaseModel<out T>{
    var code : Int? = 0
    var message :String? = null
    val result : T? = null
}