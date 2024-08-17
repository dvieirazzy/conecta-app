package br.com.natura.conecta.ui.components.shimmers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.natura.conecta.extensions.shimmerEffect

@Composable
fun ProductCardShimmer(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(15.dp),
        color = Color.White
    ) {
        Column(
            Modifier
                .padding(15.dp)
                .heightIn(200.dp, 205.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Box(
                    Modifier
                        .size(150.dp)
                        .align(Alignment.CenterVertically)
                        .clip(RoundedCornerShape(10.dp))
                        .shimmerEffect()
                ) {}
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Box(
                        Modifier
                            .height(20.dp)
                            .width(100.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .shimmerEffect()
                    ) {}
                    Box(
                        Modifier
                            .height(20.dp)
                            .width(150.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .shimmerEffect()
                    ) {}
                    Box(
                        Modifier
                            .height(20.dp)
                            .width(150.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .shimmerEffect()
                    ) {}
                    Box(
                        Modifier
                            .height(20.dp)
                            .width(70.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .shimmerEffect()
                    ) {}
                }
            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column(
                    modifier = Modifier.padding(top = 5.dp)
                ) {
                    Box(
                        Modifier
                            .height(20.dp)
                            .width(135.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .shimmerEffect()
                    ) {}
                    Spacer(Modifier.weight(1f))
                    Box(
                        Modifier
                            .height(20.dp)
                            .width(135.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .shimmerEffect()
                    ) {}
                }
                Box(
                    Modifier
                        .fillMaxSize(0.90f)
                        .clip(RoundedCornerShape(10.dp))
                        .shimmerEffect()
                ) {}
            }
        }
    }
}

@Preview
@Composable
private fun ProductCardShimmerPreview() {
    ProductCardShimmer()
}