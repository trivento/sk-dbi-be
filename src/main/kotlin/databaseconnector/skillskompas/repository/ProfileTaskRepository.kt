package databaseconnector.skillskompas.repository

import databaseconnector.skillskompas.model.DomainTaskCluster
import databaseconnector.skillskompas.model.ProfileTask
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import databaseconnector.skillskompas.model.TaskRevision

@Repository
interface ProfileTaskRepository : CrudRepository<ProfileTask, Long> {



}

