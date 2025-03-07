/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CustomerController;

import context.ValidFunction;
import dao.CustomerDAO;
import dao.StaffDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;
import model.Staff;

/**
 *
 * @author jaxbo
 */

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ValidFunction valid = new ValidFunction();
        String userType = request.getParameter("userType");
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        HttpSession session = request.getSession();

        try {
            if ("customer".equals(userType)) {
                CustomerDAO dao = new CustomerDAO();
                Customer customerAccount = dao.customerLogin(user);
                try {
                    if (customerAccount != null && valid.checkPassword(password, customerAccount.getPassword())) {
                        session.setAttribute("customerAccount", customerAccount);
                        if (rememberMe != null) {
                            Cookie cusUsername = new Cookie("username", user);
                            Cookie cusPassword = new Cookie("password", password);

                            cusUsername.setMaxAge(30 * 24 * 60 * 60);
                            cusPassword.setMaxAge(30 * 24 * 60 * 60);

                            response.addCookie(cusUsername);
                            response.addCookie(cusPassword);
                        } else {
                            //xoa cookie neu khong chon RemMe
                            Cookie usernameCookie = new Cookie("username", "");
                            Cookie passwordCookie = new Cookie("password", "");
                            usernameCookie.setMaxAge(0);
                            passwordCookie.setMaxAge(0);
                            response.addCookie(usernameCookie);
                            response.addCookie(passwordCookie);
                        }
                        response.sendRedirect("index_1.jsp");
                    } else {
                        request.setAttribute("error", "Invalid username or password !");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
                } catch (IllegalArgumentException e) {
                    request.setAttribute("error", "Password format is invalid. Please contact support!");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } else if ("staff".equals(userType)) {
                StaffDAO dao = new StaffDAO();
                Staff staff = dao.staffLogin(user);

                try {
                    if (staff == null || !valid.checkPassword(password, staff.getPassword())) {
                        request.setAttribute("error", "Invalid email or password!");
                        request.setAttribute("userType", "staff");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    } else {
                        String dob = null;
                        String hireDate = null;
                        if (staff.getDateOfBirth() != null) {
                            dob = valid.formatDate(staff.getDateOfBirth());
                        }
                        if (staff.getHireDate() != null) {
                            hireDate = valid.formatDate(staff.getHireDate());
                        }
                        Staff s = new Staff(staff.getStaffID(), staff.getFullName(), staff.getEmail(), staff.getPassword(), staff.getPhone(), staff.getGender(), dob, staff.getAddress(), hireDate, staff.getRoleID(), staff.getStatus(), staff.getProfilePicture());
                        session.setAttribute("staffAccount", s);
                        if (rememberMe != null) {
                            Cookie staffEmail = new Cookie("email", user);
                            Cookie staffPassword = new Cookie("password", password);
                            staffEmail.setMaxAge(30 * 24 * 60 * 60);
                            staffPassword.setMaxAge(30 * 24 * 60 * 60);
                            response.addCookie(staffEmail);
                            response.addCookie(staffPassword);
                        }
                        response.sendRedirect("index_1.jsp");
                    }
                } catch (IllegalArgumentException e) {
                    request.setAttribute("error", "Password format is invalid. Please contact support!");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("error", "Invalid User Type");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (ServletException | IOException e) {
            request.setAttribute("error", "An unexpected error occurred. Please try again.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
