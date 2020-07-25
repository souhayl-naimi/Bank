package io.naimi.bank.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "clients")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientCode;
    private String clientName;
    private String clientEmail;
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private Collection<Account> accounts;
}
