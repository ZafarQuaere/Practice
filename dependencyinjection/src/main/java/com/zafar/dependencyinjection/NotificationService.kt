package com.zafar.dependencyinjection

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

interface NotificationService {
    fun send(notification: String, from: String, body: String)
}

@ActivityScope
class EmailService @Inject constructor() : NotificationService {
    override fun send(notification: String, from: String, body: String) {
        Log.d("$TAG EmailService", "Email sent")
    }
}

class MessageService() : NotificationService {
    override fun send(notification: String, from: String, body: String) {
        Log.d("$TAG MessageService", "Message sent >> retry count ")
    }
}