package com.zafar.dependencyinjection

import javax.inject.Qualifier
import javax.inject.Scope

@Qualifier
@MustBeDocumented
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class MessageQualifier()

@Scope
@MustBeDocumented
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope()