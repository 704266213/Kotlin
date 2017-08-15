package com.kotlin.demo.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.kotlin.demo.R
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        help.setText("帮助")
        about.setText("关于应用")
    }

    fun onBack(view: View) {
        finish()
    }

}
