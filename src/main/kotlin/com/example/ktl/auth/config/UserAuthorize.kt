package com.example.ktl.auth.config

import org.springframework.security.access.prepost.PreAuthorize
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Retention

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.TYPE
)
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasRole('ROLE_USER')")
annotation class UserAuthorize()
