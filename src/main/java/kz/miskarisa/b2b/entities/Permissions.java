package kz.miskarisa.b2b.entities;

import javax.persistence.*;

@Entity
@Table(name="permissions")
public class Permissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long transactionLimit;

    @Enumerated(value = EnumType.STRING)
    private Role role;
}
