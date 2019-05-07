package databaseconnector.skillskompas.controller

import databaseconnector.skillskompas.model.TaskCompetenceMapping
import databaseconnector.skillskompas.service.TaskCompetenceMappingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api")
class TaskCompetenceMappingController{
    @Autowired
    lateinit var taskCompetenceMappingService: TaskCompetenceMappingService

    @GetMapping("/taskcompetencemapping")
    fun findAll(): MutableIterable<TaskCompetenceMapping> {
        return taskCompetenceMappingService.getAllTaskCompetenceMappings()
    }

    @GetMapping("/taskcompetencemapping/{id}")
    fun findById(@PathVariable(value = "id") taskCompetenceMappingID: Long): ResponseEntity<TaskCompetenceMapping>? {
        return taskCompetenceMappingService.getTaskCompetenceMapping(taskCompetenceMappingID)
    }
    @PostMapping("/taskcompetencemapping")
    fun createNewProfileTask(@Valid @RequestBody taskCompetenceMapping: TaskCompetenceMapping):TaskCompetenceMapping =
            taskCompetenceMappingService.addTaskCompetenceMapping(taskCompetenceMapping)

    @DeleteMapping("/taskcompetencemapping/{id}")
    fun removeProfileTask(@PathVariable(value = "id") taskCompetenceMappingID:Long) {
        return taskCompetenceMappingService.removeTaskCompetenceMapping(taskCompetenceMappingID)
    }
}


