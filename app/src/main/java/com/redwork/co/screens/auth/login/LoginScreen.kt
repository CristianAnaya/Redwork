package com.redwork.co.screens.auth.login

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.redwork.co.screens.auth.login.component.GetOTP
import com.redwork.co.screens.auth.login.component.LoginContent

@Composable

fun LoginScreen(navController: NavHostController = rememberNavController()) {

    Scaffold {
        LoginContent(it)
    }

    GetOTP()

}