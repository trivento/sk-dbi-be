package databaseconnector.skillskompas.repository

import databaseconnector.skillskompas.model.*
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FunctionProfileRevisionRepository : CrudRepository<FunctionProfileRevision, Long>

