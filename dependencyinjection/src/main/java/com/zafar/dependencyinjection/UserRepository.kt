package com.zafar.dependencyinjection

import android.util.Log
import javax.inject.Inject

interface UserRepository {
    fun saveUser(email: String, password: String)
}

class SqlRepository @Inject constructor(val analyticsService: AnalyticsService) : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d("$TAG SqlRepository", "User saved in SQL")
        analyticsService.trackEvent("User saved", "CREATE")
    }
}

class FirebaseRepository @Inject constructor(val analyticsService: AnalyticsService) : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d("$TAG FirebaseRepository", "User saved in Firebase")
        analyticsService.trackEvent("User saved", "CREATE")
    }
}