package io.naimi.bank.Entities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Collection;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
@Entity
@DiscriminatorValue("SA")
public class SavingsAccount extends Account{
    private double rate;
    @Builder

    public SavingsAccount(String accountCode, Date dateCreation, double balance, Client client, Collection<Operation> operations, double rate) {
        super(accountCode, dateCreation, balance, client, operations);
        this.rate=rate;
    }
}
