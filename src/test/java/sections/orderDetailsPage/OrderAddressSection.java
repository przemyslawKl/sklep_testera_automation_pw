package sections.orderDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import org.example.utils.AddressDetailsUtils;
import org.example.utils.FirstAndLastNameUtils;
import org.example.utils.PageUtils;
import pages.BasePage;

@Getter
public class OrderAddressSection extends BasePage {

    private final String addressesForm = "#checkout-addresses-step ";
    private Locator firstNameInput;
    private Locator lastNameInput;
    private Locator companyInput;
    private Locator vatNumberInput;
    private Locator addressInput;
    private Locator addressComplementInput;
    private Locator zipPostalCodeInput;
    private Locator cityInput;
    private Locator countryExpandedList;
    private Locator phoneNumberInput;
    private Locator useAddressForInvoiceCheckbox;
    private Locator continueButton;


    public OrderAddressSection(Page page) {
        super(page);
        this.firstNameInput = page.locator(addressesForm + "#field-firstname");
        this.lastNameInput = page.locator(addressesForm + "#field-lastname");
        this.companyInput = page.locator(addressesForm + "#field-company");
        this.vatNumberInput = page.locator(addressesForm + "#field-vat_number");
        this.addressInput = page.locator(addressesForm + "#field-address1");
        this.addressComplementInput = page.locator(addressesForm + "#field-address2");
        this.zipPostalCodeInput = page.locator(addressesForm + "#field-postcode");
        this.cityInput = page.locator(addressesForm + "#field-city");
        this.countryExpandedList = page.locator(addressesForm + "#field-id_country");
        this.phoneNumberInput = page.locator(addressesForm + "#field-phone");
        this.useAddressForInvoiceCheckbox = page.locator(addressesForm + "#use_same_address");
        this.continueButton = page.locator(addressesForm + "button[name=confirm-addresses]");
        PageUtils.waitForPageToLoad(page);
    }

    private OrderAddressSection fillFirstName(String firstName) {
        firstNameInput.fill(firstName);
        return this;
    }

    private OrderAddressSection fillLastName(String lastName) {
        lastNameInput.fill(lastName);
        return this;
    }

    private OrderAddressSection fillCompany(String company) {
        companyInput.fill(company);
        return this;
    }

    private OrderAddressSection fillVatNumber(Long vatNumber) {
        vatNumberInput.fill(String.valueOf(vatNumber));
        return this;
    }

    private OrderAddressSection fillAddress(String address) {
        addressInput.fill(address);
        return this;
    }

    private OrderAddressSection fillAddressComplement(String addressComplement) {
        addressComplementInput.fill(addressComplement);
        return this;
    }

    private OrderAddressSection fillZipPostalCode(String zipPostalCode) {
        zipPostalCodeInput.fill(zipPostalCode);
        return this;
    }

    private OrderAddressSection fillCity(String city) {
        cityInput.fill(city);
        return this;
    }

    private OrderAddressSection chooseCountryFromList(Integer country) {
        countryExpandedList.selectOption(String.valueOf(country));
        return this;
    }

    private OrderAddressSection fillPhoneNumber(Long randomPhoneNumber) {
        phoneNumberInput.fill(String.valueOf(randomPhoneNumber));
        return this;
    }

    private OrderAddressSection checkUseAddressForInvoice() {
        useAddressForInvoiceCheckbox.check();
        return this;
    }

    private OrderAddressSection clickContinueButton() {
        continueButton.click();
        return this;
    }

    public ShippingMethodSection enterAddressDetailInformation(){
        fillFirstName(FirstAndLastNameUtils.getFirstName())
                .fillLastName(FirstAndLastNameUtils.getLastName())
                .fillCompany(AddressDetailsUtils.getRandomCompanyName())
                .fillVatNumber(AddressDetailsUtils.getRandomVatNumber())
                .fillAddress(AddressDetailsUtils.getRandomAddress())
                .fillAddressComplement(AddressDetailsUtils.getRandomAddress())
                .fillZipPostalCode(AddressDetailsUtils.getRandomPostalCode())
                .fillCity(AddressDetailsUtils.getRandomCity())
                .fillPhoneNumber(AddressDetailsUtils.getRandomPhoneNumber())
                .checkUseAddressForInvoice()
                .clickContinueButton();
        return new ShippingMethodSection(page);
    }

}
