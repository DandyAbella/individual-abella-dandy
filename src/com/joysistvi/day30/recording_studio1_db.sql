-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 17, 2026 at 02:11 PM
-- Server version: 10.11.16-MariaDB
-- PHP Version: 8.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `recording_studio1_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `albums`
--

CREATE TABLE `albums` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL COMMENT 'title of the album',
  `year` int(11) NOT NULL COMMENT 'release year of the album',
  `artist_id` int(11) NOT NULL COMMENT 'foreign key referencing artists_id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `albums`
--

INSERT INTO `albums` (`id`, `name`, `year`, `artist_id`) VALUES
(1, 'Tropa', 1994, 1),
(2, 'Cutterpillow', 1995, 2),
(3, 'Burugudoy', 1997, 3),
(4, 'Appetite for Destruction', 1987, 4),
(5, 'The One That You Love', 1981, 5);

-- --------------------------------------------------------

--
-- Table structure for table `artists`
--

CREATE TABLE `artists` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL COMMENT 'Name of the artist'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `artists`
--

INSERT INTO `artists` (`id`, `name`) VALUES
(1, 'Siakol'),
(2, 'Eraserheads'),
(3, 'Parokya ni Edgar'),
(4, 'Guns N\' Roses'),
(5, 'Air Supply');

-- --------------------------------------------------------

--
-- Table structure for table `myplaylist`
--

CREATE TABLE `myplaylist` (
  `id` int(11) NOT NULL,
  `playlist_name` varchar(100) NOT NULL,
  `date_created` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `myplaylist`
--

INSERT INTO `myplaylist` (`id`, `playlist_name`, `date_created`) VALUES
(1, 'PinoyLoveSongs', '2026-11-17'),
(2, 'All time favorite', '2026-11-16');

-- --------------------------------------------------------

--
-- Table structure for table `playlist_songs`
--

CREATE TABLE `playlist_songs` (
  `id` int(11) NOT NULL,
  `playlist_id` int(11) NOT NULL,
  `song_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `playlist_songs`
--

INSERT INTO `playlist_songs` (`id`, `playlist_id`, `song_id`) VALUES
(1, 1, 6),
(2, 1, 5),
(3, 2, 7),
(4, 2, 2),
(5, 2, 4),
(6, 1, 1);

-- --------------------------------------------------------

--
-- Stand-in structure for view `playlist_song_view`
-- (See below for the actual view)
--
CREATE TABLE `playlist_song_view` (
`id` int(11)
,`playlist_name` varchar(100)
,`song_title` varchar(150)
);

-- --------------------------------------------------------

--
-- Table structure for table `songs`
--

CREATE TABLE `songs` (
  `id` int(11) NOT NULL,
  `title` varchar(150) NOT NULL,
  `genre` varchar(50) NOT NULL,
  `length` varchar(10) NOT NULL,
  `album_id` int(11) NOT NULL COMMENT 'FK referencing albums_id',
  `is_archived` tinyint(4) NOT NULL COMMENT '0= active (false), 1 = archived/true'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `songs`
--

INSERT INTO `songs` (`id`, `title`, `genre`, `length`, `album_id`, `is_archived`) VALUES
(1, 'Biyaheng Langit', 'Pinoy Rock', '4:15', 1, 0),
(2, 'Lakas Tama', 'Pinoy Rock', '4:02', 1, 0),
(3, 'Magasin', 'Pinoy Rock', '4:56', 2, 0),
(4, 'Overdrive', 'Pinoy Rock', '3:50', 2, 0),
(5, 'Harana', 'Pinoy Rock', '4:20', 3, 0),
(6, 'Halaga', 'Pinoy Rock', '5:08', 3, 0),
(7, 'Sweet Child O\' Mine', 'Hard Rock', '5:56', 4, 0),
(8, 'Welcome to the Jungle', 'Hard Rock', '4:33', 4, 0),
(9, 'Out of nothing at all', 'Soft Rock', '4:18', 5, 0),
(10, 'Here I am', 'Soft Rock', '3:47', 5, 0);

-- --------------------------------------------------------

--
-- Stand-in structure for view `song_album_view`
-- (See below for the actual view)
--
CREATE TABLE `song_album_view` (
`song_id` int(11)
,`song_title` varchar(150)
,`album_name` varchar(100)
,`album_year` int(11)
);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `albums`
--
ALTER TABLE `albums`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_albums_artist` (`artist_id`);

--
-- Indexes for table `artists`
--
ALTER TABLE `artists`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `myplaylist`
--
ALTER TABLE `myplaylist`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `playlist_songs`
--
ALTER TABLE `playlist_songs`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `title` (`id`),
  ADD KEY `fk_playlist` (`playlist_id`),
  ADD KEY `fk_playlist_songs` (`song_id`);

--
-- Indexes for table `songs`
--
ALTER TABLE `songs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_songs_album` (`album_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `albums`
--
ALTER TABLE `albums`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `artists`
--
ALTER TABLE `artists`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `myplaylist`
--
ALTER TABLE `myplaylist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `playlist_songs`
--
ALTER TABLE `playlist_songs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `songs`
--
ALTER TABLE `songs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

-- --------------------------------------------------------

--
-- Structure for view `playlist_song_view`
--
DROP TABLE IF EXISTS `playlist_song_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `playlist_song_view`  AS SELECT `ps`.`id` AS `id`, `mp`.`playlist_name` AS `playlist_name`, `s`.`title` AS `song_title` FROM ((`playlist_songs` `ps` join `myplaylist` `mp` on(`ps`.`playlist_id` = `mp`.`id`)) join `songs` `s` on(`ps`.`song_id` = `s`.`id`)) ;

-- --------------------------------------------------------

--
-- Structure for view `song_album_view`
--
DROP TABLE IF EXISTS `song_album_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `song_album_view`  AS SELECT `s`.`id` AS `song_id`, `s`.`title` AS `song_title`, `a`.`name` AS `album_name`, `a`.`year` AS `album_year` FROM (`songs` `s` join `albums` `a` on(`s`.`album_id` = `a`.`id`)) ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `albums`
--
ALTER TABLE `albums`
  ADD CONSTRAINT `fk_albums_artist` FOREIGN KEY (`artist_id`) REFERENCES `artists` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `playlist_songs`
--
ALTER TABLE `playlist_songs`
  ADD CONSTRAINT `fk_playlist` FOREIGN KEY (`playlist_id`) REFERENCES `myplaylist` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_playlist_songs` FOREIGN KEY (`song_id`) REFERENCES `songs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `songs`
--
ALTER TABLE `songs`
  ADD CONSTRAINT `fk_songs_album` FOREIGN KEY (`album_id`) REFERENCES `albums` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
