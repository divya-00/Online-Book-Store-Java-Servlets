import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
public class LogoutServlet extends HttpServlet {  
        protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                                throws ServletException, IOException {  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
              
            request.getRequestDispatcher("link.html").include(request, response);  
              
            HttpSession session=request.getSession();  
            session.invalidate();  
            out.print("<title>DK Book Store | Logout </title><body style=\"background-color: violet;  background-image: linear-gradient(to bottom right, red, violet); color:white;\">");  
            out.print("<h1><center>You are successfully logged out!</center></h1>");  
              
            out.close();  
    }  
}  