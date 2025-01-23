package sections.orderDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.assertj.core.api.Assertions;
import org.example.utils.TestTextUtils;
import pages.BasePage;

public class ShippingMethodAndConfirmationSection extends BasePage {

    private final String wayOfShippingSection = "#checkout-delivery-step ";
    private Locator clickAndCollectCheckbox;
    private Locator myCarrierCheckbox;
    private Locator commentInputField;
    private Locator continueButton;
    private Locator confirmationText;


    public ShippingMethodAndConfirmationSection(Page page) {
        super(page);
        this.clickAndCollectCheckbox = page.locator(wayOfShippingSection + "#delivery_option_1");
        this.myCarrierCheckbox = page.locator(wayOfShippingSection + "#delivery_option_2");
        this.commentInputField = page.locator(wayOfShippingSection + "#delivery_message");
        this.continueButton = page.locator(wayOfShippingSection + "button[type=submit]");
    }

    private ShippingMethodAndConfirmationSection chooseClickAndCollectShipping() {
        clickAndCollectCheckbox.check();
        return this;
    }

    private ShippingMethodAndConfirmationSection chooseMyCarrierShipping() {
        myCarrierCheckbox.check();
        return this;
    }

    private ShippingMethodAndConfirmationSection addComment(String comment) {
        commentInputField.fill(comment);
        return this;
    }
    private ShippingMethodAndConfirmationSection clickContinueButton() {
        continueButton.click();
        return this;
    }


    public PaymentChooseSection chooseClickAndCollectShippingAddCommentAndClickContinueButton() {
        chooseClickAndCollectShipping()
                .addComment(TestTextUtils.createRandomText())
                .clickContinueButton();
        return new PaymentChooseSection(page);
    }
}
