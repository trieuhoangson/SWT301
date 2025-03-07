package context;

import org.junit.Test;
import static org.junit.Assert.*;
import java.text.ParseException;

/**
 * Unit test for ValidFunction class using JUnit 4.
 */
public class ValidFunctionTest {

    private final ValidFunction valid = new ValidFunction();

    @Test
    public void testContainsDigitOrSpecialChar() {
        assertTrue(valid.containsDigitOrSpecialChar("Hello123"));
        assertTrue(valid.containsDigitOrSpecialChar("Hello@World"));
        assertFalse(valid.containsDigitOrSpecialChar("Hello World"));
    }

    @Test
    public void testNormalizeName() {
        assertEquals("Nguyen Van A", valid.normalizeName("nguyen VAN a"));
        assertEquals("Le Hoang", valid.normalizeName("  le   hoang  "));
        assertEquals("", valid.normalizeName(" "));
    }

    @Test
    public void testIsValidPhoneNumber() {
        assertTrue(valid.isValidPhoneNumber("0123456789"));
        assertFalse(valid.isValidPhoneNumber("1234567890"));
        assertFalse(valid.isValidPhoneNumber("01234abcde"));
    }

    @Test
    public void testIsValidPassword() {
        assertTrue(valid.isValidPassword("Strong1@"));
        assertFalse(valid.isValidPassword("weak"));
        assertFalse(valid.isValidPassword("NoNumber@"));
    }

    @Test
    public void testFormatDate() {
        assertEquals("25/12/2023", valid.formatDate("2023-12-25 14:30:00.0"));
    }

    @Test
    public void testFormatDateNews() {
        assertEquals("25/12/2023", valid.formatDateNews("2023-12-25 14:30:00.0"));
    }

    @Test
    public void testFormatDateTime() {
        assertEquals("25-12-2023 14:30", valid.formatDateTime("2023-12-25 14:30:00.0", "dd-MM-yyyy HH:mm"));
    }

    @Test
    public void testConvertDateString() throws ParseException {
        assertEquals("25/12/2023", valid.convertDateString("2023-12-25", "dd/MM/yyyy"));
        assertEquals("", valid.convertDateString("", "dd/MM/yyyy"));
    }

    @Test
    public void testHashPassword() {
        String password = "SecurePass123!";
        String hashedPassword = valid.hashPassword(password);
        assertNotNull(hashedPassword);
        assertNotEquals(password, hashedPassword);
    }

    @Test
    public void testCheckPassword() {
        String password = "SecurePass123!";
        String hashedPassword = valid.hashPassword(password);
        assertTrue(valid.checkPassword(password, hashedPassword));
        assertFalse(valid.checkPassword("WrongPass", hashedPassword));
    }
}
