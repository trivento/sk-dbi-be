package databaseconnector.skillskompas.service

import databaseconnector.skillskompas.model.AddableTask
import databaseconnector.skillskompas.model.TaskCompetenceMapping
import databaseconnector.skillskompas.repository.TaskCompetenceMappingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class TaskCompetenceMappingService {
    @Autowired
    lateinit var taskCompetenceMappingRepository: TaskCompetenceMappingRepository

    fun addTaskCompetenceMapping(taskCompetenceMapping: TaskCompetenceMapping): TaskCompetenceMapping {
        return taskCompetenceMappingRepository.save(taskCompetenceMapping)
    }

    fun addTaskCompetenceMapping(addableTask: AddableTask): TaskCompetenceMapping {
        return addTaskCompetenceMapping(createTaskCompetenceMappingFromAddableTask(addableTask))
    }

    fun getTaskCompetenceMapping(taskCompetenceId: Long): ResponseEntity<TaskCompetenceMapping>? {
        return taskCompetenceMappingRepository.findById(taskCompetenceId)
                .map {source -> ResponseEntity.ok(source)}
                .orElse(ResponseEntity.notFound().build())
    }

    fun removeTaskCompetenceMapping(taskCompetenceId: Long) {
        return taskCompetenceMappingRepository.deleteById(taskCompetenceId)
    }

    fun getAllTaskCompetenceMappings(): MutableIterable<TaskCompetenceMapping> {
        return taskCompetenceMappingRepository.findAll()
    }

    private fun createTaskCompetenceMappingFromAddableTask(addableTask: AddableTask): TaskCompetenceMapping {
        return TaskCompetenceMapping(
                taskrevision_id = addableTask.taskRevisionId!!,
                competence_id = addableTask.competenceId,
                core_competence = addableTask.coreCompetence
        )
    }
}

