package sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import org.example.DTO.ProductDTO;
import org.example.utils.StringUtils;
import pages.ProductDetailsPage;

import java.util.List;
import java.util.stream.Collectors;
public class SearchResultSection {

    @Getter
    private List<Locator> productsList;
    private Page page;

    public SearchResultSection(Page page){
        this.page = page;
        this.productsList = page.locator(".js-product").all();
    }

    public ProductDetailsPage showProductDetails(String productName){
        ProductDTO productDTO = changeProductDetailsToDTO().stream()
                .filter(p -> p.getProductName().equals(productName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found: " + productName));

        productDTO.getThumbnail().click();

        return new ProductDetailsPage(page);
    }

    public List<ProductDTO> changeProductDetailsToDTO() {
        return productsList.stream()
                .map(p -> ProductDTO.builder()
                        .thumbnail(p.locator(".thumbnail-top"))
                        .productName(p.locator(".product-title").innerText())
                        .productPrice(Double.parseDouble(p.locator(".price").innerText().replaceAll("[^\\d.,]", "").replaceAll(",", ".")))
                        .build())
                .collect(Collectors.toList());
    }
}
