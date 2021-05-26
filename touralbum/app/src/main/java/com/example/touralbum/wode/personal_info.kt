package com.example.wode

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import androidx.appcompat.app.AppCompatActivity
import com.example.touralbum.R
import java.io.ByteArrayInputStream

class personal_info : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.personal_info)
        val prefs_personal=getSharedPreferences("change_data",Context.MODE_PRIVATE)
        val user_name_1=prefs_personal.getString("user_name","")
        val personal_signature_1=prefs_personal.getString("personal_signature","")
        val sharedPreferences = getSharedPreferences("testSP", Context.MODE_PRIVATE)
        //第一步:取出字符串形式的Bitmap
        val imageString = sharedPreferences.getString("image", "")
        //第二步:利用Base64将字符串转换为ByteArrayInputStream
        val byteArray = Base64.decode(imageString, Base64.DEFAULT)
        val byteArrayInputStream = ByteArrayInputStream(byteArray)
        //第三步:利用ByteArrayInputStream生成Bitmap
        val bitmap = BitmapFactory.decodeStream(byteArrayInputStream)
        headsculpture.setImageBitmap(bitmap)
        user_name.text=user_name_1
        personal_signature.text=personal_signature_1
        modify_info_bt.setOnClickListener{
            val intent = Intent(this, modify_info::class.java)
            startActivity(intent)
        }

        about_us_bt.setOnClickListener{
            val intent = Intent(this, about_us::class.java)
            startActivity(intent)
        }

        changepwd_bt.setOnClickListener{
            val intent = Intent(this, changepwd::class.java)
            startActivity(intent)
        }
        /*recommend_us_bt.setOnClickListener{
            val intent = Intent(this, sendmessage::class.java)
            startActivity(intent)
        }*/
        //TODO 连接登陆界面
        /*log_out_bt.setOnClickListener{
            val intent = Intent(this, 登陆界面::class.java)
            startActivity(intent)
        }*/

        //TODO 连接好友列表
        /*add_friends_bt.setOnClickListener{
            val intent = Intent(this, 好友列表::class.java)
            startActivity(intent)
        }*/
    }
}
