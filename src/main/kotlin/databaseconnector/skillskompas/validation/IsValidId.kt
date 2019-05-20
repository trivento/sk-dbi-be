package databaseconnector.skillskompas.validation

import databaseconnector.skillskompas.service.*
import org.springframework.beans.factory.annotation.Autowired
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class IsValidTaskClusterId : ConstraintValidator<IsValidTaskClusterIdValidator, Long> {
    @Autowired
    lateinit var taskClusterService: TaskClusterService
    override fun isValid(value: Long, context: ConstraintValidatorContext): Boolean {
        return taskClusterService.validateTaskClusterId(value)
    }
}

class IsValidDomainId : ConstraintValidator<IsValidDomainIdValidator, Long> {
    @Autowired
    lateinit var domainService: DomainService
    override fun isValid(value: Long, context: ConstraintValidatorContext): Boolean {
        return domainService.validateDomainId(value)
    }
}

class IsValidCompetenceId : ConstraintValidator<IsValidCompetenceIdValidator, Long> {
    @Autowired
    lateinit var competenceService: CompetenceService
    override fun isValid(value: Long, context: ConstraintValidatorContext): Boolean {
        return competenceService.validateCompetenceId(value)
    }
}

class IsValidFunctionProfileRevisionId : ConstraintValidator<IsValidFunctionProfileRevisionIdValidator, Long> {
    @Autowired
    lateinit var functionProfileRevisionService: FunctionProfileRevisionService
    override fun isValid(value: Long, context: ConstraintValidatorContext): Boolean {
        return functionProfileRevisionService.validateFunctionProfileRevisionId(value)
    }
}
