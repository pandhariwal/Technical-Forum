/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;

public class PostAnsSuccess extends HttpServlet {

 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
  
  PrintWriter out = response.getWriter();
  String ans=request.getParameter("tbans");
   HttpSession hs=request.getSession();
   int quid=Integer.parseInt(hs.getAttribute("qid").toString());
   HttpSession session=request.getSession();
   String expid=session.getAttribute("uid").toString();
   int techid=Integer.parseInt(session.getAttribute("exptechid").toString());
   
 try
 {
  Class.forName("com.mysql.jdbc.Driver");
      Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/techforum?zeroDateTimeBehavior=convertToNull","Vinay","vinay.123");
     PreparedStatement ps=conn.prepareStatement
        ("Insert Into answertbl(ans,qid,expid,techid)Values(?,?,?,?)");
     ps.setString(1, ans);
     ps.setInt(2, quid);
     ps.setString(3, expid);
     ps.setInt(4, techid);
     int k=ps.executeUpdate();
     if(k>0)
     {
     response.sendRedirect("ViewQueriesServlet");
     }
     else{
     out.println("Answer Not Posted");
     }
 }catch(Exception ex)
 {
 out.println(ex.getMessage());
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
