package pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import sections.ArtProductSection;

@Getter
public class ArtPage {


    private ArtProductSection artProductSection;
    public ArtPage(Page page) {
        this.artProductSection = new ArtProductSection(page);
    }
}
