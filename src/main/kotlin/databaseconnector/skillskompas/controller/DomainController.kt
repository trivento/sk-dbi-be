package databaseconnector.skillskompas.controller

import databaseconnector.skillskompas.service.DomainService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class DomainController{
    @Autowired
    lateinit var domainService: DomainService

    @GetMapping("/domainlist")
    fun getDomainList(): List<Map<Long, String>> {
        return domainService.getDomainList()
    }

}


