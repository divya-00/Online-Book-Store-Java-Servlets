import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.*;  
import javax.servlet.*;  
import java.io.*;  
public class Profile extends HttpServlet{  
public void doGet(HttpServletRequest req,HttpServletResponse res)  throws ServletException,IOException  
{ 
res.setContentType("text/html");//setting the content type  
PrintWriter pw=res.getWriter();//get the stream to write the data  
RequestDispatcher rd=req.getRequestDispatcher("link.html");  
rd.include(req, res); 
 try
 {  
            
Class.forName("com.mysql.jdbc.Driver");  

Connection con=DriverManager.getConnection("jdbc:mysql://localhost/it","root","");  
Statement st=con.createStatement();

HttpSession session = req.getSession(false);
if(session!= null)
{
    String uname=(String)session.getAttribute("uname");
    ResultSet rs = st.executeQuery("SELECT * FROM bk_logins where uname='"+uname+"'");   

 while (rs.next()) 
 {
    pw.println("<title> DK Book store | Profile</title><body style=\"background-color: violet;  background-image: linear-gradient(to bottom right, red, violet); color:white;\">");
    pw.println("<big><center><h1 style=\"color:smokewhite;\">!....Hi "+rs.getString(1)+"....!</h1></center></big>");
    pw.println("<h1 style=\"color:smokewhite;\">The details of the user are</h1>");
    pw.println("<ul style=\"list-style:none;\">"); 
    pw.println("<h2><li>Name : "+rs.getString(1));
    pw.println("<li>Username : "+rs.getString(2));
    pw.println("<li>Gender : "+rs.getString(5));
    pw.println("<li>Phone Number : "+rs.getString(6));
    pw.println("<li>Email id : "+rs.getString(7)+"</h2>");
 }
}

else
{
    pw.print("<h3>Please login first!</h3>"); 
 rd=req.getRequestDispatcher("/Login.html");  
rd.include(req, res); 
}
 
pw.close();//closing the stream  
}
catch(Exception e)
 { 
     System.out.println(e);
 }
   
}
}

