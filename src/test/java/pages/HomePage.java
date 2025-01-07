package pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import sections.TopMenuWithSearchSection;
import sections.TopNavigationSection;

@Getter
public class HomePage {

    protected Page page;
    private TopMenuWithSearchSection topMenuWithSearchSection;
    private TopNavigationSection topNavigationSection;

    public HomePage (Page page){
        this.page = page;
        this.topMenuWithSearchSection = new TopMenuWithSearchSection(page);
        this.topNavigationSection = new TopNavigationSection(page);
    }

}
