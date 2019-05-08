package databaseconnector.skillskompas.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "SK_FUNCTIONPROFILEREVISION")
data class FunctionProfileRevision(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val functionprofilerevision_id: Long = -1,
        val functionprofile_id: Long,
        val revision: Int,
        val revision_date: Date,
        val last_edit_date: Date,
        val copied_from_profile_id: Long,
        val deleted: Int,
        val name: String,
        val functiontype: Char,
        val active: Int,
        val company_id: Int,
        val copied_from_root_profile_id: Long,
        val revisiondescription: String,
        val visible: Int,
        val normed: Int,
        val function_cluster_1:Int,
        val function_cluster_2:Int,
        val function_cluster_3:Int,
        val function_cluster_4:Int,
        val function_cluster_5:Int,
        val name_short: String,
        val person_id: Long,
        val source: String,
        val rank: Int,
        val result_areas_complete:Boolean,
        val external_ref: String,
        val labour_market_image_path: String
)
