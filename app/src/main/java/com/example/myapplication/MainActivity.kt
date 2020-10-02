package com.example.myapplication

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.telephony.TelephonyManager


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // check permission

        var readSMS = ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_SMS
        ) != PackageManager.PERMISSION_GRANTED;
        var readPhoneNumber = ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_PHONE_NUMBERS
        ) != PackageManager.PERMISSION_GRANTED

        var readPhoneState = ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_PHONE_STATE
        ) != PackageManager.PERMISSION_GRANTED

        val getSimNumber = if (readSMS && readPhoneNumber && readPhoneState
        ) {

            val telemamanger =
                getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            val getSimSerialNumber = telemamanger.simSerialNumber
            telemamanger.line1Number
        } else {
            return
        }


    }


}

