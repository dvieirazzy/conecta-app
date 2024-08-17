package br.com.natura.conecta.ui.screens

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.model.Order
import br.com.natura.conecta.sampledata.cart
import br.com.natura.conecta.sampledata.orderChose
import br.com.natura.conecta.sampledata.sampleOrders
import br.com.natura.conecta.ui.components.checkout.BenefitsCard
import br.com.natura.conecta.ui.components.checkout.InviteCard
import br.com.natura.conecta.ui.components.checkout.OrderResumeCard
import br.com.natura.conecta.ui.components.sections.ConsultantsSection
import br.com.natura.conecta.ui.components.widgets.ArrowButton
import br.com.natura.conecta.ui.theme.NaturaGradient
import br.com.natura.conecta.ui.theme.SoftGray
import kotlin.random.Random

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun OrderDetailsScreen(
    order: Order,
    onNavigateToCheckout: () -> Unit = {},
    onNavigateBack: () -> Unit = {}
) {
    val context = LocalContext.current
    Column(
        Modifier
            .background(SoftGray)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(SoftGray)
                .padding(vertical = 22.dp),
            verticalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            Box(
                Modifier.fillMaxWidth().padding(horizontal = 22.dp)
            ) {
                ArrowButton(
                    rotateArrow = true,
                    modifier = Modifier.align(Alignment.CenterStart),
                    onNavigateBack = {
                        onNavigateBack()
                    }
                )
                Text(
                    text = "Detalhes do pedido",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxSize(0.40f),
                    textAlign = TextAlign.Center
                )
            }
            OrderResumeCard(
                modifier = Modifier.padding(horizontal = 22.dp),
                order = order
            )
            BenefitsCard(
                modifier = Modifier.padding(horizontal = 22.dp)
            )
            ConsultantsSection(
                order = order,
                points = divideNumber(order.points, order.consultants.size)

            )
            InviteCard(
                modifier = Modifier.padding(horizontal = 22.dp)
            )
            Button(
                onClick = {
                    if (cart.isClosed()) {
                        onNavigateToCheckout()
                        orderChose = order
                    } else {
                        Toast.makeText(context, "Feche seu carrinho primeiro!", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 22.dp),
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(15.dp),
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
                        text = "Entrar no Pedido",
                        fontSize = 18.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

fun divideNumber(number: Int, parts: Int): List<Int> {
    val result = MutableList(parts) { 0 }
    var remaining = number

    for (i in 0 until parts - 1) {
        val maxPart = remaining - (parts - i - 1)
        val part = Random.nextInt(1, maxPart + 1)
        result[i] = part
        remaining -= part
    }

    result[parts - 1] = remaining

    return result
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun OrderDetailsScreenPreview() {
    OrderDetailsScreen(order = sampleOrders.first())
}