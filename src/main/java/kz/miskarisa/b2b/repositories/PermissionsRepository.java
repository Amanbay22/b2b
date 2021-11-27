package kz.miskarisa.b2b.repositories;

import kz.miskarisa.b2b.entities.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionsRepository extends JpaRepository<Long, Permissions> {
}
