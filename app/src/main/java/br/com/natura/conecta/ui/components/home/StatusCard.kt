package br.com.natura.conecta.ui.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.ui.theme.DarkGray
import br.com.natura.conecta.ui.theme.NaturaGradient
import br.com.natura.conecta.ui.theme.Orange
import br.com.natura.conecta.ui.theme.SoftGray

@Composable
fun StatusCard(
    modifier: Modifier = Modifier,
    onNavigateToLevels: () -> Unit = {}
) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        modifier = modifier.fillMaxWidth(),
        color = Color.White
    ) {
        Column(
            Modifier
                .width(320.dp)
                .height(250.dp)
                .padding(22.dp)
        ) {
            Text(
                text = "Meus Resultados",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "Ufa! Você conseguiu manter o seu nível!",
                fontSize = 14.sp,
                color = DarkGray,
                modifier = Modifier.padding(top = 8.dp)

            )
            Column(
                Modifier
                    .padding(vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "350 Pontos",
                        fontSize = 14.sp,
                        color = Orange,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "400",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = SoftGray
                    )
                }
                Box {
                    Row(
                        Modifier
                            .height(13.dp)
                            .fillMaxWidth()
                            .background(
                                color = SoftGray,
                                shape = RoundedCornerShape(10.dp)
                            )
                    ) {}
                    Row(
                        Modifier
                            .height(13.dp)
                            .fillMaxWidth(0.875f)
                            .background(
                                brush = NaturaGradient,
                                shape = RoundedCornerShape(10.dp)
                            )
                    ) {}
                }
            }
            Text(
                text = "Você ainda pode subir de nível se aumentar seus pontos até dia 25/06/2024!",
                fontSize = 14.sp,
                color = DarkGray
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Conheça os Níveis",
                fontSize = 18.sp,
                style = TextStyle(NaturaGradient),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    onNavigateToLevels()
                }
            )
        }
    }
}

@Preview
@Composable
private fun StatusCardPreview() {
    StatusCard()
}