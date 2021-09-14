package com.hongdatchy.bookcar.service_impl;

import com.hongdatchy.bookcar.entities.model.Contract;
import com.hongdatchy.bookcar.repo.ContractRepo;
import com.hongdatchy.bookcar.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService_impl implements ContractService {

    @Autowired
    ContractRepo contractRepo;

    @Override
    public List<Contract> findByUserId(Integer userId) {
        return contractRepo.findByUserId(userId);
    }
}
