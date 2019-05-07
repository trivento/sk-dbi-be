package databaseconnector.skillskompas.model

import javax.validation.constraints.*


class AddableTask (
        @get: NotNull @get: NotEmpty @get: NotBlank @get: Size(min = 10)
        val displayName: String,
        val dot: String? = null,
        @get: Max( 2000)
        val rank: Int = 1000,
        val active: Int = 0,
        @get: Min(0)
        val solverMinTime: Int = 1,
        @get: Max(120)
        val solverMaxTime: Int = 80,
        @get: Min(0) @get: Max(1)
        val revision: Int = 1,
        //Is checked through own validation
        val domainId: Long,
        //Is checked through own validation
        val taskClusterId: Long = 1,
        //Is checked through own validation
        var taskRevisionId: Long,
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



