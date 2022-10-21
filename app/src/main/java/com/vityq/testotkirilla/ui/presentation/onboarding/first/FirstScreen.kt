package com.vityq.testotkirilla.ui.presentation.onboarding.first

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
import com.vityq.testotkirilla.ui.view.PagerIndicator

@Composable
fun OnboardingFirstImage(modifier: Modifier, screen: Int) {
    val density = LocalDensity.current
    AnimatedVisibility(
        visible = screen == 0,
        enter = slideInVertically(
            initialOffsetY = { with(density) { -40.dp.roundToPx() } },
            animationSpec = tween(durationMillis = 1000, delayMillis = 1000)
        ) + fadeIn(
            initialAlpha = 0f,
            animationSpec = tween(durationMillis = 1000, delayMillis = 1000)
        ),
        exit = slideOutVertically(
            targetOffsetY = { with(density) { 200.dp.roundToPx() } },
            animationSpec = tween(durationMillis = 1000)
        ) +
                fadeOut(targetAlpha = 0f)
    ) {
        Image(
            modifier = modifier,
            painter = painterResource(id = R.drawable.ic_onboarding_1),
            contentDescription = null
        )
    }
}

@Composable
fun OnboardingFirstContent(modifier: Modifier, screen: Int, onContinueClick: () -> Unit) {
    val density = LocalDensity.current
    Box(
        modifier
    ) {
        AnimatedVisibility(
            screen == 0,
            enter = slideInVertically(
                initialOffsetY = { with(density) { -40.dp.roundToPx() } },
                animationSpec = tween(durationMillis = 500, delayMillis = 1000)
            ) + fadeIn(
                initialAlpha = 0f,
                animationSpec = tween(durationMillis = 500, delayMillis = 1000)
            ),
            exit = slideOutHorizontally(
                targetOffsetX = { with(density) { -200.dp.roundToPx() } },
                animationSpec = tween(durationMillis = 500)
            ) +
                    fadeOut(targetAlpha = 0f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Автоматическое",
                    style = MaterialTheme.typography.h3.copy(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Подключение",
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
                    currentScreen = 0
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 32.dp),
                    text = "Теперь не нужно каждый раз нажимать кнопку подключения VPN\n" +
                            "\n" +
                            "Настрой автоматическое подключение \n" +
                            "для тех приложений которыми ты обычно пользуешься и больше не думать отключен ли VPN на твоем устройстве.",
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(24.dp))
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