package databaseconnector.skillskompas.model

data class Property(
        val type: Type,
        val label: String,
        val defaultValue: Any?,
        val constraints: MutableMap<String,Int>?
)


enum class Type {
    TEXT, NUM, CATEGORY, UNKNOWN
}
