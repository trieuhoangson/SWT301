/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author pc
 */
@RunWith(MockitoJUnitRunner.class)
public class RoleDAOTest {
    private RoleDAO mockDAO;

    @Before 
    public void setUp() {
        // Mock DAO
        mockDAO = Mockito.mock(RoleDAO.class);
    }

    @Test
    public void testUpdateRole_Success() throws Exception {
        doNothing().when(mockDAO).updateRole(1, "Admin", "Administrator role");
        mockDAO.updateRole(1, "Admin", "Administrator role");
        verify(mockDAO, times(1)).updateRole(1, "Admin", "Administrator role");
    }


    @Test
    public void testCreateRole_Success() throws Exception {
        doNothing().when(mockDAO).createRole("User", "User role");
        mockDAO.createRole("User", "User role");
        verify(mockDAO, times(1)).createRole("User", "User role");
    }


    @Test
    public void testUpdateRole_WithInvalidId() throws Exception {
        doThrow(new IllegalArgumentException("Invalid role ID"))
                .when(mockDAO).updateRole(-1, "Admin", "Administrator role");
        try {
            mockDAO.updateRole(-1, "Admin", "Administrator role");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid role ID", e.getMessage());
        }
    }

    @Test
    public void testCreateRole_WithEmptyName() throws Exception {
        doThrow(new IllegalArgumentException("Role name cannot be empty"))
                .when(mockDAO).createRole("", "User role");
        try {
            mockDAO.createRole("", "User role");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Role name cannot be empty", e.getMessage());
        }
    }
    
}
