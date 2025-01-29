package pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import sections.orderDetailsPage.ConfirmationSection;

@Getter
public class OrderConfirmationPage extends BasePage{

    private ConfirmationSection confirmationSection;
    public OrderConfirmationPage(Page page) {
        super(page);
        this.confirmationSection = new ConfirmationSection(page);
    }
}
