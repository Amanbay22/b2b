package kz.miskarisa.b2b.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Role roleId;


}
