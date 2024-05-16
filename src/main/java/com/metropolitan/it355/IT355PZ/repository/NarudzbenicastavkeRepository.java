package com.metropolitan.it355.IT355PZ.repository;

import com.metropolitan.it355.IT355PZ.entity.Narudzbenicastavke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NarudzbenicastavkeRepository extends JpaRepository<Narudzbenicastavke, Integer> {
}