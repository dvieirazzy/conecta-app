package br.com.natura.conecta.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.natura.conecta.model.BottomAppBarItem
import br.com.natura.conecta.ui.theme.SoftGray
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConectaBottomNavBar(
    item: BottomAppBarItem,
    modifier: Modifier = Modifier,
    items: List<BottomAppBarItem> = emptyList(),
    sheetState: SheetState,
    onItemChange: (BottomAppBarItem) -> Unit = {}
) {
    val scope = rememberCoroutineScope()
    Surface(
        shape = RoundedCornerShape(50.dp),
        modifier = modifier
            .fillMaxWidth(0.70f)
            .height(70.dp)
            .background(Color.Transparent),
        shadowElevation = 10.dp
    ) {
        Row(
            modifier = Modifier
                .background(SoftGray),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach {
                val isSelected = item.destination.route == it.destination.route
                NavBarItem(
                    item = it,
                    isSelected = isSelected,
                    onItemChange = {item ->
                        onItemChange(item)

                        if (it.destination == AppDestination.Map)
                            scope.launch {
                                sheetState.hide()
                            }
                    },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun NavBarItem(
    modifier: Modifier = Modifier,
    item: BottomAppBarItem,
    isSelected: Boolean,
    onItemChange: (BottomAppBarItem) -> Unit = {}
) {
    val background = if (isSelected)
        Color.White.copy(alpha = 0.6f)
    else
        Color.Transparent

    Box(
        modifier = modifier
            .fillMaxHeight()
            .padding(3.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(background)
            .clickable {
                onItemChange(item)
            },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = null,
            tint = item.color,
            modifier = Modifier.size(30.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(widthDp = 300)
@Composable
private fun ConectaBottomNavBarPreview() {
    ConectaBottomNavBar(
        item = bottomNavBarItems.first(),
        items = bottomNavBarItems,
        sheetState = rememberStandardBottomSheetState()
    )
}