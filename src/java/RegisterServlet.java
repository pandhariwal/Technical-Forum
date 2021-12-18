
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class RegisterServlet extends HttpServlet 
{
 
    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
            throws ServletException, IOException
    {
     
       PrintWriter out = response.getWriter();
       String uid=request.getParameter("tbuid");
       String upass=request.getParameter("tbupass");
       String fname=request.getParameter("tbfname");
       int utype=Integer.parseInt(request.getParameter("comboutype"));
       int exptechid=Integer.parseInt(request.getParameter("combotech"));
       String city=request.getParameter("combocity");
       try
       {
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/techforum?zeroDateTimeBehavior=convertToNull","Vinay","vinay.123");
           
           PreparedStatement ps=conn.prepareStatement
             ("Insert Into userstbl(uid,upass,fname,utype,city,exptechid)"
                     + "Values(?,?,?,?,?,?)");
           ps.setString(1, uid);
           ps.setString(2, upass);
           ps.setString(3, fname);
           ps.setInt(4, utype);
           ps.setString(5, city);
           ps.setInt(6, exptechid);
           int k=ps.executeUpdate();
           if(k>0)
           {
           out.println("Registration Successfull...");
           response.sendRedirect("Login.html");
           }
           else
           {
           out.println("Registration Failed");
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
