package databaseconnector.skillskompas.model

import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "SK_DOMAIN")
data class Domain(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val domain_id: Long = -1,
        @get: Size(min = 10, message= "A task should be at least 10 characters long")
        val system_name: String,
        @get: Size(min = 10, message= "A task should be at least 10 characters long")
        val display_name: String,
        @get: Size(min = 10, message= "A task should be at least 10 characters long")
        val description: String,
        @get: Size(min = 10, message= "A task should be at least 10 characters long")
        val logo: String,
        val matchbox_sector_id:Int,
        val show_logo_in_pdf: Boolean,
        val default_url_id:Int
)

fun Domain.toKeyValue() = mutableMapOf(domain_id to display_name)

