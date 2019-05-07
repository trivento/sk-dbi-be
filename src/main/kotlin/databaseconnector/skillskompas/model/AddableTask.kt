package databaseconnector.skillskompas.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.Min

@Entity
class AddableTask (
        @Id
        val id: Long,
        val displayName: String,
        val dot: String? = null,
        val rank: Int = 1000,
        val active: Int = 0,
        @get: Min(4)
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
){

    override fun toString(): String {
        return(
                "displayName = ${displayName}" +
                "\ndot = ${dot}" +
                "\nrank = ${rank}" +
                "\nactive = ${active}" +
                "\nsolverMinTime = ${solverMinTime}" +
                "\nsolverMaxTime = ${solverMaxTime}" +
                "\nrevision = ${revision}" +
                "\ndomainId = ${domainId}" +
                "\ntaskClusterId = ${taskClusterId}" +
                "\ntaskRevisionId = ${taskRevisionId}" +
                "\ncompetenceId = ${competenceId}" +
                "\ncoreCompetence = ${coreCompetence}" +
                "\nfunctionProfileRevisionId = ${functionProfileRevisionId}" +
                "\ncoreTask = ${coreTask}" +
                "\nstandardTask = ${standardTask}" +
                "\ntimeScore = ${timeScore}" +
                "\ntaskGroup = ${taskGroup}" +
                "\nresultAreaId = ${resultAreaId}" +
                "\nprofileTaskId = ${profileTaskId}" +
                "\nweight = ${weight}"
        )
    }
}



