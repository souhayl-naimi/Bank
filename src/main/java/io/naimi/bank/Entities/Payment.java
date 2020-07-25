package io.naimi.bank.Entities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
@Entity
@DiscriminatorValue("P")
public class Payment extends Operation  {
    @Builder
    public Payment(Long operationNumber, Date operationDate, double operationAmount, Account account) {
        super(operationNumber, operationDate, operationAmount, account);
    }
}
