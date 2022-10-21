package com.vityq.testotkirilla.ui.view

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vityq.testotkirilla.ui.theme.TestOtKirillaTheme

@Composable
fun BezierLine(modifier: Modifier, screen: Int) {
    val xOffset = listOf(0f, 1f, 1.3f)
    val yOffset = listOf(0f, 1.2f, 1f)
    val density = LocalDensity.current
    val x by animateFloatAsState(
        targetValue = if (screen >= 0) xOffset[screen] else 0f,
        animationSpec = tween(800)
    )
    val y by animateFloatAsState(
        targetValue = if (screen >= 0) yOffset[screen] else 0f,
        animationSpec = tween(1000)
    )
    val scaleOffset by animateFloatAsState(
        targetValue = if (screen == -1) 5f else 1f,
        animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
    )
    val yOff by animateFloatAsState(
        targetValue = if (screen == -1) 1f else 0f,
        animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
    )

    Column(modifier = modifier
        .scale(scaleOffset)
        .graphicsLayer { translationY = 1800f * yOff }) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            translate(left = -size.width * x, top = density.run { 100.dp.toPx() } * y) {
                val path = Path()
                path.moveTo(0f, size.height / 2)
                path.cubicTo(
                    size.width * 0.4f,
                    (size.height / 2) - (size.width * 0.05f),
                    size.width * 0.6f,
                    (size.height / 2) + (size.width * 0.3f),
                    size.width,
                    (size.height / 2) - (size.width * 0.1f)
                )
                path.cubicTo(
                    size.width * 1.5f,
                    (size.height / 2f) - (size.width * 0.5f),
                    size.width * 1.7f,
                    (size.height / 2) - (size.width * 0.05f),
                    size.width * 2f,
                    (size.height / 2) - (size.width * 0.1f)
                )
                path.quadraticBezierTo(
                    size.width * 2.5f,
                    (size.height / 2) - (size.width * 0.2f),
                    size.width * 2.5f,
                    (size.height / 2) - (size.width * 0.4f)
                )
                path.lineTo(size.width * 2.5f, size.height)
                path.lineTo(0f, size.height)
                path.close()
                drawPath(
                    path,
                    color = Color.White
                )
            }
        }
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRect(color = Color.White)
        }
    }
}

@Preview(showBackground = true, heightDp = 640, widthDp = 320)
@Composable
fun BezierPreview() {
    TestOtKirillaTheme() {
        Column(Modifier.fillMaxSize()) {
            BezierLine(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(200.dp), 0
            )
        }
    }
}
