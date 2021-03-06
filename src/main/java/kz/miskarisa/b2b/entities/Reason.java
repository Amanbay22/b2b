package kz.miskarisa.b2b.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_reason")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reason_id")
    private Long id;

    @OneToMany(mappedBy = "reason", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<F_Transaction> f_transactions;

    private String description;
    private String name;
}
