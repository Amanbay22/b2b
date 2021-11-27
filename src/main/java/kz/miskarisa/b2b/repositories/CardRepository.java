package kz.miskarisa.b2b.repositories;

import kz.miskarisa.b2b.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Card getCardByCardMask(String cardMask);
    Card getCardById(Long id);
}
