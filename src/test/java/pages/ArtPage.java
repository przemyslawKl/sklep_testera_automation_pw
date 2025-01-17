package pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import sections.ArtProductSection;
import sections.FilterBySection;

@Getter
public class ArtPage extends BasePage {
    private ArtProductSection artProductSection;
    private FilterBySection filterBySection;
    public ArtPage(Page page) {
        super(page);
        this.artProductSection = new ArtProductSection(page);
        this.filterBySection = new FilterBySection(page);
    }
}