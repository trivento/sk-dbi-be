package databaseconnector.skillskompas.controller

import databaseconnector.skillskompas.model.AddableTask
import databaseconnector.skillskompas.service.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/api")
class TaskController {

    @Autowired
    lateinit var taskService: TaskService

    @PostMapping("/addtask")
    fun addTask(@Valid @RequestBody addableTask: AddableTask){
        taskService.addTask(addableTask)
    }
}
