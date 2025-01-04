package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SearchResultPage;

public class SearchTest extends BaseTest {


    private HomePage homePage;

    @BeforeEach
    void beforeEach(){
        homePage = new HomePage(page);
    }

    @Test
    void should_return_products_by_search_name_mug() {
        page.navigate("https://www.skleptestera.pl/");
        SearchResultPage searchResultPage = homePage.getTopMenuWithSearchSection().typeProductNameAndStartSearching("mug");
        Assertions.assertThat(searchResultPage.getSearchResultSection().getProductsList().size()).isEqualTo(5);
    }

}
