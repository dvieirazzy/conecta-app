package br.com.natura.conecta.ui.components.community

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.R
import br.com.natura.conecta.ui.theme.DarkGray
import br.com.natura.conecta.ui.theme.NaturaGradient
import br.com.natura.conecta.ui.theme.SoftGray

@Composable
fun LeaderCard() {
    Column(
        Modifier
            .background(Color.White)
            .padding(22.dp)
            .height(310.dp)
    ) {
        Text(
            text = "Contate sua Líder",
            fontSize = 22.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        Text(
            text = "Precisa de ajuda? Contate sua líder Natura para suporte e orientação :)",
            color = DarkGray,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        Card(
            modifier = Modifier
                .height(130.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                Modifier
                    .fillMaxSize()
                    .background(SoftGray)
                    .padding(0.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Image(
                    painter = painterResource(id = R.drawable.doubt_woman),
                    contentDescription = null,
                    modifier = Modifier.fillMaxHeight()
                )
                Button(
                    onClick = { },
                    modifier = Modifier
                        .width(100.dp)
                        .height(50.dp)
                        .align(Alignment.Bottom)
                        .padding(bottom = 10.dp),
                    contentPadding = PaddingValues(0.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                )
                {
                    Row(
                        modifier = Modifier
                            .background(NaturaGradient),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            text = "Contatar",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(start = 8.dp),
                            color = Color.White
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow),
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
private fun LeaderCardPReview() {
    LeaderCard()
}