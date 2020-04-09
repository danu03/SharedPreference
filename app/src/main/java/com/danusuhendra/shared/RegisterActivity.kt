package com.danusuhendra.shared

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val sp = getSharedPreferences("demo", Context.MODE_PRIVATE)
        val esp = sp.edit()

        if (sp.getBoolean("isLogin", false)) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else if (sp.getBoolean("isRegister", false)) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_signup.setOnClickListener {
            esp.putBoolean("isRegister", true)
            esp.putString("name", edt_name.text.toString())
            esp.putInt("age", edt_age.text.toString().toInt())
            esp.putString("email", edt_email.text.toString())
            esp.putString("password", edt_password.text.toString())
            esp.apply()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
