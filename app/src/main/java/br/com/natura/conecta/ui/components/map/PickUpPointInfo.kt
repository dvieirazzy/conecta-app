package br.com.natura.conecta.ui.components.map

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.R
import br.com.natura.conecta.model.PickUpPoint
import br.com.natura.conecta.ui.theme.DarkGray
import br.com.natura.conecta.ui.theme.SoftGray
import com.google.android.gms.maps.model.LatLng
import java.util.Calendar

@Composable
fun PickUpPointInfo(pickUpPoint: PickUpPoint) {
    val calendar = remember { Calendar.getInstance() }
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Image(
            painter = painterResource(id = pickUpPoint.image),
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .height(200.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = pickUpPoint.name,
            fontSize = 22.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = null,
                tint = Color.Yellow,
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = "${pickUpPoint.evaluation} (${pickUpPoint.evaluationNumber}K)",
                fontSize = 18.sp,
                color = Color.Black
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(SoftGray)
                    .padding(horizontal = 5.dp, vertical = 3.dp)
            ) {
                Text(
                    text = if (calendar.get(Calendar.HOUR_OF_DAY) < pickUpPoint.closeHour) "Aberto" else "Fechado",
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }
            Text(
                text = if (calendar.get(Calendar.HOUR_OF_DAY) < pickUpPoint.closeHour) "Fecha as ${pickUpPoint.closeHour}h" else "Abre as ${pickUpPoint.closeHour - 9}h",
                fontSize = 18.sp,
                color = DarkGray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PickUpPointInfoPreview() {
    PickUpPointInfo(
        PickUpPoint(
            name = "Loja Natura",
            evaluation = "4.9",
            position = LatLng(1.0, 1.0),
            image = R.drawable.natura_store1,
            icon = R.drawable.ic_map_natura_store,
            closeHour = 19,
            evaluationNumber = 2.0F
        )
    )
}