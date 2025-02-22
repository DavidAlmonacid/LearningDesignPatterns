package dev.designpatterns.creational.builder.query

fun main() {
    println("\n -- Builder Pattern - Challenge!!! -- \n")

    val usersQuery: String = QueryBuilderImpl("users")
        .select("id", "name", "email")
        .where("age > 18")
        .where("country = 'COL'")
        .orderBy(field = "id", direction = Direction.ASC)
        .orderBy(field = "name")
        .orderBy(field = "email", direction = Direction.DESC)
        .limit(10)
        .execute()

    println("* Query:")
    println(usersQuery)
}
