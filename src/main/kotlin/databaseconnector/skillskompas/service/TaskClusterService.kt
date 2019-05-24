package databaseconnector.skillskompas.service

import databaseconnector.skillskompas.model.convertToKeyValuePair
import databaseconnector.skillskompas.repository.TaskClusterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TaskClusterService {
    @Autowired
    lateinit var taskClusterRepository: TaskClusterRepository

    fun validateTaskClusterId(taskClusterId: Long): Boolean {
        return taskClusterRepository.existsById(taskClusterId)
    }

    fun getTaskClusterList(): List<MutableMap<Long, String>> {
        return taskClusterRepository.findAll().map { it.convertToKeyValuePair() }
    }
}
