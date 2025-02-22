package dev.designpatterns.creational.builder

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class QueryBuilderImplTest {
    @Test
    fun `test basic query with default select`() {
        // When no select fields are provided, default is *
        val query = QueryBuilderImpl("users").execute()
        val expected = "SELECT *\nFROM users;"
        assertEquals(expected, query)
    }

    @Test
    fun `test full query with select, where, orderBy and limit`() {
        val query = QueryBuilderImpl("users")
            .select("id", "name", "email")
            .where("age > 18")
            .where("country = 'Cri'")
            .orderBy("name")
            .limit(10)
            .execute()

        val expected = "SELECT id, name, email\nFROM users\nWHERE age > 18 AND country = 'Cri'\nORDER BY name ASC\nLIMIT 10;"
        assertEquals(expected, query)
    }
}
