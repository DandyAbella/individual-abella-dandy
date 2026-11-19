package com.joysistvi.recordingapp.main;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class Main {

    static String url = "jdbc:mysql://localhost:3306/recording_studio_db";
    static String username = "root";
    static String password = "";

    public static void main(String[] args) {

        //createUser("yuno", "yuno123", "yuno@gmail.com");
        loginUser("yuno", "yuno123");
    }

    // ducking exception
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // CRUD Operation

    // ==========================================
    // ALBUMS CRUD OPERATIONS
    // ==========================================

    // Read Albums
    public static void viewAllAlbums() {
        String query = "SELECT albums.id, albums.name, albums.year, artists.name AS artist_name " +
                "FROM albums " +
                "JOIN artists " +
                "ON albums.artist_id = artists.id"; // Create SQL Statement / Query

        try (Connection connection = connect();
             Statement statement = connection.createStatement(); // create a statement object for sending sql statement
             ResultSet resultSet = statement.executeQuery(query); // execute query then store the result in the result set
        ) {
            System.out.println("\n----- Albums -----");
            System.out.printf("%-4s %-20s %-8s %-20s%n", "ID", "Name", "Year", "Artist"); // print header
            // Extract the data
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int year = resultSet.getInt("year");
                String artistName = resultSet.getString("artist_name");
                System.out.printf("%-4d %-20s %-8d %-20s%n", id, name, year, artistName);
            }
        } catch (SQLException e) {
            System.out.println("Read Albums: " + e.getMessage());
        }



    }

    // DML - Data Manipulation Language (prepareStatement) (executeUpdate) -> Create, Update, Delete
    // DQL - Data Query Language (createStatement) (executeQuery) -> Read / Select

    // ============================================================================
    // JDBC & SQL QUICK REFERENCE (DML vs. DQL)
    // ============================================================================
    // 1. DML (Data Manipulation Language): INSERT, UPDATE, DELETE
    //    - Purpose: Modifies data inside tables (adds, updates, or removes rows).
    //    - Execution: Uses executeUpdate(), which returns an 'int' (number of rows affected).
    //      * rowsAffected > 0  -> one or more rows were changed.
    //      * rowsAffected == 0 -> no matching row was found for the condition.
    //
    // 2. DQL (Data Query Language): SELECT
    //    - Purpose: Reads/retrieves data from tables without altering stored rows.
    //    - Execution: Uses executeQuery(), which returns a ResultSet.
    //      * Iterate with while (resultSet.next()) and read columns via getString(), getInt(), etc.
    //
    // 3. PreparedStatement vs. Statement:
    //    - Prefer PreparedStatement whenever there are '?' parameters (even for SELECT queries!)
    //      to prevent SQL injection and cleanly bind typed parameters.
    //    - Statement can be used for static SQL without '?' parameters, though PreparedStatement
    //      is a safe default across JDBC operations.

    // Create Album
    public static void createAlbum(String name, int year, int artistId) {
        String query = "INSERT INTO albums (name, year, artist_id) " +
                "VALUES (?, ?, ?)"; // parameterized query (anti-sql injection)

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            // setting parameter wild cards
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, year);
            preparedStatement.setInt(3, artistId);

            preparedStatement.executeUpdate();

            System.out.println("Album: " + name + " created successfully!");
            viewAllAlbums(); // RAW
        } catch (SQLException e) {
            System.out.println("Update Album: " + e.getMessage());
        }
    }


    //    Activity Solutions Start:


    // Mini-Activity: Archive Album, Restore Album, and Search Album

    // Update Album
    public static void updateAlbum(int id, String name, int year, int artistId) {
        String query = "UPDATE albums SET name = ?, year = ?, artist_id = ? WHERE id = ?";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, year);
            preparedStatement.setInt(3, artistId);
            preparedStatement.setInt(4, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("\nAlbum ID " + id + " updated successfully!");
                viewAllAlbums();
            } else {
                System.out.println("\nNo album found with ID " + id + ".");
            }
        } catch (SQLException e) {
            System.out.println("\nUpdate Album Error: " + e.getMessage());
        }
    }

    // Delete Album
    public static void deleteAlbum(int id) {
        String query = "DELETE FROM albums WHERE id = ?";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("\nAlbum ID " + id + " deleted successfully!");
                viewAllAlbums();
            } else {
                System.out.println("\nNo album found with ID " + id + ".");
            }
        } catch (SQLException e) {
            System.out.println("\nDelete Album Error: " + e.getMessage());
        }
    }



    public static void searchAlbum(String keyword) {
        String query = "SELECT albums.id, albums.name, albums.year, artists.name AS artist_name " +
                "FROM albums " +
                "JOIN artists ON albums.artist_id = artists.id " +
                "WHERE albums.is_archived = 0 AND albums.name LIKE ? " +
                "ORDER BY albums.id ASC";

        // Try-with-resources automatically closes Connection, PreparedStatement, and ResultSet.
        try (Connection conn = connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            // Trim keyword so leading/trailing spaces don't accidentally break matching.
            String cleanKeyword = (keyword == null) ? "" : keyword.trim();
            prep.setString(1, "%" + cleanKeyword + "%");

            try (ResultSet res = prep.executeQuery()) {
                System.out.println("\n----- Search Albums (Keyword: '" + cleanKeyword + "') -----");
                System.out.printf("%-4s %-22s %-8s %-20s%n", "ID", "Name", "Year", "Artist");

                boolean found = false;
                while (res.next()) {
                    found = true;
                    System.out.printf("%-4d %-22s %-8d %-20s%n",
                            res.getInt("id"),
                            res.getString("name"),
                            res.getInt("year"),
                            res.getString("artist_name"));
                }

                if (!found) {
                    System.out.println("No matching active albums found.");
                }
            }
        } catch (SQLException e) {
            System.out.println("\nSearch Album Error: " + e.getMessage());
        }
    }

    public static void archiveAlbum(int id) {
        String query = "UPDATE albums SET is_archived = 1 WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setInt(1, id);

            int rowsAffected = prep.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("\nAlbum ID " + id + " archived successfully!");
            } else {
                // 0 rows affected means no album matched that ID in the table.
                System.out.println("\nNo album found with ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("\nArchive Album Error: " + e.getMessage());
        }
    }

    public static void restoreAlbum(int id) {
        String query = "UPDATE albums SET is_archived = 0 WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setInt(1, id);

            int rowsAffected = prep.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("\nAlbum ID " + id + " restored successfully!");
            } else {
                System.out.println("\nNo album found with ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("\nRestore Album Error: " + e.getMessage());
        }
    }


    // ==========================================
    // ARTISTS CRUD OPERATIONS
    // ==========================================

    // Read Artists
    public static void viewAllArtists() {
        String query = "SELECT * FROM artists WHERE is_archived = 0";

        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("\n----- Artists -----");
            System.out.printf("%-4s %-20s%n", "ID", "Artist Name");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.printf("%-4d %-20s%n", id, name);
            }
        } catch (SQLException e) {
            System.out.println("Read Artists Error: " + e.getMessage());
        }
    }

    // Create Artist
    public static void createArtist(String name) {
        String query = "INSERT INTO artists (name) VALUES (?)";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);

            preparedStatement.executeUpdate();

            System.out.println("\nArtist: " + name + " created successfully!");
            viewAllArtists();
        } catch (SQLException e) {
            System.out.println("Create Artist Error: " + e.getMessage());
        }
    }

    // Update Artist
    public static void updateArtist(int id, String name) {
        String query = "UPDATE artists SET name = ? WHERE id = ?";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("\nArtist ID " + id + " updated successfully!");
                viewAllArtists();
            } else {
                System.out.println("\nNo artist found with ID " + id + ".");
            }
        } catch (SQLException e) {
            System.out.println("\nUpdate Artist Error: " + e.getMessage());
        }
    }

    // Delete Artist
    public static void deleteArtist(int id) {
        String query = "DELETE FROM artists WHERE id = ?";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("\nArtist ID " + id + " deleted successfully!");
                viewAllArtists();
            } else {
                System.out.println("\nNo artist found with ID " + id + ".");
            }
        } catch (SQLException e) {
            System.out.println("\nDelete Artist Error: " + e.getMessage());
        }
    }

    // Performs a SOFT DELETE (archiving) on a record by setting is_archived = true/1 instead of permanently removing the row with SQL Delete (Hard Delete)

    // Why soft-delete instead of Hard Delete?
    // - Allows records to be restored later if archived by mistake

    public static void archiveArtist(int id) {
        String query = "UPDATE artists SET is_archived = 1 WHERE id = ?";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("\nArtist ID " + id + " archived successfully!");
                viewAllArtists();
            } else {
                System.out.println("\nNo artist found with ID " + id + ".");
            }
        } catch (SQLException e) {
            System.out.println("\nArchive Artist Error: " + e.getMessage());
        }
    }

    public static void restoreArtist(int id) {

        String query = "UPDATE artists SET is_archived = 0 WHERE id = ?";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("\nArtist ID " + id + " restored successfully!");
                viewAllArtists();
            } else {
                System.out.println("\nNo artist found with ID " + id + ".");
            }
        } catch (SQLException e) {
            System.out.println("\nRestore Artist Error: " + e.getMessage());
        }
    }


    public static void searchArtist(String keyword) {
        String query = "SELECT id, name FROM artists " +
                "WHERE is_archived = 0 AND name LIKE ? " +
                "ORDER BY id ASC";  // parameterized query

        // Try-with-resources automatically closes Connection, PreparedStatement, and ResultSet.
        try (Connection conn = connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            // Clean/trim keyword so accidental leading or trailing spaces don't break search.
            String cleanKeyword = (keyword == null) ? "" : keyword.trim();
            prep.setString(1, "%" + cleanKeyword + "%");

            try (ResultSet res = prep.executeQuery()) {
                System.out.println("\n----- Search Artists (Keyword: '" + cleanKeyword + "') -----");
                System.out.printf("%-4s %-25s%n", "ID", "Artist Name");

                boolean found = false;
                while (res.next()) {
                    found = true;
                    System.out.printf("%-4d %-25s%n",
                            res.getInt("id"),
                            res.getString("name"));
                }

                if (!found) {
                    System.out.println("No matching active artists found.");
                }
            }
        } catch (SQLException e) {
            System.out.println("\nSearch Artist Error: " + e.getMessage());
        }
    }

    /*
     * WHAT IS VALIDATION?
     * Validation is the process of checking whether incoming data is safe, complete,
     * and valid BEFORE processing it or saving it to the database (e.g., non-empty
     * username, valid email format, minimum password length, positive ID).
     *
     * Why do it early?
     * - Prevents bad/incomplete data from entering the database.
     * - Avoids unnecessary database queries when input is already invalid.
     * - Gives clear feedback on what went wrong.
     *
     * What is a Guard Clause?
     * A guard clause is an early-exit check (`if (invalid) { ... return; }`) placed
     * at the top of a method so the code "fails fast" without deep if-else nesting.
     */

    // [SECTION] USER Authentication (BCrypt with Validation (Guard Clauses)

    public static void createUser(String uname, String rawPassword, String email) {

        // Guard Clause
        if (uname == null || uname.trim().isEmpty()) {
            System.out.println("\nValidation Error: Username is required.");
            return;
        }

        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            System.out.println("\nValidation Error: Valid email is required.");
            return;
        }

        if (rawPassword == null || rawPassword.trim().length() < 6) {
            System.out.println("\nValidation Error: Password must be at least 6 characters.");
            return;
        }

        String hashedPassword = BCrypt.hashpw(rawPassword.trim(), BCrypt.gensalt());

        String query = "INSERT INTO users (username, password, email, role) VALUES (?, ?, ?, 'USER')";

        // Try-with-resources automatically closes Connection and PreparedStatement after use.
        try (Connection conn = connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setString(1, uname.trim());
            prep.setString(2, hashedPassword);
            prep.setString(3, email.trim());

            int rowsAffected = prep.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("\nUser '" + uname.trim() + "' created successfully!");
                //viewAllUsers();
            }
        } catch (SQLException e) {
            // Common case: duplicate username/email if a UNIQUE constraint is set in MySQL.
            System.out.println("\nCreate User Error: " + e.getMessage());
        }


    }


    public static void loginUser(String uname, String candidatePassword) {
        // GUARD CLAUSE 1: Early exit if username is blank/null.
        if (uname == null || uname.trim().isEmpty()) {
            System.out.println("\nValidation Error: Username is required to log in.");
            return;
        }

        // GUARD CLAUSE 2: Early exit if password is missing/empty.
        if (candidatePassword == null || candidatePassword.isEmpty()) {
            System.out.println("\nValidation Error: Password is required to log in.");
            return;
        }

        // Look up the user by username first so we can retrieve the stored BCrypt hash.
        // Notice we do NOT select or read 'id' here.
        String query = "SELECT username, password, role FROM users WHERE username = ?";

        try (Connection conn = connect();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setString(1, uname.trim());

            try (ResultSet res = prep.executeQuery()) {
                if (res.next()) {
                    String storedHash = res.getString("password");

                    // BCrypt.checkpw(plainText, storedHash) safely compares the entered password
                    // against the stored hash (extracting the salt automatically).
                    // Note: If a seeded DB row has a plain-text password instead of a BCrypt hash,
                    // BCrypt.checkpw() will return false / throw an error unless hashed first.
                    if (BCrypt.checkpw(candidatePassword, storedHash)) {
                        String username = res.getString("username");
                        String role = res.getString("role");
                        System.out.println("\nLogin successful! Welcome, " + username + " (Role: " + role + ")");
                    } else {
                        // Generic message: avoids telling attackers whether the username exists or not.
                        System.out.println("\nLogin failed: Invalid username or password.");
                    }
                } else {
                    // Same generic message when username is not found.
                    System.out.println("\nLogin failed: Invalid username or password.");
                }
            }
        } catch (SQLException e) {
            System.out.println("\nLogin Error: " + e.getMessage());
        }
    }





    //    Activity Solutions End
}