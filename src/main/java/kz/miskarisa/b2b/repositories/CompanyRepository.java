package kz.miskarisa.b2b.repositories;

import kz.miskarisa.b2b.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findDistinctById(Long id);
}
