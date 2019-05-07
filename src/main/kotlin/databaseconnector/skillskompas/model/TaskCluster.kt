package databaseconnector.skillskompas.model

import javax.persistence.*

@Entity
@Table(name = "SK_TASKCLUSTER")
data class TaskCluster(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val taskcluster_id: Long = -1,
        val name: String,
        val rank: Long?
)
