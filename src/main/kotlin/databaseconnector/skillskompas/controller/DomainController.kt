package databaseconnector.skillskompas.controller

import databaseconnector.skillskompas.model.Domain
import databaseconnector.skillskompas.model.DomainTaskCluster
import databaseconnector.skillskompas.repository.DomainRepository
import databaseconnector.skillskompas.service.DomainService
import databaseconnector.skillskompas.service.DomainTaskClusterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api")
class DomainController{
    @Autowired
    lateinit var domainService: DomainService

    @GetMapping("/domain")
    fun findAll(): MutableIterable<Domain> {
        return domainService.getAllDomains()
    }
}


