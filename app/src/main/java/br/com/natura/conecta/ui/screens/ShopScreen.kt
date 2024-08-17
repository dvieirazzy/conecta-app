package br.com.natura.conecta.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.natura.conecta.model.Product
import br.com.natura.conecta.ui.components.sections.ProductSection
import br.com.natura.conecta.ui.theme.SoftGray

@Composable
fun ShopScreen(
    onNavigateToCart: () -> Unit = {},
    onNavigateToProductDetails: (Product) -> Unit = {},
) {
    Column(
        Modifier
            .background(SoftGray)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProductSection(
            onNavigateToCart = {
                onNavigateToCart()
            },
            onNavigateToProductDetails = {
                onNavigateToProductDetails(it)
            }
        )
    }
}

@Preview
@Composable
private fun ShopScreenPreview() {
    ShopScreen()
}