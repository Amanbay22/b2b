package kz.miskarisa.b2b.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Employee employee;

    @OneToOne
    @JoinColumn(name="f_transaction_id")
    @JsonIgnore
    private F_Transaction f_transaction;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

//    @ManyToOne
//    @JoinColumn(name = "card_id")
//    private Card card;
}
