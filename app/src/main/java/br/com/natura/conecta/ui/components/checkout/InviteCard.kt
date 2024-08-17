package br.com.natura.conecta.ui.components.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.R
import br.com.natura.conecta.ui.theme.DarkGray
import br.com.natura.conecta.ui.theme.PinkOrange

@Composable
fun InviteCard(modifier: Modifier = Modifier) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp),
        color = Color.White
    ) {
        Row(
            Modifier.background(Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.invite_image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.40f),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .background(Color.White)
                    .padding(top = 22.dp, bottom = 22.dp, start = 10.dp)
                    .fillMaxWidth(0.80f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Convide outras consultoras!",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                Text(
                    text = "Vamos crescer e economizar juntas!",
                    color = DarkGray,
                    fontSize = 14.sp
                )
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
private fun InviteCardPreview() {
    InviteCard()
}