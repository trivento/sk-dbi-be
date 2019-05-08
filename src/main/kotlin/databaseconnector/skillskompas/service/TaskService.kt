package databaseconnector.skillskompas.service
import databaseconnector.skillskompas.model.AddableTask
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TaskService{


    fun addTask(addableTask: AddableTask) {
        println(addableTask)
//            val taskRevision = taskRevisionService.addTaskRevision(addableTask)
//            addableTask.taskRevisionId = taskRevision.taskrevision_id
//            domainTaskClusterService.addDomainTaskCluster(addableTask)
//            taskCompetenceMappingService.addTaskCompetenceMapping(addableTask)
//            val profileTask = profileTaskService.addProfileTask(addableTask)
//            addableTask.profileTaskId = profileTask.profiletask_id
//            profileCompetenceService.addProfileCompetence(addableTask)


    }
}
