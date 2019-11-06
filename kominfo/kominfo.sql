-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 02 Nov 2019 pada 09.29
-- Versi server: 10.3.16-MariaDB
-- Versi PHP: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kominfo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `bill_`
--

CREATE TABLE `bill_` (
  `id_bill` int(11) NOT NULL,
  `id_cust` int(11) NOT NULL,
  `bln_hitung` date NOT NULL,
  `jlm_pakai` int(11) NOT NULL,
  `id_type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `bill_`
--

INSERT INTO `bill_` (`id_bill`, `id_cust`, `bln_hitung`, `jlm_pakai`, `id_type`) VALUES
(1, 1, '2019-11-02', 12, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `costumer_`
--

CREATE TABLE `costumer_` (
  `id_cust` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `no_telp` varchar(255) NOT NULL,
  `id_status` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `costumer_`
--

INSERT INTO `costumer_` (`id_cust`, `username`, `pass`, `nama`, `alamat`, `no_telp`, `id_status`) VALUES
(1, 'gg', 'gg', 'gg', 'gg', 'gg', 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `employee_`
--

CREATE TABLE `employee_` (
  `id_emp` int(11) NOT NULL,
  `nama_emp` varchar(255) NOT NULL,
  `no_hp` varchar(255) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `employee_`
--

INSERT INTO `employee_` (`id_emp`, `nama_emp`, `no_hp`, `alamat`) VALUES
(1, 'Zein', '082385804045', 'Balai baru');

-- --------------------------------------------------------

--
-- Struktur dari tabel `gangguan`
--

CREATE TABLE `gangguan` (
  `id_gangguan` int(11) NOT NULL,
  `keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `gangguan`
--

INSERT INTO `gangguan` (`id_gangguan`, `keterangan`) VALUES
(1, 'gg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `history_status_`
--

CREATE TABLE `history_status_` (
  `id_hist` int(11) NOT NULL,
  `id_status` varchar(255) NOT NULL,
  `tgl_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `id_emp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `home_type_`
--

CREATE TABLE `home_type_` (
  `id_type` int(11) NOT NULL,
  `nama_type` varchar(255) NOT NULL,
  `harga_type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pasanglayanan`
--

CREATE TABLE `pasanglayanan` (
  `id_pemilik` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `no_telp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pasanglayanan`
--

INSERT INTO `pasanglayanan` (`id_pemilik`, `nama`, `alamat`, `no_telp`) VALUES
(1, '11', '1', '1'),
(2, 'gg', 'gg', 'gg'),
(3, 'zeuh', 'gg', 'gg'),
(4, 'ft', 'gg', 'gg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `status_`
--

CREATE TABLE `status_` (
  `id_status` tinyint(4) NOT NULL,
  `nama_status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `status_`
--

INSERT INTO `status_` (`id_status`, `nama_status`) VALUES
(1, 'Aman'),
(2, 'Kacau');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users_`
--

CREATE TABLE `users_` (
  `id_us` int(11) NOT NULL,
  `id_emp` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `users_`
--

INSERT INTO `users_` (`id_us`, `id_emp`, `username`, `pass`) VALUES
(2, 1, 'zein', '123456'),
(3, 1, 'zein', '123456'),
(4, 1, 'fadli', '123456'),
(5, 1, 'zein', '123456'),
(6, 1, 'fadli', '123456'),
(7, 1, 'test', '123456');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `bill_`
--
ALTER TABLE `bill_`
  ADD PRIMARY KEY (`id_bill`);

--
-- Indeks untuk tabel `costumer_`
--
ALTER TABLE `costumer_`
  ADD PRIMARY KEY (`id_cust`);

--
-- Indeks untuk tabel `employee_`
--
ALTER TABLE `employee_`
  ADD PRIMARY KEY (`id_emp`);

--
-- Indeks untuk tabel `gangguan`
--
ALTER TABLE `gangguan`
  ADD PRIMARY KEY (`id_gangguan`);

--
-- Indeks untuk tabel `pasanglayanan`
--
ALTER TABLE `pasanglayanan`
  ADD PRIMARY KEY (`id_pemilik`);

--
-- Indeks untuk tabel `status_`
--
ALTER TABLE `status_`
  ADD PRIMARY KEY (`id_status`);

--
-- Indeks untuk tabel `users_`
--
ALTER TABLE `users_`
  ADD PRIMARY KEY (`id_us`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `bill_`
--
ALTER TABLE `bill_`
  MODIFY `id_bill` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `costumer_`
--
ALTER TABLE `costumer_`
  MODIFY `id_cust` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `employee_`
--
ALTER TABLE `employee_`
  MODIFY `id_emp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `gangguan`
--
ALTER TABLE `gangguan`
  MODIFY `id_gangguan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `pasanglayanan`
--
ALTER TABLE `pasanglayanan`
  MODIFY `id_pemilik` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `status_`
--
ALTER TABLE `status_`
  MODIFY `id_status` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `users_`
--
ALTER TABLE `users_`
  MODIFY `id_us` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
