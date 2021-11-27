package kz.miskarisa.b2b.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "l_transaction")
@NoArgsConstructor
@AllArgsConstructor
public class L_Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Employee employee;
    @OneToOne
    private F_Transaction transaction;
    @OneToOne
    private Card card;

}
