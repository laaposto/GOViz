import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONObject;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;
import java.util.*;
import java.text.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


@WebServlet(name = "InnerMunDateParser", urlPatterns = {"/InnerMunDateParser"})
public class InnerMunDateParser extends HttpServlet {




 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

int[] costs = new int[1000];
int[] dap = new int[90000];
String doc[] = new String[90000];
String subjectarray[]=new String[90000];
int subcount=0;

int date=0;
int p=0;
int f=0;

String[] dates=new String[1000];
for(date=0;date<1000;date++){
dates[date]="null";
}

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



int found=0;
int it=0;
int org=0;
int countglobal=0;
int orgcount;
int sum=0;

String datefrom=request.getParameter("datefrom");
String dateto=request.getParameter("dateto");
String mun=request.getParameter("mun");
String mymun=mun.replaceAll("%20"," ");

for (it=0; it<272;it++){
if (mymun.equals(names[it])){

    org=uids[it];

}
}


InputStream is  = null;

int takis=1;
int total=0;


  try {
     do{

is = new URL("http://opendata.diavgeia.gov.gr/api/decisions?output=json&datefrom="+datefrom+"&dateto="+dateto+"&org="+org+"&type=27&from="+takis+"&order=asc").openStream();


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
String subject = jsons[i].getJSONObject("metadata").getString("subject");
                Long submission = jsons[i].getLong("submissionTimestamp");

                DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(submission);
                String sub=formatter.format(calendar.getTime());

                for(date=0;date<1000;date++){
        if(sub.equals(dates[date])){
found=1;
  break;



                                    }


}
 if(found==0){

 for(date=0;date<1000;date++){
        if(dates[date].equals("null")){

 dates[date]=sub;
break;


                                    }


}

 }
                 found=0;

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

for(orgcount=0;orgcount<1000;orgcount++){
                            if(sub.equals(dates[orgcount])){costs[orgcount]=costs[orgcount]+sum1; break;}


                            }
                              dap[f]=sum1;
                              f++;



                                                 }
               else if(value.isEmpty()){

                            sum=sum+0;

                                        }

               else if(value.equals(" ")){
                                sum=sum+0;

                                          }
               else if(value.equals("  ")){
                                sum=sum+0;

                                          }
               else if(value.contains("   ")){
                                sum=sum+0;

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
                              dap[f]=sum2;
                              f++;

  for(orgcount=0;orgcount<1000;orgcount++){
                            if(sub.equals(dates[orgcount])){costs[orgcount]=costs[orgcount]+sum2; break;}


                            }

                    }

                    }

                                                                 }

                }

                String documenturl = jsons[i].getString("documentUrl");
                 documenturl=documenturl.replaceAll("Α","a");
                 documenturl=documenturl.replaceAll("Β","b");
                 documenturl=documenturl.replaceAll("Γ","g");
                 documenturl=documenturl.replaceAll("Δ","d");
                 documenturl=documenturl.replaceAll("Ε","e");
                 documenturl=documenturl.replaceAll("Ζ","z");
                 documenturl=documenturl.replaceAll("Η","h");
                 documenturl=documenturl.replaceAll("Θ","q");
                 documenturl=documenturl.replaceAll("Ι","i");
                 documenturl=documenturl.replaceAll("Κ","k");
                 documenturl=documenturl.replaceAll("Λ","l");
                 documenturl=documenturl.replaceAll("Μ","m");
                 documenturl=documenturl.replaceAll("Ν","n");
                 documenturl=documenturl.replaceAll("Ξ","j");
                 documenturl=documenturl.replaceAll("Ο","o");
                 documenturl=documenturl.replaceAll("Π","p");
                 documenturl=documenturl.replaceAll("Ρ","r");
                 documenturl=documenturl.replaceAll("Σ","s");
                 documenturl=documenturl.replaceAll("Τ","t");
                 documenturl=documenturl.replaceAll("Υ","y");
                 documenturl=documenturl.replaceAll("Χ","x");
                 documenturl=documenturl.replaceAll("Φ","f");
                 documenturl=documenturl.replaceAll("Ψ","c");
                 documenturl=documenturl.replaceAll("Ω","w");

                 subject=subject.replaceAll("Α","a");
                 subject=subject.replaceAll("Β","b");
                 subject=subject.replaceAll("Γ","g");
                 subject=subject.replaceAll("Δ","d");
                 subject=subject.replaceAll("Ε","e");
                 subject=subject.replaceAll("Ζ","z");
                 subject=subject.replaceAll("Η","h");
                 subject=subject.replaceAll("Θ","q");
                 subject=subject.replaceAll("Ι","i");
                 subject=subject.replaceAll("Κ","k");
                 subject=subject.replaceAll("Λ","l");
                 subject=subject.replaceAll("Μ","m");
                 subject=subject.replaceAll("Ν","n");
                 subject=subject.replaceAll("Ξ","j");
                 subject=subject.replaceAll("Ο","o");
                 subject=subject.replaceAll("Π","p");
                 subject=subject.replaceAll("Ρ","r");
                 subject=subject.replaceAll("Σ","s");
                 subject=subject.replaceAll("Τ","t");
                 subject=subject.replaceAll("Υ","y");
                 subject=subject.replaceAll("Χ","x");
                 subject=subject.replaceAll("Φ","f");
                 subject=subject.replaceAll("Ψ","c");
                 subject=subject.replaceAll("Ω","w");

                 doc[p]=documenturl;
p++;

subjectarray[subcount]=subject;
                 subcount++;

            }







        } catch (ParseException ex) {

        }


if(countglobal==500){

    takis=takis+500;
}

}while(countglobal==500);

 } finally {

      is.close();
    }
response.setContentType("text/xml; charset=UTF-8");
response.setHeader("Cache-Control", "no-cache");

       int i;
Document document = new Document();

Element root = new org.jdom.Element("root");
    document.setRootElement(root);
    Element item;

 for (i=0; i<1000;i++){

        if(costs[i]>0){

        item = new org.jdom.Element("item");
        org.jdom.Element element = new org.jdom.Element("date");
        String t = dates[i];
        element.addContent(t);
        item.addContent(element);

        element = new org.jdom.Element("poso");
        t=Integer.toString(costs[i]);
        element.addContent(t);
        item.addContent(element);



root.addContent(item);
      }
      }



    for (i=0; i<p;i++){

        if(!(doc[i].equals("null"))){

        item = new org.jdom.Element("url");
        org.jdom.Element element = new org.jdom.Element("doc");
        String t = doc[i];
        element.addContent(t);
        item.addContent(element);

        element = new org.jdom.Element("dap");
        t=Integer.toString(dap[i]);
        element.addContent(t);
        item.addContent(element);

         element = new org.jdom.Element("sub");
        t=subjectarray[i];
        element.addContent(t);
        item.addContent(element);

root.addContent(item);
      }
      }




   XMLOutputter output = new XMLOutputter();
    String outString=output.outputString(document);
response.getWriter().write(outString);


    }

}
