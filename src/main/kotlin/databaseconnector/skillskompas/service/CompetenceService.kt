package databaseconnector.skillskompas.service

import databaseconnector.skillskompas.repository.CompetenceRepository
import databaseconnector.skillskompas.repository.DomainRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CompetenceService {
    @Autowired
    lateinit var competenceRepository: CompetenceRepository

    fun validateCompetenceId(competenceId: Long): Boolean {
        return competenceRepository.existsById(competenceId)
    }
}
