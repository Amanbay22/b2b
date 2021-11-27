package kz.miskarisa.b2b.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="card")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long id;

    private String cardMask;
    private String cardType;
    @JsonIgnore
    private Long balance;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<L_Transaction> l_transactions;

//    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
//    private List<L_Transaction> l_transactions;
}
