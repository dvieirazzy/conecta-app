package br.com.natura.conecta.model

import androidx.annotation.DrawableRes
import java.math.BigDecimal
import java.util.UUID
import kotlin.random.Random

class Product(
    var id: String = UUID.randomUUID().toString(),
    var code: String = Random.nextInt(57000, 58000).toString(),
    var name: String,
    var description: String,
    var purchasePrice: BigDecimal,
    var salePrice:  BigDecimal,
    @DrawableRes var image: Int,
    var points: Int,
    var quantity: Int = 1
)