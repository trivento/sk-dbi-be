package databaseconnector.skillskompas.controller

import databaseconnector.skillskompas.model.DomainTaskCluster
import databaseconnector.skillskompas.service.DomainTaskClusterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api")
class DomainTaskClusterController{
    @Autowired
    lateinit var domainTaskClusterService: DomainTaskClusterService

    @GetMapping("/domaintaskcluster")
    fun findAll(): MutableIterable<DomainTaskCluster> {
        return domainTaskClusterService.getAllDomainTaskClusters()
    }

    @GetMapping("/domaintaskcluster/{id}")
    fun findById(@PathVariable(value = "id") domaintTaskClusterId : Long): ResponseEntity<DomainTaskCluster>? {
        return domainTaskClusterService.getDomainTaskCluster(domaintTaskClusterId)
    }

    @PostMapping("/domaintaskcluster")
    fun createProfileCompetence(@Valid @RequestBody domainTaskCluster: DomainTaskCluster): DomainTaskCluster =
            domainTaskClusterService.addDomainTaskCluster(domainTaskCluster)

    @DeleteMapping("/domaintaskcluster/{id}")
    fun removeProfileCompetence(@PathVariable(value = "id") domaintTaskClusterId: Long) {
        return domainTaskClusterService.removeDomainTaskCluster(domaintTaskClusterId)
    }
}


