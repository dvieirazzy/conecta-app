package br.com.natura.conecta.ui.components.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.R
import br.com.natura.conecta.sampledata.cart
import br.com.natura.conecta.sampledata.consultant
import br.com.natura.conecta.sampledata.orderChose
import br.com.natura.conecta.sampledata.orderFinished
import br.com.natura.conecta.ui.components.checkout.CheckoutItemCard
import br.com.natura.conecta.ui.components.shop.CartResumeCard
import br.com.natura.conecta.ui.components.widgets.ArrowButton
import br.com.natura.conecta.ui.theme.DarkOrange
import br.com.natura.conecta.ui.theme.NaturaGradient
import br.com.natura.conecta.ui.theme.SoftGray

@Composable
fun CheckoutSection(
    listState: LazyListState,
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit = {},
    onFinishOrder: () -> Unit ={}
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
                    text = "Revisão de Pedido",
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

        items(cart.getProducts()) {
            CheckoutItemCard(it)
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
            Column(
                Modifier.padding(vertical = 5.dp)
            ) {
                Text(
                    text = "Pagamento",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(500),
                    color = Color.Black
                )
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        Modifier.padding(top = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "VISA",
                            Modifier
                                .background(
                                    NaturaGradient,
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .padding(4.dp),
                            color = Color.White,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(
                                text = "VISA Classic",
                                color = Color.Black,
                                fontSize = 16.sp
                            )
                            Text(
                                text = "****-0976",
                                letterSpacing = 4.sp,
                                color = Color.Black,
                                fontSize = 16.sp
                            )
                        }
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.ic_simple_arrow),
                        contentDescription = null,
                        tint = DarkOrange
                    )
                }
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
                    orderChose!!.points += cart.getTotalPoints()
                    orderChose!!.consultants += consultant
                    orderFinished = orderChose
                    onFinishOrder()
                },
                modifier = Modifier.padding(vertical = 5.dp),
                buttonText = "Finalizar Pedido"
            )
        }
    }
}

@Preview
@Composable
private fun CheckoutSectionPreview() {
    CheckoutSection(rememberLazyListState())
}