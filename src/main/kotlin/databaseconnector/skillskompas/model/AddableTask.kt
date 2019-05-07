package databaseconnector.skillskompas.model

import databaseconnector.skillskompas.service.DomainTaskClusterService
import org.springframework.beans.factory.annotation.Autowired

 class AddableTask (
        val displayName: String,
        val dot: String? = null,
        val rank: Int = 1000,
        val active: Int = 0,
        val solverMinTime: Int = 1,
        val solverMaxTime: Int = 80,
        val revision: Int = 1,
        val domainId: Long,
        val taskClusterId: Long = 1,
        var taskRevisionId: Long? = null,
        val competenceId: Long,
        val coreCompetence: Int,
        val functionProfileRevisionId: Long,
        val coreTask: Int = 0,
        val standardTask: Int = 0,
        val timeScore: Int = 0,
        val taskGroup: Int? = null,
        val resultAreaId: Int? = null,
        var profileTaskId: Long? = null,
        val weight: Int
)
{
        @Autowired
        private lateinit var domainTaskClusterService: DomainTaskClusterService

        fun validate(): Boolean {
                println(domainTaskClusterService.validateDomainId(this.domainId))

                return true
        }
}


