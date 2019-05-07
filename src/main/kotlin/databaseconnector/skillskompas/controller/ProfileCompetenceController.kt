package databaseconnector.skillskompas.controller

import databaseconnector.skillskompas.model.ProfileCompetence
import databaseconnector.skillskompas.service.ProfileCompetenceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api")
class ProfileCompetenceController{
    @Autowired
    lateinit var profileCompetenceService: ProfileCompetenceService

    @GetMapping("/profilecompetence")
    fun findAll(): MutableIterable<ProfileCompetence> {
        return profileCompetenceService.getAllProfileCompetences()
    }
    @GetMapping("/profilecompetence/{id}")
    fun findById(@PathVariable(value = "id") profileCompetenceId : Long): ResponseEntity<ProfileCompetence>? {
        return profileCompetenceService.getProfileCompetence(profileCompetenceId)
    }
    @PostMapping("/profilecompetence")
    fun createProfileCompetence(@Valid @RequestBody profileCompetence: ProfileCompetence): ProfileCompetence=
            profileCompetenceService.addProfileCompetence(profileCompetence)

    @DeleteMapping("/profilecompetence/{id}")
    fun removeProfileCompetence(@PathVariable(value = "id") profileCompetenceId:Long) {
        return profileCompetenceService.removeProfileCompetence(profileCompetenceId)
    }
}


