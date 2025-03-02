import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import utils.ConfigLoader
import kotlin.test.Test


class LoginCRM {

    val BASE_URL: String = "https://kz-solva-release-300.kz.idfaws.com/secure/new-admin/index.html#/login"
//    private val BASE_URL: String = "https://kz-solva-release-slkz-91712.kz.idfaws.com/secure/new-admin/index.html#/login"

    val usernameField = "input[name='username']"
    val passwordField = "input[name='password']"
    val buttonSubmit = "button[type='submit']"
    val textTitle = `$`("h2.indexTitle")
    val textLoans = `$`("li.ng-binding")

    @BeforeEach
    fun setup() {
        Configuration.browser = "chrome"
    }

    @Test
    fun testLoginCRM() {

        open(BASE_URL)

        `$`(usernameField).setValue("admmin")
        `$`(passwordField).setValue("nimda2012")
        `$`(buttonSubmit).click()

        Assertions.assertTrue(textTitle.text().contains("Главная"), "Текст элемента не содержит 'Главная'")
    }

    @Test
    fun testOfflineAgentLoginCRM() {

        val config = ConfigLoader.loadConfig()

        open(BASE_URL)

        `$`(usernameField).setValue(config.username)
        `$`(passwordField).setValue(config.password)
        `$`(buttonSubmit).click()

        Assertions.assertTrue(textLoans.text().contains("Займы"), "Текст элемента не содержит 'Займы'")
    }

    @AfterEach
    fun tearDown() {
        closeWebDriver()
    }
}