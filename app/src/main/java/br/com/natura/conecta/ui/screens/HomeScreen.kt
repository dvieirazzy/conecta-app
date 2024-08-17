package br.com.natura.conecta.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.natura.conecta.sampledata.sampleBanners
import br.com.natura.conecta.sampledata.sampleInfos
import br.com.natura.conecta.ui.components.home.StatusCard
import br.com.natura.conecta.ui.components.home.WelcomePanel
import br.com.natura.conecta.ui.components.sections.BannerSection
import br.com.natura.conecta.ui.components.sections.InfoCardSection
import br.com.natura.conecta.ui.theme.SoftGray

@Composable
fun HomeScreen(
    onOpenDrawerBar: () -> Unit = {},
    onNavigateToLevels: () -> Unit = {}
) {
    Column(
        Modifier
            .background(SoftGray)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(SoftGray)
                .padding(top = 50.dp, bottom = 100.dp),
            verticalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            WelcomePanel(
                modifier = Modifier
                    .padding(horizontal = 22.dp),
                onOpenDrawerBar = {
                    onOpenDrawerBar()
                }
            )
            StatusCard(
                modifier = Modifier
                    .padding(horizontal = 22.dp),
                onNavigateToLevels = {
                    onNavigateToLevels()
                }
            )
            BannerSection(
                banners = sampleBanners
            )
            InfoCardSection(
                infos = sampleInfos
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}