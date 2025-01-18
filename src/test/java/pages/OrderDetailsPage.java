package pages;

import com.microsoft.playwright.Page;
import sections.orderDetailsPage.OrderPersonalInformationSection;

public class OrderDetailsPage extends BasePage {
    private final OrderPersonalInformationSection orderPersonalInformationSection;

    public OrderDetailsPage(Page page) {
        super(page);
        this.orderPersonalInformationSection = new OrderPersonalInformationSection(page);
    }

}
