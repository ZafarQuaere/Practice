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

        // This is how we get the UserRegistrationService dependency using Dagger
//        val component = DaggerUserRegistrationComponent.builder()
//            .notificationServiceModule(NotificationServiceModule(3))
//            .build()

        val appComponent = (application as UserApplication).component

//        val userRegistrationComponent = appComponent.getUserRegistrationComponentFactory().create(3)
        val userRegistrationComponent = appComponent.getUserRegistrationComponentBuilder().retryCount(3).build()

        userRegistrationComponent.inject(this)


        userRegistrationService.registerUser("abc@gail.com", "password")

    }
}

