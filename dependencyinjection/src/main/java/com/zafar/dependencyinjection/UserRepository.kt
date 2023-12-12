package com.zafar.dependencyinjection

import android.util.Log
import javax.inject.Inject

interface UserRepository {
    fun saveUser(email: String, password: String)
}

class SqlRepository @Inject constructor() : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d("$TAG SqlRepository", "User saved in SQL")
    }
}

class FirebaseRepository @Inject constructor() : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d("$TAG FirebaseRepository", "User saved in Firebase")
    }
}