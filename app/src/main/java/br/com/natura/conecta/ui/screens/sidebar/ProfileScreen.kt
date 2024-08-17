package br.com.natura.conecta.ui.screens.sidebar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.R
import br.com.natura.conecta.ui.components.home.StatusCard
import br.com.natura.conecta.ui.theme.DarkGray
import br.com.natura.conecta.ui.theme.DarkOrange
import br.com.natura.conecta.ui.theme.NaturaGradient
import br.com.natura.conecta.ui.theme.SoftGray

@Composable
fun ProfileScreen(
    onNavigateToLevels: () -> Unit = {}
) {
    Column(
        Modifier
            .background(NaturaGradient)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(SoftGray)
                .padding(bottom = 7.dp)
        ) {
            Box {
                Box(
                    modifier = Modifier
                        .clip(diagonalCutShape())
                        .fillMaxWidth()
                        .height(300.dp)
                        .background(NaturaGradient)
                ) {}
                Image(painter = painterResource(id = R.drawable.consultant_user_photo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(bottom = 15.dp)
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.BottomCenter)
                )
            }
            Text(
                text = "Helena Dias",
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(vertical = 5.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Consultora Ouro",
                fontSize = 16.sp,
                color = DarkGray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Row(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .padding(top = 15.dp, start = 22.dp, end = 22.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth(0.70f),
                    contentPadding = PaddingValues(0.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color.White,
                        contentColor = DarkOrange
                    )
                ) {
                    Text(
                        text = "Editar perfil",
                        fontSize = 18.sp,
                        color = DarkOrange
                    )
                }
                Button(
                    onClick = {},
                    modifier = Modifier.size(50.dp),
                    contentPadding = PaddingValues(0.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color.White,
                        contentColor = DarkOrange
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_camera),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp),
                        tint = DarkOrange
                    )
                }
            }
            StatusCard(
                modifier = Modifier.padding(horizontal = 22.dp, vertical = 10.dp),
                onNavigateToLevels = {
                    onNavigateToLevels()
                }
            )
            Column(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 15.dp, horizontal = 22.dp),
                verticalArrangement = Arrangement.spacedBy(22.dp)
            ) {
                ProfileCard(
                    title = "Ingressou em",
                    number = "22 de Julho de 2024",
                    icon = R.drawable.ic_calendar
                )
                ProfileCard(
                    title = "Participação",
                    number = "16 Compras Coletivas",
                    icon = R.drawable.ic_cart
                )
                ProfileCard(
                    title = "Pontos",
                    number = "+620 Pontos",
                    icon = R.drawable.ic_graphic
                )
            }
        }
    }
}

fun diagonalCutShape() = GenericShape { size, _ ->
    moveTo(size.width, 0f)
    lineTo(size.width, size.height / 2f)
    lineTo(0f, size.height)
    lineTo(0f, 0f)
    close()
}

@Composable
fun ProfileCard(
    modifier: Modifier = Modifier,
    title: String,
    number: String,
    @DrawableRes icon: Int
) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id =  icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .size(50.dp)
                    .graphicsLayer(alpha = 0.99f)
                    .drawWithCache {
                        onDrawWithContent {
                            drawContent()
                            drawRect(NaturaGradient, blendMode = BlendMode.SrcAtop)
                        }
                    }
            )
            Column {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Text(
                    text = number,
                    fontSize = 16.sp,
                    color = DarkGray
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen()
}