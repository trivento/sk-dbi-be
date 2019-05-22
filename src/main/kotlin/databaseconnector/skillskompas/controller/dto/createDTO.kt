package databaseconnector.skillskompas.controller.dto
import databaseconnector.skillskompas.model.Competence
import databaseconnector.skillskompas.model.Domain
import databaseconnector.skillskompas.model.TaskCluster

fun Competence.toKeyValue() = mutableMapOf(competence_id to display_name)
fun Domain.toKeyValue() = mutableMapOf(domain_id to display_name)
fun TaskCluster.toKeyValue() = mutableMapOf(taskcluster_id to name)
