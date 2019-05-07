package databaseconnector.skillskompas.controller

import databaseconnector.skillskompas.model.ProfileTask
import databaseconnector.skillskompas.service.ProfileTaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api")
class ProfileTaskController{
    @Autowired
    lateinit var profileTaskService: ProfileTaskService

    @GetMapping("/profiletask")
    fun findAll(): MutableIterable<ProfileTask> {
        return profileTaskService.getAllProfileTasks()
    }
    @GetMapping("/profiletask/{id}")
    fun findById(@PathVariable(value = "id") profileTaskId: Long): ResponseEntity<ProfileTask>? {
        return profileTaskService.getProfileTask(profileTaskId)
    }
    @PostMapping("/profiletask")
    fun createNewProfileTask(@Valid @RequestBody profileTask: ProfileTask):ProfileTask =
            profileTaskService.addProfileTask(profileTask)

    @DeleteMapping("/profiletask/{id}")
    fun removeProfileTask(@PathVariable(value = "id") profileTaskId: Long) {
        return profileTaskService.removeProfileTask(profileTaskId)
    }
}


