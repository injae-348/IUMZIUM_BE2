package test.iumzium.option.domain;

import lombok.Getter;

@Getter
public enum Size {
    TALL("TALL"),
    GRANDE("GRANDE"),
    VENTI("VENTI");

    private final String size;

    Size(String size) {
        this.size = size;
    }
}
