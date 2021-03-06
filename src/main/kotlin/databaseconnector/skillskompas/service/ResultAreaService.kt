package databaseconnector.skillskompas.service

import databaseconnector.skillskompas.repository.ResultAreaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ResultAreaService {
    @Autowired
    lateinit var resultAreaRepository: ResultAreaRepository

    fun validateResultAreaId(resultAreaId: Long?): Boolean {
        return if (resultAreaId == null) {
            true
        } else {
            resultAreaRepository.existsById(resultAreaId)
        }
    }
}
