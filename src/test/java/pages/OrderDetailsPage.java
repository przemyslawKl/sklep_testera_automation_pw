package pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import org.example.utils.PageUtils;
import sections.orderDetailsPage.*;

@Getter
public class OrderDetailsPage extends BasePage {
    private OrderPersonalInformationSection orderPersonalInformationSection;
    private OrderAddressSection orderAddressSection;
    private ShippingMethodAndConfirmationSection shippingMethodAndConfirmationSection;
    private PaymentChooseSection paymentChooseSection;
    private ConfirmationSection confirmationSection;

    public OrderDetailsPage(Page page) {
        super(page);
        PageUtils.waitForPageToLoad(page);
        this.orderPersonalInformationSection = new OrderPersonalInformationSection(page);
        this.orderAddressSection = new OrderAddressSection(page);
        this.shippingMethodAndConfirmationSection = new ShippingMethodAndConfirmationSection(page);
        this.paymentChooseSection = new PaymentChooseSection(page);
        this.confirmationSection = new ConfirmationSection(page);
    }

}
