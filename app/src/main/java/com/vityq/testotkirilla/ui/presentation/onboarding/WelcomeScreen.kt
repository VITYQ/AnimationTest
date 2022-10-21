package com.vityq.testotkirilla.ui.presentation.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vityq.testotkirilla.ui.presentation.onboarding.first.OnboardingFirstContent
import com.vityq.testotkirilla.ui.presentation.onboarding.first.OnboardingFirstImage
import com.vityq.testotkirilla.ui.presentation.onboarding.second.OnboardingSecondContent
import com.vityq.testotkirilla.ui.presentation.onboarding.second.OnboardingTwoImage
import com.vityq.testotkirilla.ui.presentation.onboarding.third.OnboardingThreeContent
import com.vityq.testotkirilla.ui.presentation.onboarding.third.OnboardingThreeImage
import com.vityq.testotkirilla.ui.theme.primary
import com.vityq.testotkirilla.ui.view.BezierLine
import com.vityq.testotkirilla.ui.view.KlyaksaView

@Composable
fun WelcomeScreen() {
    var screen by remember { mutableStateOf(-1) }
    Box(
        Modifier
            .fillMaxSize()
            .background(primary),
    ) {
        KlyaksaView(screen)


        Box(modifier = Modifier.align(Alignment.Center)) {
            AnimatedVisibility(
                visible = screen == -1,
                exit = fadeOut(),
                enter = fadeIn()
            ) {
                Button(
                    modifier = Modifier
                        .size(128.dp)
                        .align(Alignment.Center),
                    onClick = { screen++ },
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White,
                        contentColor = primary
                    )
                ) {
                    Text(
                        text = "GO",
                        fontSize = 48.sp,
                        fontWeight = FontWeight.ExtraLight
                    )
                }
            }
        }


        OnboardingFirstImage(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 36.dp), screen = screen
        )
        OnboardingTwoImage(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 36.dp),
            screen = screen
        )
        OnboardingThreeImage(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 36.dp),
            screen = screen
        )

        BezierLine(
            Modifier
                .fillMaxSize()
                .padding(top = 200.dp),
            screen
        )
        OnboardingFirstContent(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 54.dp),
            screen = screen
        ) {
            screen++
        }

        OnboardingSecondContent(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 54.dp),
            screen = screen
        ) {
            screen++
        }
        OnboardingThreeContent(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 36.dp),
            screen = screen
        ) {
            screen = -1
        }
    }
}