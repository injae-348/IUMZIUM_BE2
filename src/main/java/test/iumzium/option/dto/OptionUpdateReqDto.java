package test.iumzium.option.dto;

import org.antlr.v4.runtime.misc.NotNull;
import test.iumzium.option.domain.Size;
import test.iumzium.option.domain.Syrup;

public record OptionUpdateReqDto(
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


}
