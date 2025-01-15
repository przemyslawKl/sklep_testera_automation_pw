package pages;

import com.microsoft.playwright.Page;
import sections.productDetailsPage.ProductCustomizationSection;

public class ProductDetailsPage {

    private ProductCustomizationSection productCustomizationSection;

    private ProductDetailsPage(Page page) {
        this.productCustomizationSection = new ProductCustomizationSection(page);
    }
}
