package test.iumzium.option.dto;

import lombok.Builder;
import org.antlr.v4.runtime.misc.NotNull;
import test.iumzium.menu.domain.Menu;
import test.iumzium.option.domain.Option;
import test.iumzium.option.domain.Size;
import test.iumzium.option.domain.Syrup;

@Builder
public record OptionReqDto(
        @NotNull
        boolean isHot, // True: Hot, False: Ice

        @NotNull
        Size size,

        @NotNull
        Syrup syrup,

        @NotNull
        int quantity,

        @NotNull
        int totalOptionPrice
) {
    public Option toEntity(Menu menu) {
        return Option.builder()
                .menu(menu)
                .isHot(isHot)
                .size(size)
                .syrup(syrup)
                .quantity(quantity)
                .totalOptionPrice(totalOptionPrice)
                .build();
    }
}
