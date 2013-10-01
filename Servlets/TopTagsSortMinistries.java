import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;






public class TopTagsSortMinistries extends HttpServlet {

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


        String[] tag=new String[593];
        int[] poso=new int[593];
        Integer count=0;

         if (con!=null) {
            try {
                Statement stmt = con.createStatement();

                 ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM toptagsmini ");

                        while(rs.next())
                        {

                            tag[count]=rs.getString(1);
                            poso[count]=rs.getInt(2);
                           count++;

                }


   int n = count;
    for (int pass=1; pass < n; pass++) {

        for (int i=0; i < n-pass; i++) {
            if (poso[i] < poso[i+1]) {

                int temp = poso[i];  poso[i] = poso[i+1];  poso[i+1] = temp;
                String temp2=tag[i]; tag[i]=tag[i+1]; tag[i+1]=temp2;
            }
        }
    }



  res.getWriter().write(tag[0]+"@"+poso[0]+"#"+tag[1]+"$"+poso[1]+"%"+tag[2]+"^"+poso[2]+"&"+tag[3]+"*"+poso[3]+"("+tag[4]+"!"+poso[4]);


            }
            catch(SQLException e) {
                 //res.getWriter().write("ERROR");
                log("SQL eksairesh", e);
                }
        }
        else {
            // res.getWriter().write("ERROR");

            }







    }




}
