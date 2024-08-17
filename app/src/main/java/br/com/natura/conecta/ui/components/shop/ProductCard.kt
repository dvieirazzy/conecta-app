package br.com.natura.conecta.ui.components.shop

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
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
import br.com.natura.conecta.ui.theme.DarkGray
import br.com.natura.conecta.ui.theme.NaturaGradient

@Composable
fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier,
    onProductChange: () -> Unit = {},
    onNavigateToProductDetails: (Product) -> Unit = {}
) {
    val context = LocalContext.current
    Surface(
        modifier = modifier.clickable {
              onNavigateToProductDetails(product)
        },
        shape = RoundedCornerShape(15.dp),
        color = Color.White
    ) {
        Column(
            Modifier
                .padding(15.dp)
                .heightIn(200.dp, 205.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = null,
                    Modifier
                        .size(150.dp)
                        .padding(15.dp)
                        .align(Alignment.CenterVertically)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )
                Column {
                    Text(
                        text = "Natura | cod.${product.code}",
                        fontSize = 14.sp,
                        color = DarkGray
                    )
                    Text(
                        text = product.name,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "${product.points} Pontos",
                        fontSize = 16.sp,
                        color = Color.Black,
                        style = TextStyle(NaturaGradient),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column {
                    Text(
                        text = "Pague: ${product.purchasePrice.toBrazilianCurrency()}",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 5.dp),
                        color = Color.Black
                    )
                    Spacer(Modifier.weight(1f))
                    Text(
                        text = "Venda: ${product.salePrice.toBrazilianCurrency()}",
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }
                Button(
                    onClick = {
                        val cartResponse = cart.addProduct(product)
                        when(cartResponse) {
                            CartProductAddResponse.SUCCESS -> {
                                Toast.makeText(context, "Produto adicionado ao carrinho!", Toast.LENGTH_SHORT).show()
                                onProductChange()
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
                        .fillMaxSize(0.90f),
                    contentPadding = PaddingValues(0.dp),
                    shape = RoundedCornerShape(10.dp),
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
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            text = "Adicionar",
                            fontSize = 18.sp,
                            modifier = Modifier.padding(start = 8.dp),
                            color = Color.White
                        )
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                                .padding(end = 8.dp),
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
private fun ProductCardPreview() {
    ProductCard(sampleProducts.random())
}
