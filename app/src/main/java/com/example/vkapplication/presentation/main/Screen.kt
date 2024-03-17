package com.example.vkapplication.presentation.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavHostController
import com.example.vkapplication.biometric.BiometricAuth
import com.example.vkapplication.biometric.BiometricAuthStatus

@Composable
fun Screen(navController: NavHostController, biometricAuthenticator: BiometricAuth) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        val activity = LocalContext.current as FragmentActivity
        var message by remember {
            mutableStateOf("")
        }

        // Проверяем доступность биометрической аутентификации
        when (biometricAuthenticator.isBiometricAvailable()) {
            BiometricAuthStatus.READY -> {
                // Если биометрическая аутентификация доступна, отображаем кнопку для входа
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextButton(
                        onClick = {
                            // Запускаем процесс аутентификации по отпечатку пальца
                            biometricAuthenticator.promptBiometricAuth(
                                title = "Login",
                                subTitle = "Use your fingerprint",
                                negativeButtonText = "Cancel",
                                fragmentActivity = activity,
                                onSuccess = {
                                    // При успешной аутентификации переходим на главный экран
                                    navController.navigate("main") {
                                        popUpTo("screen") { inclusive = true }
                                    }
                                },
                                onError = { _, errorString ->
                                    message = errorString.toString()
                                },
                                onFailed = {
                                    message = "Verification error"
                                }
                            )
                        }
                    ) {
                        Text(text = "Sign in with fingerprint")
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = message)
                }
            }
            else -> {
                // Если биометрическая аутентификация недоступна, отображаем соответствующее сообщение
                Text(
                    text = "Biometric authentication is not available",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}