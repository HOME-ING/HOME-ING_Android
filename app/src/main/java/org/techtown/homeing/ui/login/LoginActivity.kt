package org.techtown.homeing.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import org.techtown.homeing.MainActivity
import org.techtown.homeing.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        login_btn.setOnClickListener{
            if(login_name.text.isNullOrBlank()||  login_pwd.text.isNullOrBlank()){
                Toast.makeText(this, "이메일과 비밀번호를 확인하세요.", Toast.LENGTH_SHORT).show()

            }else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

}
