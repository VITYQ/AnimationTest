package com.vityq.testotkirilla.ui.view

import android.graphics.drawable.Drawable
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vityq.testotkirilla.R

@Composable
fun IconTextRow(modifier: Modifier, text: String) {
    Row(modifier = modifier) {
        Image(painter = painterResource(id = R.drawable.ic_star), contentDescription = null)
        Spacer(modifier = Modifier.width(24.dp))
        Text(text = text, maxLines = 1)
    }
    
}