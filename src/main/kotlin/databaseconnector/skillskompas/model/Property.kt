package databaseconnector.skillskompas.model

data class Property(
        val type: Type,
        val label: String,
        val defaultValue: Long?,
        val constraints: Constraint,
        val takeDefaultIfUndefined: Boolean
){}

data class Constraint(
        val minValue:Int?,
        val maxValue: Int?,
        val minLength: Int?,
        val mustBeInValues: Boolean?
){}

enum class Type {
    TEXT, NUM, CATEGORIE
}
