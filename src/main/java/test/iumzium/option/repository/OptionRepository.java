package test.iumzium.option.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.iumzium.option.domain.Option;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
}
