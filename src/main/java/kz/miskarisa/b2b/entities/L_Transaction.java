package kz.miskarisa.b2b.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "l_transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class L_Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="l_transaction_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToOne(mappedBy = "l_transaction")
    private F_Transaction transaction;

    @OneToOne
    @JoinColumn(name = "card_id")
    private Card card;

}
