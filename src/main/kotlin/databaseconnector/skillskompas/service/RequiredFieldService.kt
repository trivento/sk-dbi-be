package databaseconnector.skillskompas.service
import databaseconnector.skillskompas.model.AddableTask
import databaseconnector.skillskompas.model.Property
import databaseconnector.skillskompas.model.Type
import databaseconnector.skillskompas.model.getStandardValues
import org.springframework.stereotype.Service
import java.util.*
import java.util.regex.Pattern
import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties

@Service
class RequiredFieldService {

    fun getRequiredFields(name: String): List<Property> {
        return when (name) {
            "task" -> getRequiredFieldsForClass(AddableTask::class)
            "somethingelse" -> getRequiredFieldsForSomethingElse()
            else -> emptyList()
        }
    }

    private fun getRequiredFieldsForSomethingElse(): List<Property> {
        return emptyList()
    }

    fun getRequiredFieldsForClass(kClass: KClass<AddableTask>): List<Property> {
        val listOfProperties: MutableList<Property> = mutableListOf()
        for (memberProperty in kClass.declaredMemberProperties) {
            val name = memberProperty.name
            val type: Type = when {
                memberProperty.getter.returnType.toString().contains("Int")->  Type.NUM
                memberProperty.getter.returnType.toString().contains("Long")-> Type.NUM
                memberProperty.getter.returnType.toString().contains("String")-> Type.TEXT
                memberProperty.getter.returnType.toString().contains("Enum")-> Type.CATEGORY
                else -> Type.UNKNOWN
            }

            val constraints: MutableMap<String,Int> = mutableMapOf()
            for (sub in memberProperty.getter.annotations) {
                when (sub.annotationClass.simpleName) {
                    "Max" -> constraints["maxValue"] = filterValue(sub,"value=\\d+" )
                    "Min" -> constraints["minValue"] = filterValue(sub, "value=\\d+")
                    "Size" -> constraints["minLength"] = filterValue(sub,"min=\\d+")
                }
            }
            val property = Property(
                    type = type,
                    label = name,
                    defaultValue = getStandardValues().get(name),
                    constraints = if(constraints.isNotEmpty()){ constraints } else {null}
            )
            listOfProperties.add(property)
        }
        return listOfProperties
    }

    private fun filterValue(annotation: Annotation, delimiter: String): Int{
        val values = LinkedList<String>()
        val p = Pattern.compile(delimiter)
        val m = p.matcher(annotation.toString())
        while (m.find()) {
            values.add(m.group())
        }
        return values.last.substringAfter("=").toInt()
    }

}

