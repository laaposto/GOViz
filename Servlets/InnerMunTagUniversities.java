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

@WebServlet(name = "InnerMunTagUniversities", urlPatterns = {"/InnerMunTagUniversities"})
public class InnerMunTagUniversities extends HttpServlet {


  String[] units={
"edel","mhtrwo foithtwn",
"dieyqynsh ekpaideyshs kai ereynas","genikh dieyqynsh proswpikoy kai dhmosiwn sxesewn","grafeio prytanh","dieyqunsh dioikhtikoy","dieyqunsh sxediasmoy kai programmatismoy","dieyqunsh mhxanorganwshs","dieyqunsh dhmosiwn sxesewn kai istorias","dieyqunsh dhmosieymatwn kai ekdosewn","dieyqunsh oikonomikwn yphresiwn","dieyqunsh perioysias","dieyqunsh klhrodothmatos","dieyqunsh texnikwn yphresiwn","dieyqunsh panepisthmiakhs lesxhs","genikh dieyqunsh ekpaideushs","genikh dieyqunsh perioysias kai oikonomikwn","dieyqunsh vivlioqhkwn","grafeio antiprytani akadhmaikwn ypoqesewn kai proswpikoy","grafeio antiprytani oikonomikoy programmatismou kai anaptyjhs","grafeio antiprytani foititikhs merimnas kai ejwterikwn sxesewn","eidikos logariasmos kondyliwn ereynas","grammateia sygklhtoy","grammataeia prytanikoy symboylioy","istorias kai arxaiologias","qeologias","koinwnikhs qeologias","nomikhs","oikonomikwn episthmwn","p.e.d.d.","iatrikh sxolh","odontiatrikhs","farmakeytikhs","noshleytikhs","filologias","filosofias, paidagwgikhs kai cyxologias","agglikhs glwssas kai filologias","gallikhs glwssas kai filologias","germanikhs glwssas kai filologias","qeatrikwn spoydwn","moysikwn spoydwn","italikhs glwssas kai filologias","ispanikhs glwssas kai filologias","toyrkikwn kai sygxronwn asiatikwn spoudwn","slabikwn spoydwn","fysikhs","xhmeias","maqhmatikwn","biologias","gewlogias kai gewperiballontos","plhroforikhs kai thlepikoinwniwn","t.e.f.a.a.","p.t.d.e.","t.e.a.p.h.","e.m.m.e.","m.i.q.e.","panepisthmiakh lesxh","etaireia ajiopoihshs kai diaxeirhshs ths perioysias","pms-ekpaideush kai anqrwpina dikaiwmata","diaxeiristikh epitroph klhrodothmatos","diaxeiristikh epitroph toy klhrodothmatos","kosmhteia filosofikhs sxolhs",
"neuroxeiroyrgiko institoyto panepisthmioy iwanninwn",
"dioikoysa epitropi","eidikos logariasmos ereunas dipae","kosmhteia sxolhs oikonomias kai dioikhshs","kosmhteia sxolhs episthmwn kai texnologias","kosmhteia sxolhs anrqwpistikwn episthmwn",
"dieyqynsh texnikwn ergwn","dieuqynsh mhxanorganwshs","tmhma promhqeiwn","dieyqynsh dioikhtikoy","eidikos logariasmos kondyliwn ereynas","grammateia prytanikoy symboylioy","dieyqynsh oikonomikhs diaxeirhshs","tmhma hlektrologwn mhxanikwn kai mhxanikwn ypologistwn","tmhma iatrikhs","tmhma nomikhs","tmhma moriakhs bilogias kai genetikhs","grammateia sygklhtoy","tmhma episthmhs fysikhs agwghs kai aqlhtismoy","dieyqynsh akadhmaikwn qematwn","tmhma grotikhs anaptyjhs","upologistiko kentro kai kentro diaxeirishs diktywn","tmhma istorias kai eqnologias","tmhma glwssas, filologias kai politismou pareyjeiniwn xwrwn","tmhma dasologias kai diaxeirishs periballontos kai fysikwn porwn","tmhma episthmwn ths ekpaideyshs sthn prosxolikh hlikia","tmhma politikwn mhxanikwn","tmhma mhxanikwn paragwghs kai dioikhshs","tmhma ellhnikhs filologias","tmhma arxitektonwn mhxanikwn","tmhma dioikhshs epixeirhsewn","diatmhmatiko programma metaptyxiakwn spoudwn askhsh kai poiothta zwhs","tmhma koinwnikhs dioikhshs","tmhma politikwn episthmwn","paidagwgiko tmhma dhmotikhs ekpaideyshs","sxolh episthmwn agwghs","tmhma mhxanikwn periballontos",
"tmhma diktywn diadiktyoy","tmhma grammateias logariasmoy ereynas","dieyqynsh dioikhtikoy","dieyqynsh oikonomikou","grammateia sygklhtoy kai prytanikoy symboulioy","tmhma episthmhs kai texnologias trofimwn","organwtikh epitroph gia thn anadeijh twn melwn toy 1oy symboulioy toy gpa",
"genikh dieyqynsh dioikhtikwn yphresiwn","genikh dieyqynsh oikonomikwn yphresiwn","genikh dieyqynsh texnikwn yphresiwn kai mhxanorganwshs","eidikos logariasmos kondyliwn ereunas","dieyqynsh proswpikou","tmhma didaktikou ereunhtikoy proswpikou","tmhma loipoy proswpikoy","tmhma dioikhtikou proswpikou","dieuqynsh dioikhtikoy","tmhma dioikhshs","tmhma prwtokolloy kai diekpairaiwshs","dieyqynsh syntonismou akadhmaikwn monadwn","tmhma dieqnwn sxesewn","tmhma eurwpaikwn ekpaideytikwn programmatwn","tmhma dhmosiwn sxesewn","tmhma diasyndeshs","tmhma spoydwn","dieuqynsh oikonomikhs diaxeirishs","tmhma proupologismou-apologimsou","tmhma misqodosias","tmhma dapanwn","tmhma dhmosiwn ependysewn","tmhma syggrafikwn dikaiwmatwn kai foititikwn daneiwn","dieuqynsh periousias kai promhqeiwn","tmhma periousias","tmhma promhqeiwn","tmhma klhrodothmatwn","dieuqynshs programmatismou, meletwn kai ektleshs ergwn","tmhma programmatismou kai meletwn","tmhma ekteleshs ergwn","dieuqynsh synthrhshs kai leitoyrgias egkatastasewn","tmhma synthrhshs kai ektleshs mikroergwn","tmhma leitoyrgias egkatastasewn","dieuqynsh mhxanogranwshs","tmhma organwshs-mhxanorganwshs","tmhma statistikhs tekmhriwshs","aytoteles tmhmatos grammateias epitrophs diktywn kai epikoinwniwn","autoteles tmhmatos grammateias texnikou symboulioy","autoteles tmhmatos grammateias","grammateia sygklhtoy","grammateia prytanikoy sumbouliou","grammateia nomikhs epitrophs","dikastiko grafeio","aytoteles grafeio typou, metafrashs kai diermhneias","grammateia sxoleiou neas ellhnikhs glwssas","tmhma plhroforikhs","tmhma xhmeias","tmhma maqhmatikwn","tmhma fysikhs","tmhma biologias","tmhma gewlogias","tmhma qeologias","tmhma poimantikhs kai koinwnikhs qeologias","tmhma nomikhs","tmhma oikonomikwn episthmwn","tmhma politikwn episthmwn","gewponikh sxolh","sxolh dasologias kai fysikoy periballontos","kthniatrikh sxolh","iatrikh sxolh","odontiatrikh sxolh","tmhma politikwn mhxanikwn","tmhma arxitektonwn mhxanikwn","tmhma agronomwn topografwn mhxanikwn","tmhma mhxanologwn mhxanikwn","tmhma hlektrologwn mhxanikwn kai mhxanikwn ypologistwn","tmhma xhmikwn mhxanikwn","geniko tmhma","tmhma mhxanikwn xwrotajias kai anaptyjhs (beroia)","tmhma eikastikwn kai efarmosmenwn texnwn","tmhma mousikwn spoudwn","tmhma qeatrou","tmhma kinhmatografoy","paidagwgiko tmhma dhmotikhs ekpaideyshs","tmhma episthmwn prosxolikhs agwghs kai ekpaideushs","tmhma farmakeytikhs","tmhma episthmhs fysikhs agwghs kai aqlhtismou","tmhma episthmhs fysikhs agwghs kai aqlhtismou (serres)","tmhma dhmosiografias kai mme","tmhma filologias","tmhma istorias kai arxaiologias","tmhma filosofias kai paidagwgikhs","tmhma cuxologias","tmhma agglikhs glwssas kai filologias","tmhma gallikhs glwssas kai filologias","tmhma germanikhs glwssas kai filologias","tmhma italikhs glwssas kai filologias","kosmhteia polytexnikhs sxolhs","kosmhteia sxolhs qetikwn episthmwn","kosmhteia paidagwgikhs sxolhs","kosmhteia sxolhs nope","kosmhteia sxolhs kalwn texnwn","kosmhteia qeologikhs sxolhs","kosmhteia filosofikhs sxolhs","kentrikh vivlioqhkh","epitroph epopteias panepisthmiakou gymnasthrioy","tmhma ekdosewn","d.p.m.s. plhroforikh kai dioikhsh","d.p.m.s. tmhmatos filologias","d.p.m.s. tmhmatos filosofias kai paidagwgikhs","d.p.m.s. agglikhs glwssas kai filologias (metafrashs)","d.p.m.s. agglikhs glwssas kai filologias (eurwpaikh logotexnia)","d.p.m.s. tmhmatos gallikhs glwssas kai filologias","d.p.m.s. tmhmatos fysikhs","d.p.m.s. tmhmatos biologias","d.p.m.s. tmhmatos plhroforikhs","d.p.m.s. iatrikhs sxolhs (thlematikh)","d.p.m.s. iatrikhs sxolhs (sygxrones iatrikes prajeis)","d.p.m.s. arxitektonwn mhxanikwn (mnhmeia)","d.p.m.s. arxitektonwn mhxanikwn (mouseiologia)","d.p.m.s. tmhmatos arxitektonwn mhxanikwn (arxitektonikh topioy)","diapanepisthmiako tmhmatos hlektrologwn mhxanikwn kai mhxanikwn ypologistwn","d.d.p.m.s. tmhmatos hlektrologwn mhxanikwn kai mhxanikwn ypologistwn","d.d.p.m.s. tmhmatos xhmikwn mhxanikwn","d.d.p.m.s. tmhmatos episthmwn prosxolikhs agwghs kai ekpaideyshs-cyxopaidagwgikh","d.d.p.m.s. tmhmatos episthmwn prosxolikhs agwghs kai ekpaideyshs-periballontikh ekpaideysh","d.d.p.m.s. tmhmatos fysikhs agwghs kai aqlhtismou","d.p.m.s. tmhmatos politikwn mhxanikwn kai agronomwn topografwn mhxanikwn","d.p.m.s. gallikhs glwssas kai filologias","pms toy tomea paidagwgikhs","pms tou tomea filosofias",
"eidikos logariasmos kondyliwn ereunas","grammateia sygklhtoy kai prytanikoy sumvoulioy","dieuqynsh oikonomikhs diaxeirishs","dieuqynsh dioikhtikoy","dieuqynshspoudwn kai foititikhs merimnas","dieuqynsh plhroforikhs kai diktywn","dieuqynsh texnikwn yphresiwn","dieuqynsh biblioqhkhs kai kentroy plhroforikhs","autoteles grafeio dieqnwn kai dhmosiwn sxesewn","tmhma istorias","tmhma jennwn glwsswn, metafrashs kai diermhneias","tmhma mousikwn spoudwn","tmhma arxeionomias","tmhma plhroforikhs","tmhma texnwn, hxou kai eikonas","tmhma asiatikwn spoudwn","tmhma didaktikou ekpaideutikoy proswpikou","tmhma dioikhtikou proswpikou","tmhma dioikhtikhs merimnas","tmhma prwtokolloy kai diekpairaiwshs","tmhma proypologismou","tmhma logisthrioy","tmhma misqodosias","tmhma promhqeiwn","tmhma proptyxiakwn spoudwn","tmhma metaptyxiakwn spoudwn","tmhma foititikhs merimnas","autoteles grafeio dhmosieumatwn kai ekdosewn","tmhma plhroforiakwn systhmatwn","tmhma diktywn kai thlepikoinwniwn","tmhma leitourgias h/y","tmhma programmatismou kai meletwn","tmhma ekteleshs ergwn","tmhma synthrhshs kai texnikhs yposthrijhs","grammateia ionioy panepisthmiou","grammateia ionioy panepisthmiou",
"dioikoysa epitropi","grammateia tmhmatos dioikhshs epixeirhsewn agrotikwn proiontwn kai trofimwn","grammateia tmhmatos diaxeirishs periballontos kai fysikwn porwn","grammateia tmhmatos diaxeirishs politismikou periballontos kai newn texnologiwn","oikonomikh diaxeirish","dioikhtikh yphresia","eidikos logariasmos kondyliwn ereynas",
"etaireia ajiopoihshs kai diaxeirishs perioysias toy dhmokritoy panepisthmioy qrakhs",
"dieuqynsh akadhmaikwn qematwn kai proswpikou","dieuqynsh oikonomikhs diaxeirishs","tmhma dieqnwn kai dhmosiwn sxesewn","tmhma mhxanorganwshs","yphresia vivlioqhkhs","nomikh yphresia","tmhma texnikwn ergwn","tmhma logisthriou","tmhma misqodosias","tmhma promhqeiwn","tmhma akadhmaikwn qematwn","tmhma proswpikou","tmhma panepisthmiakwn arxwn kai organwn","grammateia tmhmatos episthmhs diatrofhs","grammateia tmhmatos oikiakhs oikonomias","grammateia tmhmatos gewgrafias","grammateia tmhmatos plhroforikhs","elke","tmhma panepisthmiakwn arxwn","tmham-gewgrafias","tmhma oikiakhs oikonomias","grafeio spoydwn ejwterikou",
"kentrikh dioikhsh panepisthmiakwn daswn","dioikhsh panepisthmiakou dasous pertoulioy","dioikhsh panepisthmiakou dasous tajiarxh",
"tameio dioikhshs kai diaxeirhshs agrokthmatos a.p.q.",
"ptytanhs","antiprytanhs akadhmaikwn upoqesewn kai proswpikou","antiprytanhs oikonomikou programmatismou kai anaptyjhs","dieuqynsh kentrikhs dioikhshs","genikh dieuqynsh dioikhtikwn yphresiwn","dieuqynsh proswpikou","dieyqynsh akadhmaikwn qematwn","genikh dieyqynsh oikonomikwn yphresiwn","dieyqynsh oikonomikwn yphresiwn","dieuqynsh dhmosieumatwn","dieyqynsh mhxanorganwshs","dieyqynsh vivlioqhkhs","eidikos logariasmos kondyliwn ereynas","tmhma dieqnwn kai eyrwpaikwn spoydwn","tmhma politikhs peisthmhs kai istorias","tmhma dhmosias dioikhshs","tmhma koinwniologias","tmhma oikonomikhs kai periferiakhs anaptyjhs","tmhma epikoinwnias meswn kai politismou","tmhma cyxologias","tmhma koinwnikhs politikhs","tmhma koinwnikhs anqrwpologias","geniko tmhma dikaiou","tmhma foititikhs merimnas","tmhma texnikwn yphresiwn","grammateia prytanikoy sumvoulioy","grammateia sygklhtoy","tmhma dieqnwn sxesewn kai eurwpaikhs enwshs","prytaneia",
"oikonomikes yphresies","dioikhtikou","elke","tmhma perifereiakhs anaptyjhs","tmhma plhroforikhs",
"oikonomikhs diazeirihsh kai programmatismou","epitroph ereynwn","proswpikou","grammateia prytanikou","grammateia sygklhtoy",
"promhqeiwn","didaktikou ekpaideytikoy proswpikou","logisthriou","dioikhtikoy proswpikou kai dioikhtikhs merimnas","mhxanorganwshs","texnikwn ergwn","dieuqynsh spoudwn","dieuqynsh yposthrijhs panepisthmiakwn organwn","panepisthmio peiraiws","kentro ereunwn","tmhma statistikhs kai asfalistikhs episthmhs","tmhma oikonomikhs episthmhs","tmhma organwshs kai dioikhshs epixeirhsewn","tmhma xrhmatooikonomikhs kai trapezikhs dioikhtikhs","biomhxanikhs dioikhshs kai texnologias","tmhma nautiliakwn spoudwn","tmhma plhroforikhs","tmhma chfiakwn systhmatwn","tmhma dieqnwn kai eyrwpaikwn spoudwn",
"dioikhtikwn yphresiwn","oikonomikwn yphresiwn","elke","texnikwn yphresiwn kai programmatismou diktywn","ekteleshs kai synthrhshs ergwn","programmatismou kai meletwn","diktywn kai mhxanorganwshs","dioikhtikwn kai oikonomikwn yphresiwn",
"dieuqynsh oikonomikhs diaxeirishs","prytaniko symvoulio","prostamenos grammateias","dieuqynsh dioikhtikou","prytanhs","elke","antiprytanhs oikonomikou programmatismou","antiprytanhs strathgikoy sxediasmou","antiprytanhs akadhmaikwn ypoqesewn","tmhma mousikhs episthmhs kai texnwn","sygklhtos","dieyqynsh texnikwn ergwn","dieuqynsh vivlioqhkhs","d.p.m.s. sth dioikhsh epixeirhsewn","tmhma ekpaideutikhs kai koinwnikhs politikhs","tmhma oikonomikwn episthmwn","tmhma organwshs kai dioikhshs epixeirhsewn","tmhma efarmosmenhs plhroforikhs","tmhma logistikhs kai xrhmatooikonomikhs","tmhma dieqnwn kai eyrwpaikwn spoudwn","tmhma balkanikwn slabikwn kai anatolikwn spoudwn","d.p.m.s. sta plhroforiaka systhmata","d.p.m.s. sthn oikonomikh episthmh","p.m.s. sthn efarmosmenh logistikh","grafeio diasyndeshs","p.m.s. dieqnwn kai eyrwpaikwn spoudwn","monada kainotomias kai epixeirhmatikothtas","p.m.s. sthn efarmosmenh plhroforikh","p.m.s. sthn efarmosmenh plhroforikh",
"eidikos logariasmos","ypodieyqynsh oikonomikhs diaxeirishs","genikh dieyqynsh dioikhtikwn kai oikonomikwn yphresiwn","tmhma b' proswpikou","tmhma a' proswpikou","tmhma a' proswpikou-ypodieyqynsh dioikhtikou","dieyqynsh oikonomikhs diaxeirishs","tmhma dioikhtikhs merimnas","tmhma dioikhtikhs merimnas-dieyqynsh dioikhtikou","tmhma episthmhs upologistwn","tmhma cuxologias","tmhma politikhs episthmhs","tmhma oikonomikwn episthmwn","tmhma koinwniologias","tmhma filologias","tmhma istorias","tmhma filosofikwn kai koinwnikwn spoudwn","paidagwgiko tmhma prosxolikhs ekpaideyshs","paidagwgiko tmhma dhmotikhs ekpaideushs","tmhma xhmeias","tmhma biologias","tmhma efarmosmenwn maqhmatikwn","tmhma maqhmatikwn","tmhma fysikhs","tmhma episthmhs kai texnologias ylikwn","ypodieyqynsh texnikwn ergwn","dieyqynsh texnikwn ergwn","dieyqynsh ekpaideyshs kai ereynas","tmhma iatrikhs","sxolh koinwnikwn episthmwn","filosofikh sxolh","sxolh episthmwn ths agwghs","grammateia sygklhtoy","grammateia prytanikou symboulioy","tmhma b' proswpikou-dieyqynsh dioikhtikou","tmhma b' proswpikou-dieyqynsh dioikhtikou","etaireia ajiopoihshs kai diaxeirishs periousias","tmhma panepisthmiakwn arxwn","organwtikh epitroph","sxolh qetikwn kai texnologikwn episthmwn","dieyqynsh ndieqnwn kai dhmosiwn sxesewn",
"elke","grammateia prytanikou symvouliou","dieyqynsh dioikhtikou","dieyqynsh oikonomikhs diaxeirishs","dieyqynsh texnikwn yphresiwn","grammateia sygklhtoy","grammateia tmhmatos istorias-arxaiologias","grammateia tmhmatos xhmeias","grammateia paidagwgikou tmhmatos dhmotikhs ekpaideyshs","grammateia paidagwgikou tmhmatos nhpiagwgwn","grammateia tmhmatos maqhmatikwn","grammateia tmhmatos filosofias","grammateia tmhmatos fysikhs","grammateia tmhmatos filologias","grammateia tmhmatos bilogikwn efarmogwn","grammateia tmhmatos mhxanikwn episthmhs ylikwn","grammateia tmhmatos plastikwn texnwn","grammateia tmhmatos plhroforikhs","grammateia tmhmatos iatrikhs","dieuqynsh dieqnwn kai dhmosiwn sxesewn","tmhma perioysias","grammateia tmhmatos dioikhshs epixeirhsewn agrotikwn proiontwn","grammateia tmhmatos diaxeirishs politismikou periballontos","grammateia tmhmatos diaxeirishs periballontos kai fysikwn porwn","dioikoysa epitroph",
"genikh dieyqynsh dioikhtikhs yposthrijhs","dieyqynsh dioikhtikou","dieyqynsh oikonomikhs diaxeirishs","dieyqynsh akadhmaikwn qematwn","dieyqynsh texnikwn yphresiwn","dieyqynsh dhmosieymatwn kai ekdosewn","dieyqynsh foititikhs merimnas","grammateia sygklhtoy","grammateia prytanikoy sumvoulioy","elke","dieyqynsh mhxanorganwshs","tmhma promhqeiwn","tmhma mhxanologwn mhxanikwn","tmhma mhxanikwn xwrotajias, poleodomias kai perifereiakhs anaptyjhs","tmhma politikwn mhxanikwn","tmhma arxitektonwn mhxanikwn","tmhma mhxanikwn hlektronikwn ypologistwn thlepikoinwneiwn kai diktywn","paidagwgiko tmhma dhmotikhs ekpaideyshs","paidagwgiko tmhma prosxolikhs ekpaideyshs","paidagwgiko tmhma eidikhs agwghs","tmhma istorias arxaiologias kai koinwnikhs anqrwpologias","tmhma gewponias fytikhs paragwghs","tmhma gewponias ixqyologias kai ydatinou periballontos","tmhma iatrikhs","tmhma kthniatrikhs","tmhma bioxhmeias kai biotexnologias","tmhma episthmhs fysikhs agwghs kai aqlhtismou","tmhma oikonomikwn episthmwn",
"dieyqynsh dioikhsh kai oikonomikhs diaxeirishs","tmhma mhxanikwn plhroforikhs kai thlepikoinwniwn","tmhma mhxanologwn mhxanikwn","paidagwgiko tmhma nhpiagwgwn","paidagwgiko tmhma dhmotikhs ekpaideyshs","tmhma balkanikwn spoudwn","tmhma eikastikwn kai eframosmenwn texnwn","dioikousa epitroph","elke","tmhma dioikhshs kai proswpikou","tmhma oikonomikhs diaxeirishs","tmhma akadhmaikwn qematwn","tmhma dhmosieymatwn","tmhma mhxanorganwshs","texnikh yphresia","tmhma dieqnwn sxesewn","paidagwgikh sxolh flwrinas",
"perifereiakh dieuqynsh mytilhnhs","kentrikh dieuqynsh dioikhtikwn upoqesewn","kentrikh dieuqynsh oikonomikwn ypoqesewn","tmhma proupologismou","tmhma periousias","kentrikh dieuqynsh spoudwn kai foititikhs merimnas","kentrikh dieuqynsh texnikwn yphresiwn","kentrikh dieuqynsh plhrofrikhs kai epikoinwniwn","kentrikh yphresia vivlioqhkhs","perifereiakh dieuqynsh xiou","perifereiakh dieuqynsh samou","perifereiakh dieuqynsh rodou","perifereiakh dieuqynsh lhmnou","perifereiakh dieuqynsh syroy","genikh dieuqynsh dioikhtikhs yposthrijhs","genikh dieuqynsh texnikhs yposthrijhs","kentrikh dieuqynsh dhmosiwn-dieqnwn sxesewn","grammateia sygklhtoy","grammateia prytanikou symboulioy","tmhma mhxanografhshs","tmhma didaktikou proswpikou","tmhma dioikhtikou proswpikou","grafeio prwtokollou","tmhma periousias kai promhqeiwn","tmhma proptyxiakwn spoudwn","tmhma metaptyxiakwn spoudwn kai ereynas","tmhma dieqnwn akadhmaikwn programmatwn","tmhma foithtikhs merimnas","tmhma dhmosiwn sxesewn","grafeio dieqnwn sxesewn","grafeio dhmosieumatwn","tmhma programmatismou kai meletwn","tmhma ekteleshs ergwn","tmhma synthrhshs ergwn","grafeio dioikhtikhs yposthrijhs","tmhma anaptyjhs plhroforiakwn systhmatwn","tmhma anaptyjhs upologistikwn systhmatwn","grafeio uposthrijhs ergwn plhroforikhs","perifereiako tmhma dioikhtikwn ypoqesewn-mytilhnhs","perifereiako tmhma oikonomikwn ypoqesewn-mytilhnhs","perifereiako tmhma texnikwn yphresiwn-mytilhnhs","perifereiako tmhma plhroforikhs kai epikoinwniwn-mytilhnhs","perifereiako grafeio dieqnwn-dhmosiwn sxesewn-mytilhnhs","perifereiako grafeio spoudwn-mytilhnhs","perifereiako tmhma dioikhtikwn ypoqesewn-xiou","perifereiako tmhma oikonomikwn ypoqesewn-xiou","perifereiako tmhma texnikwn yphresiwn-xiou","perifereiako tmhma plhroforikhs kai epikoinwniwn-xiou","perifereiako grafeio dieqnwn-dhmosiwn sxesewn-xiou","perifereiako grafeio spoudwn-xiou","perifereiako grafeio dieqnwn-dhmosiwn sxesewn-rodou","perifereiako grafeio spoudwn-rodou","perifereiako tmhma dioikhtikwn ypoqesewn-rodou","perifereiako tmhma oikonomikwn ypoqesewn-rodou","perifereiako tmhma plhroforikhs-rodou","perifereiako tmhma texnikwn yphresiwn-rodou","perifereiako grafeio dieqnwn-dhmosiwn sxesewn-samou","perifereiako grafeio spoudwn-samou","perifereiako tmhma dioikhtikwn ypoqesewn-samou","perifereiako tmhma oikonomikwn ypoqesewn-samou","perifereiako tmhma plhroforikhs-samou","perifereiako tmhma texnikwn yphresiwn-samou","perifereiako grafeio dieqnwn-dhmosiwn sxesewn-syrou","perifereiako grafeio spoudwn-syrou","perifereiako tmhma dioikhtikwn ypoqesewn-syrou","perifereiako tmhma oikonomikwn ypoqesewn-syrou","perifereiako tmhma plhroforikhs-syrou","perifereiako tmhma texnikwn yphresiwn-syrou","perifereiako grafeio dieqnwn-dhmosiwn sxesewn-lhmnou","perifereiako grafeio spoudwn-lhmnou","perifereiako tmhma dioikhtikwn ypoqesewn-lhmnou","perifereiako tmhma oikonomikwn ypoqesewn-lhmnou","perifereiako tmhma plhroforikhs-lhmnou","perifereiako tmhma texnikwn yphresiwn-lhmnou","tmhma paraggeliwn vivloqhkhs","elke","sxolh koinwnikwn episthmwn","sxolh periballontos","sxolh episthmwn dioikhshs","sxolh anqrwpistikwn episthmwn","sxolh qetikwn episthmwn","tmhma periballontos","tmhma koinwnikhs anqrwpologias kai istorias","tmhma gewgrafias","tmhma dioikhshs epixeirhsewn","tmhma naytilias","tmhma maqhmatikwn","tmhma mhxanikwn plhroforiakwn kai epikoinwniakwn systhmatwn","paidagwgiko tmhma dhmotikhs ekpaideyshs","tmhma episthmwn prosxolikhs agwghs","tmhma mespgeiakwn spoudwn","tmhma mhxanikwn oikonomias","tmhma politismikhs texnologias","tmhma episthmwn ths qalassas","tmhma koinwniologias","tmhma mhxanikwn sxediashs proiontwn kai systhmatwn","tmhma statistikhs kai analogiwn","tmhma episthmhs trofimwn kai diatrofhs","tmhma oikonomikhs kai dioikhshs tourismou","organwtikh epitroph","pms","mba",
"elke","prytanhs","antiprytansh akadhmaikwn ypoqesewn","antiprytanhs oikonomikou programmatismou","proistamenos grammateias","genikh dieyqunsh dioikhtikwn yphresiwn","dieyqunsh dioikhtikou","dieyqunsh oikonomikou","dieyqunsh ekpaideyshs","dieyqunsh mhxanografhshs","dieyqunsh vivlioqhkhs","foititikh lesxh","tmhma oikonomikhs episthmhs","tmhma dieqnwn kai eyrwpaikwn oikonomikwn spoudwn","tmhma organwshs kai dioikhshs epixeirhsewn","tmhma marketingk","tmhma logistikhs","tmhma dioikhtikhs episthmhs","tmhma plhroforikhs","tmhma statistikhs","tmhma periousias","oraganwtikh epitroph",
"ereunhtiko panepisthmiako instiroyto systhmatwn epikoinwniwn kai ypologistwn",
"panepisthmiakh foititikh lesxh a.p.q.",
"aprosdioristo"};




