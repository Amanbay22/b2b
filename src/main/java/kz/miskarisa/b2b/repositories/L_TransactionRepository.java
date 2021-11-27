package kz.miskarisa.b2b.repositories;

import kz.miskarisa.b2b.entities.F_Transaction;
import kz.miskarisa.b2b.entities.L_Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface L_TransactionRepository extends JpaRepository<L_Transaction, Long> {
}
