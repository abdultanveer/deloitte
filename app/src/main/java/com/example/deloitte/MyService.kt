package com.example.deloitte

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    private val binder = LocalBinder()

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

    fun add(s1: Int,s2:Int):Int {
        return s1 + s2
    }

    override fun onBind(intent: Intent): IBinder? {
        return binder //binder as a pipe
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"service destroyed")


    }

    companion object{
        var TAG = MyService::class.java.simpleName
    }

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    inner class LocalBinder : Binder() {
        // Return this instance of LocalService so clients can call public methods
        fun getService(): MyService = this@MyService
    }




}