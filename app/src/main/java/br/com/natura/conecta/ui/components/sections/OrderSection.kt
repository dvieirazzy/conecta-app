package br.com.natura.conecta.ui.components.sections

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.R
import br.com.natura.conecta.model.Order
import br.com.natura.conecta.model.enums.OrderType
import br.com.natura.conecta.sampledata.sampleOrders
import br.com.natura.conecta.ui.components.order.OrderCard
import br.com.natura.conecta.ui.components.widgets.ArrowButton
import br.com.natura.conecta.ui.theme.DarkOrange
import br.com.natura.conecta.ui.theme.NaturaGradient

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit = {},
    orderType: OrderType,
    onNavigateToOrderDetails: (Order) -> Unit = {}
) {
    val filteredOrders = sampleOrders.filter {
        it.type == orderType
    }

    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(22.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Box(
                Modifier.fillMaxWidth()
            ) {
                Box(
                    Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Pedidos em aberto",
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
            }
        }
        itemsIndexed(filteredOrders) {index, order ->
            OrderCard(
                order,
                index + 1,
                onNavigateToOrderDetails = {
                    onNavigateToOrderDetails(order)
                }
            )
        }

        item {
            Spacer(modifier = Modifier.height(70.dp))
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun OrderSectionPreview() {
    OrderSection(orderType = OrderType.CLÁSSICO)
}