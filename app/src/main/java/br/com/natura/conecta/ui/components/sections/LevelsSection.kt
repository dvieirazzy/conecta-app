package br.com.natura.conecta.ui.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.sampledata.sampleLevels
import br.com.natura.conecta.ui.components.checkout.InviteCard
import br.com.natura.conecta.ui.components.home.LevelCard
import br.com.natura.conecta.ui.components.widgets.ArrowButton

@Composable
fun LevelsSection(
    onNavigateBack: () -> Unit = {}
) {
    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(22.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Box(
                Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Níveis",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier
                        .padding(15.dp)
                        .align(Alignment.Center)
                )
                ArrowButton(
                    onNavigateBack = {
                        onNavigateBack()
                    },
                    rotateArrow = true
                )
            }
        }

        item {
            Text(
                text = "Conheça os níveis das consultoras natura e cada um dos seus benefícidos!",
                fontSize = 18.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }

        items(sampleLevels) {
            LevelCard(
                level = it
            )
        }

        item {
            InviteCard()
        }
    }
}

@Preview
@Composable
private fun LevelsSectionPreview() {
    LevelsSection()
}