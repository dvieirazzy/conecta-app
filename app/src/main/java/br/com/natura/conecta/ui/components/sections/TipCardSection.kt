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
import br.com.natura.conecta.model.Tip
import br.com.natura.conecta.sampledata.sampleTips
import br.com.natura.conecta.ui.components.community.TipCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TipCardSection(tips: List<Tip>, modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(
        pageCount = { tips.size },
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 22.dp)
    ) {
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 22.dp),
            modifier = modifier
                .fillMaxWidth(),
            pageSpacing = 22.dp,
            pageSize = PageSize.Fixed(270.dp)
        ) { page ->
            TipCard(tips[page])
        }
    }
}

@Preview
@Composable
private fun TipCardSectionPreview() {
    TipCardSection(
        sampleTips
    )
}