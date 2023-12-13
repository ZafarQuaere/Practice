package com.zafar.dependencyinjection

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AnalyticsModule::class])
interface AppLevelComponent {
    fun getAnalyticsService(): AnalyticsService
}