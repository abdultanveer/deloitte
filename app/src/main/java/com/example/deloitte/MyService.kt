package com.example.deloitte

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG,"service created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
         super.onStartCommand(intent, flags, startId)
        Log.i(TAG,"service started--"+intent?.getStringExtra("musicfilename"))
       // stopSelf()
        return START_STICKY


    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"service destroyed")


    }

    companion object{
        var TAG = MyService::class.java.simpleName
    }

}