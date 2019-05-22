package databaseconnector.skillskompas.service

import databaseconnector.skillskompas.controller.dto.toKeyValue
import databaseconnector.skillskompas.repository.CompetenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CompetenceService {
    @Autowired
    lateinit var competenceRepository: CompetenceRepository

    fun validateCompetenceId(competenceId: Long): Boolean {
        return competenceRepository.existsById(competenceId)
    }

    fun getCompetencesList(): List<Map<Long, String>> {
        return competenceRepository.findAll().map { it.toKeyValue() }
    }
}
