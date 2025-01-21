package pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import org.example.utils.PageUtils;
import org.junit.jupiter.api.Order;
import sections.orderDetailsPage.OrderAddressSection;
import sections.orderDetailsPage.OrderPersonalInformationSection;
import sections.orderDetailsPage.ShippingMethodSection;

@Getter
public class OrderDetailsPage extends BasePage {
    private OrderPersonalInformationSection orderPersonalInformationSection;
    private OrderAddressSection orderAddressSection;
    private ShippingMethodSection shippingMethodSection;

    public OrderDetailsPage(Page page) {
        super(page);
        PageUtils.waitForPageToLoad(page);
        this.orderPersonalInformationSection = new OrderPersonalInformationSection(page);
        this.orderAddressSection = new OrderAddressSection(page);
        this.shippingMethodSection = new ShippingMethodSection(page);
    }

}
