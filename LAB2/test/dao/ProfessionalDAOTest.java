/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import model.Customer;
import model.Professional;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author Windows
 */
@RunWith(MockitoJUnitRunner.class)
public class ProfessionalDAOTest {
        
        private ProfessionalDAO mockDAO;
       @Before
    public void setUp() {
        mockDAO = Mockito.mock(ProfessionalDAO.class);
    }

    @Test
    public void testGetProfessionalByID_Success() {
      
         Date dateOfBirth = new Date();
    Date hireDate = new Date();
    Date createdAt = new Date();
    
    
    byte[] profilePicture = "profile.jpg".getBytes(StandardCharsets.ISO_8859_1);

   
    Professional mockProfessional = new Professional(
            1, "John Doe", "john@example.com", "hashedPassword",
            dateOfBirth, "Male", "123 Main St", "123456789",
            hireDate, "Active", profilePicture,
            "Cardiology", "9AM-5PM", "MD", "Expert in cardiology", createdAt
    );

    
    when(mockDAO.getProfessionalbyID(1)).thenReturn(mockProfessional);

    
    Professional result = mockDAO.getProfessionalbyID(1);

    
    assertNotNull(result);
    assertEquals(1, result.getStaffID());
    assertEquals("John Doe", result.getName()); 
    assertEquals("john@example.com", result.getEmail());
    assertEquals("Cardiology", result.getSpecialization());
    }

    @Test
    public void testGetProfessionalByID_NotFound() {
       
        when(mockDAO.getProfessionalbyID(999)).thenReturn(null);

        
        Professional result = mockDAO.getProfessionalbyID(999);

        
        assertNull(result);
    }
    
    @Test
public void testGetProfessionalByID_ThrowsException() {

    when(mockDAO.getProfessionalbyID(500)).thenThrow(new RuntimeException("Database error"));

    try {
      
        Professional result = mockDAO.getProfessionalbyID(500);
        fail("Expected an exception to be thrown");
    } catch (RuntimeException e) {
       
        assertEquals("Database error", e.getMessage());
    }
}

@Test
public void testGetProfessionalByID_ForceFail() {
   
    Date dateOfBirth = new Date();
    Date hireDate = new Date();
    Date createdAt = new Date();
    byte[] profilePicture = "profile.jpg".getBytes(StandardCharsets.ISO_8859_1);

    Professional mockProfessional = new Professional(
            1, "John Doe", "john@example.com", "hashedPassword",
            dateOfBirth, "Male", "123 Main St", "123456789",
            hireDate, "Active", profilePicture,
            "Cardiology", "9AM-5PM", "MD", "Expert in cardiology", createdAt
    );

 
    when(mockDAO.getProfessionalbyID(1)).thenReturn(mockProfessional);

    
    Professional result = mockDAO.getProfessionalbyID(1);

    
    assertEquals("Jane Doe", result.getName()); 
}


    @Test
    public void testUpdateProfessional_Success() {
        
        Date dateOfBirth = new Date();
        Date hireDate = new Date();
        Date createdAt = new Date();
        byte[] profilePicture = "profile.jpg".getBytes(StandardCharsets.ISO_8859_1);

        Professional professional = new Professional(
                1, "John Doe", "john@example.com", "hashedPassword",
                dateOfBirth, "Male", "123 Main St", "123456789",
                hireDate, "Active", profilePicture,
                "Cardiology", "9AM-5PM", "MD", "Expert in cardiology", createdAt
        );

        
        when(mockDAO.updateProfessional(professional)).thenReturn(true);

       
        boolean result = mockDAO.updateProfessional(professional);

        
        assertTrue(result);
    }

    @Test
    public void testUpdateProfessional_Fail() {
        
        Date dateOfBirth = new Date();
        Date hireDate = new Date();
        Date createdAt = new Date();
        byte[] profilePicture = "profile.jpg".getBytes(StandardCharsets.ISO_8859_1);

        Professional professional = new Professional(
                2, "Jane Doe", "jane@example.com", "hashedPassword",
                dateOfBirth, "Female", "456 Elm St", "987654321",
                hireDate, "Inactive", profilePicture,
                "Neurology", "10AM-6PM", "PhD", "Expert in Neurology", createdAt
        );

        
        when(mockDAO.updateProfessional(professional)).thenReturn(false);

        
        boolean result = mockDAO.updateProfessional(professional);

        
        assertFalse(result);
    }

    @Test
    public void testUpdateProfessional_ForceFail() {
        
        Date dateOfBirth = new Date();
        Date hireDate = new Date();
        Date createdAt = new Date();
        byte[] profilePicture = "profile.jpg".getBytes(StandardCharsets.ISO_8859_1);

        Professional professional = new Professional(
                3, "Error Test", "error@example.com", "hashedPassword",
                dateOfBirth, "Male", "789 Pine St", "555666777",
                hireDate, "Active", profilePicture,
                "Surgery", "8AM-4PM", "MD", "Expert in Surgery", createdAt
        );

        
        when(mockDAO.updateProfessional(professional)).thenReturn(true);

      
        boolean result = mockDAO.updateProfessional(professional);

        
        assertFalse(result);
    }


    
    
}
