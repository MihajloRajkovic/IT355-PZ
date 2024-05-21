-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2024 at 10:23 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restorandb`
--
CREATE DATABASE IF NOT EXISTS `restorandb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `restorandb`;

-- --------------------------------------------------------

--
-- Table structure for table `artikli`
--

DROP TABLE IF EXISTS `artikli`;
CREATE TABLE IF NOT EXISTS `artikli` (
                                         `ArtikalID` int(11) NOT NULL AUTO_INCREMENT,
    `Naziv` varchar(100) DEFAULT NULL,
    `Cena` decimal(10,2) DEFAULT NULL,
    `Kolicina_Na_Stanju` int(11) DEFAULT NULL,
    PRIMARY KEY (`ArtikalID`)
    ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `artikli`
--

INSERT INTO `artikli` (`ArtikalID`, `Naziv`, `Cena`, `Kolicina_Na_Stanju`) VALUES
                                                                               (1, 'Pizza Margherita', 5.50, 20),
                                                                               (2, 'Pasta Carbonara', 7.25, 15),
                                                                               (3, 'Tiramisu', 4.75, 10),
                                                                               (4, 'Espresso', 1.50, 30),
                                                                               (5, 'Mineralna voda', 1.25, 40);

-- --------------------------------------------------------

--
-- Table structure for table `finansije`
--

DROP TABLE IF EXISTS `finansije`;
CREATE TABLE IF NOT EXISTS `finansije` (
                                           `FinansijeID` int(11) NOT NULL,
    `Datum` date DEFAULT NULL,
    `Zarada` decimal(10,2) DEFAULT NULL,
    `Potrosnja` decimal(10,2) DEFAULT NULL,
    `Plate_Radnika` decimal(10,2) DEFAULT NULL,
    PRIMARY KEY (`FinansijeID`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `finansije`
--

INSERT INTO `finansije` (`FinansijeID`, `Datum`, `Zarada`, `Potrosnja`, `Plate_Radnika`) VALUES
                                                                                             (1, '2024-05-01', 500.00, 300.00, 200.00),
                                                                                             (2, '2024-05-02', 450.00, 250.00, 150.00),
                                                                                             (3, '2024-05-03', 600.00, 400.00, 180.00),
                                                                                             (4, '2024-05-04', 580.00, 360.00, 220.00),
                                                                                             (5, '2024-05-05', 610.00, 410.00, 200.00);

-- --------------------------------------------------------

--
-- Table structure for table `korisnici`
--

DROP TABLE IF EXISTS `korisnici`;
CREATE TABLE IF NOT EXISTS `korisnici` (
                                           `Korisnik_ID` int(11) NOT NULL AUTO_INCREMENT,
    `Ime` varchar(50) DEFAULT NULL,
    `Prezime` varchar(50) DEFAULT NULL,
    `Korisnicko_Ime` varchar(50) DEFAULT NULL,
    `Lozinka` varchar(255) DEFAULT NULL,
    `Tip_Korisnika` varchar(20) DEFAULT NULL,
    `Role` varchar(255) NOT NULL,
    PRIMARY KEY (`Korisnik_ID`),
    UNIQUE KEY `KorisnickoIme` (`Korisnicko_Ime`)
    ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `korisnici`
--

INSERT INTO `korisnici` (`Korisnik_ID`, `Ime`, `Prezime`, `Korisnicko_Ime`, `Lozinka`, `Tip_Korisnika`, `Role`) VALUES
                                                                                                                    (1, 'Marko', 'Markovic', 'markom', 'pass123', 'konobar', 'USER'),
                                                                                                                    (2, 'Jelena', 'Jovanovic', 'jelenaj', 'paaaaaa', 'kuvar', 'USER'),
                                                                                                                    (3, 'Petar', 'Petrovic', 'petarp', 'pass345', 'menadzer', 'ADMIN'),
                                                                                                                    (4, 'Ana', 'Antic', 'anaa', 'pass456', 'konobar', 'USER'),
                                                                                                                    (5, 'Vladimir', 'Vladimirovic', 'vladv', 'pass567', 'sanker', 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `meni`
--

DROP TABLE IF EXISTS `meni`;
CREATE TABLE IF NOT EXISTS `meni` (
                                      `MeniID` int(11) NOT NULL AUTO_INCREMENT,
    `Naziv` varchar(100) DEFAULT NULL,
    PRIMARY KEY (`MeniID`)
    ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `meni`
--

INSERT INTO `meni` (`MeniID`, `Naziv`) VALUES
                                           (1, 'Osnovni meni'),
                                           (2, 'Specijaliteti'),
                                           (3, 'Pića'),
                                           (4, 'Dezerti'),
                                           (5, 'Sezonski meni');

-- --------------------------------------------------------

--
-- Table structure for table `menistavke`
--

DROP TABLE IF EXISTS `menistavke`;
CREATE TABLE IF NOT EXISTS `menistavke` (
                                            `MeniStavkaID` int(11) NOT NULL,
    `MeniID` int(11) DEFAULT NULL,
    `ArtikalID` int(11) DEFAULT NULL,
    PRIMARY KEY (`MeniStavkaID`),
    KEY `menistavke_ibfk_2` (`ArtikalID`),
    KEY `menistavke_ibfk_3` (`MeniID`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menistavke`
--

INSERT INTO `menistavke` (`MeniStavkaID`, `MeniID`, `ArtikalID`) VALUES
                                                                     (1, 1, 1),
                                                                     (2, 1, 2),
                                                                     (3, 2, 3),
                                                                     (4, 3, 4),
                                                                     (5, 4, 5);

-- --------------------------------------------------------

--
-- Table structure for table `narudzbenicastavke`
--

DROP TABLE IF EXISTS `narudzbenicastavke`;
CREATE TABLE IF NOT EXISTS `narudzbenicastavke` (
                                                    `NarudzbenicaStavkaID` int(11) NOT NULL,
    `NarudzbenicaID` int(11) DEFAULT NULL,
    `ArtikalID` int(11) DEFAULT NULL,
    `Kolicina` int(11) DEFAULT NULL,
    PRIMARY KEY (`NarudzbenicaStavkaID`),
    KEY `NarudzbenicaID` (`NarudzbenicaID`),
    KEY `narudzbenicastavke_ibfk_2` (`ArtikalID`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `narudzbenicastavke`
--

INSERT INTO `narudzbenicastavke` (`NarudzbenicaStavkaID`, `NarudzbenicaID`, `ArtikalID`, `Kolicina`) VALUES
                                                                                                         (1, 1, 1, 2),
                                                                                                         (2, 2, 2, 3),
                                                                                                         (3, 3, 3, 1),
                                                                                                         (4, 4, 4, 5),
                                                                                                         (5, 5, 5, 2);

-- --------------------------------------------------------

--
-- Table structure for table `narudzbenice`
--

DROP TABLE IF EXISTS `narudzbenice`;
CREATE TABLE IF NOT EXISTS `narudzbenice` (
                                              `NarudzbenicaID` int(11) NOT NULL AUTO_INCREMENT,
    `VlasnikID` int(11) DEFAULT NULL,
    `Datum_Narudzbine` date DEFAULT NULL,
    PRIMARY KEY (`NarudzbenicaID`),
    KEY `VlasnikID` (`VlasnikID`)
    ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `narudzbenice`
--

INSERT INTO `narudzbenice` (`NarudzbenicaID`, `VlasnikID`, `Datum_Narudzbine`) VALUES
                                                                                   (1, 1, '2024-05-10'),
                                                                                   (2, 2, '2024-05-11'),
                                                                                   (3, 3, '2024-05-12'),
                                                                                   (4, 4, '2024-05-13'),
                                                                                   (5, 5, '2024-05-14');

-- --------------------------------------------------------

--
-- Table structure for table `porudzbine`
--

DROP TABLE IF EXISTS `porudzbine`;
CREATE TABLE IF NOT EXISTS `porudzbine` (
                                            `PorudzbinaID` int(11) NOT NULL AUTO_INCREMENT,
    `Stol` int(11) DEFAULT NULL,
    `RadnikID` int(11) DEFAULT NULL,
    `Vreme_Porudzbine` timestamp NOT NULL DEFAULT current_timestamp(),
    PRIMARY KEY (`PorudzbinaID`),
    KEY `RadnikID` (`RadnikID`)
    ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `porudzbine`
--

INSERT INTO `porudzbine` (`PorudzbinaID`, `Stol`, `RadnikID`, `Vreme_Porudzbine`) VALUES
                                                                                      (1, 1, 1, '2024-05-16 10:00:00'),
                                                                                      (2, 2, 2, '2024-05-16 10:15:00'),
                                                                                      (3, 3, 3, '2024-05-16 10:30:00'),
                                                                                      (4, 4, 4, '2024-05-16 10:45:00'),
                                                                                      (5, 5, 5, '2024-05-16 11:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `stavkeporudzbine`
--

DROP TABLE IF EXISTS `stavkeporudzbine`;
CREATE TABLE IF NOT EXISTS `stavkeporudzbine` (
                                                  `StavkaID` int(11) NOT NULL,
    `PorudzbinaID` int(11) DEFAULT NULL,
    `ArtikalID` int(11) DEFAULT NULL,
    `Kolicina` int(11) DEFAULT NULL,
    `Cena` decimal(10,2) DEFAULT NULL,
    PRIMARY KEY (`StavkaID`),
    KEY `PorudzbinaID` (`PorudzbinaID`),
    KEY `stavkeporudzbine_ibfk_2` (`ArtikalID`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `stavkeporudzbine`
--

INSERT INTO `stavkeporudzbine` (`StavkaID`, `PorudzbinaID`, `ArtikalID`, `Kolicina`, `Cena`) VALUES
                                                                                                 (1, 1, 1, 2, 11.00),
                                                                                                 (2, 2, 2, 3, 21.75),
                                                                                                 (3, 3, 3, 1, 4.75),
                                                                                                 (4, 4, 4, 5, 7.50),
                                                                                                 (5, 5, 5, 2, 2.50);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `menistavke`
--
ALTER TABLE `menistavke`
    ADD CONSTRAINT `menistavke_ibfk_2` FOREIGN KEY (`ArtikalID`) REFERENCES `artikli` (`ArtikalID`),
  ADD CONSTRAINT `menistavke_ibfk_3` FOREIGN KEY (`MeniID`) REFERENCES `meni` (`MeniID`);

--
-- Constraints for table `narudzbenicastavke`
--
ALTER TABLE `narudzbenicastavke`
    ADD CONSTRAINT `fk2` FOREIGN KEY (`NarudzbenicaID`) REFERENCES `narudzbenice` (`NarudzbenicaID`),
  ADD CONSTRAINT `narudzbenicastavke_ibfk_2` FOREIGN KEY (`ArtikalID`) REFERENCES `artikli` (`ArtikalID`);

--
-- Constraints for table `narudzbenice`
--
ALTER TABLE `narudzbenice`
    ADD CONSTRAINT `fk1` FOREIGN KEY (`VlasnikID`) REFERENCES `korisnici` (`Korisnik_ID`);

--
-- Constraints for table `porudzbine`
--
ALTER TABLE `porudzbine`
    ADD CONSTRAINT `porudzbine_ibfk_1` FOREIGN KEY (`RadnikID`) REFERENCES `korisnici` (`Korisnik_ID`);

--
-- Constraints for table `stavkeporudzbine`
--
ALTER TABLE `stavkeporudzbine`
    ADD CONSTRAINT `fk4` FOREIGN KEY (`PorudzbinaID`) REFERENCES `porudzbine` (`PorudzbinaID`),
  ADD CONSTRAINT `stavkeporudzbine_ibfk_2` FOREIGN KEY (`ArtikalID`) REFERENCES `artikli` (`ArtikalID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
