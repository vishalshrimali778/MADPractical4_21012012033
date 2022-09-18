package com.example.madpractical4_21012012033

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
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnBrowse:Button=findViewById(R.id.btn_browse)
        val txtBrowse:EditText=findViewById(R.id.txt_browse)
        val btnCall:Button=findViewById(R.id.btn_call)
        val txtCall:EditText=findViewById(R.id.txt_call)
        val txtAlarm:EditText=findViewById(R.id.txt_alarm)

        val btnContact:Button=findViewById(R.id.btn_contact)
        val btnCallLog:Button=findViewById(R.id.btn_call_log)
        val btnGallery:Button=findViewById(R.id.btn_gallery)
        val btnCamera:Button=findViewById(R.id.btn_camera)
        val btnAlarm:Button=findViewById(R.id.btn_alarm)


        btnBrowse.setOnClickListener {
            if(txtBrowse.text.toString()!="")
            {
                Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://"+(txtBrowse.text.toString()))).apply {
                    startActivity(this)
                }
            }
            else{
                Toast.makeText(this,"Please enter URL",Toast.LENGTH_SHORT).show()
            }
        }
        btnCall.setOnClickListener {
            if(txtCall.text.toString()!="")
            {
                Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:"+txtCall.text.toString())).apply {
                    startActivity(this)
                }
            }
            else{
                Toast.makeText(this,"Please enter mobile number",Toast.LENGTH_SHORT).show()
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
        btnAlarm.setOnClickListener {
            if(txtAlarm.text.toString()!="")
            {
                Intent(AlarmClock.ACTION_SET_ALARM).apply {
                    this.putExtra(AlarmClock.EXTRA_MESSAGE, txtAlarm.text.toString())
                    this.putExtra(AlarmClock.EXTRA_HOUR, 10)
                    this.putExtra(AlarmClock.EXTRA_MINUTES, 30)
                    startActivity(this)
                }
            }
            else{
                Toast.makeText(this,"Please enter Alarm Name",Toast.LENGTH_SHORT).show()
            }
        }
    }
}