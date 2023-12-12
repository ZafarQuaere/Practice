package com.zafar.dependencyinjection

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationServiceModule() {

    @Provides
    fun getEmailService(emailService: EmailService): NotificationService {
        return emailService
    }

    @MessageQualifier
    @Provides
    fun getMessageService(): NotificationService {
        return MessageService()
    }
}