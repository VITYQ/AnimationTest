package com.vityq.testotkirilla.ui.presentation.onboarding.third

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vityq.testotkirilla.R
import com.vityq.testotkirilla.ui.presentation.AnimData
import com.vityq.testotkirilla.ui.view.IconTextRow
import com.vityq.testotkirilla.ui.view.PagerIndicator

@Composable
fun OnboardingThreeImage(modifier: Modifier, screen: Int) {
    val density = LocalDensity.current
    AnimatedVisibility(
        visible = screen == 2,
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
            animationSpec = tween(durationMillis = AnimData.animDurationImageIn, delayMillis = 1000)
        ) +
                fadeOut(targetAlpha = 0f)
    ) {
        Image(
            modifier = modifier,
            painter = painterResource(id = R.drawable.ic_onboarding_3),
            contentDescription = null
        )
    }
}

@Composable
fun OnboardingThreeContent(modifier: Modifier, screen: Int, onContinueClick: () -> Unit) {
    val density = LocalDensity.current
    Box(
        modifier
    ) {
        AnimatedVisibility(
            screen == 2,
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
            exit = fadeOut(targetAlpha = 0f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Почувствуй",
                    style = MaterialTheme.typography.h3.copy(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "все преимущества",
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
                    currentScreen = 2
                )
                Spacer(modifier = Modifier.height(24.dp))
                // СЮДА ПИСАТЬ
                Column(
                    modifier = Modifier.padding(horizontal = 64.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    IconTextRow(modifier = Modifier, text = "Автоматизация")
                    IconTextRow(modifier = Modifier, text = "Самые быстрые соединения")
                    IconTextRow(modifier = Modifier, text = "Трафик без ограничений")
                }
                Spacer(modifier = Modifier.height(16.dp))
                TextButton(onClick = { onContinueClick() }) {
                    Text(text = "В другой раз", fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 48.dp)
                        .height(64.dp),
                    shape = MaterialTheme.shapes.medium,
                    onClick = { onContinueClick() }) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Попробовать",
                            style = MaterialTheme.typography.button.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        )
                        Text(
                            text = "Бесплатный период 3 дня",
                            fontSize = 14.sp,
                            color = Color.LightGray
                        )
                    }
                }
            }
        }
    }
}