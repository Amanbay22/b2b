package kz.miskarisa.b2b.repositories;

import kz.miskarisa.b2b.entities.Reason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReasonRepository extends JpaRepository<Reason, Long> {
}
