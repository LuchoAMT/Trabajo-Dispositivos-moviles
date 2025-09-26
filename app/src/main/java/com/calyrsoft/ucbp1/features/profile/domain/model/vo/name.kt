package com.calyrsoft.ucbp1.features.profile.domain.model.vo

@JvmInline
value class name(val value: String) {
    init {
        require(value.isNotEmpty()){
            "Value must be not be empty"
        }
        require(value.length in 3..15){
            "Value must have more than 3 characters and less than 15"
        }
        require(!value.contains(" ")){
            "value must not contain spaces"
        }
        require(value.matches(Regex("^[A-Za-z0-9]+$"))){
            "value must contain only alphanumeric characters A-Z a-z 0-9"
        }
    }
}