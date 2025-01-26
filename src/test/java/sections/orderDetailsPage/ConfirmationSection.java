package sections.orderDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.BasePage;

public class ConfirmationSection extends BasePage {

    private Locator confirmationTextBlock;
    private final String confirmationTextInPolish = "Twoje zamówienie zostało potwierdzone";
    private final String confirmationTextInEnglish = "Your order is confirmed";


    public ConfirmationSection(Page page) {
        super(page);
        this.confirmationTextBlock = page.locator(".h1.card-title");
    }
    public void waitForConfirmationSectionToBeVisible(){
        page.waitForCondition(() -> confirmationTextBlock.isVisible());
    }

    public void checkIfConfirmationSectionHasText() {
        page.waitForCondition(() -> confirmationTextBlock.textContent().contains(confirmationTextInPolish) || confirmationTextBlock.textContent().contains(confirmationTextInEnglish));
    }
}
