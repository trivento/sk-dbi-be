package databaseconnector.skillskompas.controller

import databaseconnector.skillskompas.controller.dto.competence.CompetencePickListDTO
import databaseconnector.skillskompas.service.CompetenceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class CompetenceController{
    @Autowired
    lateinit var competenceService: CompetenceService

    @GetMapping("/competenceslist")
    fun getCompetencesList(): List<Map<Long, String>> {
        return competenceService.getCompetencesList()
    }

}


