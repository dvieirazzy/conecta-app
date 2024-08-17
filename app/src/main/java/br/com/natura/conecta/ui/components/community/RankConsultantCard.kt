package br.com.natura.conecta.ui.components.community

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.model.Consultant
import br.com.natura.conecta.sampledata.sampleConsultants
import br.com.natura.conecta.ui.theme.DarkGray
import br.com.natura.conecta.ui.theme.NaturaGradient

@Composable
fun RankConsultantCard(consultant: Consultant) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(130.dp, 135.dp),
        color = Color.White
    ) {
        Row(
            modifier = Modifier.padding(15.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .size(100.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${consultant.position}º",
                    color = Color.White,
                    fontSize = 60.sp,
                    style = TextStyle(NaturaGradient)
                )
            }
            Column(
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Column {
                    Text(
                        text = consultant.name,
                        fontSize = 22.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "${consultant.city} - ${consultant.state}",
                        color = DarkGray,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "Nível: ${consultant.level}",
                        color = DarkGray,
                        fontSize = 14.sp
                    )
                }
                Row {
                    Spacer(modifier = Modifier.weight(1f))
                    Box(
                        Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(NaturaGradient)
                            .padding(5.dp)
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "${consultant.points} pontos",
                            color = Color.White,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun RankConsultantCardPreview() {
    RankConsultantCard(sampleConsultants.first())
}