package tests;

import org.assertj.core.api.Assertions;
import org.example.utils.Properties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.HomePage;
import pages.SearchResultPage;

import java.util.stream.Stream;

public class SearchTest extends BaseTest {


    private HomePage homePage;

    @BeforeEach
    void beforeEach(){
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        //homePage.getTopNavigationSection().changeLanguageToEnglish();
    }
    @DisplayName("Search for product in browser")
    @ParameterizedTest(name = "Search for {0} should return {1} times {0}")
    @MethodSource("searchData")
    void should_return_products_by_product_name(String productName, int productCounter) {
        SearchResultPage searchResultPage = homePage.getTopMenuWithSearchSection().typeProductNameAndStartSearching(productName);
        Assertions.assertThat(searchResultPage.getSearchResultSection().getProductsList().size()).isEqualTo(productCounter);
    }

    private static Stream <Arguments> searchData() {
        return Stream.of(
                Arguments.of("T-Shirt", 1),
                Arguments.of ("Mug", 5),
                Arguments.of ("Frame", 4),
                Arguments.of("Sweater", 1),
                Arguments.of("Graphics", 3),
                Arguments.of("Notebook", 3),
                Arguments.of("Cushion", 3)
        );
    }
}
