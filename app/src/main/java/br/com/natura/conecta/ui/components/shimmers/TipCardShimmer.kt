package br.com.natura.conecta.ui.components.shimmers

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.natura.conecta.extensions.shimmerEffect
import br.com.natura.conecta.ui.theme.SoftGray

@Composable
fun TipCardShimmer(modifier: Modifier = Modifier) {
    var isPressed by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        animationSpec = tween(
            durationMillis = 200,
            easing = { it }
        ), label = ""
    )

    Surface(
        shape = RoundedCornerShape(15.dp),
        color = Color.White,
        modifier = modifier.scale(scale)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed = true
                        tryAwaitRelease()
                        isPressed = false
                    }
                )
            }
    ) {
        Column(
            Modifier
                .size(width = 270.dp, height = 380.dp)
                .background(SoftGray)
                .padding(15.dp)
        ) {
            Box(
                Modifier
                    .padding(bottom = 10.dp)
                    .height(20.dp)
                    .width(150.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .shimmerEffect()
            ) {}
            Box(
                Modifier
                    .height(20.dp)
                    .fillMaxWidth(0.90f)
                    .clip(RoundedCornerShape(5.dp))
                    .shimmerEffect()
            ) {}
        }
    }
}

@Preview
@Composable
private fun TipCardShimmerPreview() {
    TipCardShimmer()
}