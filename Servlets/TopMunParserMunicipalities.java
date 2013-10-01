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








public class TopMunParserMunicipalities extends HttpServlet implements Runnable {



Connection con;
Thread searcher;

       public void init(ServletConfig config) throws ServletException {
    super.init(config);                  // always!
    searcher = new Thread(this);
    searcher.setPriority(Thread.MIN_PRIORITY);  // be a good citizen
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





Integer[] uids={
 6142,6140,6139,6138,6137,6136,6135,6134,6133,6132,6131,
 6130,6129,6128,6127,6126,6125,6123,6122,6121,6120,
 6119,6118,6117,6116,6115,6114,6113,6112,6111,6110,
 6109,6107,6106,6105,6104,6103,6102,6101,6100,6098,
 6096,6094,6093,6091,6090,6089,6088,6087,6086,6085,
 6084,6083,6082,6081,6080,6079,6077,6076,6075,6073,
 6072,6070,6069,6068,6067,6066,6065,6064,6063,6062,
 6061,6060,6059,6058,6057,6055,6054,6053,6052,6051,
 6050,6049,6048,6047,6046,6044,6041,6040,6039,6038,
 6037,6036,6035,6034,6033,6032,6031,6030,6027,6026,
 6025,6024,6022,6021,6020,6018,6017,6014,6012,6011,
 6010,6009,6008,6007,6005,6004,6003,6002,6325,6324,
 6323,6322,6321,6319,6318,6316,6314,6312,6311,6310,
 6309,6308,6307,6306,6305,6304,6303,6302,6301,6299,
 6298,6297,6296,6295,6293,6292,6291,6290,6289,6288,
 6287,6286,6285,6284,6283,6282,6281,6280,6279,6278,
 6276,6275,6274,6272,6271,6270,6269,6268,6267,6266,
 6265,6263,6262,6260,6259,6258,6257,6256,6255,6254,
 6252,6249,6248,6247,6246,6245,6243,6242,6241,6240,
 6239,6238,6237,6236,6235,6234,6233,6232,6231,6230,
 6229,6227,6226,6225,6223,6220,6219,6218,6217,6216,
 6215,6214,6213,6212,6211,6209,6207,6206,6205,6204,
 6203,6202,6200,6199,6197,6196,6195,6193,6192,6189,
 6188,6187,6186,6185,6184,6183,6181,6179,6178,6177,
 6175,6174,6172,6171,6170,6169,6168,6167,6166,6165,
 6164,6163,6162,6161,6160,6159,6158,6157,6155,6154,
 6153,6152,6151,6150,6149,6148,6147,6146,6145,6144,6143

};

String[] names={
"katerinh","kassandra","kasos","karystos","karpenhsi","karpaqos","karditsa","kantanos","kalymnos","kalliqea",
"kalampaka","kalamata","kalamaria","kalavryta","kaisariani","kavala","iwannina","ilio","ikaria","iqaki",
"ios","mesologgi","ierapetra","iasmos","qhra","qives","qessalonikh","qermo","qermh","qermaikos",
"qasos","hrakleio attikhs","hlioypolh","hlida","hgoumenitsa","zwgrafou","zitsa","zhros","zaxarw","zakynqos",
"zagora","erymanqos","eretria","epidauros","emmanouil papa","argyroupolh","eleusina","elafonhsos","elassona","edessa",
"dwridos","dwdwnh","dytikh manh","axaia","drama","dojato","domokos","dirfyos","dios","dionysos",
"deskath","delfoi","ymhttos","grevena","gortynia","gortyna","glyfada","gewrgiou karaiskakh","gaudos","galatsi",
"vyrwna","vrilhssia","voreia tzoymerka","voreia kynouria","volos","volvh","visaltia","viannos","veroia","voxa",//Voxa swsta
"voula","axarnes","astypalaia","aspropyrgos","asterousio","arxaia olympia","arrianos","argiqea","apokorwno","anwgeia",
"antiparos","andros","andritsaina","andrabida","anafh","anatolikh manh","amfipolh","amfiloxia","amfikleia","amorgos",
"marousi","amari","Alonhsos","almyros","alimos","aliartos","alejandria","vonitsa","aigalew","agrinio",
"agrafa","agkistri","kamatero","agios eustratios","agios dhmhtrios","agia paraskeuh","agia varvara","agia","agaqonhsi","hrakleio",
"wrwpos","wraiokastro","filoqeh","jara","xersonhsos","xania","xalkh","xalandri","fylh","foyrnoi",
"folegandros","flwrina","filiates","filadelfeia","farsala","farkadona","faistos","ydra","tyrnavos","troizinia",
"tripolh","trikala","topeiros","thnos","thlos","tanagra","sfakia","syros","sumh","stylida",
"spetses","spata","sparth","sofades","soufli","souli","skyros","skydra","skopelos","skiathos",
"sifnos","kiato","sikinos","siqwnia","serres","serifos","servia","sarwnikos","samos","samoqrakh",
"salamina","rodos","reqymno","rafhna","pyrgos","pylos","pylh","xortiatis","kolindros","prosotsanh",
"prespes","poros","phneios","petroupolh","peristeri","perama","pentelh","peiraias","paulos melas","patra",
"patmos","paros","parga","paranesti","xolargos","pajoi","pallhnh","palamas","palaio falhro","paionias",
"paiania","paggaio","oropedi lasiqi","orestidos","orestiada","oinousses","janqh","phlio","notia kynouria","nisyros",
"nikolaos skoufas","nikaia","nestos","nestorio","nemea","nea smurnh","nea iwnia","neapolh","nauplio","naupaktos",
"naousa","najos","molos","mykonos","mykh","mosxato","monemvasia","agios nikolaos","mhlos","metsovo",
"megisth","megara","meganhsi","megalopolh","maroneia","markopoulo","marathwnas","mandra","makrakomh","peukh",
"loutraki","limnh plasthra","lhmnos","lesvos","leros","leija","livadeia","laurio","larisa","lamia",
"lagkadas","kws","kumh","kuqnos","kiqyra","kropia","korudallos","korinqos","kordelio","komothnh",
"kozanh","kissamos","kimolos","kilkis","kileler","kifisia","kefalonia","kerkyra","drapetswna","kentrika tzoumerka",
"kea","neurokopi"};


         while (true) {                      //FOREVER

int[] costs = new int[272];
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
                            for(orgcount=0;orgcount<272;orgcount++){
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
                            for(orgcount=0;orgcount<272;orgcount++){
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
                        "SELECT * FROM topmun");
                  while(rs.next()){




    if(costs[sqlcount]>0){
        int cost=rs.getInt(2);
        int souma=cost+costs[sqlcount];

        int updateCount2 = stmt1.executeUpdate(
            "UPDATE topmun SET cost ='"+souma+"' WHERE mun='"+names[sqlcount]+"';");
    }
    sqlcount++;

                }

//res.getWriter().write("OK");



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
