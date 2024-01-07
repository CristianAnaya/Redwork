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
import androidx.compose.material.icons.rounded.Menu
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
    viewModel.getCategories()

    Scaffold(
        modifier =
        Modifier.fillMaxSize()
    ) {
        GetAvailableCategories(paddingValues = it)
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AvailableCategoryScreenPreview() {
    AvailableCategoryScreen(rememberNavController())
}