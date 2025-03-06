/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller_Insurance;

import dal.DAO_Insurance;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import model.Insurance;
import model.Insurance_transactions;

/**
 *
 * @author Windows
 */
@WebServlet(name="sortInsuranceTransactionServlet", urlPatterns={"/sortInsuranceTransaction"})
public class sortInsuranceTransactionServlet extends HttpServlet {
   
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
            out.println("<title>Servlet sortInsuranceTransactionServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet sortInsuranceTransactionServlet at " + request.getContextPath () + "</h1>");
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
       String sort = request.getParameter("sortInsuranceTransaction");
        String transaction_type = request.getParameter("transaction_type");
         HttpSession session = request.getSession();
        Insurance i = (Insurance) session.getAttribute("account");
        DAO_Insurance dao = new DAO_Insurance();
        List<Insurance_transactions> list = new ArrayList<>();
        if(sort.equals("none") && transaction_type.equals("all")){
            list = dao.getInsuranceTransactionByInsuranceID(i.getInsurance_id());
        }
        else if(sort.equals("none") && transaction_type.equals("premium_payment")){
            list = dao.getInsuranceTransactionByInsuranceIDAndTransactionType(i.getInsurance_id(),transaction_type);
        }
        else if(sort.equals("none") && transaction_type.equals("claim_payment")){
            list = dao.getInsuranceTransactionByInsuranceIDAndTransactionType(i.getInsurance_id(),transaction_type);
        }
        else if(sort.equals("transaction_date") && transaction_type.equals("all")){
            list = dao.sortInsuranceTransactionByTransactionDate(i.getInsurance_id());
        }
        else if(sort.equals("transaction_date") && transaction_type.equals("premium_payment")){
            list = dao.sortInsuranceTransactionByTransactionDateAndTransactionType(i.getInsurance_id(),transaction_type);
        }
         else if(sort.equals("transaction_date") && transaction_type.equals("claim_payment")){
            list = dao.sortInsuranceTransactionByTransactionDateAndTransactionType(i.getInsurance_id(),transaction_type);
        }
        else if(sort.equals("amount") && transaction_type.equals("all")){
            list = dao.sortInsuranceTransactionByAmount(i.getInsurance_id());
        }
         else if(sort.equals("amount") && transaction_type.equals("premium_payment")){
            list = dao.sortInsuranceTransactionByAmountAndTransactionType(i.getInsurance_id(),transaction_type);
        }
        else if(sort.equals("amount") && transaction_type.equals("claim_payment")){
            list = dao.sortInsuranceTransactionByAmountAndTransactionType(i.getInsurance_id(),transaction_type);
        }
        request.setAttribute("listT", list);
        request.setAttribute("sort", sort);
        request.setAttribute("transaction_type", transaction_type);
        request.getRequestDispatcher("managerInsuranceTransaction.jsp").forward(request, response);
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
