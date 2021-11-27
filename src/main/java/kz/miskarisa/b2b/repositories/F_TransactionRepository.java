package kz.miskarisa.b2b.repositories;

import kz.miskarisa.b2b.entities.F_Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface F_TransactionRepository extends JpaRepository<F_Transaction, Long> {
    List<F_Transaction> findAllByDateTimeBetween(LocalDate start, LocalDate end);
    List<F_Transaction> findAllByCompanyIdAndCompanyRecieverId(Long id, Long id1);
}
