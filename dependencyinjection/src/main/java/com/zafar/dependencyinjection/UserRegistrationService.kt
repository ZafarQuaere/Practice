package com.zafar.dependencyinjection

import javax.inject.Inject
import javax.inject.Named

class UserRegistrationService @Inject constructor(
    private val userRepository: UserRepository,
    @MessageQualifier private val notificationService: NotificationService
) {

    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send("abc@gail.com", "subject", "body")
    }

}