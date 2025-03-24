package context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for ValidFunction class using JUnit 4.
 */
public class ValidFunctionTest {

    private final ValidFunction valid = new ValidFunction();

    public String normalizeName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "";
        }
        name = name.trim().toLowerCase();
        String[] words = name.split("\\s+");
        StringBuilder normalized = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                normalized.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }
        return normalized.toString().trim();
    }
    @Test
    public void testNormalizeName() {
        assertEquals("Doi La Be Kho", valid.normalizeName("doi La BE KHo"));
        assertEquals("", valid.normalizeName(" "));
        assertEquals("", valid.normalizeName(null));
        assertEquals("A", valid.normalizeName("a"));
        assertEquals("B", valid.normalizeName("B"));
        assertEquals("Tran Thi B", valid.normalizeName("  tran   THI  b ")); 
        assertEquals("O'connor John", valid.normalizeName("o'connor JOHN")); 
        assertEquals("Doi La Be Kho", valid.normalizeName("      doi   La   Be khO    ")); 
        assertEquals("Le Van!", valid.normalizeName("le VAN!")); 
        assertEquals("Lê Văn Tùng", valid.normalizeName("lê vĂn TÙNG")); 
        assertEquals("123", valid.normalizeName("123")); 
    }
    
    
    public String convertDateString(String inputDate, String outputPattern) {
        if (inputDate == null || inputDate.isEmpty()) {
            return "";
        }
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = inputFormat.parse(inputDate);
            SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
            return outputFormat.format(date);
        } catch (ParseException e) {
            return "";
        }
    }

    @Test
    public void testConvertDateString() {
        assertEquals("10/03/2025", valid.convertDateString("2025-03-10", "dd/MM/yyyy"));
        assertEquals("April 10, 2025", valid.convertDateString("2025-04-10", "MMMM dd, yyyy"));
        assertEquals("10-03-25", valid.convertDateString("2025-03-10", "dd-MM-yy"));
        assertEquals("", valid.convertDateString("", "dd/MM/yyyy"));
        assertEquals("", valid.convertDateString(null, "dd/MM/yyyy")); 
        assertEquals("", valid.convertDateString("10-03-2025", "dd/MM/yyyy")); 
        assertEquals("", valid.convertDateString("March 10, 2025", "yyyy-MM-dd")); 
        assertEquals("", valid.convertDateString("2025/03/10", "dd/MM/yyyy")); 
        assertEquals("2025-03-10", valid.convertDateString("2025-03-10", "yyyy-MM-dd"));
        assertEquals("Monday", valid.convertDateString("2025-03-10", "EEEE")); 
        assertEquals("2025", valid.convertDateString("2025-03-10", "yyyy"));
    }
}
