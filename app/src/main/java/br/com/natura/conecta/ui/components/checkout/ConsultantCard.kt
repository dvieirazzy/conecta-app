package br.com.natura.conecta.ui.components.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.model.Consultant
import br.com.natura.conecta.sampledata.sampleConsultants
import br.com.natura.conecta.ui.theme.DarkGray
import br.com.natura.conecta.ui.theme.NaturaGradient

@Composable
fun ConsultantCard(
    modifier: Modifier = Modifier,
    consultant: Consultant,
    points: Int
) {
    Card(
        modifier = modifier
            .size(height = 200.dp, width = 160.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painter = painterResource(id = consultant.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = consultant.name,
                color = Color.Black,
                fontSize = 18.sp
            )
            Text(
                text = "Consultora " + consultant.level,
                color = DarkGray,
                fontSize = 14.sp
            )
            Text(
                text = "$points Pontos",
                fontSize = 14.sp,
                style = TextStyle(NaturaGradient),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
private fun ConsultantCardPreview() {
    ConsultantCard(
        consultant = sampleConsultants.first(),
        points = 2
    )
}