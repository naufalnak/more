package com.makaraya.more.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.makaraya.more.model.OnboardingPage
import com.makaraya.more.presentation.OnboardingScreen

@Composable
fun OnboardingView(
    pages: List<OnboardingPage>,
    onComplete: () -> Unit
) {
    var currentPage by remember { mutableStateOf(0) }

    if (currentPage < pages.size) {
        OnboardingScreen(
            page = pages[currentPage],
            onNextClicked = {
                currentPage++
                if (currentPage == pages.size) {
                    onComplete()
                }
            },
            pageCount = pages.size,
            currentPage = currentPage
        )
    }
}
