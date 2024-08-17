package br.com.natura.conecta.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.natura.conecta.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen() {
    val visible = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(500)
        visible.value = true
    }

    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding(),
    ) {
        AnimatedVisibility(
            modifier = Modifier
                .fillMaxSize(0.85f)
                .align(Alignment.Center),
            visible = visible.value,
            enter = fadeIn(animationSpec = tween(durationMillis = 2000))
        ) {
            Image(
                painter = painterResource(id = R.drawable.splash_logo),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen()
}