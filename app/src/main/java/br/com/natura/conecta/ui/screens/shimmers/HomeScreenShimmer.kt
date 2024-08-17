package br.com.natura.conecta.ui.screens.shimmers

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.natura.conecta.ui.components.shimmers.StatusCardShimmer
import br.com.natura.conecta.ui.components.shimmers.WelcomePanelShimmer

@Composable
fun HomeScreenShimmer() {
    Column(
        Modifier
            .background(Color.White)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(Color.White)
                .padding(top = 50.dp, bottom = 100.dp),
            verticalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            WelcomePanelShimmer(
                modifier = Modifier
                    .padding(horizontal = 22.dp)
            )
            StatusCardShimmer(
                modifier = Modifier
                    .padding(horizontal = 22.dp)
            )
            StatusCardShimmer(
                modifier = Modifier
                    .padding(horizontal = 22.dp)
            )
            StatusCardShimmer(
                modifier = Modifier
                    .padding(horizontal = 22.dp)
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenShimmerPreview() {
    HomeScreenShimmer()
}