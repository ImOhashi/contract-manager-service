package com.ohashi.contractmanagerservice.entities;

import com.ohashi.contractmanagerservice.controllers.payloads.ContractRequest;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contract")
public class Contract {

    public Contract(ContractRequest newContract) {
        this.name = newContract.getName();
        this.clientName = newContract.getClientName();
        this.initDate = newContract.getInitDate();
        this.endDate = newContract.getEndDate();
        this.company = newContract.getCompany();
        this.renewed = false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String clientName;

    private LocalDate initDate;

    private LocalDate endDate;

    private boolean renewed;

    private String company;
}