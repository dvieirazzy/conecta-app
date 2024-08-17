package br.com.natura.conecta.model

import androidx.annotation.DrawableRes
import br.com.natura.conecta.ui.navigation.AppDestination

class DrawerBarItem(
    var name: String,
    @DrawableRes var icon: Int,
    var route: AppDestination
)