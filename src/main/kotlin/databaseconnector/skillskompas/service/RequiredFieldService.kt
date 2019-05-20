package databaseconnector.skillskompas.service
import databaseconnector.skillskompas.model.Property
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RequiredFieldService {
    @Autowired
    lateinit var taskService: TaskService

    fun getRequiredFields(name: String): List<Property> {
        return when (name) {
            "task" -> getRequiredFieldsForTask()
            "somethingelse" -> getRequiredFieldsForSomethingElse()
            else -> emptyList()
        }
    }

    private fun getRequiredFieldsForSomethingElse(): List<Property> {
        return emptyList()
    }

    private fun getRequiredFieldsForTask(): List<Property> {
        return taskService.getRequiredFieldsForTask()
    }
}

