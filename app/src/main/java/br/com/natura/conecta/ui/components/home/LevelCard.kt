package br.com.natura.conecta.ui.components.home

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.R
import br.com.natura.conecta.model.Level
import br.com.natura.conecta.sampledata.sampleLevels

@Composable
fun LevelCard(level: Level) {
    var isExpanded by remember { mutableStateOf(false) }

    val rotationAngle by animateFloatAsState(
        targetValue = if (isExpanded) 90f else 0f, label = ""
    )

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(level.color)
            .clickable {
                isExpanded = !isExpanded
            }
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .fillMaxWidth()
                .height(100.dp)
                .background(level.color),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Consultora ${level.level.name.toLowerCase().capitalize()}",
                fontSize = 30.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth(0.50f)
                    .padding(start = 15.dp),
                fontWeight = FontWeight.Light,
                lineHeight = 35.sp
            )
            Box(
                modifier = Modifier
                    .clip(sideCutShape())
                    .height(100.dp)
                    .width(150.dp)
                    .background(Color.White)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_simple_arrow),
                    contentDescription = null,
                    tint = level.color,
                    modifier = Modifier
                        .padding(end = 15.dp)
                        .size(25.dp)
                        .align(Alignment.CenterEnd)
                        .rotate(rotationAngle)
                )
            }
        }
        AnimatedVisibility(isExpanded) {
            Column(
                modifier = Modifier
                    .background(level.color)
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 22.dp)
                    .padding(bottom = 15.dp)
                    .fillMaxSize()
            ) {
                LevelInfoCard(
                    title = "Vendas Presenciais",
                    subTitle = "${level.storeGain}% de ganho",
                    color = level.color,
                    icon = R.drawable.ic_dollar
                )
                LevelInfoCard(
                    title = "Vendas pela Internet",
                    subTitle = "Até ${level.onlineGain}% de ganho",
                    color = level.color,
                    icon = R.drawable.ic_dollar
                )
                LevelInfoCard(
                    title = "Prêmios",
                    subTitle = level.rewards ?: " - ",
                    color = level.color,
                    icon = R.drawable.ic_reward
                )
                LevelInfoCard(
                    title = "Pontuação",
                    subTitle = if(level.maxPoints != null)
                        "Entre ${level.minPoints} e ${level.maxPoints} pontos no período"
                    else
                        "Acima de ${level.minPoints} pontos no período",
                    color = level.color,
                    icon = R.drawable.ic_graphic
                )
            }
        }
    }
}

@Composable
fun LevelInfoCard(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    color: Color,
    @DrawableRes icon: Int
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(color),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .size(50.dp),
            tint = Color.White
        )
        Column {
            Text(
                text = title,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 10.dp),
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = subTitle,
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}

fun sideCutShape() = GenericShape { size, _ ->
    moveTo(0f, 0f)
    lineTo(size.width / 2f, size.height)
    lineTo(size.width, size.height)
    lineTo(size.width, 0f)
    close()
}

@Preview
@Composable
private fun LevelCardPreview() {
    LevelCard(sampleLevels.first())
}