package io.naimi.bank.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "OP_TYPE",
        discriminatorType = DiscriminatorType.STRING,length = 1)
public abstract class Operation implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operationNumber;
    private Date operationDate;
    private double operationAmount;
    @ManyToOne
    @JoinColumn(name = "ACCOUNT_CODE")
    private Account account;
}
