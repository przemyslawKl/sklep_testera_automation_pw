package pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import org.example.utils.PageUtils;
import org.junit.jupiter.api.Order;
import sections.orderDetailsPage.OrderAddressSection;
import sections.orderDetailsPage.OrderPersonalInformationSection;
@Getter
public class OrderDetailsPage extends BasePage {
    private OrderPersonalInformationSection orderPersonalInformationSection;
    private OrderAddressSection orderAddressSection;

    public OrderDetailsPage(Page page) {
        super(page);
        PageUtils.waitForPageToLoad(page);
        this.orderPersonalInformationSection = new OrderPersonalInformationSection(page);
        this.orderAddressSection = new OrderAddressSection(page);
    }

}
