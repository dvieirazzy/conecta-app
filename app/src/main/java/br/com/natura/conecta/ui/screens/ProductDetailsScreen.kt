package br.com.natura.conecta.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.extensions.toBrazilianCurrency
import br.com.natura.conecta.model.enums.CartProductAddResponse
import br.com.natura.conecta.model.Product
import br.com.natura.conecta.sampledata.cart
import br.com.natura.conecta.sampledata.sampleProducts
import br.com.natura.conecta.ui.theme.ConectaTheme
import br.com.natura.conecta.ui.theme.DarkGray
import br.com.natura.conecta.ui.theme.NaturaGradient

@Composable
fun ProductDetailsScreen(product: Product, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        Modifier
            .background(Color.White)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .systemBarsPadding()
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(id = product.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.70f),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Natura | cod.${product.code}",
                    fontSize = 14.sp,
                    color = DarkGray
                )
                Text(
                    text = product.name,
                    fontSize = 24.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "${product.points} Pontos",
                    fontSize = 16.sp,
                    color = Color.Black,
                    style = TextStyle(NaturaGradient),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Pague: ${product.purchasePrice.toBrazilianCurrency()}",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 5.dp),
                    color = Color.Black
                )
                Text(
                    text = "Venda: ${product.salePrice.toBrazilianCurrency()}",
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Text(
                    text = product.description,
                    color = DarkGray,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 20.dp)
                )
                Button(
                    onClick = {
                        val cartResponse = cart.addProduct(product)
                        when(cartResponse) {
                            CartProductAddResponse.SUCCESS -> {
                                Toast.makeText(context, "Produto adicionado ao carrinho!", Toast.LENGTH_SHORT).show()
                            }
                            CartProductAddResponse.PRODUCT_ALREADY_ADDED -> {
                                Toast.makeText(context, "Este produto já está no carrinho!", Toast.LENGTH_SHORT).show()
                            }
                            CartProductAddResponse.CART_CLOSED -> {
                                Toast.makeText(context, "O carrinho está fechado!", Toast.LENGTH_SHORT).show()
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    contentPadding = PaddingValues(0.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                )
                {
                    Row(
                        modifier = Modifier
                            .background(NaturaGradient)
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Adicionar ao carrinho",
                            fontSize = 18.sp,
                            modifier = Modifier.padding(end = 10.dp),
                            color = Color.White
                        )
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            modifier = Modifier
                                .size(35.dp),
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ProductDetailsScreenPreview() {
    ConectaTheme {
        Surface {
            ProductDetailsScreen(
                product = sampleProducts.random(),
            )
        }
    }
}