package com.calyrsoft.ucbp1.features.profile.data.repository

import com.calyrsoft.ucbp1.features.profile.domain.model.ProfileModel
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.cellphone
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.email
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.name
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.pathUrl
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.summary
import com.calyrsoft.ucbp1.features.profile.domain.repository.IProfileRepository

class ProfileRepository: IProfileRepository {
    override fun fetchData(): Result<ProfileModel> {
        return Result.success(
            ProfileModel(
                name = name("Homero J. Simpson"),
                email = email("homero.simpson@springfieldmail.com"),
                cellphone = cellphone("+1 (939) 555‑7422"),
                pathUrl = pathUrl("https://www.viaempresa.cat/uploads/s1/43/99/69/homer.jpg"),
                summary = summary("Ciudadano de Springfield y dedicado inspector de seguridad en la Planta Nuclear.")
            )
        )
    }
}