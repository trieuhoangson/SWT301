/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlller;

import dal.DAO;
import dal.DAO_Admin;
import dal.DAO_Insurance;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;
import model.Customer;
import model.Insurance;
import model.Staff;
import utils.Password;

/**
 *
 * @author Windows
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
        String username = request.getParameter("username");
        String password = request.getParameter("pass");      
        String role = request.getParameter("role");
        password = Password.toSHA1(password);
        DAO dao = new DAO();
        DAO_Admin daoadmin = new DAO_Admin();
        DAO_Insurance daoinsurance = new DAO_Insurance();
        if ("customer".equals(role)) {
            Customer acc = dao.login(username, password);
            if (acc == null) {
                request.setAttribute("mess", "Wrong username or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("account", acc);
                response.sendRedirect("home.jsp");  // Điều hướng đến trang chính sau khi đăng nhập thành công
            }
        } else if ("staff".equals(role)) {
            Staff acc = daoadmin.login_admin(username, password);
            if (acc == null) {
                request.setAttribute("mess", "Wrong username or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("account", acc);
                response.sendRedirect("home.jsp");  // Điều hướng đến trang chính sau khi đăng nhập thành công
            }
        }else if("insurance".equals(role)){
            Insurance acc = daoinsurance.login_insurance(username, password);
            if (acc == null) {
                request.setAttribute("mess", "Wrong username or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("account", acc);
                response.sendRedirect("home.jsp");  // Điều hướng đến trang chính sau khi đăng nhập thành công
            }
        }
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
