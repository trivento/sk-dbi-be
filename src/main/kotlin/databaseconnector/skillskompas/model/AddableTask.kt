package databaseconnector.skillskompas.model

import javax.validation.constraints.*


class AddableTask (
        //TODO create check
        var profileTaskId: Long? = null,
        //TODO create check
        val functionProfileRevisionId: Long,
        //Is checked through own validation
        val domainId: Long,
        //Is checked through own validation
        val taskClusterId: Long = 1,
        //Is checked through own validation
        val competenceId: Long,
        //Should exist because we create this when adding a task
        var taskRevisionId: Long?,
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



