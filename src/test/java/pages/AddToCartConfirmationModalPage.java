package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.utils.PageUtils;

public class AddToCartConfirmationModalPage {

    private Locator addToCartConfirmationMessage;
    private Locator goToOrderRealization;
    private Page page;


    public AddToCartConfirmationModalPage(Page page){
        PageUtils.waitForPageToLoad(page);
        this.addToCartConfirmationMessage = page.locator("#myModalLabel");
        this.goToOrderRealization = page.locator("div[class='cart-content-btn'] a[class='btn btn-primary']");
        this.page = page;
    }

    public String getConfirmationMessage(){
       return addToCartConfirmationMessage.innerText();
    }

    public CartPage clickToGoToOrderRealization(){
        goToOrderRealization.click();
        return new CartPage(page);
    }


    public void waitForBuyoutModalToBeVisible(){
        page.waitForCondition(() -> addToCartConfirmationMessage.isVisible());}
}
