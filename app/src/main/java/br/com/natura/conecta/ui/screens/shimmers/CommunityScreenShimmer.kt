package br.com.natura.conecta.ui.screens.shimmers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.natura.conecta.extensions.shimmerEffect
import br.com.natura.conecta.ui.components.shimmers.LeaderCardShimmer
import br.com.natura.conecta.ui.components.shimmers.RankCardShimmer
import br.com.natura.conecta.ui.components.shimmers.TipCardSectionShimmer
import br.com.natura.conecta.ui.theme.SoftGray

@Composable
fun CommunityScreenShimmer() {
    Column(
        Modifier
            .background(Color.White)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(SoftGray),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Column(
                Modifier
                    .background(Color.White)
            ) {
                Box(
                    Modifier
                        .padding(start = 22.dp, top = 35.dp, bottom = 15.dp)
                        .fillMaxWidth(0.80f)
                        .height(30.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .shimmerEffect()
                ) {}
                TipCardSectionShimmer()
            }
            RankCardShimmer()
            LeaderCardShimmer()
        }
    }
}

@Preview
@Composable
private fun CommunityScreenShimmerPreview() {
    CommunityScreenShimmer()
}