package com.ccruz.spendly.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class AccountDTO {

    private Long id;

    @NotBlank(message = "The name cannot be empty or null.")
    private String name;

    @NotNull(message = "Balance is required.")
    @PositiveOrZero(message = "Balance must be positive or zero.")
    private Double balance;

    private Boolean active;

}
