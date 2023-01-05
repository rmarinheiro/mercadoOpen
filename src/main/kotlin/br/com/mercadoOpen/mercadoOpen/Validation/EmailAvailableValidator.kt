package br.com.mercadoOpen.mercadoOpen.Validation

import br.com.mercadoOpen.mercadoOpen.Service.CustomerService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class EmailAvailableValidator( var customerService: CustomerService) : ConstraintValidator<EmailAvailable,String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrEmpty()){
            return false
        }
        return  customerService.emailAvailable(value)
    }


}
