package databaseconnector.skillskompas.service
import databaseconnector.skillskompas.model.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.valueParameters

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
        var listOfProperties: MutableList<Property> = mutableListOf()
        for (memberProperty in AddableTask::class.declaredMemberProperties) {
            println(memberProperty.name)
            println(memberProperty.getter.annotations)
            for (sub in memberProperty.getter.annotations) {
                when (sub.annotationClass.simpleName){
                    "Max" -> println(sub.annotationClass.simpleName)
                    "Min" -> println(sub.annotationClass.simpleName)
                    "NotNull" -> println(sub.annotationClass.simpleName)
                    "Size" -> println(sub.annotationClass.simpleName)
                }
                println(memberProperty)
            }
        }

        return listOfProperties
//            listOfProperties.add(
//                    Property(
//                            label = memberProperty.name,
//                            type = memberProperty
//                    )
//            )
//            println(memberProperty.name)



//        return listOf(Property(
//                type = Type.TEXT,
//                label = "A text field",
//                defaultValue = null,
//                takeDefaultIfUndefined = true,
//                constraints = Constraint(
//                        minValue = 1,
//                        maxValue = 3,
//                        minLength = 3,
//                        mustBeInValues = true
//                )
//        ),
//                Property(
//                        type = Type.CATEGORIE,
//                        label = "A balbalbal",
//                        defaultValue = 10,
//                        takeDefaultIfUndefined = true,
//                        constraints = Constraint(
//                                minValue = 0,
//                                maxValue = 10,
//                                minLength = null,
//                                mustBeInValues = false
//                        )
//
//                )
//        )
    }
}
