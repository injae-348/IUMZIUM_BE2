package test.iumzium.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.iumzium.menu.domain.Menu;


@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
