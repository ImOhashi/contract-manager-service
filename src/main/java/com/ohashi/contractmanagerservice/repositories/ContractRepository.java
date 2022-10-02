package com.ohashi.contractmanagerservice.repositories;

import com.ohashi.contractmanagerservice.entities.Contract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends CrudRepository<Contract, Integer> {
    List<Contract> findAll();
    List<Contract> findByCompany(String companyName);
}
