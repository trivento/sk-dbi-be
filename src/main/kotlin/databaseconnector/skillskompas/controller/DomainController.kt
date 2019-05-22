package databaseconnector.skillskompas.controller

import databaseconnector.skillskompas.controller.dto.domain.DomainDTO
import databaseconnector.skillskompas.model.Domain
import databaseconnector.skillskompas.service.DomainService
import databaseconnector.skillskompas.service.RequiredFieldService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api")
class DomainController{
    @Autowired
    lateinit var domainService: DomainService

    @GetMapping("/domain")
    fun findAll(): List<Map<Long, String>> {
        return domainService.getAllDomains()
    }

}


