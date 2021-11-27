package kz.miskarisa.b2b.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "f_transaction")
@NoArgsConstructor
@AllArgsConstructor
public class F_Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String currency;
    private float money;
    private LocalDate dateTime;
    @ManyToOne
    private Reason reason;
    @ManyToOne
    private Status status;

    @OneToOne
    private L_Transaction l_transactions;
}
