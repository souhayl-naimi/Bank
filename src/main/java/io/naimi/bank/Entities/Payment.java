package io.naimi.bank.Entities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@ToString
@Entity
@DiscriminatorValue("P")
public class Payment extends Operation  {
}
