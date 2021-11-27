package kz.miskarisa.b2b.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "l_transactions")
@NoArgsConstructor
@AllArgsConstructor
public class L_Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Employees employee_id;
    private F_Transactions transaction_id;
    private Card card_id;

}
