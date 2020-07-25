package io.naimi.bank.Services;

import io.naimi.bank.DAO.AccountRepository;
import io.naimi.bank.DAO.ClientRepository;
import io.naimi.bank.DAO.OperationRepository;
import io.naimi.bank.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class BusinessImplementation implements IBusiness {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private OperationRepository operationRepository;

    @Override
    public Account consultAccount(String accountCode) {
        Account account = accountRepository.findById(accountCode).get();
        return account;
    }

    @Override
    public void pay(String accountCode, double amount) {
        Account account = consultAccount(accountCode);
        Payment payment = new Payment(null,new Date(),amount,account);
        operationRepository.save(payment);
        account.setBalance(account.getBalance()+amount);
        accountRepository.save(account);
    }

    @Override
    public void withdraw(String accountCode, double amount) {
        Account account = consultAccount(accountCode);
        double facilitesCaisse = 0;
        if(account instanceof CheckingAccount){
            facilitesCaisse = ((CheckingAccount) account).getOverdraft();
        }
        if(account.getBalance()+facilitesCaisse<amount)
            throw new RuntimeException("Not Enough Balance");

        Withdrawal withdrawal = new Withdrawal(null,new Date(),amount,account);
        operationRepository.save(withdrawal);
        account.setBalance(account.getBalance()-amount);
        accountRepository.save(account);
    }

    @Override
    public void transfer(String accountCodeSender, String accountCodeReceiver, double amount) {
            withdraw(accountCodeSender,amount);
            pay(accountCodeReceiver,amount);
    }

    @Override
    public Page<Operation> listOperation(String accountCode, int page, int size) {
        return operationRepository.listOperation(accountCode, PageRequest.of(page, size));
    }
}
