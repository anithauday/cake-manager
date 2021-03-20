package com.cake.manager.cakemanager.repository;


import com.cake.manager.cakemanager.domain.entity.Cake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CakeRepository extends JpaRepository<Cake, String> {

    List<Cake> findAll();

}
