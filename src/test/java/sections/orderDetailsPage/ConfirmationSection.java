package sections.orderDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.assertj.core.api.Assertions;
import pages.BasePage;

public class ConfirmationSection extends BasePage {

    private Locator confirmationTextBlock;
    private final String confirmationSection = "#content-hook_order_confirmation ";
    private final String confirmationTextInPolish = "Twoje zamówienie zostało potwierdzone";
    private final String confirmationTextInEnglish = "Your order is confirmed";


    public ConfirmationSection(Page page) {
        super(page);
        this.confirmationTextBlock = page.locator(confirmationSection + ".card-title");
    }

    public String getConfirmationMessage(){
        return confirmationTextBlock.innerText();
    }

    public ConfirmationSection  waitForConfirmationSectionToBeVisible(){
        page.waitForCondition(() -> confirmationTextBlock.isVisible());
        return this;
    }

    public ConfirmationSection checkIfConfirmationMessageHasProperText(){
        String confirmationMessage = getConfirmationMessage().toLowerCase();
        Assertions.assertThat((confirmationMessage.contains(confirmationTextInPolish.toLowerCase()) || confirmationMessage.contains(confirmationTextInEnglish.toLowerCase())));
        return this;
    }
}
