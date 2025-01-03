package pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TopMenuWithSearchSection {

    private Page page;
    private Locator testerShopHyperlink;
    public Locator contactUsHyperlink;
    private  Locator clothesHyperlink;
    private Locator relevantProductsHyperlink;
    private Locator artHyperlink;
    private Locator searchInputField;
    private Locator expandableLanguageChooseList;
    private Locator logInHyperlink;
    private Locator cartHyperlink;


    public TopMenuWithSearchSection(Page page) {
        this.page = page;
        this.searchInputField = page.getByPlaceholder("Szukaj w naszym katalogu");
        this.testerShopHyperlink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sklep Testera"));
        this.clothesHyperlink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Clothes"));
        this.relevantProductsHyperlink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Produkty powiązane"));
        this.artHyperlink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Art").setExact(true));
        this.contactUsHyperlink = page.locator("#contact-link").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Kontakt z nami"));
        this.expandableLanguageChooseList = page.getByLabel("Lista rozwijana języków");
        this.logInHyperlink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Zaloguj się"));
        this.cartHyperlink = page.getByText("Koszyk");


    }

    public void typeProductNameAndStartSearching(String productName){
        searchInputField.pressSequentially(productName);
        searchInputField.press("Enter");
    }
}
