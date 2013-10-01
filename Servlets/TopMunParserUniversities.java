import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;


public class TopMunParserUniversities extends HttpServlet implements Runnable {



Connection con;
Thread searcher;

       public void init(ServletConfig config) throws ServletException {
    super.init(config);                 
    searcher = new Thread(this);
    searcher.setPriority(Thread.MIN_PRIORITY);  
    searcher.start();

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




        public void run() {


  }


    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {


String[] names={
"ellhniko anoixto","eqniko kai kapodistriako","e.p.i. iwanninwn","dieqnes ellados","dhmokriteio qrakhs","gewponiko aqhnwn","aristoteleio qessalonikhs","ionio","dytikhs elladas","etaireia ajiopoihshs kai diaxeirishs perioysias toy dhmokritoy qrakhs",
"xarokopeio","tameio dioikishs diaxeirhshs panepisthmiakwn daswn","tameio dioikishs diaxeirhshs agrokthmatos aristoteleioy qessalonikhs","panteio","stereas elladas","pelloponhsoy","peiraiws","patrwn","makedonias","krhths",
"iwanninwn","qessalias","dytikhs makedonias","aigaioy","oikonomiko aqhnwn","ereunhtiko panepisthmiako instiroyto systhmatwn epikoinwniwn kai ypologistwn","panepisthmiakh foititikh lesxh a.p.q."};

Integer[] uids={
99203044, 99203020, 99202996, 99202922, 99202868, 99202112, 99202041, 99202011, 53926, 99201185,
99219608, 99219528, 99219525, 99206927, 99206925, 99206924, 99206922, 99206920, 99206919, 99206917,
99206915, 99206913, 99206912, 99206911, 99206861, 50166, 50089};


        while (true) {                      //FOREVER

int[] costs = new int[27];
int sqlcount=0;
int tagval=0;
int orgcount=0;
int tagcount=0;
int countglobal=0;
int sum=0;
InputStream is  = null;
int from=1;
int total=0;
Date today = new Date();


SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        String datefrom=sdf.format(today);
        String s1;
        Date date;
        Format formatter;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        s1 = formatter.format(date);
        String dateto=s1;

  try {
     do{
is = new URL("http://opendata.diavgeia.gov.gr/api/decisions?output=json&datefrom="+datefrom+"&type=27&from="+from+"&order=asc").openStream();

        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        StringBuilder sb = new StringBuilder();

int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
                                       }

        String jtext=sb.toString();

        try {

            JSONObject json = new JSONObject(jtext);
            JSONObject root = json.getJSONObject("model");
            JSONObject queryinfo = root.getJSONObject("queryInfo");
            total=queryinfo.getInt("total");
            Integer count=queryinfo.getInt("count");
            countglobal=count;

org.json.JSONArray desicions = root.getJSONArray("decisions");
int size = desicions.length();
ArrayList<JSONObject> aboutdesicions = new ArrayList<JSONObject>();

            for (int i = 0; i < size; i++) {
                JSONObject arrays = desicions.getJSONObject(i);
                aboutdesicions.add(arrays);
                                            }

JSONObject[] jsons = new JSONObject[aboutdesicions.size()];
aboutdesicions.toArray(jsons);

            for (int i = 0; i < aboutdesicions.size(); i++) {

                String organizationId = jsons[i].getJSONObject("metadata").getString("organizationId");
                String tag = jsons[i].getJSONObject("metadata").getJSONObject("tags").getString("tagId");
                tag=tag.substring(1,tag.length()-1);

                if(tag.contains(",")){

                    int pos=tag.indexOf(",");
                    tag=tag.substring(0,pos);

                                     }

 if(!(tag.equals(""))){
                 tagval=Integer.parseInt(tag);
                }


String checkfornull=jsons[i].getJSONObject("metadata").getString("extraFields");
if(!(checkfornull.equals("null"))){
org.json.JSONArray extrafield= jsons[i].getJSONObject("metadata").getJSONObject("extraFields").getJSONArray("extraField");

int size2 = extrafield.length();

ArrayList<JSONObject> aboutextrafield = new ArrayList<JSONObject>();

                for (int m = 0; m < size2; m++) {
                JSONObject arrays2 = extrafield.getJSONObject(m);
                aboutextrafield.add(arrays2);
                                                }
                JSONObject[] jsons2 = new JSONObject[aboutextrafield.size()];
                aboutextrafield.toArray(jsons2);

                for (int l = 0; l < aboutextrafield.size(); l++) {
                String name = jsons2[l].getString("name");
                String value = jsons2[l].getString("value");

                if (name.equals("poso_dapanis")){


                        if(value.contains(",")){

                            String akeraio=value.split(",")[0];
                            do{
                            if(akeraio.charAt(0)==' '){

                                akeraio=akeraio.substring(1,akeraio.length());

                            }
                            }while(akeraio.charAt(0)==' ');
                            String[] temp = akeraio.split("\\.");
                            String poso="";
                                  for(int q =0; q < temp.length ; q++){

                                      poso=poso.concat(temp[q]);

                                                                      }

                            int sum1=Integer.parseInt(poso);
                            int orgid=Integer.parseInt(organizationId);
                            for(orgcount=0;orgcount<27;orgcount++){
                            if(orgid==uids[orgcount]){costs[orgcount]=costs[orgcount]+sum1;break;}
                                                                    }







                                                 }
               else if(value.isEmpty()){



                                        }

               else if(value.equals(" ")){
                                sum=sum+0;

                                          }
               else if(value.equals("  ")){


                                          }
               else if(value.contains("   ")){


                                          }

               else{
                        do{
                            if(value.charAt(0)==' '){

                                value=value.substring(1,value.length());

                                                    }
                        }while(value.charAt(0)==' ');
                                 value=value.split(" ")[0];
                            String[] temp2 = value.split("\\.");
                            String poso2="";
                            if(temp2[temp2.length-1].length()==2){
                                poso2=temp2[0];


                            }
                            else{
                                for(int s =0; s < temp2.length ; s++){

                                     poso2=poso2.concat(temp2[s]);

                                                                     }
                            }

                              int sum2=Integer.parseInt(poso2);
                              int orgid=Integer.parseInt(organizationId);
                            for(orgcount=0;orgcount<27;orgcount++){
                            if(orgid==uids[orgcount]){costs[orgcount]=costs[orgcount]+sum2;break;}

                                                                   }


                      }
                     }
                    }
                   }
                  }







        } catch (ParseException ex) {

        }


if(countglobal==500){
       from=from+500;
                    }

}while(countglobal==500);

 } finally {

      is.close();
    }



         if (con!=null) {
            try {
                Statement stmt = con.createStatement();
                Statement stmt1 = con.createStatement();
                  ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM topmununiv");
                  while(rs.next()){




    if(costs[sqlcount]>0){
        int cost=rs.getInt(2);
        int souma=cost+costs[sqlcount];

        int updateCount2 = stmt1.executeUpdate(
            "UPDATE topmununiv SET cost ='"+souma+"' WHERE mun='"+names[sqlcount]+"';");
    }
    sqlcount++;

                }





            }
            catch(SQLException e) {

                log("SQL eksairesh", e);
                }
        }
        else {


            }

 try {
  searcher.sleep(86400000);
 }
  catch (InterruptedException ignored) { }
  }




    }




}
