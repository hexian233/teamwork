package com.example.wode

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.touralbum.R
import kotlinx.android.synthetic.main.modify_info.*

class modify_info : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modify_info)
        //TODO 实现确认修改的信息修改
        confirmchange.setOnClickListener {
            val intent = Intent(this, personal_info::class.java)

            val editor = getSharedPreferences("change_data", MODE_PRIVATE).edit()
            if (enter_user_name.text.toString().length!=0) {
                editor.putString("user_name", enter_user_name.text.toString())
            }
            if (enter_personal_signature.text.toString().length != 0) {
                editor.putString("personal_signature", enter_personal_signature.text.toString())
            }


            editor.apply()
            Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
        uploadsculpture.setOnClickListener {
            val intent = Intent(this, changehead::class.java)
            startActivity(intent)
        }
    }
}
