package pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import org.example.utils.PageUtils;
import pages.shoppingCartPage.SummarySection;
@Getter
public class CartPage {

    public SummarySection summarySection;


    public CartPage(Page page) {
        PageUtils.waitForPageToLoad(page);
        this.summarySection = new SummarySection(page);
    }
}


