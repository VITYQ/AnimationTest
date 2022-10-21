package com.vityq.testotkirilla.ui.presentation.onboarding.second

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vityq.testotkirilla.R
import com.vityq.testotkirilla.ui.presentation.AnimData
import com.vityq.testotkirilla.ui.view.PagerIndicator

@Composable
fun OnboardingTwoImage(modifier: Modifier, screen: Int) {
    val density = LocalDensity.current
    AnimatedVisibility(
        visible = screen == 1,
        enter = slideInVertically(
            initialOffsetY = { with(density) { -40.dp.roundToPx() } },
            animationSpec = tween(
                durationMillis = AnimData.animDurationImageIn,
                delayMillis = AnimData.animDelayImageIn
            )
        ) + fadeIn(
            initialAlpha = 0f,
            animationSpec = tween(
                durationMillis = AnimData.animDurationImageIn,
                delayMillis = AnimData.animDelayImageIn
            )
        ),
        exit = slideOutVertically(
            targetOffsetY = { with(density) { 200.dp.roundToPx() } },
            animationSpec = tween(durationMillis = AnimData.animDurationExitImage)
        ) +
                fadeOut(
                    targetAlpha = 0f,
                    animationSpec = tween(durationMillis = AnimData.animDurationExitImage)
                )
    ) {
        Image(
            modifier = modifier,
            painter = painterResource(id = R.drawable.ic_onboarding_2),
            contentDescription = null
        )
    }
}

@Composable
fun OnboardingSecondContent(modifier: Modifier, screen: Int, onContinueClick: () -> Unit) {
    val density = LocalDensity.current
    Box(
        modifier
    ) {
        AnimatedVisibility(
            screen == 1,
            enter = slideInHorizontally(
                initialOffsetX = { with(density) { 200.dp.roundToPx() } },
                animationSpec = tween(
                    durationMillis = AnimData.animDurationContentIn,
                    delayMillis = AnimData.animDelayContentIn
                )
            ) + fadeIn(
                initialAlpha = 0f,
                animationSpec = tween(
                    durationMillis = AnimData.animDurationContentIn,
                    delayMillis = AnimData.animDelayContentIn
                )
            ),
            exit = slideOutHorizontally(
                targetOffsetX = { with(density) { -200.dp.roundToPx() } },
                animationSpec = tween(durationMillis = AnimData.animDurationContentOut)
            ) +
                    fadeOut(targetAlpha = 0f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Анонимность",
                    style = MaterialTheme.typography.h3.copy(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "в сети",
                    style = MaterialTheme.typography.h3.copy(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(24.dp))
                PagerIndicator(
                    modifier = Modifier,
                    pagerCount = 3,
                    currentScreen = 1
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 32.dp),
                    text = "Не оставляет ни каких следов \n" +
                            "и защищает конфиденциальные даннные.\n" +
                            "\n" +
                            "Теперь никто не узнает где вы были что делали.",
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(64.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 48.dp)
                        .height(64.dp),
                    shape = MaterialTheme.shapes.medium,
                    onClick = { onContinueClick() }) {
                    Text(
                        text = "Понятно",
                        style = MaterialTheme.typography.button.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    )
                }
            }
        }
    }
}