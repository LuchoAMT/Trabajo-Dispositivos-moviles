package com.calyrsoft.ucbp1.features.profile.domain.model

import com.calyrsoft.ucbp1.features.profile.domain.model.vo.cellphone
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.email
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.name
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.pathUrl
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.summary

data class ProfileModel(
    val pathUrl: pathUrl,
    val name: name,
    val email: email,
    val cellphone: cellphone,
    val summary: summary
)
