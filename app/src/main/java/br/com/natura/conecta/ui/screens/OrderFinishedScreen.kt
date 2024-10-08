package br.com.natura.conecta.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.R
import br.com.natura.conecta.ui.theme.DarkGray
import br.com.natura.conecta.ui.theme.NaturaGradient

@Composable
fun OrderFinishedScreen(
    onNavigateToShop: () -> Unit = {},
    onNavigateToHome: () -> Unit = {}
) {
    Box(
        Modifier
            .background(Color.White)
            .systemBarsPadding(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp, vertical = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.empty_cart_image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.80f)
                    .fillMaxHeight(0.50f)
            )
            Text(
                text = "Seu pedido foi feito com sucesso!",
                color = Color.Black,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                lineHeight = 40.sp,
                letterSpacing = 1.sp,
                modifier = Modifier.padding(bottom = 15.dp)
            )
            Text(
                text = "Obrigado por nos escolher! Sinta-se à vontade para continuar comprando e explorar nossa ampla gama de produtos. Você pode acompanhar o status do seu pedido na aba pedidos do home.",
                color = DarkGray,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    onNavigateToShop()
                },
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .height(50.dp),
                contentPadding = PaddingValues(0.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Row(
                    modifier = Modifier
                        .background(NaturaGradient)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Continuar Comprando",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }
            }
            TextButton(
                onClick = {
                    onNavigateToHome()
                },
                Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Text(
                    text = "Ir para o Home",
                    color = Color.White,
                    fontSize = 18.sp,
                    style = TextStyle(NaturaGradient)
                )
            }
        }
    }
}

@Preview
@Composable
private fun OrderFinishedScreenPreview() {
    OrderFinishedScreen()
}