 String[]tags={

"aprosdioristo","mesa metaforas,tajidia kai tourismos","oikonomia kai oikonomika","periballon kai fysikoi poroi","plhroforia kai epikoinwnia","politismos kai eleyqeros xronos","ygeia kai koinwnikh merimna","poleodomia kai kthmatologio","anqrwpoi, koinothtes kai diabiwsh","dhmosia tajh kai amyna","dikaosynh, politeia kai dhmosia dikaiosynh",
"ekpaideush kai ereuna","ergasia, asfalish kai syntajh","dieqneis ypoqeseis kai eyrwpaikh enwsh","epixeirhmatikothta kai antagwnistikothta","dioikhtika epeggelmata","periballontika epaggelmata","loipa epaggelmata","epaggelmata ekpaideyshs","epaggelmata plhroforikhs","epaggelmata ygeias",
"texnika epaggelmata","kallitexnika epaggelmata","koinwnika epaggelmata","oikonomika epaggelmata","nautika epaggelmata","epaggelmata qetikwn episthmwn","epaggelmata efarmosmenhs mhxanikhs","nomika epaggelmata","pthnotrofia","ylotomia",
"melissokomia","latomeia","dasokomia","gewrgia","metalleia","oryxeia","kthnotrofia","alieia","proswpika stoixeia","anqrwpina dikaiwmata",
"iqageneia, metanasteysh kai koinwnikh entajh","oikogeneia","mhtrwa kai dhmatologio","katoikia","kuklos zwhs","bebaiwseis","ptyxia","meteggrafes","ptyxiakes spoudes","ekpaideutika idrymata",
"anagnwrish titlwn","didaktorikes spoudes","ergasia sthn anwtath epkaideush","ypotrofies","foithtikes","aqlhsh","aqlhtikh nomoqesia","ofeiles","synallagma","telwneia",
"daneia","egkatastaseis cyxagwfias","diaskedash","tyxera paixnidia","trofima kai pota","kwdikas odikhs kykloforias","staqmeysh","daktylios","elegxos symperiforas odhgwn","projenikes ypoqeseis","dieqneis sxeseis","eyrwpaikh enwsh","dhmosies symvaseis","diplwmtikh prostasia","dieqneis sxeseis(genika)","poinikh diwjh","poiniko dikaio","nomikh ekproswphsh","nomikh vohqeia","dikasthria","klhronomiko diakio","egklhma",
"dikes kai dikasimoi","astiko dikaio","dikaiosynh","poiniko mhrwwo","oikogeneiako diakio","dikastikes apofaseis","endika mesa","dhmosia dioikhsh","ekloges","dikaiosynh kai dikaio","politeia kai dhmokratikh qesmoi","dioikhtikes diadikasies","kwdikas dioikhtikhs diadikasias","epikyrwsh eggrafwn","organwsh dhmiswn forewn","anazhthsh pistopoihtikwn","limeniko swma","pyrosvestikh",
"astynomia","opla kai ekrhktikes yles","enoples dynameis kai stratologia","dhmosia tajh","eklogikoi katalogoi","ekloges (geinka)","eklogikh nomoqesia","prosxolikh agwgh","ekpaideysh (genika)","prwtobaqmia kai deuterobaqmia ekpaideysh",
"texnikh kai epaggelmatikh epkaideysh","kathgories ekpaideyshs","jenes glwsses","ereuna (genika)","anwtath ekpaideysh","kausima","ananewsimes phges energeies","hlektrikh energeia","enoples dynameis","stratiwtikes sxoles",
"stratiwtikh qhteia","stratologikh nomoqesia","epidomata anaphrias","epidomata asqeneias","epidomata enoikiou","epoxiaka vohqhmata","oikogeneiaka epidomata","loipa epidomata","hlektronikh epikoinwnia","mesa kai typos",
"oroi kai synqhkes","ergasiaka egrafa","ergasiaka dikaiwmata","adeies","apasxolhsh sto dhmosio","syllogikes symbaseis ergasias","argies","ergasiaka","euresh ergasia","koinwnikh asfalish","askhsh epaggelmatos","syntajh","anergia","prolhrujeis","proslhceis","ergasiakh empeiria","epaggelmatikh katartish","anazhthsh ergasias","ekpaideush sthn eurwpaikh envsh",
"eyrwpaikh iqageneia","synqhkh sengken","ergasia sthn eyrwpaikh enwsh","eurwpaikh enwsh (genika)","epixeirhmatikh drastrhriothta sthn eurwpaikh enwsh","sfragida xaghs","kwdikas vivliwn kai stoixeiwn","forologia kefalaiou","foroi","forologia epixeirhsewn","hlektronikh ypobolh","foros prostiqemenhs ajias","forologia eisodhmatos","forologia","ardeysh","limnes","upogeia ydata",
"potamia","iqageneia","koinwnikh entajh","omogeneia","metanasteysh","eidikh agwgh","gewrgikh ekpaideysh",
"diapolitismikh ekpaideysh","ekklhsiastikh ekpaideysh","ekpaideysh enhlikwn","epimorfwsh ekpaideutikwn",
"idiwtikh ekpaideysh","nautikh ekpaideysh","ydreysh kai apoxeteysh","apokthsh katoikias","ergatikh katoikia",
"anergesh katoikias","thlefwnikh syndesh","enoikiash katoikias","episkeyh katoikias","hlektrodothsh",
"allagh dieuqynshs","qermansh","gamos","qanatos","gennhsh","baftish","naytilia","jenodoxeia kai estiatoria",
"emporio","paroxh yphresiwn","xrhmatopistwtikoi organismoi","biomhxania","kataskeues","asfalish metoxikwn tameiwn",
"bibliaria ygeias","asfalish tsmede","koinwnikh asfalish (genika)","asfalistikes paroxes","asfalish oaee",
"asfalish teayek","eidikes kathgories asfalishs","asfalish ika","asfalish dhmosiou","ygeionomikh periqlach",
"asfalish oap-deh","asfalish oga","asfalish tameio nomikwn kead","asfalish tajy","asfalish tapote","asfalish tsay",
"filanqrwpia","anaphria","koinwnikh politikh","didaskalia jenwn glwsswn","pistopoihtikh","jenes glwsses (genika)",
"Ekmaqhsh jenwn glwsswn","kthmatologio","oikopeda","efhmerida ths kubernhshs","syntagma ths elladas",
"kybernhsh","hlektronikh diakybernhsh","sidhrodromikes sygkoinwnies","eisithria","astikes sygkoinwnies",
"aeroporikes sygkoinwnies","yperastikes sygkoinwnies","taji","tajidia kai tourismos","metafores genika",
"oxhmata","odikh asfaleia","nausiploia","mesa mazikhs metaforas","emporeymatikes metafores","odhghsh",
"diaxeirish kykloforias","dhmatologia","metadhmoteysh","mhtrwo arrenwn","skafh","ploia","epaggelmatikes adeies",
"adeies odhghshs","adeies mhxanhmatwn","auqaireta","diathrhtea","katedafish ktiriwn","oikodomikes adeies",
"ktiriakes egkatastaseis","synthrhsh ktiriwn","aprostateuta paidia","frontida paidiwn","diazygio","monogoneikh oikogeneia",
"yioqesia","polyteknia","oikogeneiakh katastash","oikogeneiakes paroxes","epidomata kai xrhmatika bohqhmata",
"forologia kai foroi","kladoi oikonomikhs drasthriothtas","daneia, ofeiles kai synallagma","opla","ekrhktikes yles",
"tafroi","aigialos","xeimarroi","ruakia","adeies kykloforias","diagrafh oxhmatwn","mhxanhmata","pinakides",
"lewforeia kai forthga","metabibash oxhmatwn","oxhmata (genika)","telh kykloforias","texnikos elegxos oxhmatwn",
"xlwrida kai panida","prostasia periballontos","orioqethseis","energeia","ydatikoi poroi","ajiopoihsh fysikwn porwn",
"prostasia dedomenwn","thlepikoinwnies","texnologia plhroforikhs kai epikoinwnias","epikoinwnia","poleodomia kai sxedio polhs",
"kthmatologio kai oikopeda","oikodomes kai ktiria","poleodomikes meletes","poleodomia","pumotomia","oikismoi",
"arxaiothtes","politistikoi xwroi (genika)","arxaiologikoi xwroi","politismos kai dhmiourgia","pinakoqhkes",
"mouseia","vivlioqhkes","qeatra","diaskedash kai cyxagwgia","politismos","eqelontismos",
"aqlhtismos","projenikes prajeis","allodapoi sthn ellada","ellhnes sto ejwteriko","diaxeirish apoblhtwn",
"prostasia periballontos (genika)","apagoreysh kynhgiou","rypansh","aprosdioristo","hlikia","gnhsio ypografhs",
"ariqmos forologikou mhtrwou","astynomikh tautothta","bebaiwseis spoudwn","eisagwgh sthn anwtath ekpaideush",
"epaggelmatikh ekpaideush","sxoleia","ergasia sthn prwtobaqmia aki deuterobaqmia ekpaideush","syntajiodothsh",
"syntajeis tsay","syntajeis ghratos","syntajeis qanatoy","syntajeis polyteknwn","syntajeis eidikwn kathgoriwn",
"syntajeis ika","syntajeis nat","syntajeis oaee","syntajeis oap-deh","syntajeis tameio nomikwn-kead",
"syntajeis teayek","syntajeis tsmede","syntajeis metoxikwn tameiwn","syntajeis tapote","syntajeis dhmosiou",
"syntajeis oga","syntajeis anaphrias","vizas","tourismos","koinwnikos tourismos","nautika fulladia","diabathria",
"tajidia","institouta epaggelmatikhs katartishs","sxoles maqhteias oaed","texnikes sxoles","texnologies plhroforikhs",
"yphresies pistopoihshs","texnologies epikoinwnias","thlepikoinwniaka telh","leitourgia thlepikoinwniwn",
"thlepikoinwniakes syndeseis","dash","zwa","fyta","ygeia kai ygieinh","prostasia katanalwtwn","koinwnikh pronoia",
"diatrofh","pistopoihtika ygeias","ygeia genika","farmaka","susthma ygeias","noshleia","dwrea organwn",
"kanones ygieinhs","embolia","epixeirhmatikothta","elegxoi kai kyrwseis","anqrwpino dynamiko","epaggelmatikh stegh",
"systash kai leitourgia etairias","epixorhghseis epixeirhsewn","metatroph epixeirhshs","kleisimo epixeirhshs",
"idrysh kai leitourgia epixeirhshs","epixeirhsiaka programmata","sygxwneush epixeirhshs","adeies proswpikou dhmwn kai perifereiwn",
"anagnwrish ektos gamou gennhqentwn teknwn","aprosdioristo","apospaseis","apwleia-anakthsh ellhnikhs iqageneias",
"genikos grammateas perifereias","dhmosies symvaseis ergwn","dhmosies symbaseis meletwn","dhmosies symbaseis promhqeiwn",
"dhmosies symbaseis yphresiwn","diapistwsh ellhnikhs iqageneias apo gennhsh","diaxeirish periousias ota",
"diktya dhmwn kai perifereiwn","diorimoi ypallhlwn","eklogikes apozhmiwseis","eklogikes promhqeies",
"enswmatwsh dikaiou ths EE","ejoda parastashs-kinhshs ota","epitropes","epixeirhseis dhmwn kai perifereiwn",
"eurwpaika kai dieqnh anaptyjiaka programmata","eurwpaikh ebdomada topikhs dhmokratias","eurwpaikos omilos edafikhs synergasias-eoes",
"eurwph gia tous polites","metanasteush-uemata gia steroumenous diabathriou","aprosdioristo","kaqorismos amoibhs epitropwn",
"koinwnikes domes apo npdd kai epixeirhseis ota","kthsh ellhnikhs iqageneias apo gennhsh","lhjiarxeia",
"lhjiarxikes prajeis gegonotwn ejwterikou ellhnwn yphkown","lush upallhlikhs sxeshs","metanasteush-anakoinwseis cion",
"metanasteush-apofaseis sumbouliou e.e. gia thn metanasteush","metanasteush-basika eggrafa politikhs e.e.",
"metanasteush-dikaiwmata kai ypoxrewseis yphkown tritwn xwrwn","metanasteush-eidikh bebaiwsh nomimhs diamonhs gia yphkoous tritwn xwrwn",
"metanasteush-ekproswphsh yphkown tritwn xwrwn","metanasteush-ejwterikes sxeseis e.e.","metanasteush-qemata adeiwn diamonhs gia ergasia"," ","metanasteush-qemata askhshs anejarththsoikonomikhs drasthriothtas kai uchlwn ependysewn",
"metanasteush-qemata eisdoxhs yphkown tritwn xwrwn gia episthmonikh ereuna","metanasteush-qemata ejarthmenhs ergasias-diadikasia metaklhshs-epoxiakh apasxolhsh-aliergates",
"metanasteush-qemata epi makron diamenontwn gia yphkoous tritwn xwrwn kai dekaeteis adeies","metanasteush-qemata oikogeneiakhs epanenwshs gia yphkoous tritwn xwrwn",
" ","metanasteush-qemata spoudwn gia yphkoous tritwn xwrwn","metanasteush-kanonismoi e.e. gia th metanasteush",
"metanasteush-koinotikes odhgies gia th metanasteush","metanasteush-nomoqesia gia eisodo kai diamonh yphkown tritwn xwrwn sthn ellhnikh epikrateia",
"metanasteush-symperasmata eurwpaikwn symbouliwn gia th metanasteush","metatajeis","mhtrwa arrenwn","nomika proswpa dhmosiou dikaiou dhmwn",
"ohe, oase, oosa","organwsh kai aplousteush diadikasiwn","politika grafeia","politografhsh allogenwn allodapwn",
"politografhsh omogenwn allodapwn","prajeis epixorhghsewn eisforwn","prajeis kaqorismou amoibwn melwn epitrophs",
"prajeis sugkrothshs epitropwn","programma enwsh gia th mesogeio","programma chfiakh sygklish","programma dhmosiwn ependysewn",
"programma dioikhtikh metarruqmish","programma ellada","programma sae 355/8","programma sata","programma stagstikhs sundromhs ellhnwn tsigganwn",
"prolhryjeis qesewn proistamenwn","promhqeies","prosklhseis ypobolhs protasewn eurwpaikou tameiou entajhs",
"proslhceis proswpikou","proswpiko dhmotikhs astynomias","proswpiko epixeirhsewn","proswpiko idrymatwn",
"proswpiko koinwnikwn domwn","proswpiko nomikwn proswpwn dhmosiou dikaiou","proswpiko syndesmwn ota",
"proswpiko forewn diaxeirishs sterewn apoblhtwn","proupologismos","proupologismos ota","ruqmiseis kykloforias",
"ruqmiseis ofeilwn-pistolhptikh politikh ota","sdit","syllogikes sumbaseis ergasias","symboulio iqageneias",
"sumvoulio ths eurwphs","symfwno sumbiwshs","syndesmoi ota","tautothtes","yioqesia","asfaleia kai ygeia twn ergazomenwn",
"programma qhseas","programma sae 055","programma kratikhs anaptyjiakhs bohqeia-kab","topikh autodioikhsh a baqmou","topikh autodioikhsh b baqmou",
"ekloges-qemata probolhs syndyasmwn","katasthmata ygeionomikou endiaferontos","epixorhghseis twn ota a kai b baqmou apo kentrikous autoteleis porous (kap)",
" ","loipes epixorhghseis twn ota a kai b baqmou","yperwries ypallhlwn","idymata dhmwn kai perifereiwn",
"kataskeues dhmosiwn ergwn","meletes dhmosiwn ergwn","meletes idiwtikwn ergwn","syllogikh apofash ergou",
"syllogikh apofash meletwn","syllogikh apofash perifereiwn","syllogikh apofash meletwn perifereiwn","syllogikh apofash nomarxiakhs autodioikhshs",
"syllogikh apofash topikhs autodioikhshs","proegkrish syllogikhs apofashs ergwn","proegkrish syllogikhs apofashs meletwn","proegkrish syllogikhs apofashs perifereiwn",
"proegkrish syllogikhs apofashs meletwn perifereiwn","proegkrish syllogikhs apofashs nomarxiakhs autodioikhshs","proegkrish syllogikhs apofashs topikhs autodioikhshs",
"kanonistikh anaptyjiakou nomou","ypagwgh ependyshs se anaptyjiako nomo","tropopoihsh ependyshs ypaxqeisas se anaptyjiako nomo",
"oloklhrwsh ependyshs ypaxqeisas se anaptyjiako nomo","epibolhs kyrwsewn ependyshs ypaxqeisas se anaptyjiako nomo",
"egkyklios anaptyjiakou nomou","kanonistikh n.3427/2005 kefalaio st","ypourgikh apofash n.3427/2005-ypagwghs se anaptyjiako nomo",
"yphresies","dhmarxos","dhmotiko simvoulio","dhmotikoi foroi,telh,eisfores kai alla idia esoda ota",
"ypaiqria diafhmish","prostima kok kai telh elegzomenhs staqmeushs","bebaiwsh kai eisprajh esodwn twn ota-dieukolunsh ofeiletwn",
"parakrathseis yper syndesmwn twn ota","programma stegastikhs apokatastashs palinnostountwn omogenwn apo xwres ths tews sobietikhs enwshs",
"apallotriwseis","xrhmatodothsh programmatos dhmosiwn ependysewn","dhmarxiakh epitroph","taxudromikes yphresies",
"energeies diafhmiseis","apokthsh ellhnikhs iqageneias omogenwn apo xwres ths prwhn essd basei tou n.2790/2000",
"anwnymes etaireies","oikonomikh enisxysh syndikalistikwn organwsewn","organogramma ypourgeiwn","texnikh bohqeia",
"limenikes ypodomes","agora h diaqesh autokinhtwn","dwrees autok/twn pros yphresies","qesh se kykloforia aut/twn",
"arsh kykloforias aut/twn","eqnika klhrodothmata","periballon-orioqethsh dasikwn ektasewn","apofash mataiwshs diagwnismou",
"systash qesewn","ellhnikh anaptyjiakh synergasia","metakinhseis proswpikou","nomismatiko programma",
"paroxh eggyhshs ellhnikou dhmosiou","periballontikh adeiodothsh","yperwries proswpikou idiwtikou dikaiou sto dhmosio",
"antikatastash melwn d.s.","xorhghsh prokatabolhs","dienergeia diagwnismou","eswterikh metakinhsh",
"eswterikh metakinhsh","diaqesimothta ypallhlou","ereunhtika programmata h alla erga","upobolh dikaiologhtikwn gia ekdosh entalmatos plhrwmhs",
"entalma plhrwmhs","geniko programma allhlegguh kai diaxeirish metanasteutikwn rown periodou 2007-2013"," ",
"n/d. 416/1974/ peri anagkaiothtas h mh dhmosiou kthmatos gia kaluch dhmosiwn anagkwn","tropopoihsh proupologismou",
"eqnika klhrodothmata","asfalistikes eisfores sto teady","texnika qemata","ekdoseis-ektypwseis","g prajh oikonomikou endiaferontos",
"espa 2007-2013","eishghths","syndromh entypwn kai hlektronikwn periodikwn","dikastika ejoda","xrhmatodothseis ergwn programmatos dhmosiwn ependysewn",
"melh symbouliwn","oikonomikoi poroi","logariamos esodwn dhmosiwn ependysewn","apozhmiwseis plhgentwn apo fysikes katastrofes",
"orismos ekkaqaristh","arwgh","prosklhsh upobolhs protasewn","prosklhsh upobolhs protasewn","prosklhsh upobolhs protasewn"," ",
"synthrhsh fwtotypikwn maxanhmatwn","dwrea","ejoikonomhsh oikwn","diaxeirish epikoistikwn ektasewn"};


