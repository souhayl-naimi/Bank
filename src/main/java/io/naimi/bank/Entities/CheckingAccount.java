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
@DiscriminatorValue("CA")
public class CheckingAccount extends Account {
    private double overdraft;

    @Builder

    public CheckingAccount(String accountCode, Date dateCreation, double balance, Client client, Collection<Operation> operations,double overdraft) {
        super(accountCode, dateCreation, balance, client, operations);
        this.overdraft=overdraft;
    }
}
