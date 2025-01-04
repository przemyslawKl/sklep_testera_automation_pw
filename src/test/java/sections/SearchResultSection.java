package sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

import java.util.List;

public class SearchResultSection {

    @Getter
    private List<Locator> productsList;

    public SearchResultSection(Page page){
        productsList = page.locator(".js-product").all();
    }
}
