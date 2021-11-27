package kz.miskarisa.b2b.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="card")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardMask;
    private String cardType;

    @OneToOne(mappedBy = "card")
    private Company company;

    @OneToOne(mappedBy = "card")
    private L_Transaction l_transactions;
}
