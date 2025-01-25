package pages;

import com.microsoft.playwright.Page;
import sections.LoginInputSection;

public class LoginPage extends BasePage{

    public LoginInputSection loginInputSection;

    public LoginPage(Page page) {
        super(page);
        this.loginInputSection = new LoginInputSection(page);
    }
}
