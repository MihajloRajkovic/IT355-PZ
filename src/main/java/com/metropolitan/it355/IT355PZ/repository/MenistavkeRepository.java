package com.metropolitan.it355.IT355PZ.repository;

import com.metropolitan.it355.IT355PZ.entity.Artikli;
import com.metropolitan.it355.IT355PZ.entity.Meni;
import com.metropolitan.it355.IT355PZ.entity.Menistavke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenistavkeRepository extends JpaRepository<Menistavke, Integer> {

    @Query(value = "SELECT * FROM menistavke WHERE menistavke.MeniID = :meniID" , nativeQuery = true )
    List<Menistavke> findAllByMeniID(Integer meniID);
}