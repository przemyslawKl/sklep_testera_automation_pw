package sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Getter
public class FilterBySection {

    private Locator leftSlider;

    private Page page;

    private Locator rightSlider;

    private Locator priceLabel;

    private Locator greyBackground;

    private Locator mattPaperCheckbox;

    private Locator activeFilterGreyLabel;

    private String correctUrlForTestOnMattPaper;
    private Predicate<Locator> waitForCondition;

    private List<Locator> products;




    public FilterBySection(Page page) {
        this.priceLabel = page.locator("#search_filters li p");
        this.leftSlider = page.locator(".ui-slider-handle").first();
        this.rightSlider = page.locator(".ui-slider-handle").last();
        this.page = page;
        this.greyBackground = page.locator(".overlay_inner");
        this.mattPaperCheckbox = page.locator("(//span[@class='custom-checkbox'])[1]");
        this.activeFilterGreyLabel = page.locator("#js-active-search-filters");
        this.correctUrlForTestOnMattPaper = "https://skleptestera.pl/index.php?id_category=9&controller=category&id_lang=2&q=Composition-Matt+paper";
        this.products = page.locator(".js-product").all();
    }

    public void waitForGreyBackgroundToHide() {
        page.waitForCondition(greyBackground::isHidden);
    }

    public List<Locator> countAllProductsOnPage(){
        return page.locator(".js-product").all();
    }

    public void waitForGreyFilterLabelToBeVisible() {
        page.waitForCondition(activeFilterGreyLabel::isVisible);
    }

    public void waitForProperURLForTestOnMattPaper(){
        page.waitForURL(correctUrlForTestOnMattPaper);
    }

    private void moveLeftSliderByMouseOnLeft(){
        double x = leftSlider.boundingBox().x;
        double y = leftSlider.boundingBox().y;

        double middleX = x + leftSlider.boundingBox().width / 2;
        double middleY = y + leftSlider.boundingBox().height / 2;

        leftSlider.scrollIntoViewIfNeeded();
        page.mouse().move(middleX, middleY);
        page.mouse().down();
        page.mouse().move(x + 14.00, y);
        page.mouse().up();
    }
/*
    public void showLeftSliderLocator(){
        System.out.println("X point of slider :" + leftSlider.boundingBox().x);
        System.out.println("Y point of slider :" + leftSlider.boundingBox().y);
        System.out.println("Width of slider :" + leftSlider.boundingBox().width);
        System.out.println("Height of slider :" + leftSlider.boundingBox().height);
    }*/  // code for now is not used anywhere (gives information about slider)

    public void filterProductsByPriceUsingMouseLeftSlider(double fromPrice){

        while (fromPrice >= getFromPrice()) {
            moveLeftSliderByMouseOnLeft();
            waitForGreyBackgroundToHide();
        }
    }

    public void filterProductsByPriceUsingKeyboardLeftSlider(double fromPrice){
        while (fromPrice >= getFromPrice()) {
            leftSlider.press("ArrowRight");
            waitForGreyBackgroundToHide();
        }
    }

    private double getFromPrice(){
    return Arrays.asList(priceLabel.innerHTML().split(" "))
            .stream()
            .map(p -> p.replaceAll("[^\\d.,]", ""))// remove any non-numeric characters except for dot and comma
            .map(p -> p.replaceAll(",", ".")) // replace comma with dot
            .map(Double::parseDouble)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Invalid price format"));
    }

        public void clickOnMattPaperCheckbox() {
            mattPaperCheckbox.click();
            waitForGreyBackgroundToHide();
            waitForGreyFilterLabelToBeVisible();
    }

}
