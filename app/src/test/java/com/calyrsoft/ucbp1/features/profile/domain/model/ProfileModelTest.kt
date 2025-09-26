package com.calyrsoft.ucbp1.features.profile.domain.model
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.cellphone
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.email
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.name
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.pathUrl
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.summary
import org.junit.Assert.*
import org.junit.Test

class ProfileModelTest {

    // -------------------------
    // Name tests
    // -------------------------
    @Test
    fun `name valid value`() {
        val n = name("Homero123")
        assertEquals("Homero123", n.value)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `name empty should fail`() {
        name("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `name too short should fail`() {
        name("Ab")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `name too long should fail`() {
        name("ThisNameIsWayTooLong")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `name with special chars should fail`() {
        name("Homer@123")
    }

    // -------------------------
    // Email tests
    // -------------------------
    @Test
    fun `email valid`() {
        val e = email("homero.simpson@mail.com")
        assertEquals("homero.simpson@mail.com", e.value)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `email empty should fail`() {
        email("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `email missing @ should fail`() {
        email("homerosimpson.mail.com")
    }

    // -------------------------
    // Cellphone tests
    // -------------------------
    @Test
    fun `cellphone valid`() {
        val c = cellphone("+1(939)5557422")
        assertEquals("+1(939)5557422", c.value)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `cellphone empty should fail`() {
        cellphone("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `cellphone too short should fail`() {
        cellphone("123456")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `cellphone too long should fail`() {
        cellphone("12345678901234567890123")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `cellphone invalid chars should fail`() {
        cellphone("123-456")
    }

    // -------------------------
    // pathUrl tests
    // -------------------------
    @Test
    fun `pathUrl valid`() {
        val p = pathUrl("https://example.com/image.png")
        assertEquals("https://example.com/image.png", p.value)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `pathUrl empty should fail`() {
        pathUrl("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `pathUrl with spaces should fail`() {
        pathUrl("https://example.com/image path.png")
    }

    // -------------------------
    // Summary tests
    // -------------------------
    @Test
    fun `summary valid`() {
        val s = summary("Ciudadano123")
        assertEquals("Ciudadano123", s.value)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `summary empty should fail`() {
        summary("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `summary with special chars other than dots should fail`() {
        summary("Ciudadano!@#")
    }
}
