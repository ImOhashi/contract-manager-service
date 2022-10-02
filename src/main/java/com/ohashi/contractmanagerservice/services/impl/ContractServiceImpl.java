package com.ohashi.contractmanagerservice.services.impl;

import com.ohashi.contractmanagerservice.controllers.payloads.ContractRequest;
import com.ohashi.contractmanagerservice.entities.Contract;
import com.ohashi.contractmanagerservice.repositories.ContractRepository;
import com.ohashi.contractmanagerservice.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.OperationsException;
import java.lang.module.FindException;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository repository;

    @Override
    public List<Contract> getAllContracts() {
        var allContracts = repository.findAll();

        if(allContracts.size() == 0) {
            throw new FindException("Nenhum contrato foi encontrado");
        }

        return allContracts;
    }

    public List<Contract> getContractsByCompany(String companyName) {
        var contracts = repository.findByCompany(companyName);

        if(contracts.size() == 0) {
            throw new FindException("Nenhum contrato foi encontrado");
        }

        return contracts;
    }

    @Override
    public List<Contract> getContractWithRenewed() {
        return repository.findAll().stream().filter(Contract::isRenewed).toList();
    }

    @Override
    public Contract create(ContractRequest newContract) throws OperationsException {
        try {
            return repository.save(new Contract(newContract));
        } catch (Error e) {
            throw new OperationsException("Erro ao tentar criar novo contrato.");
        }

    }
}
