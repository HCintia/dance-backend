package hu.me.iit.dance.repositories;

import hu.me.iit.dance.entities.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GirlsRepository extends JpaRepository<Girl, Long> {
}
