package com.redwork.inc.components.navigation_drawer.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ScaffoldState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.redwork.inc.R
import com.redwork.inc.components.navigation_drawer.model.NavigationItem
import com.redwork.inc.ui.theme.black15Bold
import com.redwork.inc.ui.theme.black15Light
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Drawer(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavHostController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Profile,
        NavigationItem.History,
        NavigationItem.Calendar,
        NavigationItem.Settings
    )

    ModalDrawerSheet {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 14.dp)
                        .padding(start = 10.dp)
                        .wrapContentSize(),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.co), contentDescription = "profile image",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 13.dp),
                        text = "Cristian Anaya",
                        style = black15Bold,
                        fontSize = 22.sp
                    )
                }
            }
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach {
                NavigationDrawerItem(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 10.dp),
                    label = {
                        Text(
                            text = it.title,
                            style = black15Light
                        )
                    },
                    selected = currentRoute == it.route,
                    onClick = {
                        navController.navigate(it.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route = route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                    },
                    icon = {
                        Icon(painter = painterResource(id = it.icon), contentDescription = it.title)
                    }
                )
            }
        }
    }
}