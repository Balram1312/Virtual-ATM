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
public class menuServlet extends HttpServlet {

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
        
        try {
               Class.forName("oracle.jdbc.driver.OracleDriver");  
               Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","oracle");  
               
               PreparedStatement ps=con.prepareStatement(  
               "select name from atm_users where acc=?");  
               ps.setDouble(1,acc);  
               ResultSet rs = ps.executeQuery();  
               while(rs.next())
                result = rs.getString(1); 
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title></title><style>");
            out.println("*{margin: 0;padding: 0;}");
            out.println("body{background-image: url('main_bck.JPG');background-repeat: no-repeat; }");    
            out.println(".header{width: 700x;height: 100px;}");
            out.println(".header h1{font-size: 80px;text-align: center;color: #FFD700;}");    
            out.println(".button {appearance: none;background-color: #00b4fc;border: 2px solid #00b4fc;");
            out.println("border-radius: 15px;box-sizing: border-box;color: #FFFFFF;cursor: pointer;display: inline-block;");
            out.println("font-family:"); 
            out.println("Roobert,-apple-system,BlinkMacSystemFont,'Segoe UI',Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji','Segoe UI Symbol';");
            out.println("font-size: 25px;font-weight: 800;line-height: normal;margin: 0;min-height: 60px;min-width: 0;");
            out.println("outline: none;padding: 16px 24px;text-align: center;text-decoration: none;transition: all 300ms cubic-bezier(.23, 1, 0.32, 1);");
            out.println("user-select: none;-webkit-user-select: none;touch-action: manipulation;width: 200px;height:25px;will-change: transform;}");
            out.println(".button:disabled {pointer-events: none;}");
            out.println(".button:hover {box-shadow: rgba(0, 0, 0, 0.25) 0 8px 15px;transform: translateY(-2px);color: #FFD700;}");
            out.println(".button:active {box-shadow: none;transform: translateY(0);}");
            out.println(".empty{width:200px ;}");
            out.println(".empty_row{height:25px;}");
            out.println(".msg{text-align:center;color: #FFD700;}");
            out.println(".button_panel{margin-left: 9%;margin-top: 5%;}");
            out.println("</style></head><body>");
            out.println("<div class='container'><div class='header'><h1>GOLD BANK</h1><br><h4 class='msg'>Welcome "+ result+" </h4>");
            out.println("</div><div class='button_panel'><table><tr>");
            out.println("</tr><tr class='empty_row'></tr><tr>");
            out.println("<td><button onclick=\"location.href='MP_withdraw.html'\" class='button'>Withdraw</button>"); 
            out.println("<td><div class='empty'></div></td><td>");
            out.println("<button class='button' onclick=\"location.href='MP_deposit.html'\">Deposit</button></td>");
            out.println("</tr><tr class='empty_row'></tr><tr>");
            out.println("<td><button class='button' onclick=\"location.href='MP_mobilerecharge.html'\">Recharge</button></td>");
            out.println("<td><div class='empty'></div></td>");
            out.println("<td><button class='button' onclick=\"location.href='BalanceServlet'\">Balance</button></td>");
            out.println("</tr><tr class='empty_row'></tr><tr>");
            out.println("<td><button class='button' onclick=\"location.href='MP_transfer.html'\">Transfer</button></td>");
            out.println("<td><div class='empty'></div></td>");
            out.println("<td><button class='button' onclick=\"location.href='MP_changepin.html'\">Change Pin</button></td>");
      
            out.println("</tr></table></div></div></body></html>");

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
