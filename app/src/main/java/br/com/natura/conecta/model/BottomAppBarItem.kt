package br.com.natura.conecta.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import br.com.natura.conecta.ui.navigation.AppDestination

class BottomAppBarItem(
    @DrawableRes val icon: Int,
    var color: Color,
    var destination: AppDestination
)