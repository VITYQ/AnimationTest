package com.vityq.testotkirilla.ui.view

import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vityq.testotkirilla.R

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun KlyaksaView(screen: Int) {
    AnimatedVisibility(
        visible = screen != -1,
        enter = fadeIn(animationSpec = tween(1000, 1000)),
        exit = fadeOut()
    ) {
        val klyaksaOneMovements = listOf(Pair(1f, 1f), Pair(0.9f, 0.1f), Pair(1.15f, 0.8f))
        val klyaksaTwoMovements = listOf(Pair(1f, 1f), Pair(0.95f, 2.5f), Pair(1.1f, 1.05f))
        val klyaksaThreeMovements = listOf(Pair(1f, 1f), Pair(2f, 0.9f), Pair(0.88f, 1.2f))
        val klyaksaOneX by
            animateFloatAsState(
                targetValue = if (screen != -1) klyaksaOneMovements[screen].first else 0f,
                animationSpec = tween(durationMillis = 3000, delayMillis = 500)
            )
        val klyaksaOneY by
            animateFloatAsState(
                targetValue = if (screen != -1) klyaksaOneMovements[screen].second else 0f,
                animationSpec = tween(durationMillis = 3000, delayMillis = 500)
            )
        val klyaksaTwoX by
            animateFloatAsState(
                targetValue = if (screen != -1) klyaksaTwoMovements[screen].first else 0f,
                animationSpec = tween(durationMillis = 3000, delayMillis = 500)
            )
        val klyaksaTwoY by
            animateFloatAsState(
                targetValue = if (screen != -1) klyaksaTwoMovements[screen].second else 0f,
                animationSpec = tween(durationMillis = 3000, delayMillis = 500)
            )
        val klyaksaThreeX by
            animateFloatAsState(
                targetValue = if (screen != -1) klyaksaThreeMovements[screen].first else 0f,
                animationSpec = tween(durationMillis = 3000, delayMillis = 500)
            )
        val klyaksaThreeY by
            animateFloatAsState(
                targetValue = if (screen != -1) klyaksaThreeMovements[screen].second else 0f,
                animationSpec = tween(durationMillis = 3000, delayMillis = 500)
            )
        Image(
            painter = painterResource(id = R.drawable.ic_klyaksa_1),
            contentDescription = null,
            modifier = Modifier
                .absoluteOffset(x = (-130*klyaksaOneX).dp, y = (40*klyaksaOneY).dp)
                .size(300.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_klyaksa_2),
            contentDescription = null,
            modifier = Modifier
                .absoluteOffset(x = (300*klyaksaTwoX).dp, y = (40*klyaksaTwoY).dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_klyaksa_3),
            contentDescription = null,
            modifier = Modifier
                .absoluteOffset(x = (32*klyaksaThreeX).dp, y = (-100*klyaksaThreeY).dp)
                .size(270.dp)
        )
    }
}