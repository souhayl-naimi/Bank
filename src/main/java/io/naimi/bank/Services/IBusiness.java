package io.naimi.bank.Services;

import io.naimi.bank.Entities.Account;
import io.naimi.bank.Entities.Operation;
import org.springframework.data.domain.Page;

public interface IBusiness {
    public Account consultAccount(String accountCode);
    public void pay(String accountCode, double amount);
    public void withdraw(String accountCode, double amount);
    public void transfer(String accountCodeSender,String accountCodeReceiver, double amount);
    public Page<Operation> listOperation(String accountCode,int page, int size);
}
