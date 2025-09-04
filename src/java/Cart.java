import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Blob;
import javax.servlet.http.*;  
import javax.servlet.*;  
import java.io.*;
import java.util.Base64;
 
public class Cart extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        RequestDispatcher rd = req.getRequestDispatcher("link.html");
        rd.include(req, res);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/it", "root", "");
            Statement st = con.createStatement();

            pw.println("<body style=\"background-color: violet;  background-image: linear-gradient(to bottom right, red, violet); color:white;\">");
            HttpSession session = req.getSession(false);

            if (session != null) {
                String uname = (String) session.getAttribute("uname");
                ResultSet rs = st.executeQuery("SELECT * FROM Cart where uname='" + uname + "'");

                pw.println("<title>DK Book Store | Cart</title><big><center><h1 style=\"color:smokewhite;\">!....Your Cart....!</h1></center></big><br>");
                pw.println("<link rel=\"stylesheet\" href=\"Style.html\"> ");

                while (rs.next()) {
                    pw.println("<div  style=\"font-family:times;\" class=\"row\">");
                    pw.println("<div  class=\"column\" style='background-color: rgba(255, 255, 255, 0.5); padding : 25px 50px 50px 50px;'><div class=\"card\">");

                    // Retrieve the image Blob from the result set
                    Blob imageBlob = rs.getBlob("B_img");

                    if (imageBlob != null) {
                        // Convert Blob to byte array
                        byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
                        // Convert byte array to Base64 encoded string
                        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                        // Embed the Base64 encoded image in the HTML page
                        pw.println("<img style='height:250px; width:175px; float:right;' src='data:image/jpeg;base64," + base64Image + "'>");
                    } else {
                        // If imageBlob is null, display a placeholder or default image
                        pw.println("<img style='height:250px; width:175px; float:right;' src='placeholder_image_url'>");
                    }

                    pw.println("<h3></h3>");
                    pw.println("<h3>Title of the Book: &ensp;" + rs.getString(4) + "</h3>");
                    pw.println("<h3><b>Paper Back</h3>");
                    pw.println("<h2> &#8377;" + rs.getFloat(3) + " Rs</h2></b>");
                    pw.println("<h4>Eligible for FREE Shipping</h4>");
                    pw.println("<h4 style='color:green;'>In Stock</h4>");
                    pw.println("<h4>Sold by Amrtha Book Stores</h4>");
                    pw.println("</div>");
                    pw.println("</div>");
                    pw.println("</div>");
                }
            } else {
                pw.print("<h3><center>Please login first!</center></h3>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }
}
