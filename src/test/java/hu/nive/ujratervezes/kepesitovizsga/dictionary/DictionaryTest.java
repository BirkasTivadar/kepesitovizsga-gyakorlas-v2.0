package hu.nive.ujratervezes.kepesitovizsga.dictionary;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {

    private Dictionary dictionary;
    private MysqlDataSource dataSource;

    @BeforeEach
    public void setUp() {
        dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/employees?useUnicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        dictionary = new Dictionary(dataSource);

        Flyway fw = Flyway.configure().dataSource(dataSource).load();
        fw.clean();
        fw.migrate();
    }

    @Test
    public void getEnglishWord() {
        assertEquals("chair", dictionary.getEnglishWord("szék"));
    }

    @Test
    public void getHungarianWord() {
        assertEquals("kanál", dictionary.getHungarianWord("spoon"));
    }

    @Test
    public void testNotExistingWord() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> dictionary.getEnglishWord("kerítés"));
        assertEquals("No such word in dictionary.", ex.getMessage());
    }

    @Test
    public void testNotExistingWord2() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> dictionary.getHungarianWord("apple"));
        assertEquals("No such word in dictionary.", ex.getMessage());
    }
}