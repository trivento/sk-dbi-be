package databaseconnector.skillskompas.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import databaseconnector.skillskompas.model.TaskRevision
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional

@Repository
interface TaskRevisionRepository : CrudRepository<TaskRevision, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE SK_TASKREVISION SET ACTIVE=1 WHERE TASKREVISION_ID= ?1", nativeQuery = true)
    fun activateTask(taskRevisionId: Long)

    @Transactional
    @Modifying
    @Query(value = "UPDATE SK_TASKREVISION SET ACTIVE=0 WHERE TASKREVISION_ID= ?1", nativeQuery = true)
    fun deactivateTask(taskRevisionId: Long)

}

