package br.com.natura.conecta.ui.components.home

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.R
import br.com.natura.conecta.model.Info
import br.com.natura.conecta.ui.components.widgets.ArrowButton

@Composable
fun InfoCard(info: Info, modifier: Modifier = Modifier) {
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
        modifier = modifier.scale(scale)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed = true
                        tryAwaitRelease()
                        isPressed = false
                    }
                )
            },
        color = Color.White
    ) {
        Column(
            Modifier
                .width(300.dp)
                .height(380.dp)
        ) {
            Column(
                Modifier.padding(
                    start = 22.dp,
                    end = 22.dp,
                    top = 25.dp
                )
            ) {
                Text(
                    text = info.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = info.text,
                    Modifier.padding(top = 10.dp, bottom = 15.dp),
                    color = Color.Gray,
                    fontSize = 16.sp
                )
                ArrowButton()
            }
            Spacer(Modifier.weight(1f))
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(
                        start = 8.dp,
                        end = 8.dp,
                        bottom = 8.dp,
                        top = 10.dp
                    )
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Image(
                    painter = painterResource(id = info.image),
                    contentDescription = "Imagem produto Natura",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF00FF00)
@Composable
private fun InfoCardPreview() {
    InfoCard(
        Info(
            title = "Novidades da Semana",
            text = "Confira todas as promoções que preparamos para você!",
            image = R.drawable.infocard_2
        )
    )
}