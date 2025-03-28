package com.ccruz.spendly.controller.dto;

import lombok.Data;

@Data
public class TransactionTypeDTO {

    private Long id;
    private String name;
    private Boolean active;

}
