package com.ohashi.contractmanagerservice.controllers;

import com.ohashi.contractmanagerservice.controllers.payloads.ContractRequest;
import com.ohashi.contractmanagerservice.entities.Contract;
import com.ohashi.contractmanagerservice.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.management.OperationsException;
import java.net.URI;

@RestController
@RequestMapping("contract")
public class ContractController {

    @Autowired
    private ContractService service;

    @PostMapping
    public ResponseEntity<Contract> create(@RequestBody ContractRequest newContract,
                                           UriComponentsBuilder uriComponentsBuilder) throws OperationsException {
        var contract = service.create(newContract);

        URI uri = uriComponentsBuilder.path("/").buildAndExpand(contract.getId()).toUri();

        return ResponseEntity.created(uri).body(contract);
    }
}
