package com.calyrsoft.ucbp1.features.profile.domain.model.vo

@JvmInline
value class pathUrl(val value: String) {
    init {
        require(value.isNotEmpty()){
            "Value must be not be empty"
        }
        require(!value.contains(" ")){
            "value must not contain spaces"
        }
    }

}