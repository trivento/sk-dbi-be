package databaseconnector.skillskompas.controller

import databaseconnector.skillskompas.model.Property
import databaseconnector.skillskompas.service.RequiredFieldService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/fields")

class RequiredFieldsController {
    @Autowired
    lateinit var requiredFieldService: RequiredFieldService

    @GetMapping("/{name}")
    fun getFields(@Valid @PathVariable (value = "name") name:String): List<Property> {
        return requiredFieldService.getRequiredFields(name)
    }
}
