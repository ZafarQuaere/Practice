package com.zafar.dependencyinjection

import android.app.Application

class UserApplication: Application() {

    lateinit var component: UserRegistrationComponent
    override fun onCreate() {
        super.onCreate()
        component = DaggerUserRegistrationComponent.factory().create(3)
    }
}