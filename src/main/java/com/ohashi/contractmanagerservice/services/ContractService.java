package com.ohashi.contractmanagerservice.services;

import com.ohashi.contractmanagerservice.controllers.payloads.ContractRequest;
import com.ohashi.contractmanagerservice.entities.Contract;

import javax.management.OperationsException;
import java.util.List;

public interface ContractService {

    List<Contract> getAllContracts();
    List<Contract> getContractsByCompany(String companyName);
    List<Contract> getContractWithRenewed();
    Contract create(ContractRequest newContract) throws OperationsException;
}
