package databaseconnector.skillskompas.model

data class Property(
        val type: Type,
        val label: String,
        val defaultValue: Any?,
        val constraints: MutableMap<String, Any>?,
        val standardValues: List<MutableMap<Long, String>?>?
)

enum class Type {
    TEXT, NUM, CAT, UNKNOWN, BOOL, MAP, ANY
}
