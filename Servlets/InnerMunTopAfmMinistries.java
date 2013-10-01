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
import java.text.SimpleDateFormat;
import java.util.Calendar;


@WebServlet(name = "InnerMunTopAfmMinistries", urlPatterns = {"/InnerMunTopAfmMinistries"})
public class InnerMunTopAfmMinistries extends HttpServlet {


 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

     int[] costs = new int[3464];
int[] dap = new int[90000];
int af=0;
int f=0;
String[] afms=new String[2000];
for(af=0;af<2000;af++){
afms[af]="null";
}

String[] names={
    "dioikhtikhs metarryqmishs", "eswterikwn", "qallasiwn ypoqesewn","ygeias","prostasias toy polith","anaptyjhs","politismou","periballontos","oikonomikwn","metaforwn",
    "ergasias","ejwterikwn","paideias","amynas","dikaiosynhs","agrotikhs anaptyjhs"
};

Integer[] uids={
    31, 30, 21, 20, 19, 18, 17, 16, 15, 14,
    11, 10, 8, 6, 5, 3
 };

String afm="null";
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

for (it=0; it<16;it++){
if (mymun.equals(names[it])){

    org=uids[it];

}
}



InputStream is  = null;

int takis=1;
int total=0;

  try {
     do{

is = new URL("http://opendata.diavgeia.gov.gr/api/decisions?output=json&datefrom=01-03-2011&org="+org+"&type=27&from="+takis+"&order=asc").openStream();

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

                if(name.equals("eponimia_anadoxou")){

                     value=value.replaceAll("Α","a");
                 value=value.replaceAll("Β","b");
                 value=value.replaceAll("Γ","g");
                 value=value.replaceAll("Δ","d");
                 value=value.replaceAll("Ε","e");
                value=value.replaceAll("Ζ","z");
                value=value.replaceAll("Η","h");
                value=value.replaceAll("Θ","q");
                value=value.replaceAll("Ι","i");
                 value=value.replaceAll("Κ","k");
              value=value.replaceAll("Λ","l");
               value=value.replaceAll("Μ","m");
                value=value.replaceAll("Ν","n");
                 value=value.replaceAll("Ξ","j");
                value=value.replaceAll("Ο","o");
                value=value.replaceAll("Π","p");
                value=value.replaceAll("Ρ","r");
                value=value.replaceAll("Σ","s");
                value=value.replaceAll("Τ","t");
                value=value.replaceAll("Υ","y");
                value=value.replaceAll("Χ","x");
                 value=value.replaceAll("Φ","f");
                value=value.replaceAll("Ψ","c");
               value=value.replaceAll("Ω","w");
               value=value.replaceAll("΄΄","\"");
               value=value.replaceAll("Ϊ","i");
                 value=value.replaceAll("΄","'");
                 afm=value;
for(af=0;af<2000;af++){
        if(value.equals(afms[af])){
found=1;
  break;



                                    }


}
 if(found==0){

 for(af=0;af<2000;af++){
        if(afms[af].equals("null")){

 afms[af]=value;
break;


                                    }


}

 }
                 found=0;


                }




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

 for(orgcount=0;orgcount<2000;orgcount++){
                            if(afm.equals(afms[orgcount])){costs[orgcount]=costs[orgcount]+sum1; break;}


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

 for(orgcount=0;orgcount<2000;orgcount++){
                            if(afm.equals(afms[orgcount])){costs[orgcount]=costs[orgcount]+sum2; break;}


                            }

                    }

                    }

                                                                 }

                }

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

 int n = costs.length;
    for (int pass=1; pass < n; pass++) {

        for (int i=0; i < n-pass; i++) {
            if (costs[i] < costs[i+1]) {

                int temp = costs[i];  costs[i] = costs[i+1];  costs[i+1] = temp;
                String temp2=afms[i]; afms[i]=afms[i+1]; afms[i+1]=temp2;
            }
        }
    }

 response.getWriter().write(afms[0]+"@"+costs[0]+"#"+afms[1]+"$"+costs[1]+"%"+afms[2]+"^"+costs[2]+"+"+afms[3]+"*"+costs[3]+">"+afms[4]+"!"+costs[4]);

    }

}
