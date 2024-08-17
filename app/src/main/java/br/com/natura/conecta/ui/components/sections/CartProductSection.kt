package br.com.natura.conecta.ui.components.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.model.Product
import br.com.natura.conecta.sampledata.cart
import br.com.natura.conecta.ui.components.checkout.CheckoutItemCard
import br.com.natura.conecta.ui.components.shop.CartProductCard
import br.com.natura.conecta.ui.components.shop.CartResumeCard
import br.com.natura.conecta.ui.components.widgets.ArrowButton
import br.com.natura.conecta.ui.theme.SoftGray

@Composable
fun CartProductSection(
    listState: LazyListState,
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit = {},
    onProductChanged: () -> Unit = {},
    onButtonClick: () -> Unit ={},
    onNavigateToProductDetails: (Product) -> Unit = {}
) {
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
                Text(
                    text = if (cart.isOpen()) "Meu Carrinho" else "Carrinho Fechado",
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

        if (cart.isOpen()) {
            items(cart.getProducts()) { it ->
                CartProductCard(
                    product = it,
                    onProductChanged = {
                        onProductChanged()
                    },
                    onNavigateToProductDetails = {
                        onNavigateToProductDetails(it)
                    }
                )
            }
        } else {
            item {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = SoftGray
                    )
                ) {
                    Text(
                        text = "Seu carrinho já foi fechado, junte-se a outras consultoras e escolha seu ponto de coleta no mapa, ou se preferir, edite seu carrinho.",
                        color = Color.Black,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
            items(cart.getProducts()) {
                CheckoutItemCard(it)
            }
        }


        item {
            Spacer(modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(SoftGray)
                .fillMaxWidth(0.95f)
                .height(2.dp)
            )
        }

        item {
            CartResumeCard(
                onButtonClick = {
                    onButtonClick()
                },
                modifier = Modifier.padding(vertical = 5.dp),
                buttonText = if (cart.isOpen()) "Fechar Carrinho" else "Editar Carrinho"
            )
        }
    }
}

@Preview
@Composable
private fun CardProductSectionPreview() {
    CartProductSection(rememberLazyListState())
}