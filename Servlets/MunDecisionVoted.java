import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;






public class MunDecisionVoted extends HttpServlet {

Connection con;

       public void init() {

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/moufas?user=uth&password=cangetin&"+
"useUnicode=true&characterEncoding=ISO-8859-7");
            }
        catch (ClassNotFoundException e) {
            log("Couldn't find mm.mysql driver");
            }
        catch (SQLException e) {
            log("SQL Exception while connecting to MySQL", e);
            }
    }





    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        Integer count=0;

        String ada = req.getParameter("ada");
        String dap = req.getParameter("dap");
        String sub = req.getParameter("sub");

         if (con!=null) {
            try {
                Statement stmt = con.createStatement();

                 ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM desicions WHERE ada =('"+ada+"');");

                        if(rs.next())
                        {
count=rs.getInt(2);
count++;


                     int updateCount2 = stmt.executeUpdate(
"UPDATE desicions SET votes ='"+count+"' WHERE ada='"+ada+"';");
 res.getWriter().write("OK");
                }
                        else{

                        int updateCount = stmt.executeUpdate(
"INSERT INTO desicions VALUES ('"+ada+"',1,'"+dap+"','"+sub+"');");
                         res.getWriter().write("OK");
                        }






            }
            catch(SQLException e) {
                 res.getWriter().write("ERROR");
                log("SQL eksairesh", e);
                }
        }
        else {
             res.getWriter().write("ERROR");

            }

    }




}
