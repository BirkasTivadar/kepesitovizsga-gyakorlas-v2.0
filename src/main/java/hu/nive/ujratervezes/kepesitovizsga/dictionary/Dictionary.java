package hu.nive.ujratervezes.kepesitovizsga.dictionary;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dictionary {

    private DataSource dataSource;

    public Dictionary(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getEnglishWord(String hungarianWord) {
        String result;

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT angol FROM words WHERE magyar = ?;")
        ) {

            ps.setString(1, hungarianWord);

            result = getStringEnglish(ps);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed", sqlException);
        }
        return result;
    }

    private String getStringEnglish(PreparedStatement ps) {

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getString("angol");
            }

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot query", sqlException);
        }
        throw new IllegalArgumentException("No such word in dictionary.");
    }

    public String getHungarianWord(String englishWord) {
        String result;

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT magyar FROM words WHERE angol = ?;")
        ) {

            ps.setString(1, englishWord);

            result = getStringHungarian(ps);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed", sqlException);
        }
        return result;
    }

    private String getStringHungarian(PreparedStatement ps) {

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getString("magyar");
            }

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot query", sqlException);
        }
        throw new IllegalArgumentException("No such word in dictionary.");
    }
}

