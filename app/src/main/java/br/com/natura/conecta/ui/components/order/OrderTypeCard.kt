package br.com.natura.conecta.ui.components.order

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.R
import br.com.natura.conecta.model.enums.OrderType
import br.com.natura.conecta.ui.theme.DarkOrange
import br.com.natura.conecta.ui.theme.NaturaGradient
import br.com.natura.conecta.ui.theme.SoftGray

@Composable
fun OrderTypeCard(
    modifier: Modifier = Modifier,
    orderType: OrderType,
    onOrderTypeClick: (OrderType) -> Unit = {}
) {
    Surface(
        modifier = modifier.clickable {
            onOrderTypeClick(orderType)
        },
        shape = RoundedCornerShape(15.dp),
        color = SoftGray
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(horizontal = 25.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
           Column(
               Modifier.fillMaxHeight(),
               verticalArrangement = Arrangement.Center
           ) {
               Text(
                   text = "Pedido " + orderType.toString().toLowerCase().capitalize(),
                   fontSize = 30.sp,
                   color = Color.Black,
                   fontWeight = FontWeight.Light,
                   modifier = Modifier
               )
               Text(
                   text = "${orderType.value} Pontos",
                   fontSize = 18.sp,
                   style = TextStyle(NaturaGradient)
               )
           }
            Icon(painter = painterResource(
                id = R.drawable.ic_simple_arrow),
                contentDescription = null,
                tint = DarkOrange
            )
        }
    }
}

@Preview
@Composable
private fun OrderTypeCardPreview() {
    OrderTypeCard(
        orderType = OrderType.MÍNIMO
    )
}