package sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FilterBySection {

    private Locator leftSlider;

    private Page page;

    private Locator rightSlider;

    private Locator priceLabel;

    private Locator greyBackground;


    public FilterBySection(Page page) {
        this.priceLabel = page.locator("#search_filters li p");
        this.leftSlider = page.locator(".ui-slider-handle").first();
        this.rightSlider = page.locator(".ui-slider-handle").last();
        this.page = page;
        this.greyBackground = page.locator(".overlay_inner");
    }

    public void showLeftSliderLocator(){
        System.out.println("X point of slider :" + leftSlider.boundingBox().x);
        System.out.println("Y point of slider :" + leftSlider.boundingBox().y);
        System.out.println("Width of slider :" + leftSlider.boundingBox().width);
        System.out.println("Height of slider :" + leftSlider.boundingBox().height);
    }

    public void filterProductsByPriceUsingMouseLeftSlider(double fromPrice){

        while (fromPrice >= getFromPrice()) {
            double x = leftSlider.boundingBox().x;
            double y = leftSlider.boundingBox().y;

            double middleX = x + leftSlider.boundingBox().width / 2;
            double middleY = y + leftSlider.boundingBox().height / 2;

            leftSlider.scrollIntoViewIfNeeded();
            page.mouse().move(middleX, middleY);
            page.mouse().down();
            page.mouse().move(x + 14.00, y);
            page.mouse().up();
            page.waitForCondition(greyBackground::isHidden);
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
}
