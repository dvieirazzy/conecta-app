package br.com.natura.conecta.ui.components.shop

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.R
import br.com.natura.conecta.ui.components.widgets.ArrowButton
import br.com.natura.conecta.ui.theme.DarkGray

@Composable
fun EmptyCartView(onNavigateBack: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(22.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 120.dp)
        ) {
            Text(
                text = "Meu Carrinho",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                modifier = Modifier
                    .padding(15.dp)
                    .align(Alignment.Center)
            )
            ArrowButton(
                rotateArrow = true,
                modifier = Modifier.align(Alignment.CenterStart),
                onNavigateBack = {
                    onNavigateBack()
                }
            )
        }
        Image(
            painter = painterResource(id = R.drawable.empty_cart_image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.80f)
                .fillMaxHeight(0.50f)
        )
        Text(
            text = "Ops! Carrinho vazio...",
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            lineHeight = 40.sp,
            letterSpacing = 1.sp,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        Text(
            text = "Seu carrinho está vazio por enquanto, que tal explorar nossa sessão de produtos?",
            color = DarkGray,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun EmptyCartViewPreview() {

}