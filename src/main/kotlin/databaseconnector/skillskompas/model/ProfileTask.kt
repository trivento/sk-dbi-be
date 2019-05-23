package databaseconnector.skillskompas.model

import javax.persistence.*

@Entity
@Table(name = "SK_PROFILETASK")
data class ProfileTask(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val profiletask_id: Long = -1,
        val functionprofilerevision_id: Long,
        val taskrevision_id: Long,
        val core_task: Int,
        val standard_task: Int,
        val time_score:Int,
        val taskgroup:Int?,
        val resultarea_id:Long?,
        val rank:Int?

)
