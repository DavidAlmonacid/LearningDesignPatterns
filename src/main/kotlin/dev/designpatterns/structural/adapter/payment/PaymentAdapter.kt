package dev.designpatterns.structural.adapter.payment

/*
How to Implement

1. Declare the client interface and describe how clients communicate with the service.
2. Create the adapter class and make it follow the client interface.
3. Add a field to the adapter class to store a reference to the service object.
   The common practice is to initialize this field via the constructor,
   but sometimes it’s more convenient to pass it to the adapter when calling its
   methods.
4. Implement all methods of the client interface in the adapter class.
   The adapter should delegate most of the real work to the service object,
   handling only the interface or data format conversion.
5. Clients should use the adapter via the client interface.
   This will let you change or extend the adapters without affecting the client code.
 */

// 1. Client Interface
interface PaymentProcessor {
    fun processPayment(amount: Number)
}

// 2. Adapter Class
class PaymentAdapter<T>(
    private val paymentService: T, // 3. Field to store a reference to the service object through the constructor
    private val paymentMethod: (T, Number) -> Unit
) : PaymentProcessor {

    // 4. Implement the interface methods
    override fun processPayment(amount: Number) {
        paymentMethod(paymentService, amount)
    }

}
