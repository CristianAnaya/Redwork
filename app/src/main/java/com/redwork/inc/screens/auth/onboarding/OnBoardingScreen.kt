package com.redwork.inc.screens.auth.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.redwork.inc.R
import com.redwork.inc.screens.auth.onboarding.components.OnBoardingData
import com.redwork.inc.screens.auth.onboarding.components.OnBoardingPager
import com.redwork.inc.screens.auth.onboarding.components.SaveFirstTime
import com.redwork.inc.screens.auth.onboarding.components.rememberPagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(navController: NavHostController) {
    val items = ArrayList<OnBoardingData>()

    items.add(
        OnBoardingData(
            R.raw.intro1,
            "Infinidades de servicios",
            "Escoge el servicio que se adapte a tus necesidades"
        )
    )

    items.add(
        OnBoardingData(
            R.raw.intro2,
            "Los mejores profesionales del hogar",
            "Encontraras diferentes tipos de profesionales que estaran dispuestos a darte una mano"
        )
    )

    items.add(
        OnBoardingData(
            R.raw.intro3,
            "Tu opinión vale",
            "Recibe tu servicio y califica para mejorar la experiencia de todos."
        )
    )
    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )

    Scaffold() {
        OnBoardingPager(
            item = items,
            pagerState = pagerState,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(color = Color.White)
        )
    }

    SaveFirstTime(navController = navController)
}