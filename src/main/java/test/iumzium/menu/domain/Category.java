package test.iumzium.menu.domain;

import lombok.Getter;

@Getter
public enum Category {
    커피("커피"),
    차("차"),
    에이드("에이드");

    private final String category;

    Category(String category) {
        this.category = category;
    }
}
