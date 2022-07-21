package com.example.deloitte

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.widget.Toast


class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
       // intent.action
        //Toast.makeText(context,"received an sms - deloitte",Toast.LENGTH_SHORT).show()

        val bundle = intent.extras
        var msgs: Array<SmsMessage?>? = null
        var str = ""
        if (bundle != null) {
            //---retrieve the SMS message received---
            val pdus = bundle["pdus"] as Array<Any>?
            msgs = arrayOfNulls<SmsMessage>(pdus!!.size)
            for (i in msgs.indices) {
                msgs!![i] = SmsMessage.createFromPdu(pdus!![i] as ByteArray)
                str += "SMS from " + msgs!![i]?.getOriginatingAddress()
                str += " :"
                str += msgs!![i]?.getMessageBody().toString()
                str += "\n"
            }
            //---display the new SMS message---
            Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
        }
    }
}