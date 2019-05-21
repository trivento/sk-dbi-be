package databaseconnector.skillskompas.model

data class Property(
        val type: Type,
        val label: String,
        val defaultValue: Int?,
        val constraints: Constraint?,
        val takeDefaultIfUndefined: Boolean
)

data class Constraint(
        var minValue:Int?,
        var maxValue: Int?,
        var minLength: Int?,
        var mustBeInValues: Boolean?
)

enum class Type {
    TEXT, NUM, CATEGORY, UNKNOWN
}
