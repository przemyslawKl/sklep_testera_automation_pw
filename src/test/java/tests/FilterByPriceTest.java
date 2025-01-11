package tests;

import lombok.Value;
import org.assertj.core.api.Assertions;
import org.example.utils.Properties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ArtPage;
import pages.HomePage;

class FilterByPriceTest extends BaseTest {

    private HomePage homePage;

    private double fromPrice = 40.00;

    private int fromPriceInInt = (int) fromPrice;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
    }

    @Test
    void should_return_products_with_price_greater_than_40_url() {
        ArtPage artPage = homePage.getTopMenuWithSearchSection().clickArtLink();
        String newUrl = page.url() + "&q=Cena-zł-40-44";
        page.navigate(newUrl);
        Assertions.assertThat(artPage.getArtProductSection().getProductsPricesAsDoubles().stream().allMatch(p -> p > fromPriceInInt)).isTrue();
    }
    @Test
    void should_return_products_with_price_greater_than_40_mouse_movement() {
        ArtPage artPage = homePage.getTopMenuWithSearchSection().clickArtLink();
        artPage.getFilterBySection().filterProductsByPriceUsingMouseLeftSlider(fromPrice);
        Assertions.assertThat(artPage.getArtProductSection().getProductsPricesAsDoubles().stream().allMatch(p -> p > fromPriceInInt)).isTrue();
    }
    @Test
    void should_return_products_with_price_greater_than_40_keyboard_movement() {
        ArtPage artPage = homePage.getTopMenuWithSearchSection().clickArtLink();
        artPage.getFilterBySection().filterProductsByPriceUsingKeyboardLeftSlider(fromPrice);
        Assertions.assertThat(artPage.getArtProductSection().getProductsPricesAsDoubles().stream().allMatch(p -> p > fromPriceInInt)).isTrue();
    }

}
