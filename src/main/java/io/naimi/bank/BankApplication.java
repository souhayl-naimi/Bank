package io.naimi.bank;

import io.naimi.bank.DAO.AccountRepository;
import io.naimi.bank.DAO.ClientRepository;
import io.naimi.bank.DAO.OperationRepository;
import io.naimi.bank.Entities.*;
import io.naimi.bank.Services.BusinessImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;

import java.util.Date;

@SpringBootApplication
public class BankApplication implements CommandLineRunner {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private BusinessImplementation businessImplementation;
    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Client souhayl = new Client();
        souhayl.setClientName("Souhayl Naimi");
        souhayl.setClientEmail("shyl@gmail.com");
        clientRepository.save(souhayl);

        Client soukaina = new Client();
        soukaina.setClientName("Soukaina Mabchour");
        soukaina.setClientEmail("skn@gmail.com");
        clientRepository.save(soukaina);

        CheckingAccount accountCh = new CheckingAccount();
        accountCh.setAccountCode("A1E2");
        accountCh.setBalance(120000.00);
        accountCh.setDateCreation(new Date());
        accountCh.setOverdraft(6000.00);
        accountCh.setClient(souhayl);
        accountRepository.save(accountCh);

        SavingsAccount accountSa = new SavingsAccount();
        accountSa.setAccountCode("B1E8");
        accountSa.setBalance(90000.00);
        accountSa.setDateCreation(new Date());
        accountSa.setRate(5.5);
        accountSa.setClient(soukaina);
        accountRepository.save(accountSa);

   
/*

        businessImplementation.pay(accountCh.getAccountCode(),10000.00);
        businessImplementation.pay(accountCh.getAccountCode(),4550.00);
        businessImplementation.pay(accountCh.getAccountCode(),2000.00);

        businessImplementation.withdraw(accountCh.getAccountCode(),1200.00);
        businessImplementation.withdraw(accountCh.getAccountCode(),200.00);

        businessImplementation.transfer(accountSa.getAccountCode(),accountCh.getAccountCode(),20000.00);
*/



    }
}
