package tests;

import org.example.utils.Properties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
    }

    @Test
    void should_login_with_empty_credentials() {
        LoginPage loginPage = homePage.getTopNavigationSection().clickOnSignInOption();
        loginPage.loginInputSection.fillEmptyEmailAndPasswordInputAndClickSignInButton();
    }
    @Test
    void should_login_with_invalid_credentials() {
        LoginPage loginPage = homePage.getTopNavigationSection().clickOnSignInOption();
        loginPage.loginInputSection.fillWrongEmailAndPasswordInputAndClickSignInButton();
    }
}
