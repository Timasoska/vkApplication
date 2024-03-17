package com.example.vkapplication.biometric

enum class BiometricAuthStatus(val id: Int) {
    READY(1),
    NOT_AVAILABLE(0),
    TEMPORARY_NOT_AVAILABLE(-1),
    AVAILABLE_BUT_NOT_ENROLLED(-2)
}