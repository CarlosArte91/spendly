package com.ccruz.spendly.service.impl;

import com.ccruz.spendly.controller.dto.AccountDTO;
import com.ccruz.spendly.service.AccountService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AccountServiceImpl implements AccountService {

    private List<AccountDTO> accountList;

    @PostConstruct
    public void init() {
        this.accountList = new ArrayList<>();
    }

    @Override
    public void createAccount(AccountDTO data) {
        data.setId((long) (accountList.size() + 1));
        data.setActive(true);
        accountList.add(data);
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        return accountList;
    }

    @Override
    public AccountDTO getAccountById(Long id) {
        return searchAccountById(id);
    }

    @Override
    public void updateAccount(Long id, AccountDTO data) {
        AccountDTO found = searchAccountById(id);

        if (Objects.nonNull(found)) {
            found.setName(data.getName());
            found.setBalance(data.getBalance());
        }
    }

    @Override
    public void deleteAccount(Long id) {
        AccountDTO found = searchAccountById(id);

        if (Objects.nonNull(found)) {
            accountList.remove(found);
        }
    }

    private AccountDTO searchAccountById(Long id) {
        for (AccountDTO item : accountList) {
            if (Objects.equals(id, item.getId())) {
                return item;
            }
        }
        return null;
    }

}
