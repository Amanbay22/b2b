package kz.miskarisa.b2b.repositories;

import kz.miskarisa.b2b.entities.F_Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface F_TransactionRepository extends JpaRepository<F_Transaction, Long> {
}
