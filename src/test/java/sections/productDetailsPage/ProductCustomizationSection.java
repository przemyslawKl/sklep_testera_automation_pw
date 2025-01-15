package sections.productDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductCustomizationSection {


    private Page page;
    private Locator placeHolder;
    private Locator submitCustomizableData;
    private Locator customizationMessage;

    public ProductCustomizationSection(Page page) {
        this.placeHolder = page.locator("#field-textField1");
        this.submitCustomizableData = page.locator("button[@name='submitCustomizedData']");
        this.customizationMessage = page.locator(".customization-message");
    }

    public void addCustomizableTextAndSaveIt(String text) {
        placeHolder.fill(text);
        submitCustomizableData.click();
        page.waitForCondition(() -> customizationMessage.isVisible());
    }

}
