package pages;

import com.microsoft.playwright.Page;
import org.example.utils.PageUtils;
import sections.orderDetailsPage.OrderPersonalInformationSection;

public class OrderDetailsPage extends BasePage {
    public OrderPersonalInformationSection orderPersonalInformationSection;

    public OrderDetailsPage(Page page) {
        super(page);
        PageUtils.waitForPageToLoad(page);
        this.orderPersonalInformationSection = new OrderPersonalInformationSection(page);
    }

}
