package com.example.deloitte

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Toast
import java.util.*

class ServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
    }

    fun serviceHandler(view: View) {
        when(view.id){
            R.id.btnStart ->{
            var serviceIntent = Intent(this,MyService::class.java)
                serviceIntent.putExtra("musicfilename","somemusic.mp3")
                startService(serviceIntent)
            }
            R.id.btnStop ->{
                var serviceIntent = Intent(this,MyService::class.java)
                stopService(serviceIntent)
            }
            R.id.btnBind -> {
                var serviceIntent = Intent(this,MyService::class.java)
                bindService(serviceIntent,serviceConnection, BIND_AUTO_CREATE)
            }
        }
    }

    private val serviceConnection = object : ServiceConnection{
        override fun onServiceConnected(connctionName: ComponentName?, binder: IBinder?) {
        //binder returned by bind method of the service
            val binder = binder as MyService.LocalBinder
           var myService =  binder.getService()  //var myService = new Myservice()
            //i'll play with myService object as it was my local variab;e
           var result = myService.add(10,20);
            Toast.makeText(applicationContext,"the result is"+result,Toast.LENGTH_SHORT).show()

        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            TODO("Not yet implemented")
        }

    }
}