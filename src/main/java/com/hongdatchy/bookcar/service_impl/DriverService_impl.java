package com.hongdatchy.bookcar.service_impl;

import com.hongdatchy.bookcar.entities.model.Contract;
import com.hongdatchy.bookcar.entities.model.Driver;
import com.hongdatchy.bookcar.entities.payload.LoginForm;
import com.hongdatchy.bookcar.repo.ContractRepo;
import com.hongdatchy.bookcar.repo.DriverRepo;
import com.hongdatchy.bookcar.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService_impl implements DriverService {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ContractRepo contractRepo;

    @Override
    public boolean login(LoginForm loginForm) {
        return driverRepo.login(loginForm);
    }

    @Override
    public boolean applyContract(int contractId, Driver driver) {
        List<Contract> contractList = contractRepo.findAll().stream()
                .filter(contract -> contract.getId().equals(contractId))
                .collect(Collectors.toList());
        if(contractList.size()== 0){
            return false;
        }
        Contract contractUpdate = contractList.get(0);
        contractUpdate.setDriverId(driver.getId());
        contractRepo.createAndUpdate(contractUpdate);
        return true;
    }


}
