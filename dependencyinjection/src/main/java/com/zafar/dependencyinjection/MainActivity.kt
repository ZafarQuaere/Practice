package com.zafar.dependencyinjection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import javax.inject.Inject


class MainActivity : FragmentActivity() {

    @Inject
    lateinit var userRegistrationService: UserRegistrationService

    @Inject
    lateinit var emailService: EmailService

    @Inject
    lateinit var emailService1: EmailService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Below is the manual way to add dependency
//        val userRepository = UserRepository()
//        val emailService = EmailService()
//        val userRegistrationService = UserRegistrationService(userRepository, emailService)]

        // This is how we get the UserRegistrationService dependency using Dagger
//        val component = DaggerUserRegistrationComponent.builder()
//            .notificationServiceModule(NotificationServiceModule(3))
//            .build()

//        val component = DaggerUserRegistrationComponent.factory().create(3)
        val component =  (application as UserApplication).component

        component.inject(this)
//        val userRegistrationService = component.getUserRegistrationService()
//        val emailService = component.getEmailService()

        userRegistrationService.registerUser("abc@gail.com", "password")

    }
}

