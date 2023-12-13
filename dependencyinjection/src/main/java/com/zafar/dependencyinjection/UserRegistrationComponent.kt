package com.zafar.dependencyinjection

import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(dependencies = [AppLevelComponent::class], modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {

//    fun getUserRegistrationService(): UserRegistrationService
//
//    fun getEmailService(): EmailService

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance retryCount: Int, appLevelComponent: AppLevelComponent): UserRegistrationComponent
    }
}