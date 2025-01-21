package sections.orderDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.utils.TestTextUtils;
import pages.BasePage;

public class ShippingMethodSection extends BasePage {

    private final String wayOfShippingSection = "#checkout-delivery-step ";
    private Locator clickAndCollectCheckbox;
    private Locator myCarrierCheckbox;
    private Locator commentInputField;
    private Locator continueButton;


    public ShippingMethodSection(Page page) {
        super(page);
        this.clickAndCollectCheckbox = page.locator(wayOfShippingSection + "#delivery_option_1");
        this.myCarrierCheckbox = page.locator(wayOfShippingSection + "#delivery_option_2");
        this.commentInputField = page.locator(wayOfShippingSection + "#delivery_message");
        this.continueButton = page.locator(wayOfShippingSection + "button[type=submit]");
    }

    private ShippingMethodSection chooseClickAndCollectShipping() {
        clickAndCollectCheckbox.check();
        return this;
    }

    private ShippingMethodSection chooseMyCarrierShipping() {
        myCarrierCheckbox.check();
        return this;
    }

    private ShippingMethodSection addComment(String comment) {
        commentInputField.fill(comment);
        return this;
    }
    private ShippingMethodSection clickContinueButton() {
        continueButton.click();
        return this;
    }

    public ShippingMethodSection chooseClickAndCollectShippingAddCommentAndClickContinueButton() {
        chooseClickAndCollectShipping()
                .addComment(TestTextUtils.createRandomText())
                .clickContinueButton();
        return this;
    }
}
