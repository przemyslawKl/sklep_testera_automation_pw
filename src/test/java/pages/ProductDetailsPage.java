package pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import org.example.utils.PageUtils;
import pages.productDetailsPage.AddToCartSection;
import pages.productDetailsPage.ProductCustomizationSection;
@Getter
public class ProductDetailsPage {

    private ProductCustomizationSection productCustomizationSection;
    private AddToCartSection addToCartSection;

    public ProductDetailsPage(Page page) {
        PageUtils.waitForPageToLoad(page);
        this.productCustomizationSection = new ProductCustomizationSection(page);
        this.addToCartSection = new AddToCartSection(page);
    }
}
