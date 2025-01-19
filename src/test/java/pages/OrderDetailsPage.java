package pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import org.example.utils.PageUtils;
import sections.orderDetailsPage.OrderPersonalInformationSection;
@Getter
public class OrderDetailsPage extends BasePage {
    private OrderPersonalInformationSection orderPersonalInformationSection;

    public OrderDetailsPage(Page page) {
        super(page);
        PageUtils.waitForPageToLoad(page);
        this.orderPersonalInformationSection = new OrderPersonalInformationSection(page);
    }

}
