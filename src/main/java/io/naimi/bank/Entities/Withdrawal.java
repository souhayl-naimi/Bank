package io.naimi.bank.Entities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
@Entity
@DiscriminatorValue("W")
public class Withdrawal extends Operation {

}
