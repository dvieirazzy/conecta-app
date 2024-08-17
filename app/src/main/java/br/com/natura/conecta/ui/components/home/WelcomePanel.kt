package br.com.natura.conecta.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.R
import br.com.natura.conecta.ui.theme.DarkGray

@Composable
fun WelcomePanel(
    modifier: Modifier = Modifier,
    onOpenDrawerBar: () -> Unit = {}
) {
    Column(
        modifier.height(180.dp).fillMaxWidth().padding(horizontal = 22.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.natura_co),
                contentDescription =null,
                Modifier.width(150.dp).padding(top = 5.dp)
            )
            Button(
                onClick = {
                    onOpenDrawerBar()
                },
                colors = ButtonDefaults.textButtonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.size(30.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = null,
                    tint = Color(0xFFE30F43),
                    modifier = Modifier.fillMaxSize(0.9f)
                )
            }
        }
        Spacer(Modifier.weight(1f))
        Text(
            text = "Oi, Helena!",
            fontSize = 15.sp,
            color = DarkGray,
        )
        Text(
            text = "Muito bom ter você por aqui!",
            fontSize = 30.sp,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(top = 5.dp),
            letterSpacing = 1.sp,
            lineHeight = 30.sp,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomePanelPreview() {
    WelcomePanel()
}