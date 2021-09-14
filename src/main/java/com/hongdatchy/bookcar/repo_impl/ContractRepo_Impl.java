package com.hongdatchy.bookcar.repo_impl;

import com.hongdatchy.bookcar.entities.model.Contract;
import com.hongdatchy.bookcar.repo.ContractRepo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ContractRepo_Impl implements ContractRepo {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Contract createAndUpdate(Contract contract) {
        return entityManager.merge(contract);
    }

    @Override
    public List<Contract> findByUserId(Integer userId) {
        return entityManager.createQuery("select x from Contract x where x.userId =: userId")
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public List<Contract> findAll() {
        return entityManager.createQuery("select x from Contract x")
                .getResultList();
    }
}
