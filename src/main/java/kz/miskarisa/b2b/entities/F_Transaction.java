package kz.miskarisa.b2b.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "f_transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class F_Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="f_transaction_id")
    private Long id;

    private String description;
    private String currency;
    private float money;
    private LocalDate dateTime;
    @ManyToOne
    @JoinColumn(name="reason_id")
    private Reason reason;
    @ManyToOne
    @JoinColumn(name="status_id")
    private Status status;

    private Long companyId;
    private Long companyRecieverId;

    @OneToOne(mappedBy = "f_transaction", cascade = CascadeType.ALL)
    private L_Transaction l_transaction;

}
