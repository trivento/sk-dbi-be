package databaseconnector.skillskompas.service

import databaseconnector.skillskompas.controller.dto.taskcluster.TaskClusterDTO
import databaseconnector.skillskompas.controller.dto.toKeyValue
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

    fun getAllTaskClusters(): List<Map<Long, String>> {
        return taskClusterRepository.findAll().map { it.toKeyValue() }
    }
}
