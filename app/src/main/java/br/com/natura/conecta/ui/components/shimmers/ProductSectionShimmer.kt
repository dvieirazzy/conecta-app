package br.com.natura.conecta.ui.components.shimmers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.natura.conecta.extensions.shimmerEffect
import br.com.natura.conecta.sampledata.sampleProducts

@Composable
fun ProductSectionShimmer(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(22.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Box(
                Modifier.fillMaxWidth()
            ) {
                Box(
                    Modifier
                        .padding(15.dp)
                        .align(Alignment.Center)
                        .height(20.dp)
                        .width(100.dp)
                        .clip(RoundedCornerShape(100.dp))
                        .shimmerEffect()
                ) {}
                Box(
                    modifier = modifier
                        .size(40.dp)
                        .align(Alignment.CenterEnd)
                        .clip(RoundedCornerShape(100.dp))
                        .shimmerEffect()
                ) {}
            }
        }

        item {
            Box(
                Modifier
                    .height(56.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(100.dp))
                    .shimmerEffect()
            ) {}
        }

        items(sampleProducts) {
            ProductCardShimmer()
        }

        item {
            Spacer(modifier = Modifier.height(70.dp))
        }
    }
}

@Preview
@Composable
private fun ProductSectionShimmerPreview() {
    ProductSectionShimmer()
}