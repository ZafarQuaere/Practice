package com.zafar.dependencyinjection

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class UserRepositoryModule {

/*    @Provides
    fun getSqlRepository(sqlRepository: SqlRepository): UserRepository { // because SqlRepository is already injected dagger can create the object itself
        return sqlRepository
    }*/

    @Binds
    abstract fun getFirebaseRepository(firebaseRepository: FirebaseRepository): UserRepository
}