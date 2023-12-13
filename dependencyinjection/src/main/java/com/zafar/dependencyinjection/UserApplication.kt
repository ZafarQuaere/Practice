package com.zafar.dependencyinjection

import android.app.Application

class UserApplication: Application() {

    lateinit var component: AppLevelComponent
    override fun onCreate() {
        super.onCreate()
        component = DaggerAppLevelComponent.builder().build()
    }
}