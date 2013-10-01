import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;






public class TopDecisionsSortMinistries extends HttpServlet {

Connection con;

       public void init() {

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/moufas?user=root&password=root&"+
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


        String[] ada=new String[1000000];
        String[] title=new String[1000000];
        int[] cost=new int[1000000];
        int[] votes=new int[1000000];
        Integer count=0;

         if (con!=null) {
            try {
                Statement stmt = con.createStatement();

                 ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM desicionsmini ");

                        while(rs.next())
                        {

                            ada[count]=rs.getString(1);
                            votes[count]=rs.getInt(2);
                            cost[count]=rs.getInt(3);
                            title[count]=rs.getString(4);

                           count++;

                }


   int n = count;
    for (int pass=1; pass < n; pass++) {

        for (int i=0; i < n-pass; i++) {
            if (votes[i] < votes[i+1]) {

                int temp = votes[i];  votes[i] = votes[i+1];  votes[i+1] = temp;
                String temp2=ada[i]; ada[i]=ada[i+1]; ada[i+1]=temp2;
                    temp = cost[i];  cost[i] = cost[i+1];  cost[i+1] = temp;
                       temp2=title[i]; title[i]=title[i+1]; title[i+1]=temp2;
            }
        }
    }



  res.getWriter().write(ada[0]+"@"+cost[0]+"@@"+title[0]+"@@@"+ada[1]+"@@@@"+cost[1]+"@@@@@"+title[1]+"@@@@@@"+ada[2]+"@@@@@@@"+cost[2]+"@@@@@@@@"+title[2]+"@@@@@@@@@"+ada[3]+"@@@@@@@@@@"+cost[3]+"@@@@@@@@@@@"+title[3]+"@@@@@@@@@@@@"+ada[4]+"@@@@@@@@@@@@@"+cost[4]+"@@@@@@@@@@@@@@"+title[4]+"@@@@@@@@@@@@@@@");


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
