package br.com.natura.conecta.ui.components.sections

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.natura.conecta.sampledata.sampleBanners
import br.com.natura.conecta.ui.components.home.Banner
import br.com.natura.conecta.ui.components.widgets.HorizontalPagerIndicator
import br.com.natura.conecta.ui.theme.ConectaTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannerSection(banners: List<Int>, modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(
        pageCount = { banners.size }
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 22.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            pageSpacing = 10.dp,
            pageSize = PageSize.Fixed(280.dp)
        ) { page ->
            Banner(image = banners[page])
        }
        HorizontalPagerIndicator(
            pageCount = banners.size,
            currentPage = pagerState.currentPage
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BannerSectionPreview() {
    ConectaTheme {
        Surface {
            BannerSection(
                banners = sampleBanners
            )
        }
    }
}
