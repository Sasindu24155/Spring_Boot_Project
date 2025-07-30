package com.springg.demo.repo;

import com.springg.demo.entity.Item;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;


import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item, Integer> {

    List<Item> findAllByItemNameEqualsAndActive(String itemName, boolean b);

    List<Item> findAllByActive(boolean activeStatus);

    Page<Item> findAllByActive(boolean activeStatus, Pageable pageable);

    long countAllByActive(boolean activeStatus);


}
