package kz.miskarisa.b2b.repositories;

import kz.miskarisa.b2b.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionsRepository extends JpaRepository<Permission, Long> {
}
