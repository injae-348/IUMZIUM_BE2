package test.iumzium.menu.domain;


import jakarta.persistence.*;
import lombok.*;
import test.iumzium.option.domain.Option;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "MENU")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Menu {

    @Id
    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int price;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String imageName;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Option> options = new ArrayList<>();

    // Option 추가 메소드
    public void addOption(Option option) {
        options.add(option);
        option.setMenu(this);
    }

    // Option 제거 메소드
    public void removeOption(Option option) {
        options.remove(option);
        option.setMenu(null);
    }
}
