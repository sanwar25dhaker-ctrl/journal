package com.example.journal.controlar;
import com.example.journal.Entity.Account;
import com.example.journal.Entity.Customer;
import com.example.journal.Service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

//@Controller
//@RestController
@Controller
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    // Open Account Page
    @GetMapping("/open")
    public String openAccountForm(Model model) {
        model.addAttribute("account", new Account());
        return "open_account";
    }

    // Save Account
    @PostMapping("/save")
    public String saveAccount(@ModelAttribute Account account) {
        service.openAccount(account);
        return "redirect:/accounts/list";
    }

    // View Accounts
    @GetMapping("/list")
    public String listAccounts(Model model) {
        model.addAttribute("accounts", service.getAllAccounts());
        return "account_list";
    }

    // Check Balance
    @GetMapping("/balance/{accountNo}")
    @ResponseBody
    public Double checkBalance(@PathVariable Long accountNo) {
        return service.getBalance(accountNo);
    }


}
