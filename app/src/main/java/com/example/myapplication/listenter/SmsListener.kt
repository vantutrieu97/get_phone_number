package com.example.myapplication.listenter

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.telephony.SmsMessage


class SmsListener : BroadcastReceiver() {
    private val preferences: SharedPreferences? = null
    override fun onReceive(context: Context?, intent: Intent) {
        // TODO Auto-generated method stub
        if (intent.action == "android.provider.Telephony.SMS_RECEIVED") {
            val bundle = intent.extras //---get the SMS message passed in---
            var msgs: Array<SmsMessage?>? = null
            var msg_from: String
            if (bundle != null) {
                //---retrieve the SMS message received---
                try {
                    val pdus =
                        bundle["pdus"] as Array<Any>?
                    msgs = arrayOfNulls<SmsMessage>(pdus!!.size)
                    for (i in msgs.indices) {
                        msgs[i] = SmsMessage.createFromPdu(pdus[i] as ByteArray)
                        msg_from = msgs[i]?.getOriginatingAddress().toString()
                        val msgBody: String = msgs[i]?.getMessageBody() ?: "Tu ngu xi"

                        print("msg_from: $msg_from")
                        print("msgBody: $msgBody")
                    }
                } catch (e: Exception) {
//                            Log.d("Exception caught",e.getMessage());
                }
            }
        }
    }
}