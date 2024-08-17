package br.com.natura.conecta.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.sampledata.consultant
import br.com.natura.conecta.sampledata.sampleConsultants
import br.com.natura.conecta.ui.components.community.RankConsultantCard
import br.com.natura.conecta.ui.components.community.ReferCard
import br.com.natura.conecta.ui.components.home.StatusCard
import br.com.natura.conecta.ui.components.widgets.ArrowButton
import br.com.natura.conecta.ui.theme.NaturaGradient
import br.com.natura.conecta.ui.theme.SoftGray

@Composable
fun RankScreen(
    onNavigateBack: () -> Unit = {},
    onNavigateToLevels: () -> Unit = {},
) {
    Column(
        Modifier
            .background(SoftGray)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(SoftGray)
                .padding(22.dp),
            verticalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            Box(
                Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Rank de Consultoras",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier
                        .padding(start = 15.dp, top = 15.dp, end = 15.dp)
                        .align(Alignment.Center)
                        .width(150.dp),
                    textAlign = TextAlign.Center
                )
                ArrowButton(
                    rotateArrow = true,
                    modifier = Modifier.align(Alignment.CenterStart),
                    onNavigateBack = {
                        onNavigateBack()
                    }
                )
            }
            StatusCard(
                onNavigateToLevels ={
                    onNavigateToLevels()
                }
            )
            ReferCard()
            sampleConsultants.forEach {
                RankConsultantCard(consultant = it)
            }
            Surface(
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                color = Color.White
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "...",
                        fontSize = 40.sp,
                        style = TextStyle(NaturaGradient)
                    )
                }
            }
            RankConsultantCard(consultant = consultant)
        }
    }
}

@Preview
@Composable
private fun RankScreenPreview() {
    RankScreen()
}