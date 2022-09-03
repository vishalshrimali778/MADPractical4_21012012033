package com.example.madpractical4_21012022022

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.ContactsContract
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnBrowse:Button=findViewById(R.id.btn_browse)
        val txtBrowse:EditText=findViewById(R.id.txt_browse)
        val btnCall:Button=findViewById(R.id.btn_call)
        val txtCall:EditText=findViewById(R.id.txt_call)

        val btnContact:Button=findViewById(R.id.btn_contact)
        val btnCallLog:Button=findViewById(R.id.btn_call_log)
        val btnGallery:Button=findViewById(R.id.btn_gallery)
        val btnCamera:Button=findViewById(R.id.btn_camera)
        val btnAlarm:Button=findViewById(R.id.btn_alarm)


        btnBrowse.setOnClickListener {
            Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://"+(txtBrowse.text.toString()))).apply {
                startActivity(this)
            }
        }
        btnCall.setOnClickListener {
            Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:"+txtCall.text.toString())).apply {
                startActivity(this)
            }
        }

        btnContact.setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType(ContactsContract.Contacts.CONTENT_TYPE).apply {
                startActivity(this)
            }
        }

        btnCallLog.setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).apply {
                startActivity(this)
            }
        }

        btnGallery.setOnClickListener {
            Intent(Intent.ACTION_PICK).setType("image/*").apply {
                startActivity(this)
            }
        }
        btnCamera.setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
                startActivity(this)
            }
        }
    }
}