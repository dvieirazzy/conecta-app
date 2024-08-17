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
import androidx.compose.runtime.key
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
import br.com.natura.conecta.model.enums.CartStatus
import br.com.natura.conecta.model.Product
import br.com.natura.conecta.sampledata.cart
import br.com.natura.conecta.ui.components.sections.CartProductSection
import br.com.natura.conecta.ui.components.shop.EmptyCartView
import br.com.natura.conecta.ui.theme.DarkOrange
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CartScreen(
    onNavigateBack: () -> Unit = {},
    onNavigateToClosedCart: () -> Unit = {},
    onNavigateToProductDetails: (Product) -> Unit = {}
) {
    val scope = rememberCoroutineScope()
    val recompose = remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

    val listState = rememberLazyListState()

    key(recompose.value) {
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
                        text = if (cart.isOpen()) "Fechando Carrinho..." else "Abrindo o carrinho novamente...",
                        color = DarkOrange,
                        fontSize = 22.sp,
                        modifier = Modifier.padding(top = 30.dp)
                    )
                }
            } else {
                when (cart.getStatus()) {
                    CartStatus.EMPTY-> {
                        EmptyCartView(
                            onNavigateBack = {
                                onNavigateBack()
                            }
                        )
                    }
                    CartStatus.OPEN, CartStatus.CLOSED -> {
                        CartProductSection(
                            listState = listState,
                            onNavigateBack = {
                                onNavigateBack()
                            },
                            onProductChanged = {
                                recompose.value = !recompose.value
                            },
                            onButtonClick = {
                                isLoading = true
                                scope.launch {
                                    delay(3000)
                                    if (cart.isOpen()) {
                                        onNavigateToClosedCart()
                                        cart.closeCart()
                                    } else {
                                        isLoading = false
                                        cart.openCart()
                                    }
                                }
                            },
                            onNavigateToProductDetails = {
                                onNavigateToProductDetails(it)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CartScreenPreview() {
    CartScreen()
}