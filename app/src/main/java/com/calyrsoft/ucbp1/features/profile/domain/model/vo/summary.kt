package com.calyrsoft.ucbp1.features.profile.domain.model.vo

@JvmInline
value class summary(val value: String) {
    init {
        require(value.isNotEmpty()){
            "Value must be not be empty"
        }

        require(value.matches(Regex("^[A-Za-z0-9]+$"))){
            "value must contain only alphanumeric characters A-Z a-z 0-9"
        }
    }
}