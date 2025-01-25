package sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import org.example.utils.EmailUtils;
import org.example.utils.PasswordUtils;

@Getter
public class LoginInputSection {

    private Locator emailInputField;
    private Locator passwordInputField;
    private Locator signInButton;
    private Locator errorMessage;
    private final String emptyEmailInputText = " ";
    private final String emptyPasswordInputText = " ";

    public LoginInputSection(Page page) {
        this.emailInputField = page.locator("div #field-email");
        this.passwordInputField = page.locator("div #field-password");
        this.signInButton = page.locator("div #submit-login");
        this.errorMessage = page.locator("alert alert-danger");
    }

    private LoginInputSection fillEmptyEmailInput(){
        emailInputField.fill(emptyEmailInputText);
        return this;
    }
    private LoginInputSection fillEmptyPasswordInput(){
        passwordInputField.fill(emptyPasswordInputText);
        return this;
    }

    private LoginInputSection fillWrongEmailInput(){
        emailInputField.fill(EmailUtils.getRandomEmail());
        return this;
    }
    private LoginInputSection fillWrongPasswordInput(){
        passwordInputField.fill(PasswordUtils.createRandomPassword());
        return this;
    }

    private LoginInputSection clickSignInButton(){
        signInButton.click();
        return this;
    }

    private LoginInputSection checkErrorMessage(){
        errorMessage.isVisible();
        return this;
    }

    public void fillEmptyEmailAndPasswordInputAndClickSignInButton(){
        fillEmptyEmailInput()
                .fillEmptyPasswordInput()
                .clickSignInButton()
                .checkErrorMessage();
    }

    public void fillWrongEmailAndPasswordInputAndClickSignInButton(){
        fillWrongEmailInput()
                .fillWrongPasswordInput()
                .clickSignInButton()
                .checkErrorMessage();
    }
}
