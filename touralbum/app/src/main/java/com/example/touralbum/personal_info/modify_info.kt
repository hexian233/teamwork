package com.example.touralbum.personal_info

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.touralbum.MainActivity
import com.example.touralbum.R

class modify_info : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modify_info)
        //TODO 实现确认修改的信息修改
        val confirmchange :Button=findViewById(R.id.confirmchange)
        confirmchange.setOnClickListener {
            val intent = Intent()
            val editor = getSharedPreferences("change_data", MODE_PRIVATE).edit()
            val enter_user_name:EditText=findViewById(R.id.enter_user_name)
            if (enter_user_name.text.toString().length!=0) {
                editor.putString("user_name", enter_user_name.text.toString())
            }
            val enter_personal_signature:EditText=findViewById(R.id.enter_personal_signature)
            if (enter_personal_signature.text.toString().length != 0) {
                editor.putString("personal_signature", enter_personal_signature.text.toString())
            }
            editor.apply()
            Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show()
            //startActivity(intent)
            finish()
        }
        val uploadsculpture:Button=findViewById(R.id.uploadsculpture)
        uploadsculpture.setOnClickListener {
            val intent = Intent(this, changehead::class.java)
            startActivity(intent)
        }
    }
}
