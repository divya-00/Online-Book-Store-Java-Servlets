import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.*;  
import javax.servlet.*;  
import java.io.*;  
public class Details extends HttpServlet{  
public void doPost(HttpServletRequest req,HttpServletResponse res)  throws ServletException,IOException  
{
String S=req.getParameter("uname"); 
res.setContentType("text/html");//setting the content type  
PrintWriter pw=res.getWriter();//get the stream to write the data  
 try
 {  
            
Class.forName("com.mysql.jdbc.Driver");  

Connection con=DriverManager.getConnection("jdbc:mysql://localhost/it","root","");  
Statement st=con.createStatement();

ResultSet rs = st.executeQuery("SELECT * FROM bk_logins where uname='"+S+"'");

 while (rs.next()) 
 {
    pw.println("<body bgcolor=\"lavender\">");
    pw.println("<big><center><h1 style=\"color:purple;\">!....Hi "+rs.getString(1)+"....!</h1></center></big>");
    pw.println("<h1 style=\"color:purple;\">The details of the user are</h1>");
    pw.println("<ul style=\"list-style:none;\">"); 
    pw.println("<h2><li>Name : "+rs.getString(1));
    pw.println("<li>Username : "+rs.getString(2));
    pw.println("<li>Gender : "+rs.getString(5));
    pw.println("<li>Phone Number : "+rs.getString(6));
    pw.println("<li>Email id : "+rs.getString(7)+"</h2>");
 }
 
pw.close();//closing the stream  
}
catch(Exception e)
 { 
     System.out.println(e);
 }
   
}
}