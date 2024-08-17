package br.com.natura.conecta.ui.screens.sidebar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.natura.conecta.R
import br.com.natura.conecta.model.RowConfig
import br.com.natura.conecta.ui.components.widgets.ArrowButton
import br.com.natura.conecta.ui.theme.DarkGray
import br.com.natura.conecta.ui.theme.DarkOrange
import br.com.natura.conecta.ui.theme.NaturaGradient
import br.com.natura.conecta.ui.theme.SoftGray
import br.com.natura.conecta.ui.theme.SoftOrange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(onNavigateBack: () -> Unit ={}) {
    var text by remember { mutableStateOf("") }

    val configurations = listOf(
        RowConfig(
            title = "Conta",
            icon = R.drawable.ic_user
        ),
        RowConfig(
            title = "Notificações",
            icon = R.drawable.ic_notification
        ),
        RowConfig(
            title = "Preferências",
            icon = R.drawable.ic_preferences
        ),
        RowConfig(
            title = "Privacidade",
            icon = R.drawable.ic_privacy
        ),
        RowConfig(
            title = "Segurança",
            icon = R.drawable.ic_security
        ),
        RowConfig(
            title = "Pagamentos",
            icon = R.drawable.ic_payment_card
        ),
        RowConfig(
            title = "Localização",
            icon = R.drawable.ic_map
        ),
        RowConfig(
            title = "Permissões",
            icon = R.drawable.ic_permission
        )
    )

    Column(
        Modifier
            .background(Color.White)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(Color.White)
                .padding(22.dp),
            verticalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            Box(
                Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Ajustes",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier
                        .padding(15.dp)
                        .align(Alignment.Center)
                )
                ArrowButton(
                    rotateArrow = true,
                    modifier = Modifier.align(Alignment.CenterStart),
                    onNavigateBack = {
                        onNavigateBack()
                    }
                )
            }
            Surface(
                shape = RoundedCornerShape(100.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(Color.Transparent),
            ) {
                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    shape = RoundedCornerShape(100),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = DarkGray
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Pesquisar",
                            color = DarkGray,
                            fontSize = 16.sp
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = SoftGray,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        cursorColor = DarkOrange,
                        focusedTextColor = Color.Black,
                        disabledTextColor = Color.Black,
                        selectionColors = TextSelectionColors(
                            handleColor = SoftOrange,
                            backgroundColor = Color.Transparent
                        )
                    )
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                configurations.forEach {
                    ConfigRow(it)
                    Spacer(modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color(0xFFDCDCDC))
                        .fillMaxWidth(0.90f)
                        .height(2.dp)
                        .align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}

@Composable
fun ConfigRow(rowConfig: RowConfig) {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.90f)
            .height(50.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id =  rowConfig.icon),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .graphicsLayer(alpha = 0.99f)
                    .drawWithCache {
                        onDrawWithContent {
                            drawContent()
                            drawRect(NaturaGradient, blendMode = BlendMode.SrcAtop)
                        }
                    }
            )
            Text(
                text = rowConfig.title,
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        Icon(
            painter = painterResource(id =  R.drawable.ic_simple_arrow),
            contentDescription = null,
            modifier = Modifier
                .size(20.dp)
                .graphicsLayer(alpha = 0.99f)
                .drawWithCache {
                    onDrawWithContent {
                        drawContent()
                        drawRect(NaturaGradient, blendMode = BlendMode.SrcAtop)
                    }
                }
        )
    }
}

@Preview
@Composable
private fun SettingsScreenPreview() {
    SettingsScreen()
}