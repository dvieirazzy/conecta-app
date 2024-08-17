package br.com.natura.conecta.model

import androidx.annotation.DrawableRes

class Consultant(
    val name: String,
    val city: String,
    val state: String,
    val level: String,
    val position: String,
    val points: String,
    @DrawableRes var image: Int
)