=================================================
      RECORDING STUDIO MANAGEMENT SYSTEM
=================================================

Project Title
-------------
Recording Studio Management System

Project Description
-------------------
The Recording Studio Management System is a Java console-based application
designed to manage recording studio operations. It allows administrators
to manage artists, albums, songs, playlists, and users through a menu-driven
interface connected to a MySQL database.

Project Objectives
------------------
1. Manage artist records.
2. Manage album information.
3. Manage song records.
4. Create and manage playlists.
5. Manage system users.
6. Store and retrieve data using MySQL database.

System Features
---------------
USER MANAGEMENT
- Add User
- View Users
- Update User
- Archive User
- Login Authentication

ARTIST MANAGEMENT
- Add Artist
- View All Artists
- Update Artist
- Archive Artist
- View Archived Artists

ALBUM MANAGEMENT
- Add Album
- View Albums
- Update Album
- Archive Album

SONG MANAGEMENT
- Add Song
- View Songs
- Update Song
- Archive Song

PLAYLIST MANAGEMENT
- Create Playlist
- View Playlists
- Add Songs to Playlist
- Manage Playlist Contents

Project Structure
-----------------

com.joysistvi.recordingstudio

├── config
│   └── DBConnection.java
│
├── model
│   ├── Artist.java
│   ├── Album.java
│   ├── Song.java
│   ├── Playlist.java
│   └── User.java
│
├── repository
│   ├── ArtistRepository.java
│   ├── ArtistRepositoryImpl.java
│   ├── AlbumRepository.java
│   ├── AlbumRepositoryImpl.java
│   ├── SongRepository.java
│   ├── SongRepositoryImpl.java
│   ├── PlaylistRepository.java
│   ├── PlaylistRepositoryImpl.java
│   ├── UserRepository.java
│   └── UserRepositoryImpl.java
│
├── service
│   ├── ArtistService.java
│   ├── ArtistServiceImpl.java
│   ├── AlbumService.java
│   ├── AlbumServiceImpl.java
│   ├── SongService.java
│   ├── SongServiceImpl.java
│   ├── PlaylistService.java
│   ├── PlaylistServiceImpl.java
│   ├── UserService.java
│   └── UserServiceImpl.java
│
├── util
│   └── InputUtil.java
│
├── view
│   ├── ArtistView.java
│   ├── AlbumView.java
│   ├── SongView.java
│   ├── PlaylistView.java
│   └── UserView.java
│
└── App.java

Technologies Used
-----------------
Programming Language : Java
Database             : MySQL
Connectivity         : JDBC
IDE                  : IntelliJ IDEA

Database Configuration
----------------------
1. Install MySQL Server.
2. Create database: recording_studio
3. Configure the database connection settings in:

   config/DBConnection.java

Example:
---------
URL      : jdbc:mysql://localhost:3306/recording_studio
USERNAME : root
PASSWORD : your_password

How to Run
----------
1. Open the project in IntelliJ IDEA.
2. Ensure MySQL Server is running.
3. Create the required database and tables.
4. Update database credentials in DBConnection.java.
5. Compile and run App.java.
6. Login using an existing account.

Author
------
Dandy C. Abella
Bachelor of Science in Computer Engineering

Course
------
Java Database Programming

=================================================
               END OF DOCUMENT
=================================================