package sections.orderDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import org.example.utils.DateUtils;
import org.example.utils.EmailUtils;
import org.example.utils.FirstAndLastNameUtils;
import org.example.utils.PageUtils;
import pages.BasePage;
@Getter
public class OrderPersonalInformationSection extends BasePage {

    private final String personalInfoSection = "#checkout-personal-information-step ";
    private final String customerForm = personalInfoSection + "#customer-form ";
    private Locator orderAsGuestChoose;
    private Locator orderAsALoginUserChoose;
    private Locator socialTitleMr;
    private Locator socialTitleMrs;
    private Locator firstName;
    private Locator lastName;
    private Locator email;
    private Locator password;
    private Locator birthDate;
    private Locator recieveOfferFromPartnersCheckbox;
    private Locator termsAndConditionsCheckbox;
    private Locator newsletterCheckbox;
    private Locator customerDataPrivacyCheckbox;
    private Locator continueButton;

    public OrderPersonalInformationSection(Page page) {
        super(page);
        this.orderAsGuestChoose = page.locator(".nav-link[data-toggle='tab'][href='#checkout-guest-form']");
        this.orderAsALoginUserChoose = page.locator(".nav-link[data-link-action='show-login-form']");
        this.socialTitleMr = page.locator(customerForm + "#field-id_gender-1");
        this.socialTitleMrs = page.locator(customerForm + "#field-id_gender-2");
        this.firstName = page.locator(customerForm + "#field-firstname");
        this.lastName = page.locator(customerForm + "#field-lastname");
        this.email = page.locator(customerForm + "#field-email");
        this.password = page.locator(customerForm + "#field-password");
        this.birthDate = page.locator(customerForm + "#field-birthday");
        this.recieveOfferFromPartnersCheckbox = page.locator("//div[7]//div[1]//span[1]//label[1]");
        this.termsAndConditionsCheckbox = page.locator("//div[8]//div[1]//span[1]//label[1]");
        this.newsletterCheckbox = page.locator("//div[9]//div[1]//span[1]//label[1]");
        this.customerDataPrivacyCheckbox = page.locator("//div[10]//div[1]//span[1]//label[1]");
        this.continueButton = page.locator(customerForm + "button[name=continue]");
    }

    public OrderAddressSection enterPersonalInformation(){
        checkSocialTitleMr()
                .enterFirstName(FirstAndLastNameUtils.getFirstName())
                .enterLastName(FirstAndLastNameUtils.getLastName())
                .enterBirthDate(DateUtils.getRandomDate())
                .enterEmail(EmailUtils.getRandomEmail())
                .clickRecieveOfferFromPartnersCheckbox()
                .clickTermsAndConditionsCheckbox()
                .clickNewsletterCheckbox()
                .clickCustomerDataPrivacyCheckbox()
                .clickContinueButton();
                PageUtils.waitForPageToLoad(page);
                return new OrderAddressSection(page);
    }

    private OrderPersonalInformationSection clickToOrderAsGuest() {
        orderAsGuestChoose.click();
        return this;
    }

    private OrderPersonalInformationSection clickToOrderAsALoginUser() {
        orderAsALoginUserChoose.click();
        return this;
    }

    private OrderPersonalInformationSection checkSocialTitleMr() {
        socialTitleMr.check();
        return this;
    }

    private OrderPersonalInformationSection checkSocialTitleMrs() {
        socialTitleMrs.check();
        return this;
    }

    private OrderPersonalInformationSection enterFirstName(String firstName) {
        this.firstName.fill(firstName);
        return this;
    }

    private OrderPersonalInformationSection enterLastName(String lastName) {
        this.lastName.fill(lastName);
        return this;
    }

    private OrderPersonalInformationSection enterEmail(String email) {
        this.email.fill(email);
        return this;
    }

    private OrderPersonalInformationSection enterPassword(String password) {
        this.password.fill(password);
        return this;
    }

    private OrderPersonalInformationSection enterBirthDate(String birthDate) {
        this.birthDate.fill(birthDate);
        return this;
    }

    private OrderPersonalInformationSection clickRecieveOfferFromPartnersCheckbox() {
        recieveOfferFromPartnersCheckbox.check();
        return this;
    }

    private OrderPersonalInformationSection clickTermsAndConditionsCheckbox() {
        termsAndConditionsCheckbox.check();
        return this;
    }

    private OrderPersonalInformationSection clickNewsletterCheckbox() {
        newsletterCheckbox.check();
        return this;
    }

    private OrderPersonalInformationSection clickCustomerDataPrivacyCheckbox() {
        customerDataPrivacyCheckbox.check();
        return this;
    }

    private OrderPersonalInformationSection clickContinueButton() {
        continueButton.click();
        return this;
    }
}
