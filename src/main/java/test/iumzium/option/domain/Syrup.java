package test.iumzium.option.domain;

import lombok.Getter;

@Getter
public enum Syrup {
    헤이즐넛("헤이즐넛"),
    바닐라("바닐라"),
    없음("없음");

    private final String syrup;

    Syrup(String syrup) {
        this.syrup = syrup;
    }
}
