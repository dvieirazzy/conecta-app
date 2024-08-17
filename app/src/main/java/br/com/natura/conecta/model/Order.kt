package br.com.natura.conecta.model

import br.com.natura.conecta.model.enums.OrderType
import java.math.BigDecimal
import java.time.LocalTime
import java.util.Date
import java.util.UUID

class Order(
    var id: String = UUID.randomUUID().toString(),
    var consultants: List<Consultant>,
    var type: OrderType,
    var lastTime: LocalTime,
    var points: Int,
    var pointsTarget: Int = type.value,
    var totalProducts: Int,
    var totalPrice: BigDecimal,
    var date: Date
)