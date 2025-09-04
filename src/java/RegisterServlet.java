import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.*;  
import javax.servlet.*;  
import java.io.*;  
public class RegisterServlet extends HttpServlet{  
public void doPost(HttpServletRequest req,HttpServletResponse res)  throws ServletException,IOException  
{  
String s1=req.getParameter("name");   
String s2=req.getParameter("uname");  
String s3=req.getParameter("pwd");   
String s4=req.getParameter("rpwd"); 
String s5=req.getParameter("gen");   
String s6=req.getParameter("phno");
String s7=req.getParameter("email"); 
res.setContentType("text/html");//setting the content type  
PrintWriter pw=res.getWriter();//get the stream to write the data  
 try
 {  
            
Class.forName("com.mysql.jdbc.Driver");  

Connection con=DriverManager.getConnection("jdbc:mysql://localhost/it","root","");  
Statement st=con.createStatement();
req.getRequestDispatcher("link.html").include(req, res); 
int insert = st.executeUpdate("insert into bk_logins values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')");
 }
 catch(Exception e)
 { 
     System.out.println(e);
 }  
pw.println("<body style=\"background-color: red;  background-image: linear-gradient(to bottom right, red, violet); color:white;\">");
pw.println("<big><h1><center>!..You have Successfully registered..!</h1></center></big>"); 
  
pw.close();//closing the stream  
}
}