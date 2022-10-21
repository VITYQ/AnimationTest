package com.vityq.testotkirilla.ui.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vityq.testotkirilla.ui.theme.TestOtKirillaTheme
import com.vityq.testotkirilla.ui.theme.primary

@Composable
fun PagerIndicator(modifier: Modifier, pagerCount: Int, currentScreen: Int) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = modifier) {
        val density = LocalDensity.current
        var counter = 0
        for (i in 0..pagerCount - 1) {
            if (currentScreen == counter) {
                Canvas(modifier = modifier.size(14.dp)) {
                    drawCircle(
                        center = Offset(size.width / 2f, size.height / 2f),
                        color = primary,
                        radius = size.height/2
                    )
                }
            } else {
                Canvas(modifier = modifier.size(14.dp)) {
                    drawCircle(
                        center = Offset(size.width / 2f, size.height / 2f),
                        color = Color.LightGray,
                        radius = (size.height/2)*0.7f
                    )
                }
            }
            counter++
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun PagerIndicatorPreview() {
    TestOtKirillaTheme() {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            PagerIndicator(modifier = Modifier, pagerCount = 3, currentScreen = 0)
        }
    }
}