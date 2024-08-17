package br.com.natura.conecta.ui.components.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import br.com.natura.conecta.model.Product
import br.com.natura.conecta.sampledata.cart
import br.com.natura.conecta.sampledata.sampleProducts
import br.com.natura.conecta.ui.components.shop.ProductCard
import br.com.natura.conecta.ui.components.widgets.SearchTextField
import br.com.natura.conecta.ui.theme.DarkGray
import br.com.natura.conecta.ui.theme.DarkOrange
import br.com.natura.conecta.ui.theme.NaturaGradient

@Composable
fun ProductSection(
    modifier: Modifier = Modifier,
    onNavigateToCart: () -> Unit = {},
    onNavigateToProductDetails: (Product) -> Unit = {},
) {
    var recompose by remember { mutableStateOf(false) }
    val listState = rememberLazyListState()
    var text by remember { mutableStateOf("") }

    val searchedProducts = remember(text) {
        if (text.isNotBlank()) {
            sampleProducts.filter {
                it.name.contains(text, ignoreCase = true) || it.code.contains(text, ignoreCase = true)
            }
        } else sampleProducts
    }

    key(recompose) {
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
                        text = "Vitrine",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        modifier = Modifier
                            .padding(15.dp)
                            .align(Alignment.Center)
                    )
                    Box(
                        modifier = modifier
                            .size(50.dp)
                            .align(Alignment.BottomEnd)
                    ) {
                        Button(
                            onClick = {
                                onNavigateToCart()
                            },
                            colors = ButtonDefaults.textButtonColors(containerColor = Color.Transparent),
                            contentPadding = PaddingValues(0.dp),
                            modifier = Modifier.size(35.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_cart_bag),
                                contentDescription = null,
                                tint = DarkOrange,
                                modifier = Modifier.fillMaxSize(0.9f)
                            )
                        }

                        if (cart.isOpen()) {
                            Box(
                                modifier = Modifier
                                    .size(20.dp)
                                    .background(NaturaGradient, shape = CircleShape)
                                    .align(Alignment.TopEnd),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = cart.getTotalProducts().toString(),
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

            item {
                SearchTextField(
                    searchText = text,
                    onSearchChange = {
                        text = it
                    },
                    shadow = false
                )
            }

            if (searchedProducts.isNotEmpty()) {
                items(searchedProducts) { it ->
                    ProductCard(
                        product = it,
                        onProductChange = {
                            recompose = !recompose
                        },
                        onNavigateToProductDetails = {
                            onNavigateToProductDetails(it)
                        }
                    )
                }
            } else {
                item {
                    Column(
                        Modifier.padding(top = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.product_not_found_image),
                            contentDescription = null,
                            modifier = Modifier.size(120.dp)
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Nenhum Produto Encontrado",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = DarkGray
                        )
                        Text(
                            text = "Sua pesquisa não corresponde a nenhum produto. Por favor, tente novamente.",
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp,
                            color = DarkGray
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(70.dp))
            }
        }
    }
}

@Preview
@Composable
private fun ProductCardSectionPreview() {
    ProductSection()
}