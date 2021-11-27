package kz.miskarisa.b2b.repositories;

import kz.miskarisa.b2b.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
