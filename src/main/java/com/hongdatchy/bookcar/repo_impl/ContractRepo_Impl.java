package com.hongdatchy.bookcar.repo_impl;

import com.hongdatchy.bookcar.entities.model.Contract;
import com.hongdatchy.bookcar.repo.ContractRepo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class ContractRepo_Impl implements ContractRepo {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Contract createAndUpdate(Contract contract) {
        return entityManager.merge(contract);
    }
}
