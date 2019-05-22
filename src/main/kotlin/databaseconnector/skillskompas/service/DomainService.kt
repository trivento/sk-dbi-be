package databaseconnector.skillskompas.service

import databaseconnector.skillskompas.controller.dto.toKeyValue
import databaseconnector.skillskompas.repository.DomainRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DomainService {
    @Autowired
    lateinit var domainRepository: DomainRepository

    fun validateDomainId(domainId: Long): Boolean {
        return domainRepository.existsById(domainId)
    }

    fun getAllDomains(): List<Map<Long, String>> {
        return domainRepository.findAll().map{it.toKeyValue()}
    }

}
