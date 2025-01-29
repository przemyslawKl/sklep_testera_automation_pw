package sections.orderDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.BasePage;
import pages.OrderConfirmationPage;

public class PaymentChooseSection extends BasePage {

    private final String paymentChooseSection = "#checkout-payment-step ";
    private Locator payByBankWireRadioButton;
    private Locator payByCashonDeliveryRadioButton;
    private Locator payByCheckRadioButton;
    private Locator aggreToTermsOfServiceCheckbox;
    private Locator placeOrderButton;

    public PaymentChooseSection(Page page) {
        super(page);
        this.payByBankWireRadioButton = page.locator(paymentChooseSection + "#payment-option-1");
        this.payByCashonDeliveryRadioButton = page.locator(paymentChooseSection + "#payment-option-2");
        this.payByCheckRadioButton = page.locator(paymentChooseSection + "#payment-option-3");
        this.aggreToTermsOfServiceCheckbox = page.locator(paymentChooseSection + " .custom-checkbox input");
        this.placeOrderButton = page.locator(paymentChooseSection + ".btn");

    }

    public PaymentChooseSection choosePayByBankWire() {
        payByBankWireRadioButton.check();
        return this;
    }

    public PaymentChooseSection choosePayByCashOnDelivery() {
        payByCashonDeliveryRadioButton.check();
        return this;
    }

    public PaymentChooseSection choosePayByCheck() {
        payByCheckRadioButton.check();
        return this;
    }

    public PaymentChooseSection agreeToTermsOfService() {
        aggreToTermsOfServiceCheckbox.check();
        return this;
    }

    public PaymentChooseSection clickToPlaceOrder() {
        placeOrderButton.click();
        return this;
    }

    public OrderConfirmationPage addPaymentDataAndPlaceOrder(){
        choosePayByCashOnDelivery()
                .agreeToTermsOfService()
                .clickToPlaceOrder();
        return new OrderConfirmationPage(page);
    }
}
