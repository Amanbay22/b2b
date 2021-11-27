package kz.miskarisa.b2b.repositories;

import kz.miskarisa.b2b.entities.Reason;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReasonRepository extends JpaRepository<Long, Reason> {
}
