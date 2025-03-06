package controller_Admin;

import dal.DAO_Admin;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name="statistic_managementServlet", urlPatterns={"/statistic_management"})
public class statistic_managementServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet statistic_managementServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet statistic_managementServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            DAO_Admin dao = new DAO_Admin();
            
            
            request.setAttribute("totalCustomers", dao.get_Total_Customers());
            request.setAttribute("totalStaff", dao.get_Total_Staff());
            request.setAttribute("totalInsurance", dao.get_Total_Insurance());
            
            
            request.setAttribute("activeCustomers", dao.get_Active_Customers());
            request.setAttribute("activeStaff", dao.get_Active_Staff());
            request.setAttribute("activeServices", dao.get_Active_Services());
            
            
            request.setAttribute("maleCustomers", dao.get_Customers_By_Gender("male"));
            request.setAttribute("femaleCustomers", dao.get_Customers_By_Gender("female"));
            
            
            request.setAttribute("creditCards", dao.get_Customer_By_Card_Type("credit"));
            request.setAttribute("debitCards", dao.get_Customer_By_Card_Type("debit"));
            
            
            request.setAttribute("pendingRequests", dao.get_Requests_By_Status("pending"));
            request.setAttribute("approvedRequests", dao.get_Requests_By_Status("approved"));
            request.setAttribute("rejectedRequests", dao.get_Requests_By_Status("rejected"));
            
            
            request.setAttribute("totalFeedback", dao.get_Total_Feedback());
            
            request.getRequestDispatcher("/statistic management.jsp").forward(request, response);
            
        } catch (Exception e) {
            System.out.println(e);          
        }
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
