package com.example.touralbum.ui.account

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.touralbum.R
import com.example.touralbum.personal_info.about_us
import com.example.touralbum.personal_info.changepwd
import com.example.touralbum.personal_info.modify_info
import java.io.ByteArrayInputStream


class AccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val layout: View = inflater.inflate(R.layout.personal_info, null)
        val prefs_personal= getActivity()?.getSharedPreferences("change_data",Context.MODE_PRIVATE)
        val user_name_1= prefs_personal?.getString("user_name","")
        val personal_signature_1= prefs_personal?.getString("personal_signature","")
        val sharedPreferences = getActivity()?.getSharedPreferences("testSP", Context.MODE_PRIVATE)
        //第一步:取出字符串形式的Bitmap
        val imageString = sharedPreferences?.getString("image", "")
        //第二步:利用Base64将字符串转换为ByteArrayInputStream
        val byteArray = Base64.decode(imageString, Base64.DEFAULT)
        val byteArrayInputStream = ByteArrayInputStream(byteArray)
        //第三步:利用ByteArrayInputStream生成Bitmap
        val bitmap = BitmapFactory.decodeStream(byteArrayInputStream)
        val headsculpture:ImageView=layout.findViewById(R.id.headsculpture)
        headsculpture.setImageBitmap(bitmap)
        val user_name:TextView=layout.findViewById(R.id.user_name)
        user_name.text=user_name_1
        val personal_signature:TextView=layout.findViewById(R.id.personal_signature)
        personal_signature.text=personal_signature_1
        val modify_info_bt:Button=layout.findViewById(R.id.modify_info_bt)
        modify_info_bt.setOnClickListener{
            val intent = Intent(getActivity(), modify_info::class.java)
            startActivity(intent)
        }

        val about_us_bt:Button=layout.findViewById(R.id.about_us_bt)
        about_us_bt.setOnClickListener{
            val intent = Intent(getActivity(), about_us::class.java)
            startActivity(intent)
        }

        val changepwd_bt:Button=layout.findViewById(R.id.changepwd_bt)
        changepwd_bt.setOnClickListener{
            val intent = Intent(getActivity(), changepwd::class.java)
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
        return layout
    }

    /*override fun onResume() {
        super.onResume()
        val inflater:LayoutInflater=LayoutInflater.from(context)
        val layout: View = inflater.inflate(R.layout.personal_info, null)
        val prefs_personal= getActivity()?.getSharedPreferences("change_data",Context.MODE_PRIVATE)
        val user_name_1= prefs_personal?.getString("user_name","")
        val personal_signature_1= prefs_personal?.getString("personal_signature","")
        val sharedPreferences = getActivity()?.getSharedPreferences("testSP", Context.MODE_PRIVATE)
        //第一步:取出字符串形式的Bitmap
        val imageString = sharedPreferences?.getString("image", "")
        //第二步:利用Base64将字符串转换为ByteArrayInputStream
        val byteArray = Base64.decode(imageString, Base64.DEFAULT)
        val byteArrayInputStream = ByteArrayInputStream(byteArray)
        //第三步:利用ByteArrayInputStream生成Bitmap
        val bitmap = BitmapFactory.decodeStream(byteArrayInputStream)
        val headsculpture:ImageView=layout.findViewById(R.id.headsculpture)
        headsculpture.setImageBitmap(bitmap)
        val user_name:TextView= layout.findViewById(R.id.user_name)
        user_name.text=user_name_1
        val personal_signature:TextView=layout.findViewById(R.id.personal_signature)
        personal_signature.text=personal_signature_1
        inflater.inflate(R.layout.personal_info,null)
    }*/
}