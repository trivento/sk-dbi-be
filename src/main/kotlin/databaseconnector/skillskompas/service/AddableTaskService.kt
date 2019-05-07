package databaseconnector.skillskompas.service

import databaseconnector.skillskompas.model.AddableTask
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AddableTaskService {
    @Autowired
    lateinit var domainService: DomainService

    @Autowired
    lateinit var competenceService: CompetenceService

    fun validate(addableTask: AddableTask):Boolean {
        //Check if domainId exists
        if(!domainService.validateDomainId(addableTask.domainId)){
            return false
        }
        //Check if competenceId exists
        if(!competenceService.validateCompetenceId(addableTask.competenceId)){
            return false
        }
        //Check if coreCompetence is 1 or 0
        if(addableTask.coreCompetence != 0 && addableTask.coreCompetence != 1){
            return false
        }
        return true
    }
}
