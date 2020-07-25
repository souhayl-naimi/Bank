package io.naimi.bank.Entities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
@Entity
@DiscriminatorValue("T")
public class Transfer extends Operation {
    @Builder
    public Transfer(Long operationNumber, Date operationDate, double operationAmount, Account account) {
        super(operationNumber, operationDate, operationAmount, account);
    }
}
