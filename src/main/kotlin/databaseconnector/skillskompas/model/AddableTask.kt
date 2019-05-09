package databaseconnector.skillskompas.model

import databaseconnector.skillskompas.validation.IsValidCompetenceIdValidator
import databaseconnector.skillskompas.validation.IsValidDomainIdValidator
import databaseconnector.skillskompas.validation.IsValidFunctionProfileRevisionIdValidator
import databaseconnector.skillskompas.validation.IsValidTaskClusterIdValidator
import javax.validation.constraints.*


class AddableTask (
        @get: IsValidFunctionProfileRevisionIdValidator
        val functionProfileRevisionId: Long,
        @get: IsValidDomainIdValidator
        val domainId: Long,
        @get: IsValidTaskClusterIdValidator
        val taskClusterId: Long,
        @get: IsValidCompetenceIdValidator
        val competenceId: Long,
        var taskRevisionId: Long?,
        var profileTaskId: Long? = null,
        @get: NotNull @get: Size(min = 10)
        val displayName: String,
        @get: Max( 2000)
        val rank: Int = 1000,
        @get: Min(0)
        val solverMinTime: Int = 1,
        @get: Max(120)
        val solverMaxTime: Int = 80,
        @get: Min(0) @get: Max(1)
        val revision: Int = 1,
        @get: Min(0) @get: Max(1)
        val coreCompetence: Int,
        @get: Min(0) @get: Max(1)
        val coreTask: Int = 0,
        @get: Min(0) @get: Max(1)
        val standardTask: Int = 0,
        @get: Max(1000)
        val timeScore: Int = 0,
        @get: Max(100)
        val weight: Int,
        @get: Max(1000)
        val taskGroup: Int? = null,
        @get: Min(0) @get: Max(1)
        val active: Int = 0,
        val resultAreaId: Int? = null,
        val dot: String? = null


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