     Integer[] tagsuids={
0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,
34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,
64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,
96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,
118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,
142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,
174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,
206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,
238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,263,264,265,266,267,268,269,
270,271,272,273,274,275,276,277,278,279,280,281,282,283,284,285,286,287,288,289,290,291,292,293,294,295,296,297,298,299,300,301,
302,303,304,305,306,307,308,309,310,311,312,313,314,315,316,317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,
334,335,336,337,338,339,340,341,342,343,344,345,346,347,348,349,350,351,352,353,354,355,356,357,358,359,360,361,362,363,364,365,
366,367,368,369,370,371,372,373,374,375,376,377,378,379,380,381,382,383,384,385,386,387,388,389,390,391,392,393,394,395,396,397,
398,399,400,401,402,403,404,405,406,407,408,409,410,411,412,413,414,415,416,417,418,419,420,421,422,423,424,425,426,427,428,429,
430,431,432,433,434,435,436,437,438,439,440,441,442,443,444,445,446,447,448,449,450,451,452,453,454,455,456,457,458,459,460,461,
462,463,464,465,466,467,468,469,470,471,472,473,474,475,476,477,478,479,480,481,482,483,484,485,486,487,488,489,490,491,492,493,
494,495,496,497,498,499,500,501,502,503,504,505,506,507,508,509,510,511,512,513,514,515,516,517,518,519,520,521,522,523,524,525,
526,527,528,529,530,531,532,533,534,535,536,537,538,539,540,541,542,543,544,545,546,547,548,549,550,551,552,553,554,555,556,557,
558,559,560,561,562,563,564,565,566,567,568,569,570,571,572,573,574,575,576,577,578,579,580,581,582,583,584,585,586,587,588,589,590,591,592};





//String units;


 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

