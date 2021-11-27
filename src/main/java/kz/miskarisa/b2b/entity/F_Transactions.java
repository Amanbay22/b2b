package kz.miskarisa.b2b.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "f_transactions")
@NoArgsConstructor
@AllArgsConstructor
public class F_Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String currency;
    private float money;
    private LocalDate dateTime;
    private T_Reason reason_id;
    private T_Status statud_id;
}
