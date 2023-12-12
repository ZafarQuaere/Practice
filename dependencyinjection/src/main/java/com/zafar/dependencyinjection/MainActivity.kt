package com.zafar.dependencyinjection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import javax.inject.Inject


class MainActivity : FragmentActivity() {

    @Inject
    lateinit var userRegistrationService: UserRegistrationService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Below is the manual way to add dependency
//        val userRepository = UserRepository()
//        val emailService = EmailService()
//        val userRegistrationService = UserRegistrationService(userRepository, emailService)]

        // This is how we get the UserRegistrationService dependency using Dagger
        val component = DaggerUserRegistrationComponent.builder().build()
        component.inject(this)
//        val userRegistrationService = component.getUserRegistrationService()
//        val emailService = component.getEmailService()

        userRegistrationService.registerUser("abc@gail.com", "password")

    }
}

