package br.com.natura.conecta.ui.components.checkout

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.extensions.toBrazilianCurrency
import br.com.natura.conecta.model.Order
import br.com.natura.conecta.sampledata.sampleOrders
import br.com.natura.conecta.ui.theme.NaturaGradient
import br.com.natura.conecta.ui.theme.SoftGray

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun OrderResumeCard(modifier: Modifier = Modifier, order: Order) {
    Column(
        modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(22.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "Pedido " + order.type.toString().toLowerCase().capitalize(),
            fontSize = 30.sp,
            color = Color.Black,
            fontWeight = FontWeight.Light,
            modifier = Modifier
        )
        Text(
            text = "Meta de ${order.pointsTarget} pontos",
            style = TextStyle(NaturaGradient),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Text(
            text = "Tempo restante: " + String.format("%02dh %02d min", order.lastTime.hour, order.lastTime.minute),
            fontSize = 16.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(SoftGray)
            .fillMaxWidth(0.98f)
            .height(1.dp)
        )
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Total de Produtos",
                fontSize = 16.sp,
                color = Color.Black
            )
            Text(
                text = order.totalProducts.toString(),
                fontSize = 16.sp,
                color = Color.Black
            )
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Total de Pontos",
                fontSize = 16.sp,
                color = Color.Black
            )
            Text(
                text = order.points.toString(),
                fontSize = 16.sp,
                color = Color.Black
            )
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Preço Total",
                fontSize = 16.sp,
                color = Color.Black
            )
            Text(
                text = order.totalPrice.toBrazilianCurrency(),
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun OrderResumeCardPreview() {
    OrderResumeCard(order = sampleOrders.first())
}