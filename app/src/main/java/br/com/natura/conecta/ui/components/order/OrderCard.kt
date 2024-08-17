package br.com.natura.conecta.ui.components.order

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.model.Order
import br.com.natura.conecta.sampledata.sampleOrders
import br.com.natura.conecta.ui.theme.NaturaGradient
import br.com.natura.conecta.ui.theme.SoftGray
import java.text.SimpleDateFormat
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun OrderCard(
    order: Order,
    number: Int,
    onNavigateToOrderDetails: () -> Unit = {}
) {
    Surface(
        modifier = Modifier.height(200.dp),
        shape = RoundedCornerShape(15.dp),
        color = SoftGray
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .background(Color.White)
                .clickable {
                    onNavigateToOrderDetails()
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                Modifier
                    .background(NaturaGradient)
                    .fillMaxHeight()
                    .fillMaxWidth(0.35F),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier
                        .padding(vertical = 15.dp)
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = number.toString(),
                        color = Color.White,
                        fontSize = 50.sp
                    )
                    Text(
                        text = "Tempo Restante:",
                        color = Color.White,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(0.70f)
                    )
                    Text(
                        text = String.format("%02dh %02d min", order.lastTime.hour, order.lastTime.minute),
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Pedido ${order.type.toString().lowercase(Locale.getDefault()).capitalize(Locale.getDefault())}",
                    color = Color.Black,
                    fontSize = 25.sp,
                    modifier = Modifier.fillMaxWidth(0.75f)
                )
                Text(
                    text = "Meta de ${order.type.value} pontos",
                    fontSize = 16.sp,
                    style = TextStyle(NaturaGradient),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(SoftGray)
                    .fillMaxWidth()
                    .height(2.dp),
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Pontos",
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                    Text(
                        text = order.points.toString(),
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Consultoras",
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                    Text(
                        text = order.consultants.size.toString(),
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Data de entrega",
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                    val formattedDate = SimpleDateFormat("dd/MM", Locale.getDefault())
                        .format(order.date)
                    Text(
                        text = formattedDate,
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun OrderCardOPreview() {
    OrderCard(
        order = sampleOrders.first(),
        number = 2
    )
}