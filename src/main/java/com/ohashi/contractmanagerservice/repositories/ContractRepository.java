package com.ohashi.contractmanagerservice.repositories;

import com.ohashi.contractmanagerservice.entities.Contract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends CrudRepository<Integer, Contract> {
}
