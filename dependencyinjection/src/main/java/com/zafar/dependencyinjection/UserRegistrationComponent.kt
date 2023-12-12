package com.zafar.dependencyinjection

import dagger.Component

@Component(modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {

//    fun getUserRegistrationService(): UserRegistrationService
//
//    fun getEmailService(): EmailService

    fun inject(activity: MainActivity)
}