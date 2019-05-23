package databaseconnector.skillskompas.service
import databaseconnector.skillskompas.model.AddableTask
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


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
            val taskRevisionId = taskRevisionService.addTaskRevision(addableTask)
            addableTask.taskRevisionId = taskRevisionId
            domainTaskClusterService.addDomainTaskCluster(addableTask)
            taskCompetenceMappingService.addTaskCompetenceMapping(addableTask)
            val profileTask = profileTaskService.addProfileTask(addableTask)
            addableTask.profileTaskId = profileTask.profiletask_id
            profileCompetenceService.addProfileCompetence(addableTask)
            activateTask(taskRevisionId)
    }

    fun activateTask(taskRevisionId: Long){
        return taskRevisionService.activateTask(taskRevisionId)
    }

    fun deactivateTask(taskRevisionId: Long) {
        return taskRevisionService.decativateTask(taskRevisionId)

    }
}
