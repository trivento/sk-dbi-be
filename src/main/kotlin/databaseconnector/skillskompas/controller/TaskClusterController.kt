package databaseconnector.skillskompas.controller

import databaseconnector.skillskompas.controller.dto.taskcluster.TaskClusterDTO
import databaseconnector.skillskompas.service.TaskClusterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class TaskClusterController{
    @Autowired
    lateinit var taskClusterService: TaskClusterService

    @GetMapping("/taskcluster")
    fun findAll(): List<TaskClusterDTO> {
        return taskClusterService.getAllTaskClusters()
    }

}


