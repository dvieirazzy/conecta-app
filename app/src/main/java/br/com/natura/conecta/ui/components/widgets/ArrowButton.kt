package br.com.natura.conecta.ui.components.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.natura.conecta.R
import br.com.natura.conecta.ui.theme.NaturaGradient

@Composable
fun ArrowButton(modifier: Modifier = Modifier, rotateArrow: Boolean = false, onNavigateBack: () -> Unit = {}) {
    IconButton(
        onClick = {
            onNavigateBack()
        },
        modifier = modifier
            .size(50.dp)
            .background(
                brush = NaturaGradient,
                shape = RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(12.dp))
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.rotate(if (rotateArrow) 180f else 0f)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ArrowButtonPreview() {
    ArrowButton()
}