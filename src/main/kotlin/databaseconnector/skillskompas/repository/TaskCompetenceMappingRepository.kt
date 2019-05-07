package databaseconnector.skillskompas.repository

import databaseconnector.skillskompas.model.TaskCompetenceMapping
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import databaseconnector.skillskompas.model.TaskRevision

@Repository
interface TaskCompetenceMappingRepository : CrudRepository<TaskCompetenceMapping, Long> {

}

