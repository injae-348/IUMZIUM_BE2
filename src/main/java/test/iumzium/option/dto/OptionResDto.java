package test.iumzium.option.dto;

import lombok.Builder;

@Builder
public record OptionResDto(
        boolean isHot, // True: Hot, False: Ice
        String size,
        String syrup,
        int quantity,
        int totalOptionPrice
) {
}
