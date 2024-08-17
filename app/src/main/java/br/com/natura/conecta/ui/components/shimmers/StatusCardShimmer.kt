package br.com.natura.conecta.ui.components.shimmers

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.natura.conecta.extensions.shimmerEffect
import br.com.natura.conecta.ui.theme.SoftGray

@Composable
fun StatusCardShimmer(modifier: Modifier = Modifier) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        modifier = modifier.fillMaxWidth(),
        color = SoftGray
    ) {
        Column(
            Modifier
                .width(320.dp)
                .height(250.dp)
                .padding(22.dp)
        ) {
            Box(
                Modifier
                    .padding(bottom = 5.dp)
                    .height(20.dp)
                    .fillMaxWidth(0.8f)
                    .clip(RoundedCornerShape(5.dp))
                    .shimmerEffect()
            ) {}
            Box(
                Modifier
                    .height(20.dp)
                    .fillMaxWidth(0.5f)
                    .clip(RoundedCornerShape(5.dp))
                    .shimmerEffect()
            ) {}
        }
    }
}

@Preview
@Composable
private fun StatusCardShimmerPreview() {
    StatusCardShimmer()
}