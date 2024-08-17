package br.com.natura.conecta.model

import androidx.compose.ui.graphics.Color
import br.com.natura.conecta.model.enums.Levels

class Level(
    val level: Levels,
    val storeGain: Int,
    val onlineGain: Int,
    val rewards: String?,
    val minPoints: Int,
    val maxPoints: Int?,
    val color: Color
)