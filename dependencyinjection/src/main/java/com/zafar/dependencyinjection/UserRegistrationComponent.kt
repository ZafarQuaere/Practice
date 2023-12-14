package com.zafar.dependencyinjection

import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent

@ActivityScope
@Subcomponent( modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {

//    fun getUserRegistrationService(): UserRegistrationService
//
//    fun getEmailService(): EmailService


    // by creating builder
    @Subcomponent.Builder
    interface Builder {
        fun retryCount(@BindsInstance retryCount: Int): Builder
        fun build(): UserRegistrationComponent
    }


    fun inject(activity: MainActivity)

  /*  @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance retryCount: Int): UserRegistrationComponent
    }*/
}