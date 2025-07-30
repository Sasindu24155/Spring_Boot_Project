package com.springg.demo.repo;

import com.springg.demo.entity.Customer;
import com.springg.demo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer, Integer> {




    List<Customer> findAllByActive(boolean activeStatus);

}
