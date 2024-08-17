package br.com.natura.conecta.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.sampledata.sampleTips
import br.com.natura.conecta.ui.components.community.LeaderCard
import br.com.natura.conecta.ui.components.community.RankCard
import br.com.natura.conecta.ui.components.sections.TipCardSection
import br.com.natura.conecta.ui.theme.SoftGray

@Composable
fun CommunityScreen(onNavigateToRank: () -> Unit = {}) {
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
                Text(
                    text = "Descubra suas oportunidades",
                    Modifier.padding(start = 22.dp, top = 35.dp, bottom = 15.dp),
                    fontSize = 22.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                TipCardSection(tips = sampleTips)
            }
            RankCard(
                onNavigateToRank = {
                    onNavigateToRank()
                }
            )
            LeaderCard()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CommunityScreenPreview() {
    CommunityScreen()
}