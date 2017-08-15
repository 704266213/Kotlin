package com.kotlin.demo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import com.kotlin.demo.bean.UserModel
import com.google.gson.reflect.TypeToken
import com.kotlin.demo.activity.SettingActivity
import com.kotlin.demo.adapter.HomeAdapter
import com.kotlin.demo.bean.BaseModel
import com.kotlin.demo.bean.Item
import com.kotlin.demo.listener.OnItemViewClickListener
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() , View.OnClickListener, OnItemViewClickListener<Item> {


    var listData :  MutableList<Item> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        kotlin.setText("kotlin")

//        val kotlin = findViewById(R.id.kotlin) as TextView
//        kotlin.setOnClickListener(this)
//        kotlin.setText("kotlin")

        val json : String = "{\n" +
                "    \"code\": 200,\n" +
                "    \"message\": \"ok\",\n" +
                "    \"result\": {\n" +
                "        \"userName\": \"jaty\",\n" +
                "        \"passWord\": \"123456\"\n" +
                "    }\n" +
                "}"
        parseJson(json)

        initData()

//        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        var homeAdapter : HomeAdapter<Item> = HomeAdapter(this,this)
        recyclerView.adapter = homeAdapter

        initData()
        homeAdapter.addDataToList(listData)
    }

    override fun onClick(v: View?) {
        Toast.makeText(this,"kotlin",Toast.LENGTH_SHORT).show()
    }

    fun onKotlinClick(v : View?){
        Toast.makeText(this,"kotlin",Toast.LENGTH_SHORT).show()
    }


     fun parseJson(json :String){
         var gson =  Gson()
         val type = object : TypeToken<BaseModel<UserModel>>() {

         }.type
         var baseModel : BaseModel<UserModel> =  gson.fromJson<UserModel>(json,type)
         Log.e("XLog","========code===============" + baseModel.code)
         Log.e("XLog","========message===============" + baseModel.message)
         Log.e("XLog","========result===============" + baseModel.result)
         var userModel :UserModel = baseModel.result!!
         Log.e("XLog","========userName===============" + userModel.userName)
         Log.e("XLog","========passWord===============" + userModel.passWord)
    }

    fun  initData(){
        for( i in 0..50){
            var item : Item  = Item()
            item.name = "当前序号：$i"
            listData.add(item)
        }
    }

    override fun onItemViewClick(t: Item?, clickView: View?) {
        Toast.makeText(this,t?.name,Toast.LENGTH_SHORT).show()
        startActivity(Intent(this,SettingActivity::class.java))
    }

}
