package databaseconnector.skillskompas.service

import databaseconnector.skillskompas.repository.FunctionProfileRevisionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FunctionProfileRevisionService {
    @Autowired
    lateinit var functionProfileRevisionRepository: FunctionProfileRevisionRepository

    fun validateFunctionProfileRevisionId(functionProfileRevisionId: Long): Boolean {
        return functionProfileRevisionRepository.existsById(functionProfileRevisionId)
    }
}
