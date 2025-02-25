package dev.designpatterns.creational.prototype.book

/*
! Patrón Prototype:

Es un patrón de diseño creacional que nos permite copiar objetos existentes
sin hacer que el código dependa de sus clases.

* Es útil cuando queremos duplicar el contenido,
* el título y el autor de un documento, por ejemplo, o cualquier
* objeto complejo.

https://refactoring.guru/es/design-patterns/prototype
 */

data class Book(var title: String, var author: String, var content: String) {
    fun clone(): Book = Book(title, author, content)
}
