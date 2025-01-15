package sections.productDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AddToCartSection {


    private Locator quantityAmountInput;
    private Locator addToCartButton;


    public AddToCartSection(Page page) {
        this.quantityAmountInput = page.locator("#quantity_wanted");
        this.addToCartButton = page.locator(".btn btn-primary add-to-cart");
    }
}
