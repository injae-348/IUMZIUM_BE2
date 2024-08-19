package test.iumzium.menu.dto;

import lombok.Builder;
import test.iumzium.menu.domain.Category;

@Builder
public record MenuResDto(
        String name,
        int price,
        Category category,
        String imageData
) {

    public static MenuResDto of(String name, int price, Category category, String imageData) {
        return MenuResDto.builder()
                .name(name)
                .price(price)
                .category(category)
                .imageData(imageData)
                .build();
    }
}
