package databaseconnector.skillskompas.model

import javax.persistence.*

@Entity
@Table(name = "SK_COMPETENCE")
data class Competence(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val competence_id: Long = -1,
        val display_name: String,
        val rank: Int,
        val weight_multiplier: Int,
        val type: String
)
