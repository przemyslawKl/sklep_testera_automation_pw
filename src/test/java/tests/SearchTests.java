package tests;

import org.junit.jupiter.api.Test;

public class SearchTests extends BaseTest {


    @Test
    void should_return_products_by_search_name_mug(){
        page.navigate("https://www.skleptestera.pl/");
        page.pause();

    }
}
