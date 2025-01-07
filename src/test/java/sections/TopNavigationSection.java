package sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TopNavigationSection {

    private Page page;
    private Locator languageChangePlace;
    private Locator visibleEnglishOption;
    private Locator visiblePolishOption;
    private Locator checkLanguageAlreadyTurnedOn;
    private Locator languageChangePlaceInPolish;
    private Locator languageChangePlaceInEnglish;

    public TopNavigationSection(Page page) {
        this.page = page;
        this.languageChangePlaceInPolish = page.getByLabel("Lista rozwijana języków");
        this.languageChangePlaceInEnglish = page.getByLabel("Language dropdown");
        this.visibleEnglishOption = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("English"));
        this.visiblePolishOption = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Polish"));
        this.checkLanguageAlreadyTurnedOn = page.locator("span[class=expand-more]");
    }

    public void changeLanguageToEnglish() {
        if (languageChangePlaceInPolish.isVisible()){
            languageChangePlaceInPolish.click();
            visibleEnglishOption.click();
        }
    }
    }


   // page.getByLabel("Lista rozwijana języków").click();
        //    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("English")).click();