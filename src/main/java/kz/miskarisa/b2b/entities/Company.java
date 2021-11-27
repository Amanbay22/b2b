package kz.miskarisa.b2b.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="company")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    private String name;
    private String bin;
    private String phone;
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Employee> employees;

}
