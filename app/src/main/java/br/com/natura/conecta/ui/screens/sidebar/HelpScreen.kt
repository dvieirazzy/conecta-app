package br.com.natura.conecta.ui.screens.sidebar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.R
import br.com.natura.conecta.model.Question
import br.com.natura.conecta.sampledata.sampleQuestions
import br.com.natura.conecta.ui.components.widgets.ArrowButton
import br.com.natura.conecta.ui.theme.DarkOrange
import br.com.natura.conecta.ui.theme.SoftGray

@Composable
fun HelpScreen(onNavigateBack: () -> Unit = {}) {
    Column(
        Modifier
            .background(SoftGray)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(22.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            Box(
                Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Dúvidas Frequentes",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 22.sp,
                    modifier = Modifier
                        .padding(15.dp)
                        .align(Alignment.Center)
                        .fillMaxWidth(0.50f)
                )
                ArrowButton(
                    rotateArrow = true,
                    modifier = Modifier.align(Alignment.CenterStart),
                    onNavigateBack = {
                        onNavigateBack()
                    }
                )
            }

            sampleQuestions.forEach {
                QuestionCard(question = it)
            }
        }
    }
}

@Composable
fun QuestionCard(question: Question) {
    var isExpanded by remember { mutableStateOf(false) }

    val rotationAngle by animateFloatAsState(
        targetValue = if (isExpanded) 90f else 0f, label = ""
    )

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(Color.White)
            .clickable {
                isExpanded = !isExpanded
            }
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(horizontal = 22.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.80f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = question.question,
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier
                )
            }
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_simple_arrow
                ),
                contentDescription = null,
                tint = DarkOrange,
                modifier = Modifier.rotate(rotationAngle)
            )
        }
        AnimatedVisibility(isExpanded) {
            Text(
                text = question.answer,
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(bottom = 22.dp, start = 22.dp, end = 22.dp)
            )
        }
    }
}

@Preview
@Composable
private fun HelpScreenPreview() {
    HelpScreen()
}

@Preview
@Composable
private fun QuestionCardPreview() {
    QuestionCard(question = sampleQuestions.first())
}