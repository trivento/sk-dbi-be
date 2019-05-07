package databaseconnector.skillskompas.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import databaseconnector.skillskompas.model.TaskRevision

@Repository
interface TaskRevisionRepository : CrudRepository<TaskRevision, Long> {



}

