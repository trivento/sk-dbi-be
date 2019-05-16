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
        @get: NotNull @get: Size(min = 10, message= "A task should be at least 10 characters long")
        val displayName: String,
        @get: Max(2000, message = "The max value of rank can be 2000")
        val rank: Int = 1000,
        @get: Min(0, message = "The min solver time must be at least 1")
        val solverMinTime: Int = 1,
        @get: Max(120, message = "The max solver time can be 120")
        val solverMaxTime: Int = 80,
        @get: Min(0, message="Revision can either be 0 or 1") @get: Max(1, message="Revision can either be 0 or 1")
        val revision: Int = 1,
        @get: Min(0, message="A competence can only be a core (1) or non-core (0) competence") @get: Max(1,message="A competence can only be a core (1) or non-core (0) competence")
        val coreCompetence: Int,
        @get: Min(0, message="A task can only be a core (1) or non-core (0) task") @get: Max(1, message="A task can only be a core (1) or non-core (0) task")
        val coreTask: Int = 0,
        @get: Min(0, message="A task can only be standard (1) or non-standard (0)") @get: Max(1, message="A task can only be standard (1) or non-standard (0)")
        val standardTask: Int = 0,
        @get: Max(1000, message="The max timescore can only be 1000")
        val timeScore: Int = 0,
        @get: Max(100, message="The max weight can only be 100")
        val weight: Int,
        @get: Max(1000)
        val taskGroup: Int? = null,
        @get: Min(0, message= "A task can only be active (1) or inactive (0)") @get: Max(1,message="A task can only be active (1) or inactive (0)")
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



