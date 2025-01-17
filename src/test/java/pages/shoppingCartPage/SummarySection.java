package pages.shoppingCartPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pages.CartPage;

public class SummarySection {

    private Locator goToOrderRealzationButton;
    private Page page;

    public SummarySection(Page page) {
        this.page = page;
        this.goToOrderRealzationButton = page.locator("body > main:nth-child(1) > section:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > section:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > a:nth-child(1)");
    }

    public CartPage clickToGoToOrderRealization() {
        goToOrderRealzationButton.click();
        return new CartPage(page);
    }
}
