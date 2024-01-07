package com.redwork.inc.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.redwork.inc.R
import com.redwork.inc.navigation.screen.client.ClientScreen
import com.redwork.inc.ui.theme.PrimaryDark
import com.redwork.inc.ui.theme.black20Bold
import com.redwork.inc.ui.theme.white25Bold
import com.redwork.inc.ui.theme.white30Bold
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DefaultTopBar(
    title: String,
    upAvailable: Boolean = false,
    navController: NavHostController? = null
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = black20Bold
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.White
        ),
        navigationIcon = {
            if (upAvailable) {
                IconButton(onClick = { navController?.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "",
                        tint = Color.Black
                    )
                }
            }
        }
    )
}

@Composable
fun TopBar(scope: CoroutineScope, scaffoldState: ScaffoldState, currentScreen: String) {
    val screenTitle = when (currentScreen) {
        ClientScreen.Home.route -> "Inicio"
        ClientScreen.Profile.route -> "Perfil"
        ClientScreen.Request.route -> "Tu Agenda"
        ClientScreen.History.route -> "Tu historial"
        ClientScreen.Settings.route -> "Configuración"
        else -> "Inicio"
    }
    TopAppBar(
        title = {
            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = screenTitle,
                style = white25Bold
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.round_menu),
                    contentDescription = "menu",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = PrimaryDark
        )
    )
}