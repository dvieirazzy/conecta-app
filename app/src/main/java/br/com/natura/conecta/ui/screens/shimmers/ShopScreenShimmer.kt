package br.com.natura.conecta.ui.screens.shimmers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.natura.conecta.ui.components.shimmers.ProductSectionShimmer
import br.com.natura.conecta.ui.theme.SoftGray

@Composable
fun ShopScreenShimmer() {
    Column(
        Modifier
            .background(SoftGray)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProductSectionShimmer()
    }
}

@Preview
@Composable
private fun ShopScreenShimmerPreview() {
    ShopScreenShimmer()
}