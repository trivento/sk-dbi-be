package databaseconnector.skillskompas.model

import javax.persistence.*

@Entity
@Table(name = "SK_RESULTAREAS")
data class ResultAreas(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val resultarea_id: Long = -1,
        val functionprofilerevision_id: Long,
        val name: String,
        val result: String?,
        val rank: Int
)
