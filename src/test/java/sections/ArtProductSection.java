package sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ArtProductSection {

    private Page page;

    private List<Locator> products;

    public ArtProductSection(Page page) {
        this.page = page;
        this.products = page.locator(".js-product").all();
    }

    private List<String> getProductsPrices() {
        return page.locator(".js-product .price").allInnerTexts();
    }

    public List<Double> getProductsPricesAsDoubles(){
        return getProductsPrices()
                .stream()
                .map(p -> p.replaceAll("[^\\d.,]", "")) // remove any non-numeric characters except for dot and comma
                .map(p -> p.replaceAll(",", ".")) // replace comma with dot
                .map(Double::parseDouble)
                .collect(Collectors.toList())
    }
}