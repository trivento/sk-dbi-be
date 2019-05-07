package databaseconnector.skillskompas.service

import databaseconnector.skillskompas.model.AddableTask
import databaseconnector.skillskompas.model.ProfileTask
import databaseconnector.skillskompas.repository.ProfileTaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class ProfileTaskService {
    @Autowired
    lateinit var profileTaskRepository: ProfileTaskRepository

    fun addProfileTask(profileTask: ProfileTask): ProfileTask {
        return profileTaskRepository.save(profileTask)
    }
    fun addProfileTask(addableTask: AddableTask): ProfileTask {
        return addProfileTask(createProfileTaskFromAddableTask(addableTask))
    }

    fun getProfileTask(profileTaskId:Long): ResponseEntity<ProfileTask>? {
        return profileTaskRepository.findById(profileTaskId)
                .map {source -> ResponseEntity.ok(source)}
                .orElse(ResponseEntity.notFound().build())
    }

    fun removeProfileTask(profileTaskId: Long) {
        return profileTaskRepository.deleteById(profileTaskId)
    }

    fun getAllProfileTasks(): MutableIterable<ProfileTask> {
        return profileTaskRepository.findAll()
    }
    private fun createProfileTaskFromAddableTask(addableTask: AddableTask): ProfileTask {
        return ProfileTask(
                profiletask_id = addableTask.functionProfileRevisionId,
                functionprofilerevision_id = addableTask.functionProfileRevisionId,
                taskrevision_id = addableTask.taskRevisionId!!,
                core_task = addableTask.coreTask,
                standard_task = addableTask.standardTask,
                time_score = addableTask.timeScore,
                taskgroup = addableTask.taskGroup,
                resultarea_id = addableTask.resultAreaId,
                rank = addableTask.rank
        )
    }

}

