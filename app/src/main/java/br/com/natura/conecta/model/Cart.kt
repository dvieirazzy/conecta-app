package br.com.natura.conecta.model

import br.com.natura.conecta.model.enums.CartProductAddResponse
import br.com.natura.conecta.model.enums.CartStatus
import java.math.BigDecimal

class Cart {

    private var products: List<Product> = mutableListOf()
    private var status: CartStatus = CartStatus.EMPTY

    fun addProduct(product: Product): CartProductAddResponse {
        return when {
            status == CartStatus.CLOSED -> CartProductAddResponse.CART_CLOSED
            products.contains(product) -> CartProductAddResponse.PRODUCT_ALREADY_ADDED
            else -> {
                products += product
                if (status == CartStatus.EMPTY) status = CartStatus.OPEN
                CartProductAddResponse.SUCCESS
            }
        }
    }

    fun removeProduct(product: Product){
        products -= product

        if (products.isEmpty())
            status = CartStatus.EMPTY
    }

    fun closeCart() {
        status = CartStatus.CLOSED
    }

    fun openCart() {
        status = CartStatus.OPEN
    }

    fun emptyCart() {
        status = CartStatus.EMPTY
        products.forEach { it.quantity = 1 }
        products = mutableListOf()
    }

    fun getTotalPrice(): BigDecimal {
        return products.sumOf { (it.purchasePrice.times(it.quantity.toBigDecimal())) }
    }

    fun getTotalPoints(): Int {
        return products.sumOf { it.points * it.quantity }
    }

    fun getProducts(): List<Product> {
        return products
    }

    fun getStatus(): CartStatus {
        return status
    }

    fun getTotalProducts(): Int {
        return products.sumOf { it.quantity }
    }

    fun isOpen(): Boolean {
        return status == CartStatus.OPEN
    }

    fun isClosed(): Boolean {
        return status == CartStatus.CLOSED
    }

}