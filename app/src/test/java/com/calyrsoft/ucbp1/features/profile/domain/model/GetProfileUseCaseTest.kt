package com.calyrsoft.ucbp1.features.profile.domain.model

import com.calyrsoft.ucbp1.features.profile.data.repository.ProfileRepository
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.cellphone
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.email
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.name
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.pathUrl
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.summary
import com.calyrsoft.ucbp1.features.profile.domain.usecase.GetProfileUseCase
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetProfileUseCaseTest {

    private val repository = ProfileRepository()
    private val useCase = GetProfileUseCase(repository)

    @Test
    fun `use case should return profile successfully`() = runBlocking {
        val result = useCase.invoke()
        assertTrue(result.isSuccess)

        val profile = result.getOrNull()
        assertNotNull(profile)


        assertEquals("Homero J. Simpson", profile?.name?.value)
        assertEquals("homero.simpson@springfieldmail.com", profile?.email?.value)
        assertEquals("+1 (939) 555‑7422", profile?.cellphone?.value)
        assertEquals("https://www.viaempresa.cat/uploads/s1/43/99/69/homer.jpg", profile?.pathUrl?.value)
        assertEquals(
            "Ciudadano de Springfield y dedicado inspector de seguridad en la Planta Nuclear.",
            profile?.summary?.value
        )
    }

    @Test
    fun `use case returns profile with correct types`() = runBlocking {
        val profile = useCase.invoke().getOrNull()
        assertTrue(profile?.name is name)
        assertTrue(profile?.email is email)
        assertTrue(profile?.cellphone is cellphone)
        assertTrue(profile?.pathUrl is pathUrl)
        assertTrue(profile?.summary is summary)
    }

}