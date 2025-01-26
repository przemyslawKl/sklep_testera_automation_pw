package pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import sections.ArtProductSection;
import sections.FilterBySection;
import sections.SearchResultSection;

import static org.example.utils.PageUtils.waitForPageToLoad;

public class SearchResultPage {
    @Getter
    private SearchResultSection searchResultSection;

    public SearchResultPage(Page page) {
        waitForPageToLoad(page);
        this.searchResultSection = new SearchResultSection(page);

    }
}
