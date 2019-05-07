package databaseconnector.skillskompas.model

import javax.persistence.*

@Entity
@Table(name = "SK_DOMAIN_TASK_CLUSTER")
data class DomainTaskCluster(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val domain_task_cluster_id: Long = -1,
        val domain_id: Long,
        val taskcluster_id: Long,
        val taskrevision_id: Long

) {

}
