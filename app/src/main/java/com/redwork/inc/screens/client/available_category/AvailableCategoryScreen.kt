package com.redwork.inc.screens.client.available_category

import android.util.Log
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
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.redwork.inc.R
import com.redwork.inc.components.navigation_drawer.model.DrawerItems
import com.redwork.inc.navigation.screen.client.ClientScreen
import com.redwork.inc.screens.client.available_category.components.GetAvailableCategories
import com.redwork.inc.ui.theme.PrimaryDark
import com.redwork.inc.ui.theme.black15Bold
import com.redwork.inc.ui.theme.black15Light
import com.redwork.inc.ui.theme.white20Bold
import kotlinx.coroutines.launch

@Composable
fun AvailableCategoryScreen(
    navController: NavController,
    viewModel: AvailableCategoryViewModel = hiltViewModel()
) {
    Log.d("TAG", "AvailableCategoryScreen: ")
    viewModel.getCategories()

    val drawerItem = listOf(
        DrawerItems(Icons.Default.Face, "Profile", ClientScreen.Profile.route),
        DrawerItems(Icons.Default.DateRange, "Request", ClientScreen.History.route),
        DrawerItems(Icons.Default.Warning, "Report", ClientScreen.Report.route),
        DrawerItems(Icons.Default.Settings, "Setting", ClientScreen.Settings.route)
    )

    var selectedItem by remember { mutableStateOf(drawerItem[0]) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
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
                    drawerItem.forEach {
                        NavigationDrawerItem(
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .padding(top = 10.dp),
                            label = {
                                Text(
                                    text = it.text,
                                    style = black15Light
                                )
                            },
                            selected = it == selectedItem,
                            onClick = {
                                navController.navigate(it.route)
                                selectedItem = it
                                scope.launch {
                                    drawerState.close()
                                }
                            },
                            icon = {
                                Icon(imageVector = it.icon, contentDescription = it.text)
                            }
                        )
                    }
                }
            }
        },
        drawerState = drawerState
        ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "Redwork"
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Rounded.ArrowBack,
                                contentDescription = "Menu",
                                tint = Color.White
                            )
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = PrimaryDark
                    ),
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                                tint = Color.White
                            )
                        }
                    }
                )
            }
        ) {
            GetAvailableCategories(paddingValues = it)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AvailableCategoryScreenPreview() {
    AvailableCategoryScreen(rememberNavController())
}