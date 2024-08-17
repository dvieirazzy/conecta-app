package br.com.natura.conecta.ui.components.shimmers

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
import br.com.natura.conecta.sampledata.sampleTips

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TipCardSectionShimmer(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(
        pageCount = { sampleTips.size },
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
        ) {
            TipCardShimmer()
        }
    }
}

@Preview
@Composable
private fun TipCardSectionShimmerPreview() {
    TipCardSectionShimmer()
}