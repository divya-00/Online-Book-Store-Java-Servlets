import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.*;  
import javax.servlet.*;  
import java.io.*; 

public class Servlet12 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/it", "root", "");
            
            // Retrieve the username from session
            HttpSession session = req.getSession(false);
            if (session != null) {
                String uname = (String) session.getAttribute("uname");
                
                // Retrieve the image file as a byte array
                byte[] imageBytes = getImageBytes("C:\\Users\\Hp\\OneDrive\\Documents\\NetBeansProjects\\OnlineBookStore\\web\\Images\\Images\\12.jpg");
                
                // Prepare the SQL query with a parameter for the image data
                String sql = "INSERT INTO Cart VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, uname);
                ps.setInt(2, 12); // Assuming the quantity is 1
                ps.setInt(3, 249); // Assuming the price is 125
                ps.setString(4, "Dont Give Up"); // Assuming book name
                ps.setBytes(5, imageBytes); // Set the byte array as a parameter
                
                // Execute the SQL query
                int rowsInserted = ps.executeUpdate();
                if (rowsInserted > 0) {
                    String popoverScript = "<script>alert('Item added to the cart!');</script>";
                    pw.println(popoverScript);
                    RequestDispatcher rd=req.getRequestDispatcher("/index.html");  
                    rd.forward(req, res);
                } else {
                    String popoverScript = "<script>alert('Item not added to the cart due to some technical reasons :(');</script>";
                    pw.println(popoverScript);
                }
                
            } else {
                pw.println("<h3>Please login first!</h3>");
                RequestDispatcher rd = req.getRequestDispatcher("/Login.html");
                rd.include(req, res);
            }
            
            // Close resources
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }

    // Method to read the image file and return its byte array
    private byte[] getImageBytes(String imagePath) throws IOException {
        File file = new File(imagePath);
        byte[] imageBytes = new byte[(int) file.length()];
        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(imageBytes);
        }
        return imageBytes;
    }
}
