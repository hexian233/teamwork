package com.example.touralbum

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.touralbum.personal_info.modify_info
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.ByteArrayInputStream
import android.util.Base64
import android.util.Log

import java.util.*


class MainActivity : AppCompatActivity() {
    var isFirstLoading = true;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        val isFirstLoading = true;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_events,R.id.navigation_discovery,R.id.navigation_add,R.id.navigation_chat,R.id.navigation_account))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        val addevent : FloatingActionButton = findViewById(R.id.add_event)
        addevent.setOnClickListener {
            //todo 跳转到create event活动
            Toast.makeText(this, "创建出行事件", Toast.LENGTH_SHORT).show()
        }
        val intent = Intent(this@MainActivity, modify_info::class.java)

    }
    override fun onResume() {
        super.onResume()
        if (!isFirstLoading) {
            //如果不是第一次加载，刷新数据

            val prefs_personal= getSharedPreferences("change_data",Context.MODE_PRIVATE)
            val user_name_1= prefs_personal?.getString("user_name","")
            val personal_signature_1= prefs_personal?.getString("personal_signature","")
            val sharedPreferences = getSharedPreferences("testSP", Context.MODE_PRIVATE)
            //第一步:取出字符串形式的Bitmap
            val imageString = sharedPreferences?.getString("image", "")
            //第二步:利用Base64将字符串转换为ByteArrayInputStream
            val byteArray = Base64.decode(imageString, Base64.DEFAULT)
            val byteArrayInputStream = ByteArrayInputStream(byteArray)
            //第三步:利用ByteArrayInputStream生成Bitmap
            val bitmap = BitmapFactory.decodeStream(byteArrayInputStream)
            val headsculpture: ImageView =findViewById(R.id.headsculpture)
            headsculpture.setImageBitmap(bitmap)
            val user_name: TextView = findViewById(R.id.user_name)
            user_name.text=user_name_1
            val personal_signature:TextView=findViewById(R.id.personal_signature)
            personal_signature.text=personal_signature_1
        }
        isFirstLoading = false
    }

}