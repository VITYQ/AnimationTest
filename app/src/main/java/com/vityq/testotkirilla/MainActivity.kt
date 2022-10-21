package com.vityq.testotkirilla

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vityq.testotkirilla.ui.presentation.onboarding.WelcomeScreen
import com.vityq.testotkirilla.ui.presentation.onboarding.first.OnboardingFirstContent
import com.vityq.testotkirilla.ui.presentation.onboarding.first.OnboardingFirstImage
import com.vityq.testotkirilla.ui.presentation.onboarding.second.OnboardingSecondContent
import com.vityq.testotkirilla.ui.presentation.onboarding.second.OnboardingTwoImage
import com.vityq.testotkirilla.ui.presentation.onboarding.third.OnboardingThreeContent
import com.vityq.testotkirilla.ui.presentation.onboarding.third.OnboardingThreeImage
import com.vityq.testotkirilla.ui.theme.TestOtKirillaTheme
import com.vityq.testotkirilla.ui.theme.primary
import com.vityq.testotkirilla.ui.view.BezierLine
import com.vityq.testotkirilla.ui.view.KlyaksaView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestOtKirillaTheme {
                WelcomeScreen()
            }
        }
    }
}

