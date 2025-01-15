package sections.productDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AddToCartSection {


    private Locator quantityAmountInput;
    private Locator addToCartButton;


    public AddToCartSection(Page page) {
        this.quantityAmountInput = page.locator("#quantity_wanted");
        this.addToCartButton = page.locator(".add-to-cart");
    }

    public void addProductToCart() {
        this.quantityAmountInput.fill("2");
        this.addToCartButton.click();
    }
}
