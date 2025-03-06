/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package dal;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author default
 */
@WebServlet(name = "CustomerList_AServlet", urlPatterns = {"/CustomerList_AServlet"})
public class CustomerList_AServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CustomerList_AServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerList_AServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    DBContext db = new DBContext();
    List<Customer> customers = new ArrayList<>();
    String search = request.getParameter("search");

    try {
        Connection conn = (Connection) db.getConnection();
        String sql;

        if (search != null && !search.trim().isEmpty()) {
            sql = "SELECT customer_id, full_name FROM customer WHERE full_name LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + search + "%");  // Sử dụng wildcard cho tìm kiếm
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int customerId = rs.getInt("customer_id");
                String fullName = rs.getString("full_name");
                Customer customer = new Customer();
                customer.setCustomer_id(customerId);
                customer.setFull_name(fullName);
                customers.add(customer);
            }
        } else {
            sql = "SELECT customer_id, full_name FROM customer";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int customerId = rs.getInt("customer_id");
                String fullName = rs.getString("full_name");
                Customer customer = new Customer();
                customer.setCustomer_id(customerId);
                customer.setFull_name(fullName);
                customers.add(customer);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    request.setAttribute("customer", customers);
    request.getRequestDispatcher("customerList_A.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
