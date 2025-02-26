package dev.designpatterns.creational.prototype.book

fun main() {
    println("\n -- Prototype Pattern -- \n")

    val book1 = Book(
        title = "The Lord of the Rings",
        author = "J.R.R. Tolkien",
        content = "In a hole in the ground there lived a hobbit."
    )

    val book2 = book1.copy(title = "The Hobbit")

    println(book1)
    println(book2)
}
