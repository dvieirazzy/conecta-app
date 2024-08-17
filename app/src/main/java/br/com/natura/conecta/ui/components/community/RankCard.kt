package br.com.natura.conecta.ui.components.community

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.R
import br.com.natura.conecta.ui.theme.DarkGray
import br.com.natura.conecta.ui.theme.NaturaGradient

@Composable
fun RankCard(onNavigateToRank: () -> Unit = {}) {
    Column(
        Modifier
            .background(Color.White)
            .padding(22.dp)
    ) {
        Text(
            text = "Consultoras Brilhantes",
            fontSize = 22.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        Text(
            text = "Conheça as consultoras mais ativas nas compras coletivas!",
            color = DarkGray,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        Card(
            modifier = Modifier
                .height(115.dp)
                .fillMaxWidth()
                .clickable {
                    onNavigateToRank()
                },
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                Modifier
                    .fillMaxSize()
                    .background(NaturaGradient)
                    .padding(vertical = 10.dp, horizontal = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Top Consultoras",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Confira sua posição no rank!",
                        color = Color.White,
                        fontSize = 12.sp
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_click),
                        contentDescription = null,
                        modifier = Modifier.graphicsLayer {
                            scaleX = -1f
                        },
                        tint = Color.White
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.winners),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 40.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun RankCardPreview() {
    RankCard()
}