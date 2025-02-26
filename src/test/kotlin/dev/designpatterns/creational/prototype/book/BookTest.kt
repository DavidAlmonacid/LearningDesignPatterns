package dev.designpatterns.creational.prototype.book

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotSame
import org.junit.jupiter.api.Test

class BookTest {
    @Test
    fun `test book cloning`() {
        val book1 = Book(
            title = "The Lord of the Rings",
            author = "J.R.R. Tolkien",
            content = "In a hole in the ground there lived a hobbit."
        )

        val book2 = book1.copy(title = "The Hobbit")

        // Verify that the cloned book is a different instance
        assertNotSame(book1, book2)

        // Verify that the content of the cloned book is as expected
        assertEquals("The Hobbit", book2.title)
        assertEquals("J.R.R. Tolkien", book2.author)
        assertEquals("In a hole in the ground there lived a hobbit.", book2.content)

        // Verify that the original book remains unchanged
        assertEquals("The Lord of the Rings", book1.title)
        assertEquals("J.R.R. Tolkien", book1.author)
        assertEquals("In a hole in the ground there lived a hobbit.", book1.content)
    }
}
