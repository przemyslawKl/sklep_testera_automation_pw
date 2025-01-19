package tests;

import org.assertj.core.api.Assertions;
import org.example.utils.Properties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.*;
import pages.shoppingCartPage.SummarySection;

class FullBuyAndCheckoutTest extends BaseTest {


    private HomePage homePage;
    private String testMessage = "Test message";
    private String productName = "Customizable Mug";
    private String[] productNameParts = productName.split(" ");
    private String productNameWithSmallSecondWord = productNameParts[0] + " " + productNameParts[1].substring(0, 1).toLowerCase() + productNameParts[1].substring(1);


    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
    }

    @Test
    void should_puchase_and_checkout_with_selected_product_test() {
        SearchResultPage searchResultPage = homePage.getTopMenuWithSearchSection().typeProductNameAndStartSearching(productName);
        Assertions.assertThat(searchResultPage.getSearchResultSection().getProductsList().get(0).textContent()).contains(productNameWithSmallSecondWord);
        ProductDetailsPage productDetailsPage = searchResultPage.getSearchResultSection().showProductDetails(productName);
        productDetailsPage.getProductCustomizationSection().addCustomizableTextAndSaveIt(testMessage);
        AddToCartConfirmationModalPage addToCartConfirmationModalPage = productDetailsPage.getAddToCartSection().addProductToCart();
        addToCartConfirmationModalPage.waitForBuyoutModalToBeVisible();
        CartPage cartPage = addToCartConfirmationModalPage.clickToGoToOrderRealization();
        OrderDetailsPage orderDetailsPage = cartPage.getSummarySection().clickToGoToOrderRealization();
        orderDetailsPage.orderPersonalInformationSection.enterPersonalInformation();
    }
}
