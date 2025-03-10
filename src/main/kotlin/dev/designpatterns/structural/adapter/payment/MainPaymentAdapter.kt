package dev.designpatterns.structural.adapter.payment

fun main() {
    println("\n -- Adapter Pattern - Challenge!!! -- \n")

    val paypalProcessor: PaymentProcessor = PaymentAdapter(PayPalService()) { service, amount ->
        service.sendPayment(amount)
    }

    val stripeProcessor: PaymentProcessor = PaymentAdapter(StripeService()) { service, amount ->
        service.makeCharge(amount)
    }

    val mercadoPagoProcessor: PaymentProcessor = PaymentAdapter(MercadoPagoService()) { service, amount ->
        service.pay(amount)
    }

    // Procesar pagos con los diferentes servicios
    // Los 3 procesadores de pago trabajan exactamente igual después de adaptarlos
    println("Using PayPal:")
    var paymentAmount: Number = 1500
    paypalProcessor.processPayment(paymentAmount)

    println("\nUsing Stripe:")
    paymentAmount = 2700
    stripeProcessor.processPayment(paymentAmount)

    println("\nUsing Mercado Pago:")
    paymentAmount = 300_000
    mercadoPagoProcessor.processPayment(paymentAmount)
}

// Simulating third party payment libraries

class PayPalService {

    fun sendPayment(amount: Number) {
        println("Processing payment of $amount with PayPal service.")
    }

}

class StripeService {

    fun makeCharge(amount: Number) {
        println("Processing payment of $amount with Stripe service.")
    }

}

class MercadoPagoService {

    fun pay(amount: Number) {
        println("Processing payment of $amount with Mercado Pago service.")
    }

}
