package com.ccruz.spendly.service;

import com.ccruz.spendly.controller.dto.AccountDTO;

import java.util.List;

public interface AccountService {

    void createAccount(AccountDTO data);

    List<AccountDTO> getAllAccounts();

    AccountDTO getAccountById(Long id);

    void updateAccount(Long id, AccountDTO data);

    void deleteAccount(Long id);

}
