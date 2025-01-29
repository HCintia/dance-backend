package hu.me.iit.dance.repositories;

import hu.me.iit.dance.entities.Boy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoysRepository extends JpaRepository<Boy, Long> {
}
