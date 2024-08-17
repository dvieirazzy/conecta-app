package br.com.natura.conecta.ui.components.sections

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.model.Order
import br.com.natura.conecta.sampledata.sampleOrders
import br.com.natura.conecta.ui.components.checkout.ConsultantCard
import br.com.natura.conecta.ui.theme.DarkGray

@Composable
fun ConsultantsSection(modifier: Modifier = Modifier, order: Order, points: List<Int>) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Juntas neste pedido",
            fontSize = 22.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 22.dp, bottom = 5.dp)
        )
        Text(
            text = "Confira quem já está aproveitando todos os benefícios dessa compra conjunta!",
            modifier = Modifier.padding(start = 22.dp, end = 22.dp, bottom = 15.dp),
            color = DarkGray,
            fontSize = 14.sp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 22.dp),
            horizontalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            order.consultants.forEachIndexed { index, consultant ->
                ConsultantCard(
                    consultant = consultant,
                    points = points[index]
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun ConsultantsSectionPreview() {
    ConsultantsSection(
        order = sampleOrders.first(),
        points = listOf(33, 33, 33, 33, 33, 33, 33)
    )
}