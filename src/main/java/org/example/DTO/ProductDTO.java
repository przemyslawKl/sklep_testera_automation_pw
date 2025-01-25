package org.example.DTO;

import com.microsoft.playwright.Locator;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
    private String productName;
    private double productPrice;
    private Locator thumbnail;

}
