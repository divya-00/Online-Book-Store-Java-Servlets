import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.*;  
import javax.servlet.*;  
import java.io.*;  
public class LoginServlet extends HttpServlet{  
public void doPost(HttpServletRequest req,HttpServletResponse res)  throws ServletException,IOException  
{  
String uname=req.getParameter("uname");   
String s2=req.getParameter("pwd");
String s3;
String s4;
res.setContentType("text/html");//setting the content type  
PrintWriter pw=res.getWriter();//get the stream to write the data  
int flag=0;
 try
 {  
            
Class.forName("com.mysql.jdbc.Driver");  

Connection con=DriverManager.getConnection("jdbc:mysql://localhost/it","root","");  
Statement st=con.createStatement();

ResultSet rs = st.executeQuery("SELECT uname,pwd FROM bk_logins");

 while (rs.next()) 
 {
    s3 =  rs.getString("uname");
    s4 =  rs.getString("pwd");
 

if((uname.equals(s3)) && (s2.equals(s4)))
{  
 flag=flag+1;
}  
else{  
 flag=flag;
}  
}   
if(flag==1)
{  
    HttpSession session = req.getSession ();
session.setAttribute("uname",uname);
  RequestDispatcher rd=req.getRequestDispatcher("/Valid.html");  
rd.forward(req, res); 


}  
else
{  
pw.print("<h3 style=\"color:purple;\">Sorry UserName or Password Error!</h3>"); 
 RequestDispatcher rd=req.getRequestDispatcher("/Login.html");  
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


