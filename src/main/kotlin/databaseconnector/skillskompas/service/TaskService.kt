package databaseconnector.skillskompas.service
import databaseconnector.skillskompas.model.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.reflect.full.declaredMemberProperties
import java.util.LinkedList
import java.util.regex.Pattern


@Service
class TaskService{

    @Autowired
    lateinit var taskRevisionService: TaskRevisionService
    @Autowired
    lateinit var domainTaskClusterService: DomainTaskClusterService
    @Autowired
    lateinit var taskCompetenceMappingService : TaskCompetenceMappingService
    @Autowired
    lateinit var profileTaskService: ProfileTaskService
    @Autowired
    lateinit var profileCompetenceService: ProfileCompetenceService

    fun addTask(addableTask: AddableTask) {
            val taskRevision = taskRevisionService.addTaskRevision(addableTask)
            addableTask.taskRevisionId = taskRevision.taskrevision_id
            domainTaskClusterService.addDomainTaskCluster(addableTask)
            taskCompetenceMappingService.addTaskCompetenceMapping(addableTask)
            val profileTask = profileTaskService.addProfileTask(addableTask)
            addableTask.profileTaskId = profileTask.profiletask_id
            profileCompetenceService.addProfileCompetence(addableTask)
            activateTask(taskRevision.taskrevision_id)
    }

    fun activateTask(taskRevisionId: Long){
        return taskRevisionService.activateTask(taskRevisionId)
    }

    fun deactivateTask(taskRevisionId: Long) {
        return taskRevisionService.decativateTask(taskRevisionId)

    }

    fun getRequiredFieldsForTask(): List<Property> {
        val listOfProperties: MutableList<Property> = mutableListOf()
        for (memberProperty in AddableTask::class.declaredMemberProperties) {
            val name = memberProperty.name
            val type: Type = when {
                memberProperty.getter.returnType.toString().contains("Int")->  Type.NUM
                memberProperty.getter.returnType.toString().contains("Long")-> Type.NUM
                memberProperty.getter.returnType.toString().contains("String")-> Type.TEXT
                memberProperty.getter.returnType.toString().contains("Enum")-> Type.CATEGORY
                else -> Type.UNKNOWN
            }

            val constraint = Constraint(null,null,null,null)
            for (sub in memberProperty.getter.annotations) {
                when (sub.annotationClass.simpleName) {
                    "Max" -> constraint.maxValue = getMinOrMaxValue(sub)
                    "Min" -> constraint.minValue = getMinOrMaxValue(sub)
                    "Size" -> constraint.minLength = getMinSizeValue(sub)
                }
            }
            val property = Property(
                    type = type,
                    label = name,
                    defaultValue = getStandardValues().get(name),
                    takeDefaultIfUndefined = true,
                    constraints = constraint
            )
            listOfProperties.add(property)
        }
        return listOfProperties
    }

    private fun getMinSizeValue(annotation: Annotation): Int {
        val values = LinkedList<String>()
        val p = Pattern.compile("min=\\d+")
        val m = p.matcher(annotation.toString())
        while (m.find()) {
            values.add(m.group())
        }
        return values.last.substringAfter("=").toInt()
    }

    private fun getMinOrMaxValue(annotation: Annotation): Int {
        val values = LinkedList<String>()
        val p = Pattern.compile("value=\\d+")
        val m = p.matcher(annotation.toString())
        while (m.find()) {
            values.add(m.group())
        }
        return values.last.substringAfter("=").toInt()
    }

    fun getStandardValues() = mapOf(
            "rank" to 1000,
            "solverMinTime" to 1,
            "solverMaxTime" to 80,
            "revision" to 1,
            "coreCompetence" to 1,
            "coreTask" to 0,
            "standardTask" to 0,
            "timeScore" to 0,
            "weight" to 1,
            "taskGroup" to null,
            "active" to 0,
            "resultAreaId" to null
    )

}
