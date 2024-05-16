package com.metropolitan.it355.IT355PZ.repository;

import com.metropolitan.it355.IT355PZ.entity.Finansije;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinansijeRepository extends JpaRepository<Finansije, Integer> {
}