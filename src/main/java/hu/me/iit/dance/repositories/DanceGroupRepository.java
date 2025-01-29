package hu.me.iit.dance.repositories;

import hu.me.iit.dance.entities.DanceGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DanceGroupRepository extends JpaRepository<DanceGroup, Long> {
}
