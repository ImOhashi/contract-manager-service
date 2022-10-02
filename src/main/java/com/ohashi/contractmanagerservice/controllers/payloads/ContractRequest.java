package com.ohashi.contractmanagerservice.controllers.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractRequest {
    private String name;
    private String clientName;
    private LocalDate initDate;
    private LocalDate endDate;
    private String company;
}
