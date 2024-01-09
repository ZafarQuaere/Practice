package com.zafar.learning

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class MyService : Service() {

    private val binder = MyServiceBinder()
    override fun onBind(intent: Intent): IBinder {
       return binder
    }

    fun doSomething () {
        println("MyService: doing some work >>>>> ")
    }

    inner class MyServiceBinder : Binder() {
        fun getService(): MyService = this@MyService
    }
}