package io.naimi.bank.Controllers;

import io.naimi.bank.Entities.Account;
import io.naimi.bank.Entities.Operation;
import io.naimi.bank.Services.IBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BankController {
    @Autowired
    private IBusiness iBusiness;

    @RequestMapping(value = "/accounts")
    public String accounts() {
        return "accounts";
    }

    @RequestMapping(value = "/consultAccount")
    public String consultAccount(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "4") int size,
                                 @RequestParam(name = "accountCode", defaultValue = "") String accountCode) {
        try {
            Account account = iBusiness.consultAccount(accountCode);
            model.addAttribute("account", account);
            Page<Operation> operationPage = iBusiness.listOperation(accountCode, page, size);
            model.addAttribute("listOperation", operationPage.getContent());
            model.addAttribute("pages", new int[operationPage.getTotalPages()]);
            model.addAttribute("currentPage", page);
            model.addAttribute("size", size);
            model.addAttribute("accountCode", accountCode);
        } catch (Exception e) {
            model.addAttribute("exception", e.getMessage());
        }
        return "accounts";
    }

    @RequestMapping(value = "/saveOperation", method = RequestMethod.POST)
    public String saveOperation(Model model,
                                String typeOperation,
                                String accountCode,
                                double amount,
                                String accountCode2) {
        try {
            if (typeOperation.equals("WITH")) {
                iBusiness.withdraw(accountCode, amount);
            } else if (typeOperation.equals("PAY")) {
                iBusiness.pay(accountCode, amount);
            }
            if (typeOperation.equals("TRANS")) {
                iBusiness.transfer(accountCode, accountCode2, amount);
            }
        } catch (Exception e) {
            model.addAttribute("error",e);
            return "redirect:/consultAccount?accountCode=" + accountCode+"&error="+e.getMessage();
        }
        return "redirect:/consultAccount?accountCode=" + accountCode;
    }
}
