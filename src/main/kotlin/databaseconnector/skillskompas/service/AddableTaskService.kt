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

    fun validate(addableTask: AddableTask) {
        //Check if domainId exists
        domainService.validateDomainId(addableTask.domainId)
        //Check if competenceId exists
        competenceService.validateCompetenceId(addableTask.competenceId)

    }
}
