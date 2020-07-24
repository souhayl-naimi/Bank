package io.naimi.bank.Entities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@ToString
@Entity
@DiscriminatorValue("T")
public class Transfer extends Operation {
}
