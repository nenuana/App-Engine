package database;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

@SuppressWarnings("serial")
public class database2 extends HttpServlet{
    
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      // JDBC driver name and database URL
       final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
       final String DB_URL="jdbc:mysql://localhost/google_dash";

      //  Database credentials
       final String USER = "root";
       final String PASS = "Window2807";
   
      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType =
        "<!doctype html public \"-//w3c//dtd html 4.0 " +
         "transitional//en\">\n";
         out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n" +
         "<body bgcolor=\"#f0f0f0\">\n" +
         "<h1 align=\"center\">" + title + "</h1>\n");
         
  
      try{
         // Register JDBC driver
         Class.forName(JDBC_DRIVER);

         // Open a connection
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
         out.println("Connection succes");
         // Execute SQL query
         Statement stmt = conn.createStatement();

         String sql;
         sql = "SELECT report_date, gmail_num_inbound_spam_emails FROM customer_usage_data";
         ResultSet rs = stmt.executeQuery(sql);
         out.println("Connection succes sql");
         // Extract data from result set
         while(rs.next()){
            //Retrieve by column name
            int report  = rs.getInt("report_date");
            int gm = rs.getInt("gmail_num_inbound_spam_emails");
          
            //Display values
            out.println("Report: " + report + "<br>");
            out.println("Gmail: " + gm + "<br>");
            // response.sendRedirect("test.jsp");
           
         }
         out.println("</body></html>");

         // Clean-up environment
         rs.close();
         stmt.close();
         conn.close();
      }catch(SQLException se){
         //Handle errors for JDBC
         se.printStackTrace();
         out.println("Connection error1");
      }catch(Exception e){
         //Handle errors for Class.forName
         e.printStackTrace();
         out.println("Connection error");
      }
   }
}