package tests;

import org.assertj.core.api.Assertions;
import org.example.utils.Properties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.*;
import sections.orderDetailsPage.ConfirmationSection;
import sections.orderDetailsPage.OrderAddressSection;
import sections.orderDetailsPage.PaymentChooseSection;
import sections.orderDetailsPage.ShippingMethodAndConfirmationSection;

class FullBuyAndCheckoutTest extends BaseTest {


    private HomePage homePage;
    private String testMessage = "Test message";
    private String mugProductName = "Customizable Mug";
    private String tshirtProductName = "Hummingbird Printed T-Shirt";
    private String cushionProductName = "Hummingbird Cushion";
    private String vectorGraphicProductName = "Mountain Fox - Vector Graphics";
    private String notebookProductName = "Mountain Fox Notebook";
    private String[] mugProductNameParts = mugProductName.split(" ");
    private String[] tShirtProductNameParts = tshirtProductName.split(" ");
    private String[] cushionProductNameParts = cushionProductName.split(" ");
    private String[] vectorGraphicParts = vectorGraphicProductName.split(" ");
    private String[] notebookProductNameParts = notebookProductName.split(" ");
    private String getProductNameWithSmallSecondWord(String[] productNameParts) {
        return productNameParts[0] + " " + productNameParts[1].substring(0, 1).toLowerCase() + productNameParts[1].substring(1).toLowerCase();
    }
    private String tShirtProductNameWithSmallSecondWord = getProductNameWithSmallSecondWord(tShirtProductNameParts);
    private String mugProductNameWithSmallSecondWord = getProductNameWithSmallSecondWord(mugProductNameParts);
    private String cushionProductNameWithSmallSecondWord = getProductNameWithSmallSecondWord(cushionProductNameParts);
    private String vectorGraphicWithSmallSecondWord = getProductNameWithSmallSecondWord(vectorGraphicParts);
    private String notebookProductNameWithSmallSecondWord = getProductNameWithSmallSecondWord(notebookProductNameParts);

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
    }

    private ProductDetailsPage searchingAndSelectingProduct(String productName, String productNameWithSmallSecondWord) {
        SearchResultPage searchResultPage = homePage.getTopMenuWithSearchSection().typeProductNameAndStartSearching(productName);
        Assertions.assertThat(searchResultPage.getSearchResultSection().getProductsList().get(0).textContent()).contains(productNameWithSmallSecondWord);
        ProductDetailsPage productDetailsPage = searchResultPage.getSearchResultSection().showProductDetails(productName);
        return productDetailsPage;
    }

    private void wholeProcedureOfBuyingAndCheckout(ProductDetailsPage productDetailsPage) {
        AddToCartConfirmationModalPage addToCartConfirmationModalPage = productDetailsPage.getAddToCartSection().addProductToCart();
        addToCartConfirmationModalPage.waitForBuyoutModalToBeVisible();
        CartPage cartPage = addToCartConfirmationModalPage.clickToGoToOrderRealization();
        OrderDetailsPage orderDetailsPage = cartPage.getSummarySection().clickToGoToOrderRealization();
        OrderAddressSection orderAddressSection = orderDetailsPage.getOrderPersonalInformationSection().enterPersonalInformation();
        ShippingMethodAndConfirmationSection shippingMethodAndConfirmationSection = orderAddressSection.enterAddressDetailInformation();
        shippingMethodAndConfirmationSection.chooseClickAndCollectShippingAddCommentAndClickContinueButton();
        ConfirmationSection confirmationSection = orderDetailsPage.getPaymentChooseSection().addPaymentDataAndPlaceOrder();
        confirmationSection.waitForConfirmationSectionToBeVisible();
        confirmationSection.checkIfConfirmationSectionHasText();
    }

    @Test
    void should_puchase_mug_and_checkout_with_selected_product_test() {
        ProductDetailsPage productDetailsPage = searchingAndSelectingProduct(mugProductName, mugProductNameWithSmallSecondWord);
        productDetailsPage.getProductCustomizationSection().addCustomizableTextAndSaveIt(testMessage);
        wholeProcedureOfBuyingAndCheckout(productDetailsPage);
    }

    @Test
    void should_puchase_t_shirt_and_checkout_with_selected_product_test() {
        ProductDetailsPage productDetailsPage = searchingAndSelectingProduct(tshirtProductName, tShirtProductNameWithSmallSecondWord);
        wholeProcedureOfBuyingAndCheckout(productDetailsPage);
    }

    @Test
    void should_puchase_cushion_and_checkout_with_selected_product_test() {
        ProductDetailsPage productDetailsPage = searchingAndSelectingProduct(cushionProductName, cushionProductNameWithSmallSecondWord);
        wholeProcedureOfBuyingAndCheckout(productDetailsPage);
    }

    @Test
    void should_puchase_vector_graphic_and_checkout_with_selected_product_test() {
        ProductDetailsPage productDetailsPage = searchingAndSelectingProduct(vectorGraphicProductName, vectorGraphicWithSmallSecondWord);
        wholeProcedureOfBuyingAndCheckout(productDetailsPage);
    }

    @Test
    void should_puchase_notebook_and_checkout_with_selected_product_test() {
        ProductDetailsPage productDetailsPage = searchingAndSelectingProduct(notebookProductName, notebookProductNameWithSmallSecondWord);
        wholeProcedureOfBuyingAndCheckout(productDetailsPage);
    }
}
