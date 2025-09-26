package com.calyrsoft.ucbp1.features.profile.domain.model.vo

@JvmInline
value class cellphone(val value: String) {
    init {
        require(value.isNotEmpty()){
            "Value must be not be empty"
        }
        require(value.length in 7..11){
            "Value must have more than 7 characters and less than 11"
        }
        require(value.matches(Regex("^[0-9]+$"))){
            "value must contain only numbers 0-9"
        }
    }
}