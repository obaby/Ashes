package com.smilehacker.ashes.foreground

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import com.smilehacker.ashes.R
import org.jetbrains.anko.startService

/**
 * Created by zhouquan on 16/5/23.
 */
class MyService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        doFake()
        Log.i("aa", "start fake")
        return super.onStartCommand(intent, flags, startId)
    }

    private fun doFake() {
        if (Build.VERSION.SDK_INT<= 17) {
            startForeground(R.id.notification, Notification())
        } else {
            startForeground(R.id.notification, Notification())
            startService<FakeService>()
        }
    }

}
