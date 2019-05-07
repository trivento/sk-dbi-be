package databaseconnector.skillskompas.service

import databaseconnector.skillskompas.model.AddableTask
import databaseconnector.skillskompas.repository.TaskClusterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AddableTaskService {
    @Autowired
    lateinit var domainService: DomainService

    @Autowired
    lateinit var competenceService: CompetenceService

    @Autowired
    lateinit var taskClusterService: TaskClusterService

    @Autowired
    lateinit var taskRevisionService: TaskRevisionService

    fun validate(addableTask: AddableTask):Boolean {
        //Check if domainId exists
        if(!domainService.validateDomainId(addableTask.domainId)){
            return false
        }
        //Check if competenceId exists
        if(!competenceService.validateCompetenceId(addableTask.competenceId)){
            return false
        }
        //Check if taskClusterId exists
        if(!taskClusterService.validateTaskClusterId(addableTask.taskClusterId)){
            return false
        }
        if(!taskRevisionService.validateTaskRevisionId(addableTask.taskRevisionId)){
            return false
        }



        return true
    }
}
