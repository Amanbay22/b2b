package kz.miskarisa.b2b.repositories;

import kz.miskarisa.b2b.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionsRepository extends JpaRepository<Permission, Long> {
}
