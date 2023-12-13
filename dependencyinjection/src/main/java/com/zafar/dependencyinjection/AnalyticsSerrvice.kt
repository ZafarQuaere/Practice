package com.zafar.dependencyinjection

import android.util.Log
import javax.inject.Singleton

@Singleton
interface AnalyticsService {
    fun trackEvent(eventName: String, eventType: String)
}

class MixpanelAnalytics() : AnalyticsService {
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d("$TAG MixpanelAnalyticsService", "Event tracked $eventName $eventType")
    }
}
class FirebaseAnalytics() : AnalyticsService {
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d("$TAG FirebaseAnalyticsService", "Event tracked $eventName $eventType")
    }
}