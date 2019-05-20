package databaseconnector.skillskompas.controller

import databaseconnector.skillskompas.model.AddableTaskConstraints
import databaseconnector.skillskompas.service.RequiredFieldService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/fields")

class RequiredFieldsController {
    @Autowired
    lateinit var requiredFieldService: RequiredFieldService

    @GetMapping("/{name}")
    fun getFields(@Valid @RequestParam (name = "name") name:String): List<AddableTaskConstraints> {
        return requiredFieldService.getRequiredFields(name)
    }
}
