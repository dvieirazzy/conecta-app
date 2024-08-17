package br.com.natura.conecta.ui.components.community

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
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
import br.com.natura.conecta.ui.theme.NaturaGradient
import br.com.natura.conecta.ui.theme.PinkOrange

@Composable
fun ReferCard() {
    Surface(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        color = Color.White
    ) {
        Row(
            Modifier.background(Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.happy_woman),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 5.dp)
                    .align(Alignment.Bottom)
            )
            Column(
                Modifier
                    .background(Color.White)
                    .padding(top = 22.dp)
            ) {
                Text(
                    text = "Indique e Ganhe",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                Box(
                    Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(NaturaGradient)
                        .padding(2.dp)
                ) {
                    Text(
                        text = "Até 100 pontos",
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_simple_arrow),
                contentDescription = null,
                tint = PinkOrange,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@Preview
@Composable
private fun ReferCardPreview() {
    ReferCard()
}