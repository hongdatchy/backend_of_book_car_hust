package com.hongdatchy.bookcar.service;

import com.hongdatchy.bookcar.entities.model.Contract;

import java.util.List;

public interface ContractService {

    List<Contract> findByUserId(Integer userId);

}
