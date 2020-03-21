-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 15, 2020 at 03:15 AM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 7.0.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_nusa`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(10) NOT NULL,
  `nama_admin` varchar(40) NOT NULL,
  `username_admin` varchar(12) NOT NULL,
  `password_admin` varchar(12) NOT NULL,
  `photo` text NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `no_hp` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `nama_admin`, `username_admin`, `password_admin`, `photo`, `jenis_kelamin`, `no_hp`) VALUES
(1, 'Jamal', 'admin1', '12345678', '', 'Laki-laki', '08213457899');

-- --------------------------------------------------------

--
-- Table structure for table `nasabah`
--

CREATE TABLE `nasabah` (
  `id_nasabah` int(5) NOT NULL,
  `nama` varchar(40) NOT NULL,
  `nik` int(16) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `alamat` text NOT NULL,
  `photo` text NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `pekerjaan` varchar(25) NOT NULL,
  `alamat_kantor` text NOT NULL,
  `pendapatan` int(12) NOT NULL,
  `no_hp` varchar(14) NOT NULL,
  `status` varchar(10) NOT NULL,
  `nama_ibu` varchar(40) NOT NULL,
  `username_nasabah` varchar(12) NOT NULL,
  `password_nasabah` varchar(12) NOT NULL,
  `tgl_pembuatan` date NOT NULL,
  `id_rekening` int(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nasabah`
--

INSERT INTO `nasabah` (`id_nasabah`, `nama`, `nik`, `tgl_lahir`, `alamat`, `photo`, `jenis_kelamin`, `pekerjaan`, `alamat_kantor`, `pendapatan`, `no_hp`, `status`, `nama_ibu`, `username_nasabah`, `password_nasabah`, `tgl_pembuatan`, `id_rekening`) VALUES
(1, 'Jamal', 123123866, '1996-12-13', 'Kali Deres', 'res/nasabah_photos/avatar_1_jamal.jpg', 'Laki', 'Ini', 'Disini', 10000000, '0812218323', 'Duda', 'Siti', 'nasabah1', '123456', '2020-03-14', 1);

-- --------------------------------------------------------

--
-- Table structure for table `rekening`
--

CREATE TABLE `rekening` (
  `id_rekening` int(12) NOT NULL,
  `no_rekening` int(16) NOT NULL,
  `saldo` int(12) NOT NULL,
  `jenis_rekening` varchar(10) NOT NULL,
  `no_pin` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rekening`
--

INSERT INTO `rekening` (`id_rekening`, `no_rekening`, `saldo`, `jenis_rekening`, `no_pin`) VALUES
(1, 1234567890, 100000, 'Reguler', 123456);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_bank`
--

CREATE TABLE `transaksi_bank` (
  `id_transaksi` int(12) NOT NULL,
  `jenis_transaksi` varchar(10) NOT NULL,
  `nominal` int(12) NOT NULL,
  `tgl_transaksi` date NOT NULL,
  `kode_bank` int(3) NOT NULL,
  `rek_tujuan` int(16) NOT NULL,
  `biaya_admin` int(12) NOT NULL,
  `ket_transaksi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_ppob`
--

CREATE TABLE `transaksi_ppob` (
  `id_transaksi` int(12) NOT NULL,
  `jenis_transaksi` varchar(40) NOT NULL,
  `nominal` int(12) NOT NULL,
  `tgl_transaksi` datetime NOT NULL,
  `no_target` int(32) NOT NULL,
  `ket_transaksi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `nasabah`
--
ALTER TABLE `nasabah`
  ADD PRIMARY KEY (`id_nasabah`);

--
-- Indexes for table `rekening`
--
ALTER TABLE `rekening`
  ADD PRIMARY KEY (`id_rekening`);

--
-- Indexes for table `transaksi_bank`
--
ALTER TABLE `transaksi_bank`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- Indexes for table `transaksi_ppob`
--
ALTER TABLE `transaksi_ppob`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `nasabah`
--
ALTER TABLE `nasabah`
  MODIFY `id_nasabah` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `rekening`
--
ALTER TABLE `rekening`
  MODIFY `id_rekening` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `transaksi_bank`
--
ALTER TABLE `transaksi_bank`
  MODIFY `id_transaksi` int(12) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `transaksi_ppob`
--
ALTER TABLE `transaksi_ppob`
  MODIFY `id_transaksi` int(12) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
