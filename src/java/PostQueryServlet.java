import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;
import java.util.*;

public class PostQueryServlet extends HttpServlet 
{


 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
  response.setContentType("text/html;charset=UTF-8");
  try (PrintWriter out = response.getWriter()) {   
   
   out.println("<!DOCTYPE html>");
   out.println("<html>");
   out.println("<head>");
     out.println("<link href='https://fonts.googleapis.com/css?family=Merienda+One' rel='stylesheet'>");
out.println("<link rel='stylesheet' href='https://fonts.googleapis.com/icon?family=Material+Icons'>");
out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>");
out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script>");
out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
out.println("<link href='abc.png' rel='shortcut icon' type='image/png'>");
   out.println("<style type='text/css'>");
   out.println("body{		background: #eeeeee; font-family: 'Varela Round', sans-serif;	}");
out.println("    .form-inline {        display: inline-block;    }	.navbar-header.col {		padding: 0 !important;	}		.navbar {				background: #fff;		padding-left: 16px;		padding-right: 16px;		border-bottom: 1px solid #d6d6d6;		box-shadow: 0 0 4px rgba(0,0,0,.1);	}	.nav-link img {		border-radius: 50%;		width: 36px;		height: 36px;		margin: -8px 0;		float: left;		margin-right: 10px;	}	.navbar .navbar-brand {		color: #555;		padding-left: 0;		padding-right: 10px; padding-bottom:20px;		font-family: 'Merienda One', sans-serif;	}	.navbar .navbar-brand i {		font-size: 20px;		margin-right: 5px; padding-bottom:20px;	}	.navbar .nav-item i {		font-size: 18px;	}	.navbar .dropdown-item i {		font-size: 16px;		min-width: 22px;	}	.navbar .nav-item.open > a {		background: none !important;	}	.navbar .dropdown-menu {		border-radius: 1px;		border-color: #e5e5e5;		box-shadow: 0 2px 8px rgba(0,0,0,.05);	}	.navbar .dropdown-menu li a {		color: #777;		padding: 8px 20px;		line-height: normal;	}	.navbar .dropdown-menu li a:hover, .navbar .dropdown-menu li a:active {		color: #333;	}		.navbar .dropdown-item .material-icons {		font-size: 21px;		line-height: 16px;		vertical-align: middle;		margin-top: -2px;	}	.navbar .badge {		background: #f44336;		font-size: 11px;		border-radius: 20px;		position: absolute;		min-width: 10px;		padding: 4px 6px 0;		min-height: 18px;		top: 5px;	}	.navbar .active a, .navbar .active a:hover, .navbar .active a:focus {		background: transparent !important;	}	@media (min-width: 1200px){		.form-inline .input-group {			width: 300px;			margin-left: 30px;		}	}	@media (max-width: 1199px){		.form-inline {			display: block;			margin-bottom: 10px;		}		.input-group {			width: 100%;		}  .container { height:auto;\n" +
"	width:90%;\n" +
"	margin:auto;	}</style>");
 
   out.println("<title>PostQueryServlet</title>");   
   out.println("</head>");
   out.println("<body>");
   
      HttpSession session=request.getSession();

out.println("<nav class='navbar navbar-default navbar-expand-xl navbar-light'>");
out.println("	<div class='navbar-header d-flex col'>");
out.println("		<a class='navbar-brand' href='#'><i><image src='abc1.png' width=35px height=35px></image><image src='abc2.png' width=200px height=35px></image></i></a>  		");

out.println("	</div>");

out.println("	<div id='navbarCollapse' class='collapse navbar-collapse justify-content-start'>");
out.println("		<ul class='nav navbar-nav'>");
int p=Integer.parseInt(session.getAttribute("utype").toString());
if(p==1)
{
out.println("			<li class='nav-item active'><a href='ExpertHomeServlet' class='nav-link'>Home</a></li>");
out.println("			<li class='nav-item'><a href='PostQueryServlet' class='nav-link'>Post Query</a></li>");
out.println("			<li class='nav-item'><a href='SearchServlet' class='nav-link'>Search Query</a></li>");
out.println("			<li class='nav-item'><a href='ViewQueriesServlet' class='nav-link'>Answer Query</a></li>");
}
else if(p==2)
{
out.println("			<li class='nav-item active'><a href='UserHomeServlet' class='nav-link'>Home</a></li>");    
out.println("			<li class='nav-item'><a href='PostQueryServlet' class='nav-link'>Post Query</a></li>");
out.println("			<li class='nav-item'><a href='SearchServlet' class='nav-link'>Search Query</a></li>");
}
out.println("		</ul>");

out.println("		<ul class='nav navbar-nav navbar-right ml-auto'>");
out.println("			<li class='nav-item dropdown'>");
out.println("				<a href='#' data-toggle='dropdown' class='nav-link dropdown-toggle user-action'><image src='admin.jpg' width=35px height=35px></image>"+session.getAttribute("fname")+ "<b class='caret'></b></a>");
out.println("				<ul class='dropdown-menu'>");
out.println("					<li><a href='ProfileServlet' class='dropdown-item'><i class='fa fa-user-o'></i> Profile</a></li>");
					
out.println("					<li><a href='SettingServlet' class='dropdown-item'><i class='fa fa-sliders'></i> Settings</a></li>");
out.println("					<li class='divider dropdown-divider'></li>");
out.println("					<li><a href='Logout.html' class='dropdown-item'><i class='material-icons'>&#xE8AC;</i> Logout</a></li>");
    
out.println("				</ul>");
out.println("			</li>");
out.println("		</ul>");
out.println("	</div>");
out.println("</nav>");
 

out.println("<div class='container'>");
out.println("<div class='well'>");
out.println("<center>");
   out.println("<form method='get' action='PostQueryServlet'>");
   out.println("<table border='1'>");
   out.println("<tr>");
   out.println("<td>Select Technology");
   out.println("</td>");
   out.println("<td>");
   out.println("<Select name='seltech'>");
   out.println("<option value='0'>Select Technology</option>");
   out.println("<option value='1'>Java</option>");
   out.println("<option value='2'>ASP</option>");
   out.println("<option value='3'>C</option>");
   out.println("<option value='4'>CPP</option>");
   out.println("<option value='5'>Haddop</option>");
   out.println("<option value='6'>Python</option>");
   out.println("</Select>");
   out.println("</td>");
   out.println("</tr>");
   
   out.println("<tr>");
   out.println("<td>Query");
   out.println("</td>");   
   out.println("<td>");
   out.println("<textarea name='qtarea'>");   
   out.println("</textarea>");
   out.println("</td>");
   out.println("</tr>");
   
   
      out.println("<tr>");
      out.println("<td></td>");
      out.println("<td>");
      out.println("<input type='submit' name='btnpost' value='Post'>");
      out.println("</input>");
      out.println("</td>");
      out.println("</tr>");      
      out.println("</table>");
      
      int techid=Integer.parseInt(request.getParameter("seltech"));
      String query=request.getParameter("qtarea");
   
      String uid=session.getAttribute("uid").toString();
      java.util.Date   d=new java.util.Date();
      java.sql.Date dt=new java.sql.Date(d.getTime());
      try
      {
      Class.forName("com.mysql.jdbc.Driver");
      Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/techforum?zeroDateTimeBehavior=convertToNull","Vinay","vinay.123");
      PreparedStatement ps=conn.prepareStatement
        ("Insert Into queriestbl(techid,query,uid,qdate)Values(?,?,?,?)");
      ps.setInt(1, techid);
      ps.setString(2, query);
      ps.setString(3, uid);
      ps.setDate(4, dt);
      int k=ps.executeUpdate();
      if(k>0)
      {
          
        response.sendRedirect("QpostSuccessServlet");
       
      }else
      {
      
out.println("<div id='myModal' >");
out.println("    <div class='alert alert-warning alert-dismissible' role='alert'>");
  out.println("<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>");
  out.println("<strong>Sorry!</strong> Query Not posted.. try again..");
out.println("</div>");
    
      }     
      
      }catch(Exception ex)
      {
      out.println(ex.getMessage());
      }      
              
   out.println("</form>");
   out.println("</center>");
   out.println("</div>");
   out.println("</div>");
out.println("<footer class='page-footer font-small blue'>");

  
     out.println("<div class='footer-copyright text-center py-3'>© 2018 Copyright:");
     out.println("  Vinay Pandhariwal");
     out.println("</div>");
  

   out.println("</footer>");
   
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
