package databaseconnector.skillskompas.controller

import databaseconnector.skillskompas.model.AddableTask
import databaseconnector.skillskompas.model.AddableTaskConstraints
import databaseconnector.skillskompas.model.Constraint
import databaseconnector.skillskompas.model.Type
import databaseconnector.skillskompas.service.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api")
class TaskController {

    @Autowired
    lateinit var taskService: TaskService

    @PostMapping("/task/addtask")
    fun addTask(@Valid @RequestBody addableTask: AddableTask) {
        taskService.addTask(addableTask)
    }

    @PutMapping("/task/activate/{id}")
    fun activateTask(@Valid @PathVariable(value = "id") taskRevisionId: Long) {
        taskService.activateTask(taskRevisionId)
    }

    @PutMapping("/task/deactivate/{id}")
    fun deactivateTask(@Valid @PathVariable(value = "id") taskRevisionId: Long) {
        taskService.deactivateTask(taskRevisionId)
    }


}
