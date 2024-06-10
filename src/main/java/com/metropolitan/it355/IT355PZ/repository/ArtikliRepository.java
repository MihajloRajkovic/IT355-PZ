package com.metropolitan.it355.IT355PZ.repository;

import com.metropolitan.it355.IT355PZ.entity.Artikli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtikliRepository extends JpaRepository<Artikli, Integer> {
    @Query(value = "SELECT artikli.ArtikalID,artikli.Naziv,artikli.Cena,artikli.Kolicina_Na_Stanju FROM menistavke \n" +
            "JOIN artikli ON menistavke.ArtikalID = artikli.ArtikalID\n" +
            "WHERE menistavke.MeniID = :id;",nativeQuery = true)
    List<Artikli> getArtiklibyMenuID( Integer id);
}