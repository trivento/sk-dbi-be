package databaseconnector.skillskompas.model

import javax.persistence.*

@Entity
@Table(name = "SK_DOMAIN")
data class Domain(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val domain_id: Long = -1,
        val system_name: String,
        val display_name: String,
        val description: String,
        val logo: String,
        val matchbox_sector_id:Int,
        val show_logo_in_pdf: Boolean,
        val default_url_id:Int
)
