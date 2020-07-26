package io.naimi.bank.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ACCOUNT_TYPE",
        discriminatorType= DiscriminatorType.STRING,length = 2)
@Entity
@Table(name = "accounts")
public abstract class Account implements Serializable {
    @Id
    private String accountCode;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    private double balance;
    @ManyToOne
    @JoinColumn(name = "CLIENT_CODE")
    private Client client;
    @OneToMany(mappedBy = "account")
    private Collection<Operation> operations;
}
