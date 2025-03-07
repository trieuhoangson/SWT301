/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import java.util.Arrays;
import java.util.List;
import model.Customer;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author Hoang
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerDAOTest {

    @Mock
    private CustomerDAO customerDAO;

//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
        
    @Test
    public void testGetAllCustomer() {
        List<Customer> mockCustomers = Arrays.asList(
                new Customer(1, "user1", "pass1", "Customer1", "email1@test.com", "123456789",
                        "Address1", "Active", "2023-01-01", "2000-01-01", "Male", "profile1.jpg"),
                new Customer(2, "user2", "pass2", "Customer2", "email2@test.com", "987654321",
                        "Address2", "Inactive", "2023-02-01", "1998-05-10", "Female", "profile2.jpg"),
                new Customer(3, "user3", "pass3", "Customer3", "email3@test.com", "555666777",
                        "Address3", "Active", "2023-03-01", "1995-08-15", "Male", "profile3.jpg")
        );

        when(customerDAO.getAllCustomer()).thenReturn(mockCustomers);

        List<Customer> result = customerDAO.getAllCustomer();
        assertEquals(3, result.size()); // Kiểm tra số lượng khách hàng trả về
        assertEquals("Customer1", result.get(0).getFullName()); // Kiểm tra thông tin khách hàng đầu tiên
        assertEquals("Customer2", result.get(1).getFullName());
        assertEquals("Customer3", result.get(2).getFullName());
    }

    @Test
    public void testIsUsernameExist() {
        // Giả lập kiểm tra username đã tồn tại
        when(customerDAO.isUsernameExist("existingUser")).thenReturn(true);
        boolean result = customerDAO.isUsernameExist("existingUser");
        assertTrue(result);
    }
}
