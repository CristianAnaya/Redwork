package com.redwork.inc.screens.client.available_category.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.redwork.domain.category.model.Category
import com.redwork.inc.R
import com.redwork.inc.ui.theme.PrimaryDark
import com.redwork.inc.ui.theme.lightGray15
import com.redwork.inc.ui.theme.white20Bold
import com.redwork.inc.ui.theme.white25Bold
import com.redwork.inc.ui.theme.white30Bold
import com.redwork.inc.utils.ResourceUtils

@Composable
fun AvailableCategoryContent(
    paddingValues: PaddingValues,
    categories: List<Category>
) {

    Box(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .background(PrimaryDark)
    ) {
        Image(
            painter = painterResource(id = R.drawable.marks),
            contentDescription = "marks",
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier.padding(10.dp)
        ) {

            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = "Qué necesitas?",
                style = white30Bold
            )

            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(3),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalItemSpacing = 16.dp,
            ) {
                items(categories.size) {
                    val category = categories[it]
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .width(70.dp)
                                .height(70.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.White)
                        ) {
                            val iconResourceId = ResourceUtils.getIconResourceId(category.route, LocalContext.current)

                            Image(
                                painter = painterResource(id = R.drawable.carpenter),
                                contentDescription = category.name,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(8.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .padding(PaddingValues(5.dp))
                            )
                        }

                        Text(
                            text = category.name,
                            style = lightGray15
                        )
                    }

                }
            }
        }
    }

}