package com.danusuhendra.shared

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_submit.setOnClickListener {
            val sp = getSharedPreferences("demo", Context.MODE_PRIVATE)

            if (sp.getString("email", "") == edt_email.text.toString() && sp.getString(
                    "password",
                    ""
                ) == edt_password.text.toString()
            ) {
                sp.edit().putBoolean("isLogin", true).apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Username dan Password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
