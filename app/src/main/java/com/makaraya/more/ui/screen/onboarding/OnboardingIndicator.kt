package com.makaraya.more.ui.screen.onboarding

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.*
import androidx.compose.runtime.*


@Composable
fun OnboardingIndicator(
    pageCount: Int,
    currentPage: Int,
    selectedColor: String = "#1D4371",
    unselectedColor: String = "#D9D9D9",
    indicatorWidth: Dp = 16.dp,
    indicatorHeight: Dp = 16.dp,
    selectedIndicatorWidth: Dp = 36.dp
) {
    val selectedColorValue = Color(android.graphics.Color.parseColor(selectedColor))
    val unselectedColorValue = Color(android.graphics.Color.parseColor(unselectedColor))

    Row(
        modifier = Modifier.height(indicatorHeight),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pageCount) { index ->
            val width by animateDpAsState(
                targetValue = if (index == currentPage) selectedIndicatorWidth else indicatorWidth,
                animationSpec = tween(durationMillis = 300)
            )
            val color by animateColorAsState(
                targetValue = if (index == currentPage) selectedColorValue else unselectedColorValue,
                animationSpec = tween(durationMillis = 300)
            )

            Box(
                modifier = Modifier
                    .width(width)
                    .height(indicatorHeight)
                    .background(color, shape = if (index == currentPage) RoundedCornerShape(8.dp) else CircleShape)
            )

            if (index < pageCount - 1) {
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}





