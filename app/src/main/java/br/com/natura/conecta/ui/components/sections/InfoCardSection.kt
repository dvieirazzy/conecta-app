package br.com.natura.conecta.ui.components.sections

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.natura.conecta.model.Info
import br.com.natura.conecta.sampledata.sampleInfos
import br.com.natura.conecta.ui.components.home.InfoCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InfoCardSection(infos: List<Info>, modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(
        pageCount = { infos.size },
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 22.dp),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 11.dp),
            pageSpacing = 22.dp,
            pageSize = PageSize.Fixed(280.dp)
        ) { page ->
            InfoCard(infos[page])
        }
    }
}

@Preview
@Composable
private fun InfoCardSectionPreview() {
    InfoCardSection(sampleInfos)
}