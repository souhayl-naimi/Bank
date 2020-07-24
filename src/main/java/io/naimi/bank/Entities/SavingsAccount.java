package io.naimi.bank.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@DiscriminatorValue("SA")
public class SavingsAccount extends Account{
    private double rate;
}
