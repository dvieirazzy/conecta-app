package br.com.natura.conecta.ui.components.shimmers

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.natura.conecta.extensions.shimmerEffect

@Composable
fun RankCardShimmer() {
    Column(
        Modifier
            .background(Color.White)
            .padding(22.dp)
    ) {
        Box(
            Modifier
                .padding(bottom = 5.dp)
                .fillMaxWidth(0.80f)
                .height(30.dp)
                .clip(RoundedCornerShape(5.dp))
                .shimmerEffect()
        ) {}
        Box(
            Modifier
                .padding(bottom = 15.dp)
                .fillMaxWidth(0.60f)
                .height(20.dp)
                .clip(RoundedCornerShape(5.dp))
                .shimmerEffect()
        ) {}
        Card(
            modifier = Modifier
                .height(115.dp)
                .fillMaxWidth()
                .clickable {

                },
            shape = RoundedCornerShape(20.dp)
        ) {
            Box(
                Modifier
                    .fillMaxSize()
                    .shimmerEffect()
            ) {}
        }
    }
}

@Preview
@Composable
private fun RankCardShimmerPreview() {
    RankCardShimmer()
}