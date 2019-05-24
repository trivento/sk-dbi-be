package databaseconnector.skillskompas.service

import databaseconnector.skillskompas.model.convertToKeyValuePair
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

    fun getDomainList(): List<MutableMap<Long, String>> {
        return domainRepository.findAll().map{ it.convertToKeyValuePair() }
    }

}
