package tests;

import org.assertj.core.api.Assertions;
import org.example.utils.Properties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SearchResultPage;

class FullBuyAndCheckoutTest extends BaseTest {


    HomePage homePage;

    String productName = "Customizable mug";


    @BeforeEach
    void beforeEach(){
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
    }

    @Test
    void should_puchase_and_checkout_with_selected_product_test(){
        SearchResultPage customizableMug = homePage.getTopMenuWithSearchSection().typeProductNameAndStartSearching(productName);
        Assertions.assertThat(customizableMug.getSearchResultSection().getProductsList().get(0).textContent()).contains(productName);
    }
}