     Integer unitsuids[]={
4602,6159,
3410,3411,3412,3414,3422,3423,3424,3425,3426,3427,3428,3429,3430,3684,3687,3691,3693,3695,3698,4020,4669,4670,6225,7688,7689,7690,7691,7692,7693,7694,7695,7696,7697,7699,7700,7701,7702,7703,7704,7705,7706,7707,7708,7709,7710,7711,7712,7713,7714,7715,7716,7718,7720,7722,7843,8026,11474,18082,19562,19970,
16772,
2314,2315,2316,2317,5481,5982,7377,7667,7905,8291,14060,15217,15894,16022,16453,16623,16628,16692,16829,17057,17217,17225,17287,17295,17669,17720,17864,18322,18360,18384,19130,
3202,3234,4947,4948,5822,10064,19252,
3385,4288,7501,7502,7503,
2804,2807,2809,2812,2830,2831,2838,2840,2841,2842,2843,2844,2845,2849,2853,2854,2855,2857,2858,2860,2861,2852,2863,2865,2867,2869,2872,2873,2894,2895,2898,2899,2901,2903,2904,2905,2907,2909,2910,2912,2913,2914,2916,2917,2919,3784,3798,3800,3838,3851,3857,3861,3863,3868,3869,3870,3875,3884,3889,3890,3891,3897,3898,3899,3900,3901,3902,3903,3904,3909,3910,3911,3912,3919,3920,3921,3922,3923,3924,3925,3926,3927,3929,3930,3931,3932,3933,4225,4226,4228,4229,4544,4566,4567,4656,4658,8289,13848,14101,14102,14103,14104,14108,14109,14110,14111,14112,14114,14116,14117,14118,14120,14121,14122,14123,14124,14127,15437,15729,20038,20039,
5336,5383,5646,5647,5648,5649,5650,5651,5652,5653,5654,5655,5656,5657,5658,5659,5665,5666,5667,5668,5669,5670,5671,5672,5674,5675,5677,5678,5680,5682,5683,5684,5685,5686,18355,18356,
18109,18113,18114,18115,18160,18162,19931,
99201185,
3790,3791,4207,4208,4209,4210,4211,4214,4216,4218,4220,4221,4222,4224,4230,4231,4232,5175,15304,17930,18206,18516,
4252,4253,4254,
4312,
3354,3357,3360,3362,3363,3365,3366,3367,3368,3369,3370,3371,3372,3373,3374,3375,3376,3377,3378,3379,3380,3381,3382,3383,3384,3609,3610,4825,4905,
3136,3253,4204,15937,20137,
3148,3149,3151,3714,3715,
171,1115,2110,2128,2369,2370,2371,2372,3053,4304,8252,8258,8259,8261,8264,8265,8267,8270,8273,
4043,4044,4045,4047,20168,20169,20170,20171,
2601,3116,3121,3133,3156,4652,4833,4834,4835,4856,6259,7007,7008,7407,7809,7810,7811,7812,7813,7814,7815,14847,14848,15484,16041,17010,19054,19817,20231,
4024,4386,4836,5038,5199,5345,5712,5865,5900,7118,7311,7312,7313,7314,7315,7316,7317,7318,7319,7559,7685,8016,8017,8018,8019,8344,8345,8347,11570,12094,12095,12096,14873,14876,16413,16414,16730,18761,18777,19519,19962,
4311,4313,4330,4331,4332,4333,5893,6012,6076,6077,6080,6432,6518,6521,6539,6563,6829,6898,6980,7251,7329,7603,7628,9057,18053,
3388,3389,3390,3391,3393,3394,3395,3396,3397,3398,3419,3771,5949,5950,5951,5952,5953,5954,5955,5956,5957,5958,5959,5960,5961,5962,5963,5964,
2091,2092,2093,2094,2095,2096,2097,2098,3799,3940,3941,3942,3343,3944,3945,3946,3947,
2055,2056,2057,2058,2059,2060,2061,2062,2063,2064,2065,2066,2067,2068,2244,2245,2246,2247,2248,2249,2251,2252,2253,2254,2257,2258,2259,2260,2261,2262,2263,2264,2265,2266,2267,2268,2269,2270,2271,2272,2273,2274,2275,2276,2277,2278,2279,2280,2281,2282,2283,2284,2285,2286,2287,2288,2290,2291,2292,2293,2294,2295,2297,2298,2299,2300,2301,2302,2303,2304,2305,2306,2307,2308,2311,4616,6531,6532,6533,6534,6536,6565,6566,6567,6568,6569,6570,6572,6573,6574,6575,6576,6577,6578,6579,6581,6582,6583,6584,18655,19430,19670,
4423,5268,5269,5270,5272,5273,5274,5275,5276,5277,5371,5373,5374,5375,5376,5377,5378,5380,5381,5382,8805,19041,
50166,
50089,
0};

int[] costs = new int[593];
int[] dap = new int[90000];
String sub[]=new String[90000];
String tagname[]=new String[90000];
String unitname[]=new String[90000];
String doc[] = new String[90000];
int p=0;
int f=0;
int subcount=0;

String[] names={
"ellhniko anoixto","eqniko kai kapodistriako","e.p.i. iwanninwn","dieqnes ellados","dhmokriteio qrakhs","gewponiko aqhnwn","aristoteleio qessalonikhs","ionio","dytikhs elladas","etaireia ajiopoihshs kai diaxeirishs perioysias toy dhmokritoy qrakhs",
"xarokopeio","tameio dioikishs diaxeirhshs panepisthmiakwn daswn","tameio dioikishs diaxeirhshs agrokthmatos aristoteleioy qessalonikhs","panteio","stereas elladas","pelloponhsoy","peiraiws","patrwn","makedonias","krhths",
"iwanninwn","qessalias","dytikhs makedonias","aigaioy","oikonomiko aqhnwn","ereunhtiko panepisthmiako instiroyto systhmatwn epikoinwniwn kai ypologistwn","panepisthmiakh foititikh lesxh a.p.q."};

Integer[] uids={
99203044, 99203020, 99202996, 99202922, 99202868, 99202112, 99202041, 99202011, 53926, 99201185,
99219608, 99219528, 99219525, 99206927, 99206925, 99206924, 99206922, 99206920, 99206919, 99206917,
99206915, 99206913, 99206912, 99206911, 99206861, 50166, 50089};



int tagval=0;
int it=0;
int org=0;
int countglobal=0;
int orgcount;
int sum=0;

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
        String datefrom=sdf.format(today);
        String s1;
        Date date;
        Format formatter;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        s1 = formatter.format(date);


