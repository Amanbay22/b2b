package kz.miskarisa.b2b.repositories;

import kz.miskarisa.b2b.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Long, Status> {
}
