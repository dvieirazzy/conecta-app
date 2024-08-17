package br.com.natura.conecta.ui.components.map

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.R
import br.com.natura.conecta.model.enums.OrderType
import br.com.natura.conecta.model.PickUpPoint
import br.com.natura.conecta.sampledata.samplePickUpPoints
import br.com.natura.conecta.ui.theme.NaturaGradient
import kotlinx.coroutines.delay

@Composable
fun PickUpPointCard(
    modifier: Modifier = Modifier,
    isExpanded: Boolean,
    pickUpPoint: PickUpPoint = samplePickUpPoints.first(),
    onListOrders: () -> Unit = {},
    onNavigateToOrderList: (OrderType) -> Unit = {}
) {
    val rotationAngle by animateFloatAsState(
        targetValue = if (isExpanded) 90f else 0f, label = ""
    )
    var startInfoAnimation by remember { mutableStateOf(true) }
    var startOrderAnimation by remember { mutableStateOf(false) }
    Surface(
        shape = RoundedCornerShape(15.dp),
        modifier = modifier.fillMaxWidth(),
        color = Color.White
    ) {
        Column(
            Modifier
                .width(320.dp)
                .heightIn(400.dp)
                .padding(horizontal = 22.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            LaunchedEffect(isExpanded) {
                startInfoAnimation = if (!isExpanded) {
                    delay(400L)
                    true
                } else {
                    false
                }
            }
            AnimatedVisibility(startInfoAnimation) {
                PickUpPointInfo(pickUpPoint = pickUpPoint)
            }
            Button(
                onClick = {
                    onListOrders()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            )
            {
                Row(
                    modifier = Modifier
                        .background(NaturaGradient)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Listar pedidos",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(end = 15.dp),
                        color = Color.White
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_simple_arrow),
                        contentDescription = null,
                        modifier = Modifier
                            .size(25.dp)
                            .padding(end = 8.dp)
                            .rotate(rotationAngle),
                        tint = Color.White
                    )
                }
            }
            LaunchedEffect(isExpanded) {
                startOrderAnimation= if (isExpanded) {
                    delay(400L)
                    true
                } else {
                    false
                }
            }
            AnimatedVisibility(startOrderAnimation) {
                PickUpPointOrders(
                    pickUpPoint = pickUpPoint,
                    onNavigateToOrderList = {
                        onNavigateToOrderList(it)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun PickUpPointPreview() {
    PickUpPointCard(isExpanded = false)
}