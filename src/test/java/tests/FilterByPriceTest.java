package tests;

import org.example.utils.Properties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ArtPage;
import pages.HomePage;

class FilterByPriceTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
    }

    @Test
    void should_return_products_with_price_greater_than_40() {
        ArtPage artPage = homePage.getTopMenuWithSearchSection().clickArtLink();
        System.out.println(artPage.getArtProductSection().getProductsPricesAsDoubles());
        String newPageUrl = page.url() + "&q=Price-zł-40-44";
        page.navigate(newPageUrl);
        System.out.println(artPage.getArtProductSection().getProductsPricesAsDoubles());
        page.waitForTimeout(5000);



    }
}
