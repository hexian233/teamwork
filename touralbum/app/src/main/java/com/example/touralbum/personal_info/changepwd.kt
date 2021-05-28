package com.example.touralbum.personal_info

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.touralbum.R
import com.example.touralbum.ui.account.AccountFragment

class changepwd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_changepwd)


        val confirmchangepwd : Button =findViewById(R.id.confirmchangepwd)
        confirmchangepwd.setOnClickListener{
            var jump_flag=0
            val intent = Intent(this, AccountFragment::class.java)
            val editor = getSharedPreferences("change_data", Context.MODE_PRIVATE).edit()
            val password :EditText=findViewById(R.id.password)
            val confirm_password:EditText=findViewById(R.id.confirm_password)
            if(password.text.toString()==confirm_password.text.toString()){
                editor.putString("password", password.text.toString())
                editor.apply()
                jump_flag=0
            }
            else{
                Toast.makeText(this, "两次密码输入不相同，请重新输入", Toast.LENGTH_SHORT).show()
                jump_flag=1
            }
            if(jump_flag==0){
                Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }
    }
}