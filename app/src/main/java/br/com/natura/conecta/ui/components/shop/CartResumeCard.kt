package br.com.natura.conecta.ui.components.shop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.extensions.toBrazilianCurrency
import br.com.natura.conecta.sampledata.cart
import br.com.natura.conecta.ui.theme.NaturaGradient

@Composable
fun CartResumeCard(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit = {},
    buttonText: String
) {
    Column(
        modifier
            .size(width = 320.dp, height = 200.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Total de Produtos",
                fontSize = 18.sp,
                color = Color.Black
            )
            Text(
                text = "${cart.getTotalProducts()}",
                fontSize = 18.sp,
                color = Color.Black
            )
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Total de Pontos",
                fontSize = 18.sp,
                color = Color.Black
            )
            Text(
                text = "${cart.getTotalPoints()}",
                fontSize = 18.sp,
                color = Color.Black
            )
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Preço Total",
                fontSize = 18.sp,
                color = Color.Black
            )
            Text(
                text = cart.getTotalPrice().toBrazilianCurrency(),
                fontSize = 18.sp,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                onButtonClick()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            contentPadding = PaddingValues(0.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        )
        {
            Row(
                modifier = Modifier
                    .background(NaturaGradient)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = buttonText,
                    fontSize = 18.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
private fun CardResumeCardPreview() {
    CartResumeCard(buttonText = "Fechar Carrinho")
}