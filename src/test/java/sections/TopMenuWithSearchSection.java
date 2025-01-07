package sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pages.SearchResultPage;

public class TopMenuWithSearchSection {

    private Page page;
    private Locator testerShopHyperlink;
    private Locator contactUsHyperlink;
    private  Locator clothesHyperlink;
    private Locator relevantProductsHyperlink;
    private Locator artHyperlink;
    private Locator searchInputField;


    public TopMenuWithSearchSection(Page page) {
        this.page = page;
        this.searchInputField = page.locator("input[name=s]");
        this.testerShopHyperlink = page.locator("#_desktop_logo");
        this.clothesHyperlink = page.locator("#category-3");
        this.relevantProductsHyperlink = page.locator("#category-6");
        this.artHyperlink = page.locator("#category-9");
        this.contactUsHyperlink = page.locator("#contact-link");


    }

    public SearchResultPage typeProductNameAndStartSearching(String productName){
        searchInputField.pressSequentially(productName);
        searchInputField.press("Enter");
        return new SearchResultPage(page);
    }
}
