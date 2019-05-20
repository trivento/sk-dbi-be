package databaseconnector.skillskompas.service

import databaseconnector.skillskompas.model.AddableTaskConstraints
import databaseconnector.skillskompas.model.Constraint
import databaseconnector.skillskompas.model.Type
import org.springframework.stereotype.Service

@Service
class RequiredFieldService {




    fun getRequiredFields(name: String): List<AddableTaskConstraints> {
        return listOf(AddableTaskConstraints(
                type = Type.TEXT,
                label = "A text field",
                defaultValue = null,
                takeDefaultIfUndefined = true,
                constraints = Constraint(
                        minValue = 1,
                        maxValue = 3,
                        minLength = 3,
                        mustBeInValues = true
                )
        ),
                AddableTaskConstraints(
                        type = Type.CATEGORIE,
                        label = "A balbalbal",
                        defaultValue = 10,
                        takeDefaultIfUndefined = true,
                        constraints = Constraint(
                                minValue = 0,
                                maxValue = 10,
                                minLength = null,
                                mustBeInValues = false
                        )

                )
        )
    }
}
