package hu.nive.ujratervezes.kepesitovizsga.dictionary;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {

//    private Dictionary dictionary;
//    private MariaDbDataSource dataSource;
//
//    @BeforeEach
//    public void setUp() {
//        try {
//            dataSource = new MariaDbDataSource();
//            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
//            dataSource.setUser("employees");
//            dataSource.setPassword("employees");
//        } catch (SQLException sqle) {
//            throw new IllegalStateException("Can not get data from database.", sqle);
//        }
//
//        dictionary = new Dictionary(dataSource);
//
//        Flyway fw = Flyway.configure().dataSource(dataSource).load();
//        fw.clean();
//        fw.migrate();
//    }
//
//    @Test
//    public void getEnglishWord() {
//        Assertions.assertEquals("chair", dictionary.getEnglishWord("szék"));
//    }
//
//    @Test
//    public void getHungarianWord() {
//        Assertions.assertEquals("kanál", dictionary.getHungarianWord("spoon"));
//    }
//
//    @Test
//    public void testNotExistingWord() {
//        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> dictionary.getEnglishWord("kerítés"));
//        Assertions.assertEquals("No such word in dictionary.", ex.getMessage());
//    }
//
//    @Test
//    public void testNotExistingWord2() {
//        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> dictionary.getHungarianWord("apple"));
//        Assertions.assertEquals("No such word in dictionary.", ex.getMessage());
//    }

}