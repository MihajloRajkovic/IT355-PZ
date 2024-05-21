package com.metropolitan.it355.IT355PZ.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "finansije")
public class Finansije {
    @Id
    @Column(name = "FinansijeID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Datum")
    private LocalDate datum;

    @Column(name = "Zarada", precision = 10, scale = 2)
    private BigDecimal zarada;

    @Column(name = "Potrosnja", precision = 10, scale = 2)
    private BigDecimal potrosnja;

    @Column(name = "Plate_Radnika", precision = 10, scale = 2)
    private BigDecimal plateRadnika;

}