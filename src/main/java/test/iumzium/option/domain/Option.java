package test.iumzium.option.domain;

import jakarta.persistence.*;
import lombok.*;
import test.iumzium.menu.domain.Menu;

@Entity
@Getter
@Table(name = "OPTION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Option {

        @Id
        @Column(name = "option_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private int quantity;
        private boolean isHot;
        private Size size;
        private Syrup syrup;
        private int totalOptionPrice;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "menu_id")
        private Menu menu;

        public void setMenu(Menu menu) {
                this.menu = menu;
        }

        public Option update(int quantity, boolean isHot, Size size, Syrup syrup, int totalOptionPrice) {
                this.quantity = quantity;
                this.isHot = isHot;
                this.size = size;
                this.syrup = syrup;
                this.totalOptionPrice = totalOptionPrice;
                return this;
        }
}
