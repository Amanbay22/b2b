package kz.miskarisa.b2b.entities;

import javax.persistence.*;

@Entity
@Table(name="permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long transactionLimit;

    @Enumerated(value = EnumType.STRING)
    private Role role;
}
