package com.example.services;

import com.example.model.Account;
import com.example.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PaymentService {


    private AccountRepository accountRepository;


    @Transactional
    public void transferMoney(long AccountId, int totalPrice) {
        Account account = getAccountById(AccountId);

        BigDecimal price = BigDecimal.valueOf(totalPrice);
        BigDecimal newAmount = account.getAmount().subtract(price);
        account.setAmount(newAmount);

        accountRepository.save(account);
        //Часть 2
        throw new RuntimeException("Oh no! Transfer money went wrong!");
    }


    public Account getAccountById(Long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            return optionalAccount.get();
        }
        throw new IllegalArgumentException("Account not found with id: " + id);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

}