  try {
     do{

is = new URL("http://opendata.diavgeia.gov.gr/api/decisions?output=json&datefrom="+datefrom+"&org="+org+"&type=27&from="+takis+"&order=asc").openStream();

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

                  String tag = jsons[i].getJSONObject("metadata").getJSONObject("tags").getString("tagId");
                  String subject = jsons[i].getJSONObject("metadata").getString("subject");
                  String organizationUnitId = jsons[i].getJSONObject("metadata").getString("organizationUnitId");
                  int orgunit=Integer.parseInt(organizationUnitId);

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

                              dap[f]=sum1;
                              f++;
                            for(orgcount=0;orgcount<593;orgcount++){
                            if(tagval==tagsuids[orgcount]){costs[orgcount]=costs[orgcount]+sum1;  tagname[subcount]=tags[orgcount]; break;}


                            }


                              for(orgcount=0;orgcount<630;orgcount++){
                            if(orgunit==unitsuids[orgcount]){unitname[subcount]=units[orgcount]; break;}


                            }



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

  for(orgcount=0;orgcount<593;orgcount++){
                            if(tagval==tagsuids[orgcount]){costs[orgcount]=costs[orgcount]+sum2; tagname[subcount]=tags[orgcount]; break;}


                            }

  for(orgcount=0;orgcount<630;orgcount++){
                            if(orgunit==unitsuids[orgcount]){unitname[subcount]=units[orgcount]; break;}


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


    for (i=0; i<593;i++){

        if(costs[i]>0){

        item = new org.jdom.Element("item");
        org.jdom.Element element = new org.jdom.Element("tag");
        String t = tags[i];
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
