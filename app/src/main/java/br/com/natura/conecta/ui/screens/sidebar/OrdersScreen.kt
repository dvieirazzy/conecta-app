package br.com.natura.conecta.ui.screens.sidebar

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
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
import br.com.natura.conecta.sampledata.orderFinished
import br.com.natura.conecta.ui.components.order.OrderCard
import br.com.natura.conecta.ui.components.widgets.ArrowButton
import br.com.natura.conecta.ui.theme.DarkGray
import br.com.natura.conecta.ui.theme.SoftGray

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun OrdersScreen(onNavigateBack: () -> Unit = {}) {
    Column(
        Modifier
            .background(SoftGray)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(22.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                Modifier.fillMaxWidth().padding(bottom = 22.dp)
            ) {
                ArrowButton(
                    rotateArrow = true,
                    modifier = Modifier.align(Alignment.CenterStart),
                    onNavigateBack = {
                        onNavigateBack()
                    }
                )
                Text(
                    text = "Seus Pedidos",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier
                        .align(Alignment.Center),
                    textAlign = TextAlign.Center
                )
            }
            if (orderFinished != null) {
                OrderCard(
                    order = orderFinished!!,
                    1
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.no_orders_image),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 100.dp)
                        .fillMaxWidth(0.80f)
                        .fillMaxHeight(0.50f)
                )
                Text(
                    text = "Você ainda não realizou nenhum pedido. Que tal explorar nossos produtos e fazer seu primeiro pedido?",
                    color = DarkGray,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(0.80f)
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun OrdersScreenPreview() {
    OrdersScreen()
}