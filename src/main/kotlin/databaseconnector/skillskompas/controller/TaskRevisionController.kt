package databaseconnector.skillskompas.controller

import databaseconnector.skillskompas.model.TaskRevision
import databaseconnector.skillskompas.repository.TaskRevisionRepository
import databaseconnector.skillskompas.service.TaskRevisionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api")
class TaskRevisionController {
    @Autowired
    lateinit var taskRevisionService: TaskRevisionService

    @GetMapping("/taskrevision")
    fun findAll(): MutableIterable<TaskRevision> {
        return taskRevisionService.getAllTaskRevisions()
    }

    @GetMapping("/taskrevision/{id}")
    fun findById(@PathVariable(value = "id") profileTaskId: Long): ResponseEntity<TaskRevision>? {
        return taskRevisionService.getTaskRevision(profileTaskId)
    }
    @PostMapping("/taskrevision")
    fun addTaskRevision(@Valid @RequestBody taskRevision: TaskRevision): Long =
            taskRevisionService.addTaskRevision(taskRevision)

    @DeleteMapping("/taskrevision/{id}")
    fun removeProfileTask(@PathVariable(value = "id") taskRevisionId: Long) {
       taskRevisionService.removeTaskRevision(taskRevisionId)
    }
}


