/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Balra
 */
public class BalanceServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();  
        HttpSession session = request.getSession(false);
        String s  = (String)session.getAttribute("acco");
        double acc = Double.parseDouble(s);
        String result = null;
        try
          {  
               Class.forName("oracle.jdbc.driver.OracleDriver");  
               Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","oracle");  
               
               PreparedStatement ps=con.prepareStatement(  
               "select amount from atm_users where acc=?");  
               ps.setDouble(1,acc);  
               ResultSet rs = ps.executeQuery();  
               while(rs.next())
                result = rs.getString(1); 
                    
               out.print("<html><head><style>");
               out.println("*{margin: 0;padding: 0;}");
               out.println("body{background-image: url('main_bck.JPG');");
               out.println(" background-repeat: no-repeat;}");    
              out.println(".container{   width: 700x; height: 600px;}");
              out.println(".container h1{font-size: 80px;text-align: center;color: #FFD700;}");    
              out.println(".container h3{font-size: 40px;color: #FFD700;text-align: center;}");
              out.println("input[type=password] {text-align: center;width: 50%;");
              out.println("padding: 12px 20px;margin: 8px 0;box-sizing: border-box;border: 3px solid #ccc;");
              out.println("-webkit-transition: 0.5s;transition: 0.5s;outline: none;}");
              out.println("input[type=password]:focus {border: 3px solid #555;}");
              out.println(".s_container{margin-top: 90px;}");
              out.println(".s_container button{margin-top: 5%;margin-left: 42%;width: 120px;height:35px;}");
              out.println("</style></head><body>");
              out.println("<div class='container'><div class='s_container'>");
              out.println("<h1>GOLD BANK</h1><br>");
              out.println("<h3>Your Balance is </h3><br><br><br>");
              out.println("<h3>"+result+" ???</h3> ");
            
              out.println("</div></div></body></html>");
              
             
             // Thread.sleep(3000);
              //response.sendRedirect("main.html");
              response.setHeader("Refresh", "3; URL=main.html");
          }
          catch(Exception e)
          {
               System.out.println(e);
               
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
        processRequest(request, response);
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
