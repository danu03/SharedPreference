package com.danusuhendra.shared

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sp = getSharedPreferences("demo", Context.MODE_PRIVATE)

        tv_name.text = sp.getString("name","")
        tv_umur.text = sp.getInt("age", 0).toString()
        tv_email.text = sp.getString("email","")

        btn_logout.setOnClickListener {
            sp.edit().putBoolean("isLogin", false).apply()
            finish()
        }
    }
}
