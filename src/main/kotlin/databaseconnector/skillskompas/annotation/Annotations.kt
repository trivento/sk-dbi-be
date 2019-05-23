package databaseconnector.skillskompas.annotation

import databaseconnector.skillskompas.validation.*
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.annotation.AnnotationTarget.*
import kotlin.reflect.KClass

annotation class IsEnum


@MustBeDocumented
@Constraint(validatedBy = [IsValidTaskClusterId::class])
@Target(allowedTargets = [PROPERTY_GETTER])
@Retention(AnnotationRetention.RUNTIME)
annotation class IsValidTaskClusterIdValidator(
        val message: String = "This TaskClusterId does not exist",
        val groups: Array<KClass<out Any>> = [],
        val payload: Array<KClass<out Payload>> = []
)

@MustBeDocumented
@Constraint(validatedBy = [IsValidDomainId::class])
@Target(allowedTargets = [PROPERTY_GETTER])
@Retention(AnnotationRetention.RUNTIME)
annotation class IsValidDomainIdValidator(
        val message: String = "This DomainId does not exist",
        val groups: Array<KClass<out Any>> = [],
        val payload: Array<KClass<out Payload>> = []
)

@MustBeDocumented
@Constraint(validatedBy = [IsValidCompetenceId::class])
@Target(allowedTargets = [PROPERTY_GETTER])
@Retention(AnnotationRetention.RUNTIME)
annotation class IsValidCompetenceIdValidator(
        val message: String = "This CompetenceId does not exist",
        val groups: Array<KClass<out Any>> = [],
        val payload: Array<KClass<out Payload>> = []
)

@MustBeDocumented
@Constraint(validatedBy = [IsValidFunctionProfileRevisionId::class])
@Target(allowedTargets = [PROPERTY_GETTER])
@Retention(AnnotationRetention.RUNTIME)
annotation class IsValidFunctionProfileRevisionIdValidator(
        val message: String = "This FunctionProfileRevisionId does not exist",
        val groups: Array<KClass<out Any>> = [],
        val payload: Array<KClass<out Payload>> = []
)


@MustBeDocumented
@Constraint(validatedBy = [IsValidResultAreaId::class])
@Target(allowedTargets = [PROPERTY_GETTER])
@Retention(AnnotationRetention.RUNTIME)
annotation class IsValidResultAreaIdValidator(
        val message: String = "This resultAreaId does not exist",
        val groups: Array<KClass<out Any>> = [],
        val payload: Array<KClass<out Payload>> = []
)



