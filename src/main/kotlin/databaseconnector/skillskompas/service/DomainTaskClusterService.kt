package databaseconnector.skillskompas.service

import databaseconnector.skillskompas.model.AddableTask
import databaseconnector.skillskompas.model.DomainTaskCluster
import databaseconnector.skillskompas.repository.DomainTaskClusterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class DomainTaskClusterService {
    @Autowired
    lateinit var domainTaskClusterRepository: DomainTaskClusterRepository

    fun addDomainTaskCluster(domaintTaskCluster: DomainTaskCluster): DomainTaskCluster {
        return domainTaskClusterRepository.save(domaintTaskCluster)
    }

    fun addDomainTaskCluster(addableTask: AddableTask):DomainTaskCluster{
        return addDomainTaskCluster(createDomainTaskClusterFromAddableTask(addableTask))
    }

    fun getDomainTaskCluster(domaintTaskClusterId :Long): ResponseEntity<DomainTaskCluster>? {
        return domainTaskClusterRepository.findById(domaintTaskClusterId)
                .map {source -> ResponseEntity.ok(source)}
                .orElse(ResponseEntity.notFound().build())
    }

    fun removeDomainTaskCluster(domaintTaskClusterId: Long) {
        return domainTaskClusterRepository.deleteById(domaintTaskClusterId)
    }

    fun getAllDomainTaskClusters(): MutableIterable<DomainTaskCluster> {
        return domainTaskClusterRepository.findAll()
    }

    private fun createDomainTaskClusterFromAddableTask(addableTask: AddableTask): DomainTaskCluster {
        return DomainTaskCluster(
                domain_id = addableTask.domainId,
                taskcluster_id = addableTask.taskClusterId,
                taskrevision_id = addableTask.taskRevisionId!!
            )
    }
}

