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


@WebServlet(name = "InnerMunAfmParseruniversities", urlPatterns = {"/InnerMunAfmParseruniversities"})
public class InnerMunAfmParseruniversities extends HttpServlet {


 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

int[] costs = new int[2000];
int[] dap = new int[90000];
String doc[] = new String[90000];
String sub[]=new String[90000];
int subcount=0;
int af=0;
int p=0;
int f=0;
String[] afms=new String[2000];
for(af=0;af<2000;af++){
afms[af]="null";
}

String[] names={
"ellhniko anoixto","eqniko kai kapodistriako","e.p.i. iwanninwn","dieqnes ellados","dhmokriteio qrakhs","gewponiko aqhnwn","aristoteleio qessalonikhs","ionio","dytikhs elladas","etaireia ajiopoihshs kai diaxeirishs perioysias toy dhmokritoy qrakhs",
"xarokopeio","tameio dioikishs diaxeirhshs panepisthmiakwn daswn","tameio dioikishs diaxeirhshs agrokthmatos aristoteleioy qessalonikhs","panteio","stereas elladas","pelloponhsoy","peiraiws","patrwn","makedonias","krhths",
"iwanninwn","qessalias","dytikhs makedonias","aigaioy","oikonomiko aqhnwn","ereunhtiko panepisthmiako instiroyto systhmatwn epikoinwniwn kai ypologistwn","panepisthmiakh foititikh lesxh a.p.q."};

Integer[] uids={
99203044, 99203020, 99202996, 99202922, 99202868, 99202112, 99202041, 99202011, 53926, 99201185,
99219608, 99219528, 99219525, 99206927, 99206925, 99206924, 99206922, 99206920, 99206919, 99206917,
99206915, 99206913, 99206912, 99206911, 99206861, 50166, 50089};

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

for (it=0; it<27;it++){
if (mymun.equals(names[it])){

    org=uids[it];

}
}



InputStream is  = null;

int takis=1;
int total=0;
Date today = new Date();

SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        String datenow=sdf.format(today);

        if(datefrom.equals("Pick a Date")){                                 //TODAY


        datefrom= sdf.format(today);
        String s;
        Date date;
        Format formatter;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        s = formatter.format(date);
        dateto=s;
               }

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


sub[subcount]=subject;
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

 for (i=0; i<2000;i++){

        if(costs[i]>0){

        item = new org.jdom.Element("item");
        org.jdom.Element element = new org.jdom.Element("afm");
        String t = afms[i];
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
        t=sub[i];
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
