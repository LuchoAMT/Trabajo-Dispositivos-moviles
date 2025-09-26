package com.calyrsoft.ucbp1.features.profile.domain.model.vo

@JvmInline
value class email (val value: String) {
    init {
        require(value.isNotEmpty()){
            "Value must be not be empty"
        }
        require(value.contains("@")) {
            "Nickname must contain '@' to be considered an email"
        }
    }
}