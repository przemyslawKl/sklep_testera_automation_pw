package pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import sections.SearchResultSection;

public class SearchResultPage {
    @Getter
    private SearchResultSection searchResultSection;

    public SearchResultPage(Page page) {
        this.searchResultSection = new SearchResultSection(page);
    }
}
