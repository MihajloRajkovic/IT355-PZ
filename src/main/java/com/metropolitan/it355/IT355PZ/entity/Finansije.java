package com.metropolitan.it355.IT355PZ.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Integer id;

    @Column(name = "Datum")
    private LocalDate datum;

    @Column(name = "Zarada", precision = 10, scale = 2)
    private BigDecimal zarada;

    @Column(name = "Potrosnja", precision = 10, scale = 2)
    private BigDecimal potrosnja;

    @Column(name = "PlateRadnika", precision = 10, scale = 2)
    private BigDecimal plateRadnika;

}