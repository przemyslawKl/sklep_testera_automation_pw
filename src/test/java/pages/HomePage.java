package pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import sections.TopMenuWithSearchSection;

public class HomePage {

    private Page page;
    @Getter
    private TopMenuWithSearchSection topMenuWithSearchSection;

    public HomePage (Page page){
        this.page = page;
        this.topMenuWithSearchSection = new TopMenuWithSearchSection(page);
    }

}
