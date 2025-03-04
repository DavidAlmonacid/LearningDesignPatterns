package dev.designpatterns.creational.builder.query

/*
 * Tarea: crear un QueryBuilder para construir consultas SQL
 *
 * Debe de tener los siguientes métodos:
 * - constructor(table: String)
 * - select(fields: Array<out String>): QueryBuilder -- si no se pasa ningún campo, se seleccionan todos con el (*)
 * - where(condition: String): QueryBuilder - opcional
 * - orderBy(field: String, direction: Direction): QueryBuilder - opcional
 * - limit(n: Int): QueryBuilder - opcional
 * - execute(): String - retorna la consulta SQL
 *
 * * Ejemplo de uso:
 * ```
 * val usersQuery: String = QueryBuilder("users") // users es el nombre de la tabla
 *     .select("id", "name", "email")
 *     .where("age > 18")
 *     .where("country = 'Cri'")
 *     .orderBy("name", "ASC")
 *     .limit(10)
 *     .execute();
 *
 * println('Consulta: ', usersQuery);
 * // SELECT id, name, email FROM users WHERE age > 18 AND country = 'Cri' ORDER BY name ASC LIMIT 10;
 * ```
 */

interface QueryBuilder {
    fun select(vararg fields: String): QueryBuilder
    fun where(condition: String): QueryBuilder
    fun orderBy(field: String, direction: Direction = Direction.ASC): QueryBuilder
    fun limit(n: Int): QueryBuilder
}

enum class Direction {
    ASC, DESC
}

/**
 * Implementation of the [QueryBuilder] interface.
 *
 * @property table the table name for the SQL query.
 */
class QueryBuilderImpl(private val table: String) : QueryBuilder {
    private var tableFields: Array<out String> = arrayOf("*")
    private val conditions: MutableList<String> = mutableListOf()
    private val orderFields: MutableList<String> = mutableListOf()
    private var limitCount: Int? = null

    /**
     * Sets the fields to be selected.
     */
    override fun select(vararg fields: String): QueryBuilderImpl {
        if (fields.isNotEmpty()) {
            tableFields = fields
        }

        return this
    }

    /**
     * Adds a WHERE condition.
     */
    override fun where(condition: String): QueryBuilderImpl {
        conditions.add(condition)
        return this
    }

    /**
     * Adds an ORDER BY clause with the given field and direction.
     */
    override fun orderBy(field: String, direction: Direction): QueryBuilderImpl {
        orderFields.add("$field $direction")
        return this
    }

    /**
     * Sets a LIMIT on the number of results.
     */
    override fun limit(n: Int): QueryBuilderImpl {
        limitCount = n
        return this
    }

    /**
     * Builds and returns the complete SQL query.
     *
     * @return the final SQL query as a formatted String.
     */
    fun execute(): String {
        val queryBuilder = StringBuilder()

        // Append SELECT clause
        queryBuilder.append("SELECT ")
        queryBuilder.append(tableFields.joinToString())

        // Append FROM clause
        queryBuilder.append("\nFROM ")
        queryBuilder.append(table)

        // Append WHERE clause if any condition exists
        if (conditions.isNotEmpty()) {
            queryBuilder.append("\nWHERE ")
            queryBuilder.append(conditions.joinToString(separator = " AND "))
        }

        // Append ORDER BY clause if any order field exists
        if (orderFields.isNotEmpty()) {
            queryBuilder.append("\nORDER BY ")
            queryBuilder.append(orderFields.joinToString())
        }

        // Append LIMIT clause if a limit is set
        if (limitCount != null) {
            queryBuilder.append("\nLIMIT ")
            queryBuilder.append(limitCount)
        }

        return queryBuilder.append(';').toString()
    }
}
