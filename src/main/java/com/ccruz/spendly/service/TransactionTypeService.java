package com.ccruz.spendly.service;

import com.ccruz.spendly.controller.dto.TransactionTypeDTO;

import java.util.List;

public interface TransactionTypeService {

    void createTransactionType(TransactionTypeDTO transactionTypeDTO);

    List<TransactionTypeDTO> getAllTransactionTypes();

    TransactionTypeDTO getTransactionTypeById(Long id);

    void updateTransactionType(Long id, TransactionTypeDTO data);

    void deleteTransactionType(Long id);

}
