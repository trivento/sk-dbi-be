package databaseconnector.skillskompas.model

import javax.persistence.*

@Entity
@Table(name = "SK_TASK_COMPETENCE_MAPPING")
data class TaskCompetenceMapping(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val task_competence_mapping_id: Long = -1,
        val taskrevision_id: Long,
        val competence_id: Long,
        val core_competence: Int
){

}
