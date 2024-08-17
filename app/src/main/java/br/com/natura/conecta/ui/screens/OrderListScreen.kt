package br.com.natura.conecta.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.natura.conecta.model.Order
import br.com.natura.conecta.model.enums.OrderType
import br.com.natura.conecta.ui.components.sections.OrderSection
import br.com.natura.conecta.ui.theme.SoftGray

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun OrderListScreen(
    onNavigateBack: () -> Unit = {},
    orderType: OrderType,
    onNavigateToOrderDetails: (Order) -> Unit = {}
) {
    Column(
        Modifier
            .background(SoftGray)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OrderSection(
            onNavigateBack = {
                onNavigateBack()
            },
            onNavigateToOrderDetails = {
                onNavigateToOrderDetails(it)
            },
            orderType = orderType
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun OrderListScreenPreview() {
    OrderListScreen(
        orderType = OrderType.CLÁSSICO
    )
}