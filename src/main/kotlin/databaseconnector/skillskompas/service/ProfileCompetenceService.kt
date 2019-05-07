package databaseconnector.skillskompas.service

import databaseconnector.skillskompas.model.AddableTask
import databaseconnector.skillskompas.model.ProfileCompetence
import databaseconnector.skillskompas.repository.ProfileCompetenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class ProfileCompetenceService {
    @Autowired
    lateinit var profileCompetenceRepository: ProfileCompetenceRepository

    fun addProfileCompetence(profileCompetence: ProfileCompetence): ProfileCompetence {
        return profileCompetenceRepository.save(profileCompetence)
    }
    fun addProfileCompetence(addableTask: AddableTask): ProfileCompetence {
        return addProfileCompetence(createProfileCompetenceFromAddableTask(addableTask))
    }

    fun getProfileCompetence(profileCompetenceId :Long): ResponseEntity<ProfileCompetence>? {
        return profileCompetenceRepository.findById(profileCompetenceId)
                .map {source -> ResponseEntity.ok(source)}
                .orElse(ResponseEntity.notFound().build())
    }

    fun removeProfileCompetence(profileCompetenceId: Long) {
        return profileCompetenceRepository.deleteById(profileCompetenceId)
    }

    fun getAllProfileCompetences(): MutableIterable<ProfileCompetence> {
        return profileCompetenceRepository.findAll()
    }

    private fun createProfileCompetenceFromAddableTask(addableTask: AddableTask): ProfileCompetence {
        return ProfileCompetence(
                profiletask_id = addableTask.profileTaskId!!,
                competence_id = addableTask.competenceId,
                weight = addableTask.weight
        )
    }

}

