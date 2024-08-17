package br.com.natura.conecta.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.sampledata.cart
import br.com.natura.conecta.ui.components.sections.CheckoutSection
import br.com.natura.conecta.ui.theme.DarkOrange
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CheckoutScreen(
    onOrderFinished: () -> Unit = {},
    onNavigateBack: () -> Unit = {}
) {
    val scope = rememberCoroutineScope()
    var isLoading by remember { mutableStateOf(false) }
    val listState = rememberLazyListState()

    Box(
        Modifier
            .background(Color.White)
            .systemBarsPadding(),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(50.dp),
                    color = DarkOrange
                )
                Text(
                    text = "Finalizando o pedido...",
                    color = DarkOrange,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(top = 30.dp)
                )
            }
        } else {
            CheckoutSection(
                listState = listState,
                onNavigateBack = {
                    onNavigateBack()
                },
                onFinishOrder = {
                    isLoading = true
                    scope.launch {
                        delay(3000)
                        cart.emptyCart()
                        onOrderFinished()
                    }
                }
            )
        }
    }
}

@Preview
@Composable
private fun CheckoutScreenPreview() {
    CheckoutScreen()
}