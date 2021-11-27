package kz.miskarisa.b2b.repositories;

import kz.miskarisa.b2b.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Long, Company> {
}
