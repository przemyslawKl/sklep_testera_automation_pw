package tests;

import org.assertj.core.api.Assertions;
import org.example.utils.Properties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ArtPage;
import pages.HomePage;
public class FilterByCheckboxPartOnTheLeftTest extends BaseTest {

    private HomePage homePage;


    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
    }

    @Test
    void should_return_products_made_by_matt_paper_after_checking_matt_paper_checkbox() {
        ArtPage artPage = homePage.getTopMenuWithSearchSection().clickArtLink();
        artPage.getFilterBySection().clickOnMattPaperCheckbox();
        Assertions.assertThat(artPage.getFilterBySection().countAllProductsOnPage()).size().isEqualTo(3);
        //System.out.println(artPage.getArtProductSection().getProducts());
        //page.locator(".js-product").all()
    }





}
