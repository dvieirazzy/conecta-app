package br.com.natura.conecta.ui.components.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.natura.conecta.ui.theme.PinkOrange

@Composable
fun HorizontalPagerIndicator(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier,
    indicatorColor: Color = PinkOrange,
    unselectedIndicatorColor: Color = Color(0xFFDCDCDC),
    unselectedIndicatorSize: Dp = 7.dp,
    selectedIndicatorSize: Dp = 7.dp,
    indicatorPadding: Dp = 4.dp
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .wrapContentSize()
            .height(selectedIndicatorSize + indicatorPadding * 2)
    ) {
        repeat(pageCount) { page ->
            val (color, size) =
                if (currentPage == page)
                    indicatorColor to selectedIndicatorSize
                else
                    unselectedIndicatorColor to unselectedIndicatorSize
            Box(
                modifier = Modifier
                    .padding(horizontal = indicatorPadding)
                    .clip(CircleShape)
                    .background(color)
                    .size(size)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun HorizontalPagerIndicatorPreview() {
    HorizontalPagerIndicator(4, 0)
}
