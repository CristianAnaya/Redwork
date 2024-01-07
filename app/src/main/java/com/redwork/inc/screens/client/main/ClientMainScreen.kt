package com.redwork.inc.screens.client.main

import android.annotation.SuppressLint
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.redwork.inc.components.TopBar
import com.redwork.inc.components.navigation_drawer.model.NavigationItem
import com.redwork.inc.components.navigation_drawer.content.Drawer
import com.redwork.inc.navigation.graph.client.ClientNavGraph

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ClientMainScreen(navController: NavHostController = rememberNavController()) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    val scope = rememberCoroutineScope()

    val currentBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentScreen = currentBackStackEntry?.destination?.route ?: NavigationItem.Home.route

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState, currentScreen = currentScreen) },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        drawerBackgroundColor = Color.White,
        drawerGesturesEnabled = true
    ) {
        ClientNavGraph(navController = navController)
    }
}


