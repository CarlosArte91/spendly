package com.ccruz.spendly.controller;

import com.ccruz.spendly.controller.dto.TransactionTypeDTO;
import com.ccruz.spendly.service.TransactionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/transaction_type")
@RequiredArgsConstructor
public class TransactionTypeController {

    private final TransactionTypeService transactionTypeService;

    @PostMapping
    public ResponseEntity<Void> createTransactionType(@RequestBody TransactionTypeDTO data) {
        transactionTypeService.createTransactionType(data);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TransactionTypeDTO>> getAllTransactionTypes() {
        List<TransactionTypeDTO> transactionTypesList = transactionTypeService.getAllTransactionTypes();
        return ResponseEntity.ok(transactionTypesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionTypeDTO> getTransactionTypeById(@PathVariable("id") Long id) {
        TransactionTypeDTO transactionType = transactionTypeService.getTransactionTypeById(id);
        return ResponseEntity.ok(transactionType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTransactionType(@PathVariable("id") Long id, @RequestBody TransactionTypeDTO data) {
        transactionTypeService.updateTransactionType(id, data);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionType(@PathVariable("id") Long id) {
        transactionTypeService.deleteTransactionType(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
