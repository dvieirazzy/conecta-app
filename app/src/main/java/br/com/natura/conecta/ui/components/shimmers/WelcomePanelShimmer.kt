package br.com.natura.conecta.ui.components.shimmers

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.natura.conecta.extensions.shimmerEffect

@Composable
fun WelcomePanelShimmer(modifier: Modifier = Modifier) {
    Column(
        modifier
            .height(180.dp)
            .fillMaxWidth()
            .padding(horizontal = 22.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                Modifier
                    .width(150.dp)
                    .height(30.dp)
                    .padding(top = 5.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .shimmerEffect()
            ) {}
        }
        Spacer(Modifier.weight(1f))
        Box(
            Modifier
                .width(75.dp)
                .height(20.dp)
                .padding(top = 5.dp)
                .clip(RoundedCornerShape(5.dp))
                .shimmerEffect()
        ) {}
        Box(
            Modifier
                .height(40.dp)
                .fillMaxWidth(0.7f)
                .padding(top = 5.dp)
                .clip(RoundedCornerShape(5.dp))
                .shimmerEffect(),
        ) {}
        Box(
            Modifier
                .height(40.dp)
                .fillMaxWidth(0.7f)
                .padding(top = 5.dp)
                .clip(RoundedCornerShape(5.dp))
                .shimmerEffect()
        ) {}
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomePanelShimmerPreview() {
    WelcomePanelShimmer()
}