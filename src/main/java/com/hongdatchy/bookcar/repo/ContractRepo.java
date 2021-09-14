package com.hongdatchy.bookcar.repo;

import com.hongdatchy.bookcar.entities.model.Contract;

import java.util.List;

public interface ContractRepo {

    Contract createAndUpdate(Contract contract);

    List<Contract>findByUserId(Integer userId);


    List<Contract>findAll();
}
