package databaseconnector.skillskompas.model

import javax.persistence.*

@Entity
@Table(name = "SK_PROFILECOMPETENCE")
data class ProfileCompetence(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val profilecompetence_id: Long = -1,
        val profiletask_id: Long,
        val competence_id: Long,
        val weight: Int
)
