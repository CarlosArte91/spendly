package com.ccruz.spendly.service.impl;

import com.ccruz.spendly.controller.dto.TransactionTypeDTO;
import com.ccruz.spendly.service.TransactionTypeService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TransactionTypeServiceImpl implements TransactionTypeService {

    private List<TransactionTypeDTO> transactionTypeList;

    @PostConstruct
    public void init() {
        this.transactionTypeList = new ArrayList<>();
    }

    @Override
    public void createTransactionType(TransactionTypeDTO data) {
        data.setId((long) (transactionTypeList.size() + 1));
        transactionTypeList.add(data);
    }

    @Override
    public List<TransactionTypeDTO> getAllTransactionTypes() {
        return transactionTypeList;
    }

    @Override
    public TransactionTypeDTO getTransactionTypeById(Long id) {
        return searchTransactionTypeById(id);
    }

    @Override
    public void updateTransactionType(Long id, TransactionTypeDTO data) {
        TransactionTypeDTO found = searchTransactionTypeById(id);

        if (Objects.nonNull(found)) {
            found.setName(data.getName());
        }
    }

    @Override
    public void deleteTransactionType(Long id) {
        TransactionTypeDTO found = searchTransactionTypeById(id);

        if (Objects.nonNull(found)) {
            transactionTypeList.remove(found);
        }
    }

    private TransactionTypeDTO searchTransactionTypeById(Long id) {
        for (TransactionTypeDTO item : transactionTypeList) {
            if (Objects.equals(id, item.getId())) {
                return item;
            }
        }
        return null;
    }

}
