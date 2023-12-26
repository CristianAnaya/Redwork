package com.redwork.inc.screens.auth.login

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.redwork.inc.screens.auth.login.components.GetOTP
import com.redwork.inc.screens.auth.login.components.Login
import com.redwork.inc.screens.auth.login.components.LoginContent
import com.redwork.inc.screens.auth.register_client.RegisterClientScreen

@Composable
fun LoginScreen(navController: NavHostController) {

    Scaffold(modifier = Modifier.fillMaxSize()) {
        LoginContent(it)
    }
    GetOTP()
    Login(navController = navController)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}