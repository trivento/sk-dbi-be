package databaseconnector.skillskompas.model

import javax.persistence.*

@Entity
@Table(name = "SK_TASKREVISION")
data class TaskRevision(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val taskrevision_id: Long = -1,
        val revision: Int,
        val displayName: String,
        val rank: Int?,
        val active: Int = 0,
        val dot: String?,
        val solverMinTime: Int = 1,
        val solverMaxTime: Int = 80

)
