package sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pages.LoginPage;

public class TopNavigationSection {

    private Page page;
    private Locator languageChangePlace;
    private Locator visibleEnglishOption;
    private Locator visiblePolishOption;
    private Locator checkLanguageAlreadyTurnedOn;
    private Locator languageChangePlaceInPolish;
    private Locator languageChangePlaceInEnglish;
    private Locator signInOption;

    public TopNavigationSection(Page page) {
        this.page = page;
        this.languageChangePlaceInPolish = page.getByLabel("Lista rozwijana języków");
        this.languageChangePlaceInEnglish = page.getByLabel("Language dropdown");
        this.visibleEnglishOption = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("English"));
        this.visiblePolishOption = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Polish"));
        this.checkLanguageAlreadyTurnedOn = page.locator("span[class=expand-more]");
        this.signInOption = page.locator("#_desktop_user_info .hidden-sm-down");
    }

    public void changeLanguageToEnglish() {
        if (languageChangePlaceInPolish.isVisible()) {
            languageChangePlaceInPolish.click();
            visibleEnglishOption.click();
        }
    }

    public void changeLanguageToPolish() {
        if (languageChangePlaceInEnglish.isVisible()) {
            languageChangePlaceInEnglish.click();
            visiblePolishOption.click();
        }
    }

    public LoginPage clickOnSignInOption() {
        signInOption.click();
        return new LoginPage(page);
    }
}
