package br.com.natura.conecta.ui.components.shop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.R
import br.com.natura.conecta.extensions.toBrazilianCurrency
import br.com.natura.conecta.model.Product
import br.com.natura.conecta.sampledata.cart
import br.com.natura.conecta.sampledata.sampleProducts
import br.com.natura.conecta.ui.theme.NaturaGradient
import br.com.natura.conecta.ui.theme.Pink
import br.com.natura.conecta.ui.theme.SoftGray

@Composable
fun CartProductCard(
    product: Product,
    modifier: Modifier = Modifier,
    onProductChanged: () -> Unit = {},
    onNavigateToProductDetails: (Product) -> Unit ={}
) {
    var quantity by remember { mutableIntStateOf(product.quantity) }
    Surface(
        modifier = modifier.clickable {
            onNavigateToProductDetails(product)
        },
        shape = RoundedCornerShape(15.dp),
        color = SoftGray
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Image(
                painter = painterResource(id = product.image),
                contentDescription = null,
                Modifier
                    .size(130.dp)
                    .align(Alignment.CenterVertically)
                    .clip(shape = RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.60f)
                    .padding(start = 10.dp)
            ) {
                Text(
                    text = product.name,
                    fontSize = 14.sp,
                    color = Color.Black,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = "${product.points} Pontos",
                    fontSize = 16.sp,
                    color = Color.Black,
                    style = TextStyle(NaturaGradient),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = product.purchasePrice.toBrazilianCurrency(),
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                IconButton(
                    onClick = {
                        product.quantity = 1
                        cart.removeProduct(product)
                        onProductChanged()
                    },
                    modifier = Modifier.align(Alignment.End)
                    ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_trash),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp),
                        tint = Pink
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .clip(CircleShape)
                        .fillMaxWidth()
                        .height(30.dp)
                        .background(Color.White)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_minus),
                        contentDescription = null,
                        modifier = Modifier
                            .size(10.dp)
                            .clickable {
                                if (quantity > 1) {
                                    product.quantity--
                                    quantity--
                                    onProductChanged()
                                }
                            },
                        tint = Color.Black
                    )
                    Text(
                        text = "$quantity",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_plus),
                        contentDescription = null,
                        modifier = Modifier
                            .size(10.dp)
                            .clickable {
                                product.quantity++
                                quantity++
                                onProductChanged()
                            },
                        tint = Color.Black
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun CardProductCardPreview() {
    CartProductCard(sampleProducts.random())
}