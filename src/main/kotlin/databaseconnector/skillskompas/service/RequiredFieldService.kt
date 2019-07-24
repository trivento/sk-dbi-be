package databaseconnector.skillskompas.service
import databaseconnector.skillskompas.model.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import java.util.regex.Pattern
import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties

@Service
class RequiredFieldService {

    @Autowired
    lateinit var domainService: DomainService

    @Autowired
    lateinit var competenceService: CompetenceService

    @Autowired
    lateinit var taskClusterService: TaskClusterService

    fun getRequiredFields(name: String): List<Property> {
        return when (name) {
            "task" -> buildRequiredFields(AddableTask::class)
            "domain" -> buildRequiredFields(Domain::class)
            else -> emptyList()
        }
    }

    fun buildRequiredFields(kClass: KClass<out Any>): List<Property> {
        val listOfProperties: MutableList<Property> = mutableListOf()
        for (memberProperty in kClass.declaredMemberProperties) {
            val name = memberProperty.name
            var type: Type = when {
                memberProperty.getter.returnType.toString().contains("Int")->  Type.NUM
                memberProperty.getter.returnType.toString().contains("Long")-> Type.NUM
                memberProperty.getter.returnType.toString().contains("String")-> Type.TEXT
                memberProperty.getter.returnType.toString().contains("Boolean")-> Type.BOOL
                else -> Type.UNKNOWN
            }
            var standardValues: List<MutableMap<Long,String>>? = null
            val constraints: MutableMap<String,Any> = mutableMapOf()
            for (sub in memberProperty.getter.annotations) {
                when (sub.annotationClass.simpleName) {
                    "Max" -> constraints["maxValue"] = filterValue(sub,"value=\\d+" )
                    "Min" -> constraints["minValue"] = filterValue(sub, "value=\\d+")
                    "Size" -> constraints["minLength"] = filterValue(sub,"min=\\d+")
                    "IsEnum" -> {
                        standardValues = getList(memberProperty.name)
                        type = Type.CAT
                    }
                }
            }
            val property = Property(
                    type = type,
                    label = name,
                    defaultValue = getStandardValues()[name],
                    constraints = if(constraints.isNotEmpty()) { constraints } else { null },
                    standardValues = standardValues
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

    fun getList(nameOfList: String): List<MutableMap<Long, String>>? =
        when (nameOfList) {
            "domainId" ->  domainService.getDomainList()
            "competenceId" ->  competenceService.getCompetencesList()
            "taskClusterId" ->  taskClusterService.getTaskClusterList()
            else -> mutableListOf(mutableMapOf())
        }
}



