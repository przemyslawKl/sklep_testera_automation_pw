package pages.productDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.utils.RandomNumberOfProductsUtils;
import pages.AddToCartConfirmationModalPage;

public class AddToCartSection {


    private Locator quantityAmountInput;
    private Locator addToCartButton;
    private Page page;


    public AddToCartSection(Page page) {
        this.quantityAmountInput = page.locator("#quantity_wanted");
        this.addToCartButton = page.locator(".add-to-cart");
        this.page = page;
    }

    public AddToCartConfirmationModalPage addProductToCart() {
        this.quantityAmountInput.fill(String.valueOf(RandomNumberOfProductsUtils.getRandomNumberOfProducts()));
        this.addToCartButton.click();
        return new AddToCartConfirmationModalPage(page);
    }
}
