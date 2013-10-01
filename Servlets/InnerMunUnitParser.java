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


@WebServlet(name = "InnerMunUnitParser", urlPatterns = {"/InnerMunUnitParser"})
public class InnerMunUnitParser extends HttpServlet {



  String[] units={
"dioikhtikwn yphresiwn","oikonomikwn yphresiwn","texnikwn yphresiwn","poleodomias","grafeio typoy kai dhmosiwn sxesewn","tmhma pronoias","perivallontos kai prasinoy",
"dhmarxos kassandras","dioikhtikwn-oikonomikwn","dimotikh enothta kassandras","texnikwn ergwn(ektos udreyshs apoxeteyshs)","kaqariothtas periballontos","ydreushs apoxeteyshs","dhmotikh astynomia","dhmotikhs sygkoinwnias-kykloforiakoy","dhmotikh enothta pallhnhs","dhmotiko symvoulio","oikonomikh epitroph","epitroph poiothtas zwhs","epitroph diavoyleyshs","nomika proswpa",
"dhmarxos","antidhmarxos","proedros d.s","lhjiarxeio","grammateia","dhmotiko symvoylio","grafeio proswpikoy","prwtokolloy-arxeioy kai diaikperaiwshs","ko.de.dh.k",
"dioikhtikoy","oikonomikoy","texnikwn yphresiwn","poleodomias","dhmotiko symvoylio","ektelestikh epitroph","oikonomikh epitroph","epitroph poiothtas zwhs","symvoylio dhmotikhs koinothtas karystoy","epitroph diavoyleyshs","epitroph paideias",
"grafeio dhmarxoy","oikonomikh yphresia","oikonomikh epitroph","k.e.p.p.a.d.h.k.","dhmotiko symvoylio","poleodomia","dieyqunsh koinwnikhs pronoias","dieyqunsh texnikwn yphresiwn","gymmasthria","epitroph poiothtas zwhs","eniaia sxolikh epitroph 2ou dhmotikoy sxoleiou-2ou nhpiagwgeioy","grafeio kinhshs","dioikhtiko tmhma","yphresia kathariothtas","tmhma meletwn kai kataskeuwn",
"dhmarxos","antidhmarxoy","oikonomikwn yphresiwn","dioikhtikwn yphresiwn","lhjiarxeio karpaqoy","texnikwn yphresiwn kai periballontos","poleodomia","logisthrio","prosodwn-tameiakhs yphresias","programmatismou-organwshs-plhroforikhs kai anaptyjhs","yposthrijh airetwn organwn","texnikwn ergwn","antidhmarxoy","antidhmarxoy","lhjiarxeio olympoy karpaqoy","dhmotikoy symvoylioy","proswpikoy","dhmotikh epixeirhsh ydreyshs-apoxeteyshs","dhmotikh koinothta","epitropi apografhs","oikononikh epitroph","topikh koinothta bwladas","dioikhtikwn yphresiwn","tmhma dioikhshs","katasthmatwn ygeionomikoy endiaferontos","dhmotikh koinofelhs epixeirhsh","dhmotikh koinofelhs epixeirhsh","organismos politismoy aqlhshs kai paideias",
"pronoia","oikonomikh epitroph","erga kai meletes","epitroph poiothtas zwhs","dhmotiko symvoylio","poleodomia","topikh koinothta dafnosphlias","d.o.p.a.k.","dioikhtikes yphresies","epitroph paideias",
"grafeio apofasewn dhmotikoy symvoylioy","oikonomikh yphresia","texnikh yphresia","dioikhtikh yphresia","tmhma-grafeio apofasewn oikonomikhs epitrophs","sxolikh epitroph deyterobaqmias ekpaideyshs","kentro psosxolikhs agwghs paidioy",
"dioikhtikh yphresia","epitroph poiothtas zwhs","yphresia periballontos","texnikh yphresia","poleodomia","oikonomikh epitroph","oikonomikh yphresia",
"dieuqynsh dioikhtikwn yphresiwn","dieuqhnsh texnikwn yphresiwn","dieuqhnsh kathariothtas","dieuqhnsh prasinoy kai paidikwn xarwn","dieuqhnsh poleodomias","dieuqhnsh dhmotikwn prosodwn","oikonomikh epitroph","dioikhtiko symvoulio","dieuqhnsh oikonomikwn yphresiwn",
"tomeas dioikhshs kai oikonomikwn","tomeas dioikhshs kai oikonomikwn-logisthrio","tomeas dioikhshs kai oikonomikwn-tameiakh yphresia","tomeas dioikhshs kai oikonomikwn-tmhma allodapwn","grafeio adeiodothsewn kai ryqmishs emp.drasthriothtwn","tomeas dioikhshs kai oikonomikwn-tmhma misqodosias kai proswpikoy","tomeas kaqariothtas kai merimnas toy polith","tomeas kaqariothtas kai merimnas toy polith-tmhma prasinoy","tomeas kaqariothtas kai merimnas toy polith-tmhma kaqariothtas","grammateia dhm.symboulioy kai oik.epitrophs","grammateia topikwn symvouliwn","tomeas programmatismou kai anaptyjhs newn texnologiwn","tomeas ypodomwn","tomeas periballontos-poleodomias-xwrotajias","tomeas paideias-politismoy-aqlhtismoy-koin.prostasias","tmhma agrotikhs anaptyjhs","tomeas dioikhshs kai oikonomikwn-tmhma promhqeiwn","k.e.d.k.","grammateia poiothtas zwhs","grammateia ektelestikhs epitrophs","o.p.e.t.a.k.","d.e.y.a.k.","grafeio dhmarxoy","poleodomikh yphresia","dhmotikh koinothta","texnikh yphresia","sxolikh epitroph a/qmias ekpaideushs","sxolikh epitroph b/qmias ekpaideushs",
"dieyqynsh dioikhtikwn","dieyqunsh programmatismoy kai anaptyjhs","dieyqynsh oikonomikwn","dieyqynsh texnikwn yphresiwn","dieyqynsh gewtexnikwn yphresiwn","dieyqynsh kathariothtas kai amajostasioy","dieyqynsh dhmotikhs astynomias","dieyqynsh ejyphrethshs toy polith","grafeio dhmarxoy kai airetwn","dieyqynsh dioikhtikwn-tmhma dioikhshs kai proswpikoy","dhmotiko sumvoulio","dieyqynsh dioikhtikwn-tmhma dioikhtikhs yposthrijhw syllogikwn organwn","dieyqynsh oikonomikwn-tmhma promhqeiwn kai apoqhkhs","grafeio epikoinwnias dhmosiwn sxesewn kai eqimotypias","grafeio eidikwn symvoulwn kai episthmonikwn synergatwn","grafeio genikoy grammatea","grafeio nomikwn symvoylwn","grafeio diasfalishs poiothtaw kai eswterikoy elegxoy","grafeio politkhs prostasias","genikh dieyqynsh","dieyqynsh dioikhtikwn-tmhma dhmotikhs katastashs","dieyqynsh dioikhtikwn-tmhma lhjiarxeio","dieyqynsh dioikhtikwn-tmhma newn texnologiwn kai plhroforikhs","dieyqynsh oikonomikwn-tmhma logisthrioy","dieyqynsh oikonomikwn-tmhma dhmotikwn prosodwn","dieyqynsh oikonomikwn-tmhma diaxeirishs koimhthriwn kai dhmotikhs perioysias","dieyqynsh oikonomikwn-tmhma tmaeiakhs yphresias","dieyqynsh programmatismoy kai anptyjhs-tmhma programmatismoy","dieyqynsh programmatismoy kai anptyjhs-tmhma diaxeirishs diagwnismwn kai symbasewn","dieyqynsh programmatismoy kai anptyjhs-tmhma anaptjhs kai eyrwpaikwn qematwn","dieyqynsh texnikwn yphresiwn-tmhma meletwn","dieyqynsh texnikwn yphresiwn-tmhmahlektromhxanologikwn egkatastasewn kai kykloforiakwn qematwn","dieyqynsh texnikwn yphresiwn-tmhma ekteleshs ergwn kai synthrhshs ypodomwn","dieyqynsh texnikwn yphresiwn-tmhma poleodomikoy sxediasmoy kai efarmogwn","dieyqynsh gewtexnikwn yphresiwn-tmhma gewtexnikwn ergwn","dieyqynsh gewtexnikwn yphresiwn-tmhma synthrhshs prasinoy kai diaxeirhshs fysikou periballontos","dieyqhnsh kaqariothtas kai amajostasioy-tmhma apokomidhs kai diaxeirhshs aporrimatwn","dieyqynsh katariothtas kai amajostasioy-tmhma kinhshs oxhmatwn kai synthrhshs mhxanologikoy ejoplismoy","dieyqynsh ejuphrethshs toy polith-tmhma ejuphrethshs politwn","dieyqynsh ejuphrethshs toy polith-tmhma eswterikhs antapokrishs","dieyqynsh dhmotikhs astynomias-tmhma astynomeushs kai fylajhs","dieyqynsh dhmotikhs astynomias-tmhma elegxwn kai thrhshs leitourgias epithdeumatiwn kai epixeirhsewn","oikonomikh epitroph","epitroph poiothtas zwhs","dieyqunsh poleodomias","dieyqunsh pronoias","dieyqunsh dioikhtikwn-tmhma paideias","dhmotikh koinothta kalamatas",
"sygkrothsh syllogikoy organoy","dieyqunsh dioikhtikwn yphresiwn","dieyqunsh oikonomikwn yphresiwn","dieyqunsh kentrou ejyphrethshs politwn","dieyqunsh dhmotikhs astynomias","dieyqunsh texnikwn yphresiwn","dieyqunsh poleodomias kai poleodomikwn efarmogwn","dieyqunsh politikhs prostasias ergwn synthrhshs kai shmansewn","dieyqunsh kathariothtas","dieyqunsh prasinoy","genikos dieuqunths","dhmotiko symvoulio dhmoy kalamarias","oikonomikh epitroph","epitroph poiothtas zwhs","symparastashs toy polith","genikos grammateas","dhmarxos","autoteles tmhma paideias aqlhtismoy politismou kai neolaias","antidhmarxia paideias aqlhtismoy politismou kai neolaias","antidhmarxia oikonomikwn-dioikhshs kai programmatismou","antidhmarxia texnikhwn yphresiwn politikhs prostasias kai periballontos","antidhmarxia kathariothtas anakyklwshs kai prasinou","antidhmarxia koinwnikhs politikhs allhleggyhs kai dhmosias ygeias","tmhma poiothtas kai programmatismoy","ektelestikh epitroph",
"dhmotiko sumvoulio","dhmarxos","2h eniaia sxolikh epitroph gymnasioy lykeioy tee iek",
"grafeio dhmarxoy","dieyqynsh dioikhtikwn yphresiwn","dieyqynsh oikonomikwn yphresiwn","dieyqynsh texnikwn yphresiwn","dhmatiko symvoulio","oikonomikh epitroph","epitroph poiothtas zwhs",
"dieyqynsh dioikhtikwn yphresiwn","dieyqynsh oikonomikwn yphresiwn","dieyqynsh anaptyjhs kai programmatismoy","dieyqynsh texnikwn yphresiwn","dieyqynsh prasinou kai poiothtas zwhs","dieyqynsh chfiakwn yphresiwn","dieyqynsh dhmotikhs astynomias","dhmotiko symvoulio","tmhma dioikhtikhs yposthrijhs","prwtokollo","tmhma anqrwpinoy dynamikoy","dhmatologia","lhjiarxeio","tmhma ekdoshs adeiwn katasthmatwn ygeionomikoy endiaferontos","grafeio allodapwn kai metanasteushs","tmhma esodwn","tmhma logisthriou","tmhma promhqeiwn kai dhmoprasiwn","misqodosias","poleodomia","tmhma elegxoy kai ekdoshs aseiwn poleodomias","tmhma poleodomikwn sxediwn kai topografikwn meletwn poleodomias","tmhma elegxoy kataskeuwn poleodomias","dhmos kabalas","dhmotikh koinothta kavalas","oikonomikh epitroph","epitroph poiothtas zwhs","dhmotikh koinothta neas karbalhs","dhmotikh koinothta zygou","topikh koinothta amygdalewna","sxolikh epitroph 4ou kai peiramtikoy gymnasioy kavalas","sxolikh epitroph 5ou gymnasioy kavalas","tmhma dhmotikwn prosodwn",
"dieyqynsh programmatismou kai diaxeirishs ergwn","dieyqynsh oikonomikwn yphresiwn","dieyqynsh poleodomias","dieyqynsh dioikhtikwn yphresiwn","dieyqynsh periballontos","dieyqynsh texnikwn yphresiwn","dieyqynsh politismou-tourismou-paideias","oikonomikh epitroph","epitroph poiothtas zwhs","dhmotiko sumvoulio","grafeio dhmarxou","dieyqynsh poleodomias(dioikhtikh yposthrijh)","dieyqynsh poleodomias-tmhma ekdoshs oikodomikwn adeiwn kai elegxoy auqairetwn","dieyqynsh poleodomias-tmhma poleodomikoy sxediasmou kai topografikwn efarmogwn-kthmatologiou","sxolikes epitropes","grafeio genikou grammatea","dieyqynsh koinwnikhs prostasias","dieyqynsh koinwnikhs prostasias-tmhma epopteias kai elegxou","grafeio antidhmarxoy",
"dieyqynsh dioikhtikwn yphresiwn","dieyqynsh oikonomikwn yphresiwn","dieyqynsh texnikwn yphresiwn","dieyqynsh poleodomikou sxediasmou","dieyqynsh gewtexnikwn yphresiwn kai periballontos","dieyqynsh mhxanologikoy kai kaqariothtas","dieyqynsh kentrou ejyphrethshs politwn","dieyqynsh dhmotikhs astynomias","dieyqynsh koinwnikwn yphresiwn kai ygeias","grafeio dhmarxoy","autoteles tmhma dhmotikou symvoulioy","oikonomikh epitroph","epitroph poiothtas zwhs","ektelestikh epitroph",
"poleodomia","kentrikh yphresia","oikonomikh yphresia","texnikh yphresia","dhmotiko symvoulio","dhmotikh koinothta ag.khrykou","oikonomikh epitroph",
"poleodomiko grafeio",
"texnikh yphresia","oikonomikh yphresia","dioikhtikh yphresia","grafeio dhmotikoy symvouliou","grafeio oikonomikhs epitrophs","k.e.p.","dhmotikh astynomia",
"grafeio dhmotikou symvouliou kai oikonomikhs epitrophs","dieyqynsh dioikhtikwn yphresiwn","dieyqynsh oikonomikwn yphresiwn","autoteles grafeio dhmarxoy","dieyqynsh texnikwn yphresiwn-dieyqynsh poleodomias","dieyqynsh poleodomias","oikonomikh epitroph","epitroph poiothtas zwhs-antidhmarxos poiothtas zwhs","tmhma ejodwn","tmhma esodwn","tmhma dioikhtikhs merimnas","tmhma ekdoshs oikonomikwn adeiwn","dhmotikh koinothta katoxhs",
"dieyqynsh yposthriktikwn yphresiwn","dieyqynsh texnikwn yphresiwn","dieyqynsh yphresiwn koinhs wfeleias","dieyqynsh koinwnikwn drasthriothtwn","dieyqynsh k.e.p.","tmhma dioikhtikwn yphresiwn","tmhma oikonomikwn yphresiwn","tmhma ergwn","tmhma poleodomias",
"kentrikh yphresia","oikonomikh epitroph",
"dhmos qhras","periballon","dioikhtikes yphresies","oikonomikes yphresies","poleodomia","texnikes yphresies","oikonomikh epitroph","epitroph poiothtas","ektelestikh epitroph","dhmotiko symvoulio",
"tameiakh yphresia","poleodomia","oikonomikh yphresia","texnikh yphresia","dioikhtikh yphresia","yphresia prasinou","texnikh yphresia tmhma poleodomias","texnikh yphresia tmhma poleodomias(dioikhtikh yposthrijh)","epitroph poiothtas zwhs",
"grafeio dhmarxoy","grafeio antidhmarxoy astikoy sxediasmou poleodomias kai diktywn","grafeio genikoy grammatea","grafeio antidhmarxoy anaptyjhs kai diaxeirishs oikonomikwn porwn","grafeio antidhmarxou anakyklwshs kai kaqariothtas","grafeio antidhmarxou periballontos kai eleyqerwn xwrwn","grafeio antidhmarxou koinwnikhs allhleggyhs kai prostasias toy polith","grafeio antidhmarxou politismoy paideias kai tourismoy","grafeio antidhmarxou neothtas aqlhtismou kai eqelontwn","nomikh yphresia","dieuqunsh dhmosiwn kai dieqnwn sxesewn kai typou","dieuqunsh organwsews kai meqodwn","dieuqunsh dioikhshs","dieuqunsh proswpikou","dieuqunsh oikonomikwn yphresiwn","dieuqunsh prosodwn","dieuqunsh tameiakhs yphresias","dieuqunsh promhqeiwn kai apoqhkwn","dieuqunsh koimhthriwn","dieuqunsh koinwnikwn yphresiwn","dieuqunsh dhmotikhs katastashs","dieuqunsh lhjiarxeioy","dieuqunsh politismou","dieuqunsh vivlioqhkwn","dieuqunsh moysikwn drasthriothtwn","dieuqunsh bafopoyleioy","dieuqunsh neolaias aqlhtismou","dieuqunsh ekpaideushs","dieuqunsh odopoiias","dieuqunsh kykloforias","dieuqunsh kataskeuwn arxitektonikwn ergwn","dieuqunsh meletwn arxitektonikwn ergwn","dieuqunsh topografias","dieuqunsh prasinou","dieuqunsh mhxanologias","dieuqunsh hlektrologikoy","dieuqunsh katariothtas","dieuqunsh dhmotikhs astynomias","dieuqunsh poleodomias","dieuqunsh pronoias","dieuqunsh k.e.p.",
"dhmarxos","periballon kai poiothta zwhs","kathariothta kai prasino","koinwnikhs prostasias paideias kai politismou","dieuqynsh dioikhtikwn kai oikonomikwn yphresiwn","grafeio dioikhtikwn yphresiwn","grafeio oikonomikhs yphresias kai tameiwn","grafeio programmatismou plhroforikhs kai diafaneias","grafeio agrotikhs paragwghs","grafeio adeiodothsewn","grafeio apasxolhshs kai tourismou","grafeio k.e.p.","autoteles tmhma texnikwn ergwn ydreushs kai apoxeteushs",
"poleodomia","kaqariothta kai anakyklwsh","periballontos kai prasinou","yposthrijhs politikwn organwn toy dhmoy","anqrwpinoy dynamikoy","oikonomikwn yphresiwn","texnikwn yphresiwn","k.e.p.","dhmotikwn koinothtwn","dhmotikh koinwfelhs epixeirhsh koinwnikhs politikhs","ydreyshs apoxeteyshs kai kaqariothtas","dhmotikoi paidikoi kai vrefikou staqmoi","dhmotikh koinwfelhs epixeirhsh prostasias perivallontos kai anavaqmishs poiothtas zwhs","dhmotikh koinwfelhs epixeirhsh politistikhs anaptyjhs","kaph","katasthmata",
"grafeio dhmarxou","antidhmarxia dioikhtikwn kai oikonomikwn yphresiwn","antidhmarxia kaqariothtas periballontos kai prasinou","antidhmarxia texnikwn yphresiwn kai politikhs prostasias","antidhmarxia koinwnikhs prostasias paideias kai politismou","antidhmarxia topikhw oikonomikhs anaptyjhs","grafeio genikoy grammatea","dhmotikh koinwfelhs epixeirhsh mhxaniwnas","dhmotikh koinwfelhs epixeirhsh qermaikoy","grafeio esodwn diaxeirishs dhmotikhs periousias xorhghshs adeiwn katasthmatwn","grafeio dioikhshs kai proswpikou","tmhma texnikwn yphresiwn","tmhma oikonomikwn yphresiwn","dhmotikh koinothta neas mhxaniwnas","dhmotikh koinothta peraias","topikh koinothta neas kerasias","topikh koinothta aggeloxwrioy","dhmotikh koinothta epanomhs","topikh koinothta meshmerioy","grafeio yposthrijhs airetwn organwn","dhmotikh epitroph paideias","politistiko kai aqlhtiko kentro epanomhs","kaph epanomhs","kaph meshmeriou","grafeio logisthrioy misqodosias kai diaxeirishs dapanwn","oikonomikh epitroph","grafeio programmatismou kai anaptyjhs","dhmotikh koinothta agias triadas","politistiko kentro","kentro aqlhtismou","eketelestikh epitroph","epitroph poiothtas zwhs","dhmotikos paidikos staqmos epanomhs","texnikh yphresia dhmotikhs enothtas mhxaniwnas","eniaia sxolikh ewpitroph 2ou dhmotikou kai 2ou nhpiagwgeiou peraias","sxolikh epitroph sxoleiwn aggeloxwriou-neas kerasias","texnikh yphresia dhmotikhs enothtas epanomhs","kaph mhxaniwnas","kaph peraias","sxolikh epitroph 1ou dhmotikou sxoleioy mhxaniwnas","eniaia sxolikh epitroph dhmotikou sxoloeiou kai nhpiagwgeiou meshmerioy","tmhma dioikhtikwn yphresiwn","dieuqynsh texnikwn yphresiwn kai periballontos","sxolikh epitroph 2ou gel","kaph agias triadas","sxolikh epitroph 4ou dhmotikou sxoleiou peraias","sxolikh epitroph dhmotikou sxoleiou newn epibatwn","kaph newn epibatwn","dhmotiko symvoulio","eniaia sxolikh epitroph gymnasiou newn epibatwn kai tee qermaikoy","sxolikh epitroph 2ou gel","eniaia sxolikh epitroph 1ou dhmotikou sxoleiou kai nhpiagwgeiou peraias","sxolikh epitroph 2ou dhmotikou sxoleiou neas mhxaniwnas","sxolikh epitroph 3ou dhmotikou sxoleiou epanomhs","sxolikh epitroph 5ou nhpiagwgeiou peraias","sxolikh epitroph dhmotikou sxoleiou agias triadas","sxolikh epitroph 1ou gymnasioy peraias","sxolikh epitroph 1ou gel qermaikou","sxolikh epitrophgel neas mhxaniwnas","sxolikh epitroph nhpiagwgeiou agias triadas","sxolikh epitroph 3ou nhpiagwgeiou newn epibatwn","sxolikh epitroph 1ou nhpiagwgeiou newn epibatwn","sxolikh epitroph 3ou dhmotikou sxoleiou peraias","sxolikh epitroph 6ou nhpiagwgeiou peraias","sxolikh epitroph 2ou nhpiagwgeiou newn epibatwn","sxolikh epitroph 3ou kai 4ou nhpiagwgeiou epanomhs","sxolikh epitroph 2ou dhmotikou sxoleiou kai nhpiagwgeiou epanomhs","sxolikh epitroph 1ou dhmotikou sxoleiou kai nhpiagwgeiou epanomhs","sxolikh epitroph 2ou gymnasiou peraias","sxolikh epitroph 1ou gymnasiou peraias","sxolikh epitroph 7ou nhpiagwgeiou peraias","grafeio promhqeiwn kai diaxeirishs ylikoy","dhmotikh koinwfelhs epixeirhsh qermaikou",
"dhmotiko symvoulio","oikonomikh epitroph","epitroph poiothtas zwhs","texnikwn yphresiwn kai periballontos","dioikhtikwn kai oikonomikwn yphresiwn","dhmos qasou","periballontos","ergwn kai poleodomikwn efarmogwn","promhqeiwn","dioikhtikwn yphresiwn",
"dieuqynsh dioikhtikwn yphresiwn","dieuqynsh oikonomikwn yphresiwn","dieuqynsh texnikwn yphresiwn kai poleodomias","dieuqynsh periballontos","dieuqynsh dhmotikhs astynomias","dieuqynsh k.e.p.","tmhma dioikhtikwn organwn","kentro koinwnikhs pronoias","politistiko kentro","dhmotikoi paidikoi staqmoi","vivlioqhkh","aqlhtiko kentro","a kaph"," b kaph","organismos prosxolikhs agwghs kai koinwnikhs merimnas"," b baqmia sxolikh epitroph",
"dieuqynsh dioikhtikwn yphresiwn","tmhma dioikhshs","dieuqynsh oikonomikwn yphresiwn","dhmarxos","aqlhtikos organismos","oikonomikh epitroph","dhmotiko symvoulio","dieuqynsh kaqariothtas","k.a.p.h.d.h.","agia tabiqa","tmhma programmatismou kai anaptyjhs","paodhl","kafadhl","epitroph poiothtas zwhs","epitroph paideias","epitroph anaqeshs episkeywn autokinhtwn",
"texnikwn yphresiwn","oikonomikwn yphresiwn","dioikhtikwn yphresiwn","poleodomias","periballontos","grafeio dhmarxou","dhmotikhs astynomias","kep","ydatinoi poroi kai amesh antimetwpish blabwn","ydreush-apoxeteush","epitropes","ydatinwn porwn kai apokatastashs",
"dioikhtikwn yphresiwn","texnikwn yphresiwn","oikonomikwn yphresiwn","ygeias kai pronoias","grafeio dhmarxou","poleodomias","oikonomikh apitroph","epitroph poiothtas zwhs","dhmotiko symvoulio","dhmotikh astynomia",
"dieuqynsh dioikhtikwn yphresiwn","dieuqynsh oikonomikou programmatismou kai dapanwn","dieuqynsh dhmotikwn prosodwn","dieuqynsh tameiakwn yphresiwn","dieuqynsh texnikwn yphresiwn","dieuqynsh poleodomias","dieuqynsh dhmotikhs astynomias"," grammateia dhmotikwn organwn","tmhma proswpikou","tmhma proypologismou kai ekaqarishs dapanwn","tmhma promhqeiwn","tmhma efarmoghs diplografikou logistikou sxediou","grafeio dhmarxou","dhmotiko symvoulio","oikonomikh epitroph","epitroph poiothtas zwhs","epikoinwneias enhmerwshs kai dieqnwn sxesewn",
"dioikhtikes oikonomikes","dioikhtikoy","dhmou zitsas","dieuqynsh oikonomikwn anaptyjhs kai dioikhshs tmhma tameiou","tmhma esodwn logisthriou promhqeiwn periousias kai proupologismou","ydreush-apoxeteush","periballontos kaqariothtas kai prasinou","dhmotikhs katastashs lhjiarxeiwn kai allodapwn","texnikwn ergwn ydreushs-ardeyshs-apoxeteyshs-periballontos-promhqeiwn","dioikhtikwn-oikonomikwn-tameiou","paideias-politismou-aqlhtismou-ygeias-koinwnikwn yphresiwn","dhmotiko symboulio","dhmarxos","epitroph poiothtas zwhs","oikonomikh epitroph","eketelestikh epitroph","epitroph diavouleushs","symvoulio dhmatikhs koinothtas eleousas","ekkaqarisths apodoxwn d e passarwnos","ekkaqarisths apodoxwn d e ekalhs","ekkaqarisths apodoxwn d e zitsas","ekkaqarisths apodoxwn d e molosswn","ekkaqarisths apodoxwn d e eyrymenwn","dhmotikh enothta ekalhs","dhmotikh enothta zitsas","dhmotikh enothta eyrymenwn","dhmotikh enothta molosswn",
"dieuqynsh dioikhtikwn-oikonomikwn yphresiwn","oikonomikh epitroph","ektelestikh epitroph","epitroph poiothtas zwhs","epitroph diavouleushs","autoteles grafeio yposthrijhs airetwn organwn","dieuqynsh texnikhs yphresias kai periballontos","dhmotiko sumvoulio","dhmotikh koinothta filipiadas","grammateia dhmarxou","dhmotikh apitroph paideias",
"grafeio yposthrijhs airetwn organwn","autoteles grafeio programmatismou organwnshs kai plhroforikhs","dieuqynsh dioikhtikwn-oikonomikwn yphresiwn","dieuqynsh texnikwn yphresiwn kai periballontos","poleodomia","dhmotikh koinothta","oikonomikh apitroph","epitroph zwhs","dhmotiko symvoulio",
"dioikhtikwn yphresiwn","oikonomikwn yphresiwn","texnikwn yphresiwn","yposthrijhs airetwn","poleodmias","politikhs prostasias prasinou kai daswn","dhmarxou","diafaneias",
"grammateia dhmotikou symvouliou","grammateia oikonomikhs epitrophs","grammateia dhmarxou","grafeio promhqeiwn","texnikh yphresia","logisthrio","grafeio proswpikou","dioikhtiko-oikonomiko","tameio","sxolikh epitroph a/qmias ekpaideushs","sxolikh epitroph b/qmias ekpaideushs",
"tmhma dioikhtikwn yphresiwn","tmhma oikonomikwn yphresiwn","tmhma texnikwn yphresiwn kai periballontos","tmhma topikhs anaptjhs","grafeio paideias",
"dhmos eretrias","oikonomikh epitroph","dhmotiko symvoulio","eketelestikh epitroph","epitroph poiothtas zwhs",
"dioikhtikh","texnikh","oikonimikh",
"ketnrikh yphresia","dhmotiko symvoulio","oikonomikh epitroph","nomiko proswpo","oikonomikh yphresia","koinwfelhs epixeirhsh","dhmotikh koinwfelhs epixeirhsh dhmoy srymona","dhmotikh koinothta neou soulioy","dhmotikh koinothta neou skopoy","dhmotikh koinothta xrysou","sxolikh epitroph gymnasiou-lukeiou pentapolhs","sxolikh epitroph gymnasiou xrysou","sxolikh epitroph gymnasiou neou souliou","sxolikh epitroph gymnasiou-lukeiou neou skopou","sxolikh epitroph nhpiagwgeiou pentapolhs","eniaia sxolikh epitroph dhmotikou-nhpiagwgeiou newxoriou serrwn","sxolikh epitroph dhmotikou nhpiagwgeio xrysou","dhmotiko sxoleiokai nhpiagwgeio cyxikou serrwn","epitroph poiothtas zwhs","tmhma topikhs kai oikonomikhs anaptyjhs",
"dhmotiko symvoulio","oikonomikh epitroph","epitroph poiothtas zwhs","ektelestikh epitroph","dieuqynsh dioikhtikwn yphresiwn","dieuqynsh oikonomikwn yphresiwn","dieuqynsh texnikwn yphresiwn","dieuqynsh periballontos","dieuqynsh dhmotikhs astynomias","epitroph anaqeshs episkeuwn kai synthrhsewn oxhmatwn kai mhxanhmatwn","dieuqynsh poleodomias","epitroph katatajhs ypochfiwn","grafeio programmatismou organwshs kai plhroforikhs",
"dieuqynsh oikonomikwn","dieuqynsh dioikhtikwn","dieuqynsh texnikwn","tmhma dhmotikou sumvouliou","grafeio dhmarxou","dieuqynsh pronoias","dieuqynsh poleodomias","epitroph poiothtas zwhs","oikonomikh epitroph",
"dhmos elafonhsou",
"tmhma dioikhtikwn yphresiwn","tmhma oikonomikwn yphresiwn","tmhma texnikwn yphresiwn","dhmotiko symvoulio","tmhma poleodomias","oikonomikh epitroph","agrotikhs anaptyjhs prostasias kai dhmosias ygeias","epitroph synthrhshs kai episkeuhs oxhmatwn",
"dieuqynsh oikonomikwn kai dioikhtikwn yphresiwn","dieuqynsh texnikwn yphresiwn kai periballontos","dieuqynsh poleodomikou sxediasmou oikismou kai xwrotajias","dieuqynsh dhmotikhs astynomias","dhmarxos","oikonomikh epitroph","dhmotikh koinothta","dhmotiko symvoulio","epitroph poiothtas zwhs","genikos grammateas",
"grafeio dhmarxou","dhmotiko symvoulio","oikonomikh epitroph","epitroph poiothtas zwhs","oikonomikh yphresia","dhmotikos paidikos staqmos d e epauliou","grafeio antidhmarxou","proswpiko","organismos paideias kai politismou","dhmotikh koinwfelhs epixeirhsh","sxolikh epitroph a/qmias ekpaideushs","sxolikh epitroph b/qmias ekpaideushs",
"dhmotiko symvoulio","texnikh yphresia","oikonomikh yphresia","dioikhtiko","oikonomikh epitroph","epitroph poiothtas zwhs",
"dhmotiko symvoulio","oikonomikh epitroph","dieuqynsh oikonomikwn","dhmotikh enothta abias",
"texnikh yphresia","oikonomikh yphresia","proswpikou","poleodomia","adeies katasthmatwn","oikonomikh epitroph","dhmotiko symvoulio","kaqariothtas","apofaseis dhmarxou","organismos topikhs anaptyjhs dymaiwn","diakhryjeis-prokhryjeis",
"genikh dieuqynsh","dieuqynsh dioikhtikwn yphresiwn","dieuqynsh texnikwn yphresiwn","dieuqynsh oikonomikwn yphresiwn","dieuqynsh programmatismou sxediasmou kai anaptyjhs","dieuqynsh dhmotikhs astynomias","dieuqynsh poleodomias","dieuqynsh koinwnikwn yphresiwn","dhmotikh koinothta xwrisths","dhmotikh koinothta dramas","sxolikh epitroph a/qmias ekpaideushs","sxolikh epitroph b/qmias ekpaideushs","autoteles tmhma topikhs oikonomikhs anaptyjhs","dhmarxos",
"dieuqynsh dioikhtikwn yphresiwn","dieuqynsh texnikwn yphresiwn","dieuqynsh oikonomikwn yphresiwn",
"dieuqynsh oikonomikwn yphresiwn","dieuqynsh dioikhtikwn yphresiwn","oikonomikh epitroph","epitroph poiothtas zwhs","grafeio dhmarxou","ektelestikh epitroph","grafeio epikoinwneias kai dhmosiwn sxesewn","grafeio dioikhtikhs bohqeias","nomikh yphresia","dhmotiko sumvoulio","oikonomikh epitroph","ektelestikh epitroph","grafeio dhmotikhs katastashs lhjiarxeioy allodapwn kai metanasteushs","grafeio anqrwpinou dynamikou kai dioikhtikhs merimnas","grafeio periballonts kai politikhs prostasias","grafeio kaqariothtas kai anakuklwshs","grafeio synthrhshs prasinou","grafeio hlektromhxanologikwn ergwn kai energeias","grafeio ydreyshs apoxeteushs kai adreyshs","grafeio proupologismou logisthriou kai promhqeiwn","grafeio esodwnperiousias kai tameiwn","kep","poleodomia","grafeio adeiodothsewn kai ryqmishs emporikwn drasthriothtwn","grafeio apasxolhshs kai tourismou","grafeio texnikwn ergwn kai sygkoinwnias","grafeio koinwnikhs politikhs kai politikhs isothtas twn fylwn","grafeio prostasias ygeias","grafeio paideias dia biou maqhshs kai politismou-aqlhtismou kai neas genias","grafeio paidikwn staqmwn","grafeio programmatismou anaptyjhs kai organwshs","grafeio diafaneias kai plhroforikhs","grafeio agrotikhs paragwghs","epitroph poiothtas zwhs",
"dioikhtikwn kai oikonomikwn yphresiwn","dieuqynsh dioikhtikwn yphresiwn","dieuqynsh oikonomikwn yphresiwn","grafeio programmatismou","dieuqynsh texnikwn yphresiwn kai periballontos","kep","oikonomikh epitroph","dhmotiko symvoulio","epitroph diagwnismou proslhcewn","epitroph poiothtas zwhs","symvoulio dhmotikhs koinothtas caxnwn",
"oikonomikou","dioikhtikou","texnikwn",
"tmhma yposthrijhs politikwn organwn","tmhma anqrwpinoy dtnamikoy","tmhma proypologismou kai logisthriou","tmhma promhqeiwn kai diaxeirishs ylikou","dieuqynsh anqrwpinou dynamikou kai dioikhtikhs merimnas","dieuqynsh oikonomikwn yphresiwn","oikonomikh epitroph","epitroph poiothtas zwhs","dieuqynsh texnikwn yphresiwn",
"oikonomikh epitroph","dhmos deskaths",
"dhmotiko symvoulio","oikonomikh epitroph","epitroph poiothtas zwhs","dioikhtikwn yphresiwn","oikonomikwn yphresiwn","texnikwn yphresiwn","poleodomias kai periballontos","dhmarxos","grafeio antidhmarxou","dhmotikh enothta delfwn","katasthmatwn epixeirhsewn kai emporioy","dhmotikh koinothta iteas","eketelestikh epitroph","periballonots prasinou kai politikhs prostasias","dhmotikh epitroph paideias","dhmotikh koinothta delfwn","dhmotikh enothta galajidioy","dieuqynsh dioikhtikwn yphresiwn",
"diwuqynsh oikonomikwn yphresiwn","texnikwn yphresiwn","dioikhtikwn uphresiwn","grafeio kaqariothtas kai kinhshs oxhmatwn","grafeio proswpikou","dhmotiko symvoulio","grafeio dhmotikhs arxhs","oikonomikh epitroph",
"diwuqynsh dioikhtikwn oikonomikwn yphresiwn-hlektronikhs diakyvernhshs kai diafaneias","oikonomikh epitroph","texnikwn yphresiwn","grafeio ekdoshs adeiwn ygeionomikou endiaferontos","dhmotiko symvoulio","poleodomia","epitroph poiothtas zwhs",
"dhmos gortynias","epitroph poiothtas zwhs","dhmotiko symvoulio",
"diwuqynsh oikonomikwn yphresiwn","texnikwn yphresiwn","dioikhtikwn uphresiwn","dhmotiko symvoulio","epitroph poiothtas zwhs","oikonomikh epitroph","dhmotikh epitroph diavouleushs","grafeio dhmarxou","grafeio antidhmarxwn tmhma promhqeiwn","grafeio antidhmarxwn tmhma oikonomikwn yphresiwn","grafeio antidhmarxwn adeiodothsewn kai ryqmisewn emporikwn ypoqesewn",
"dhmotiko symvoulio","grafeio dhmarxou","dioikhtikwn uphreswin","oikonomikwn yphresiwn","poleodomias","texnikwn yphresiwn","oikonomikh epitroph",
"oikonomikh uphresia","texnikwn yphresiwn","kaqariothta","dhmotiko symvoulio","oikonomikh epitroph","grafeio dhmarxou",
"dhmotiko symvoulio","oikonomikh epitroph",
"dhmotiko symvoulio","grafeio paideias","anwnymh monometoxikh etairia diaxeirishs akinhtwn","oikonomikh apitroph","dioihktikwn yphresiwn","texnikhs yphresias",
"dhmos vrilhssiwn","dhmotiko sumvoulio","oikonomikh epitroph","epitroph poiothtas zwhs","dhmarxos","grafeio antidhmarxou texnikwn yphresiwn","grafeio antidhmarxou oikonomikwn yphresiwn kai ydreushs","grafeio antidhmarxou kaqariothtas,periballontos kai politikhs prostasias","grafeio antidhmarxou dioikhtikwn uphresiwn","genikos grammateas","texnikwn yphresiwn","periballontos kai politikhs prostasias","dioikhtikwn kai koinwnikwn yphresiwn","oikonomikwn yphresiwn",
"dioikhtikwn kai oikonomikwn yphresiwn","tmhma dioihktikwn yphresiwn","tmhma oikonomikwn yphresiwn","tmhma koinwnikhs politikhs","texnikwn yphresiwn kai periballonots","tmhma meletwn ergwn kai poleodomias","tmhma periballonots kai h/m ejoplismou","tmhma poleodomias","grafeio dhmarxou",
"genikh dieuqynsh dioikhtikwn kai oikonomikwn","genikh dieuqynsh texnikwn yphresiwn","dieuqynsh programmatismou kai newn texnologiwn","dieuqynsh dioikhtikwn yphresiwn","dieuqynsh oikonomikwn uphresiwn","dieuqynsh kep","dieuqynsh dhmotikhs astynomias","dieuqynsh texnikwn uphresiwn","dieuqynsh poleodomias","dieuqynsh kaqariothtas","dieuqynsh prasinou","tmhma epikoinwneias kai dhmosiwn sxesewn","tmhma plhroforikhs-mhxanografhshs","tmhma programmatismou texnikwn ergwn","tmhma programmatwn","tmhma eswterikhs dioikhshs","tmhma dhmotikou sumvouliou kai dhmarxiakhs epitrophs","tmhma astikhs kai dhmotikhs katastashs","tmhma lhjiarxeiou","tmhma allodapwn","tmhma nomikwn proswpwn kai epixeirhsewn","tmhma dhmotikwn prosodwn","tmhma ekdosewn adeiwn katasthmatwn ygeionomikou endiaferontos kai adeiwn mousikhs","tmhma tameiou","tmhma logisthriou","tmhma misqodosias","tmhma promhqeiwn kai diaxeirishs ylikou","tmhma dhmotikhs periousias","tmhma ejuphrethshs politwn","tmhma eswterikhs antapokrishs","tmhma astynomeushs","tmhma parkometrwn","tmhma dioikhtikhs yposthrijhs","tmhma odopoiias","tmhma meletwn ktiriwn-plateiwn","tmhma kataskeuwn ktiriwn-plateiwn","tmhma synthrhsewn","tmhma h/m ergwn","tmhma fwteinhs shmatodothshs","tmhma texnikhs diaxeirhshs","tmhma poleodomias","tmhma sxediou polews","tmhma kykloforiakou sxediasmou","tmhma arxeiou","tmhma kaqariothtas kai apokomidhs aporimmatwn","tmhma synthrhshs mhxanikwn meswn kai apoqhkhs","tmhma texnikhs yposthrijhs","tmhma parkwn kai platewn","tmhma dendrostoixiwn","tmhma fytwriou-apoqhkhs","grafeio dhmarxou","yphresia pronoias","oikonomikh epitroph","epitroph poiothtas zwhs","dhmotikh enothta neas iwnias","dhmotikh enothta aiswnias","dhmotikh enothta neas agxialou","dhmotikh enothta agrias","dhmotikh enothta artemidas","dhmotikh enothta makrinitsas","dhmotikh enothta portarias","dhmotikh enothta iwlkou","epitroph parakolouqhshs dietwn sxediwn drashs doyk","epitroph parakolouqhshs dietwn sxediwn drashs dhki","epitroph parakolouqhshs dietwn sxediwn drashs diek","epitroph parakolouqhshs dietwn sxediwn drashs ko-dhpeqe","epitroph parakolouqhshs dietwn sxediwn drashs deob","epitroph parakolouqhshs dietwn sxediwn drashs koinwfelous politistikou organismou iwlkou","epitroph parakolouqhshs dietwn sxediwn drashs dhkena","grafeio ekdosewn oikodomikwn adeiwn","epitroph epiloghs ypochfiwn","epitroph parakolouqhshs dietwn sxediwn drashs ths dhkeda","epitroph parakolouqhshs dietwn sxediwn drashs iwnia","dhmotiko symvoulio","tmhma oikodomwn neas iwnias","tmhma poleodomikou sxediasmou neas iwnias","elegxou katastasewn","tmhma kthmatologiou kai poleodomikou sxediasmou","epitroph parakolouqhshs dietwn sxediwn drashs dhkepada","epitroph parakolouqhshs dietwn sxediwn drashs kepada","epitroph parakolouqhshs dietwn sxediwn drashs dekppa","yphresia koimhthriwn","dhmotikh enothta bolou","epitroph parakolouqhshs dietwn sxediwn drashs ths kekpa-diek",
"oikonomikh epitroph","koinwnikhs prostasias-poiothtas zwhs","texnikwn yphresiwn","anaptyjhs oikonomikwn-diafaneias-hlektronikhs diakyvernhshs","agrotikhs anaptyjhs-prostasias periballonots","kaqariothtas-hlektrofwtismou","dhmotikou sumvouliou","dhmotikwn yphresiwn","dhmotikh koinothta brasnwn","dhmotikh koinothta asprobaltas","dhmotikh koinothta rentinas",
"sxolikh epitroph dhmotikou kai nhpiagwgeiou anqhs","sxolikh epitroph 1ou dhmotikou nigritas","sxolikh epitroph 2ou dhmotikou nigritas","sxolikh epitroph 3ou dhmotikou nigritas","1on nhpiagwgeio nigritas","sxolikh epitroph 2ou nhpiagwgeiou nigritas","dhmotiko sxoleio terpnhs","nhpiagwgeia terpnhs","nhpiagwgeio flampourou","dhmotikos sxoleio kai nhpiagwgeio berghs","dhmotiko sxoleio dhmhtritsiou","nhpiagwgeio dhmhtritsiou","nhpiagwgeio triantafyllias","sxolikh epitroph epal-sek nigritas","sxolikh epitroph gymnasiou dhmhtritsiou","sxolikh epitroph gymnasiou nigritas","sxolikh epitroph gymnasiou sitoxwriou","sxolikh epitroph gymnasiou terpnhs","sxolikh epitroph lukeiou nigritas","sxolikh epitroph lukeiou gymnasiou mauroqalassas","dhmotiko sxoleio  mauroqalassas","nhpiagwgeio mauroqalassas","dhmotiko sxoleio kai nhpiagwgeio ibhrwn","dhmotiko sxoleio kai nhpiagwgeio sitoxwriou","kentro piadikhs merimnas agwghs kai frontidas nigritas","dhmotiko sumvoulio","kaph axinou","politistiko kentro axinou","dhmotikh koinwfelhs epixeirhsh axinou","pneumatiko politistiko kentro nigritas","dhmotiko kentro koinwnikhs prostasias paideias politismou kai aqlhtismou bisaltias",
"dioikhtikes kai oikonomikes yphresies","texnikwn yphresiwn kai periballontos",
"tmhma dioikhtiko","tmhma logisthriou-ejodwn","oikonomikwn yphresiwn","dioikhtikwn uphresiwn","tmhma h/m ergwn","tmhma poleodomiko","grafeio oikodomikwn adeiwn","tmhma prasinou-daswn","tmhma kaqariothtas","tmhma kynokomeiou","dhmotikh koinothta","tmhma yposthrijhs de ap.paulou","tmhma texniko-synthrhshs ergwn","texnikwn yphresiwn","programmatismou,organwshs kai plhroforikhs","tpe","poleodomias kthmatologiou periousias","periballontos kaqariothtas kai politikhs prostasias","topikhs oikonomikhs anaptyjhs","koinwnikhs prostasias paideias politismou","tmhma prostasias kai proagwghs dhmosias ygeias","tmhma koinwnikhs politikhs kai isothtas fylwn",
"tmhma esodwn","tmhma ejodwn","tmhma texnikwn yphresiwn","dieuqynsh dioikhtikou","tameio","dhmarxos","grafeio sthrijhs airetwn organwn","tmhmatarxhs dioikhtikou","dhmotiko sumvoulio","dhmotikh koinothta zeugolatiou","dhmotikh koinothta braxatiou","dhmotikh koinothta velou",
"dieuqynsh sioikhtikou","dieuqynsh oikonomikou","dieuqynsh texnikwn yphresiwn kai poleodomias","dhmarxos","oikonomikh epitroph","grafeio dhmotikou sumvouliou","epitroph poiothtas zwhs","symvoulio dhmotikhs koinothtas barhs","symvoulio dhmotikhs koinothtas boulas","symvoulio dhmotikhs koinothtas bouliagmenhs","antidhmarxos dioikhshs kai oikonomikwn","antidhmarxos texnikwn yphresiwn kai poleodomias","antidhmarxos texnikwn yphresiwn kai poleodomias bouliagmenhs",
"dioikhtikwn yphresiwn","oikonomikwn yphresiwn","poleodomias","meletwn","poleodomikwn efarmogwn","texnikwn ergwn","koinwnikhs politikhs","dhmotikh koinothta axarnwn","ektelestikh epitroph","epitroph poiothtas zwhs","oikonomikh epitroph","aprosdioristo","dhmotiko sumboulio","dhmarxos","genikos grammateas","p.k.q.","k.e.p.e.d.a.","a/baqmia sxolikh epitroph","b/baqmia sxolikh epitroph","dhmotikh frontida","epitroph epiloghs monimou proswpikou",
"dioikhtikh-oikonomiki yphresia","tameio","dhmotiko symvoulio","oikonomikh epitroph","dhmarxos astypalaias","a/baqmia sxolikh epitroph",
"dhmotiko sumvoulio","epitroph poiothtas zwhs","oikonomikh epitroph","epitroph apografhs","oikonomikwn yphresiwn","proswpikou","ekdoshs oikodomikwn adeiwn","poleodomikwn efarmogwn","h/m ergwn","sygkoinwniwn kai egktastasewn","dhmarxos",
"tmhma ergwn ypodomhs","tmhma texnikwn ergwn","tmhma dioikhtikwn yphresiwn","grafeio dhmarxou","tmhma ejodwn","tmhma esodwn","dhmotiko sumvoulio","tmhma programmatismou kai anaptyjhs","grammateia apofasewn oikonomikhs epitrophs","epitroph poiothtas zwhs",
"dioikhtikes kai oikonomikes yphresies","dhmos arxaias olympias","dhmarxos","dhmotiko sumvoulio",
"dieuqunsh yphresiwn","tmhma dioikhtikwn yphresiwn","tmhma oikonomikwn uphresiwn","tmhma texnikwn yphresiwn kai periballontos","dhmarxos","oikonomikh epitroph","epitroph poiothtas zwhs","eketelestikh epitroph","epitroph diavouleushs","dhmotiko sumvoulio",
"dhmos argiqeas",
"dhmotiko sumvoulio","tameio","oikonomikh epitroph","epitroph poiothtas zwhs","ektelestikh epitroph",
"dioikhtikwn oikonomikwn kai texnikwn yphresiwn","tmhma dioikhtikwn kai oikonomikwn yphresiwn","tmhma texnikwn yphresiwn kai periballonots","dhmarxos","dhmotiko sumvoulio","oikonomikh epitroph",
"dhmos antiparou",
"grafeio dhmarxou","dhmotiko symvoulio","tmhma texnikwn yphresiwn kai periballontos","d.k.e.d.a.","oikonomikh epitroph","poleodomiko grafeio","k.e.d.k.a.","oikonomikh yphresia","dhmotikh koinothta androu","epitroph poiothtas zwhs","dh.k.e.d.y.","koinwfelhs epixeirhsh koinwnikhs prostasias paideias kai periballonots","a/baqmia sxolikh epitroph","b/baqmia sxolikh epitroph","dhmotikh koinothta gauriou","epitroph touristikhs anaptyjhs kai probolhs","koinwnikhs prostasias politismou kai aqlhtismou",
"dioikhtikwn kai oikonomikwn yphresiwn","texnikwn yphresiwn","dhmarxos",
"programmatismou organwshs kai plhroforikhs","topikhs oikonomikhs anaptyjhs","periballonots kai politikhs prostasias","koinwnikhs prostasias paideias kai politismou","dioikhtikwn kai oikonomikwn yphresiwn","texnikwn yphresiwn kai poleodomias","kaph","pneumatiko kai kallitexniko kentro stafidokampou","pneumatiko kai politistiko kentro kyllhnhs","paidikos staqmos lexainwn",
"dhmotiko sumvoulio","antidhmarxou",
"dhmotiko sumvoulio","dhmotikh enothta gyqeiou","poleodomia","oikonomikh epitroph","epitroph poiothtas zwhs","tmhma texnikwn yphresiwn",
"dhmotiko sumvoulio","oikonomikh epitroph","dhmarxos","epitroph poiothtas zwhs",
"allhleggyhs kai koinwnikwn ypoqesewn","programmatismou,proypologismou kai newn texnologiwn","grafeio dhmarxou","oikonomikwn anaptyjhs kai dioikhshs","dhmotiko sumvoulio","grafeio programmatismou,proypologismou","grafeio newn texnologiwn","tmhma pronoias","tmhma koinwnikhs allhleggyhs","tmhma koinwnikwn politikwn","grafeio agrotikhs oikonomias","grafeio alieias","grafeio daneiodothsewn mhtrwwn epaggelmatwn tourismou kai apasxolishs","tmhma uposthrijhs organwn dhmou","grafeio dhmotikhs katastashs lhjiarxeiou menidiou","grafeio dhmotikhs katastashs lhjiarxeiou inaxou","tmhma anqrwpinou dynamikou","tmhma esodwn kai logisthriou","tmhma tameiou","kep","grafeio poleodomikwn kai xwrotajikwn qematwn","grafeio elegxou kai ekdoshs adeiwn","grafeio dioikhtikhs yposthrijhs","tmhma texnikwn ergwn kai synthrhshs ypodomwn","grafeio politikhs prostasias","tmhma periballontos kaqariothtas kai prasinou","kep inaxou","grafeio upodomwn inaxou","grafeio kaqariothtas inaxou","tameio inaxou","koinwnikhs yposthrijhs inaxou","kep menidiou","grafeio upodomwn menidiou","grafeio kaqariothtas menidiou","grafeio koinwnikhs yposthrijhs menidiou","tmhma texnikwn ergw nkai synthrhshs ypodomwn","tmhma oikonomikhs anaptyjhs","tmhma dhmotikhs katastashs lhjiarxeiou kai allodapwn","tmhma oikistikhs anaptyjhs kai poleodomikwn efarmogwn","oikonomikh epitroph","epitroph poiothtas zwhs",
"dhmotiko symvoulio","oikonomikh yphresia","grafeio dhmarxou","oikonomikh epitroph","dioikhtikh yphresia","grafeio proswpikou","dhmotikh koinothta elateias","dhmotikh koinothta katw tiqoreas","epitroph poiothtas zwhs","dhmotikh koinothta amfikleias","dhmotikh koinothta palioxwriou","texnikh yphresia",
"dhmotiko sumvoulio","dhmarxos","oikonomikh epitroph","tmhma dioikhtikwn kai oikonomikwn yphresiwn","texnikh yphresia",
"dhmarxos","dhmotiko sumvoulio","oikonomikh epitroph","epitroph poiothtas zwhs","anqrwpinou dynamikou kai dioikhtikwn yphresiwn","nomikwn ypoqesewn","astikhs kai dhmotikhs katastashs","ejyphrethshs you polith","epopteias nomikwn proswpwn","oikonomikwn yphresiwn","dhmotikhs periousas kai promhqeiwn","periballontos kai poiothtas zwhs","poleodomias","texnikwn yphresiwn-ergwn","kaqariothtas","dhmotikhs astynomias","ajiopoihsh eurwpaikwn kai dieqnwn porwn","genikou grammatea","antidhmarxos",
"oikonomikh dioikhtikh","texnikwn ergwn","oikonomikh epitroph","dhmotiko sumvoulio",
"oikonomikh yphresia","dioikhtikh yphresia",
"tmhma anqrwpinou dynamikou kai dioikhtikhs merimnas","tmhma yposthrijhs politikwn organwn","tmhma proupologismou,logisthriou kai promhqeiwn","tmhma eisodwnn periousias,kai tameiou","tmhma poleodomias","tmhma ergwn","dieuqynsh programmatismou organwshs kai tpe,periballontos kai poiothtas zwhs",
"dieuqynsh dioikhtikwn yphresiwn","dieuqynsh oikonomikwn yphresiwn","dieuqynsh texnikwn yphresiwn","dhmarxos","dhmotiko sumvoulio","oikonomikh epitroph","dieuqynsh periballonots","dieuqynsh koinwnikhs antilhchs","epitroph poiothtas zwhs",
"dioikhtiko-oikonomiko","texniko","dhmarxos","dhmotiko sumvoulio","xorhghsh adeiwn katasthmatwn","paidikos staqmos maurommatiou","paidikos staqmos aliartoy",
"dieuqynsh dioikhtikwn yphresiwn","dieuqynsh oikonomikwn yphresiwn","dieuqynsh texnikwn yphresiwn","tmhma periballontos","tmhma poleodomias","tmhma programmatismou,organwshs kai plhroforikhs","tmhma kaqariothtas anakyklwshs kai prasinou","grafeio diafaneias","grafeio dioikhtikhs vohqeias","tmhma dhmotikhs astynomias","nomikh uphresia","kep","dhmarxos","tmhma yposthrijhs politikwn organwn","tmhma dhmotikhs katastash kai lhjiarxeiou","tmhma allodapwn kai metanasteushs","tmhma anqrwpinou dynamikou","tmhma dioikhtikhs merimnas","tmhma proypologismoulogisthriou kai promhqeiwn","tmhma esodwn kai periousias","tmhma tameiou","tmhma ejuphrethshs politwn","tmhma eswterikhs antapokrishs","grafeio politikhs prostasias","grafeio programmatismou kai anaptyjhs","tpe","dhmotiko sumboulio","poleodomias kai periballontos","organwshs poiothtas kai apodotikothtas","grafeio texnologiwn plhroforikhs kai epikoinwneiwn ","topikhs oikonomikhs anaptyjhs","agrotikhs anaptyjhs","adeiodothsewn kai emporiou","apasxolhshs kai tourismou","tmhma apokomidhs kai anakyklwshs ylikwn","kaqarismou koinoxrhstwn xwrwn","synthrhshs prasinou","diaxeirhshs kai synthrhshs oxhmatwn","tmhma koinwnikhs prostasias","tmhma paideias politismou kai aqlhtismou","tmhma sygkoinwniakwn kai ktiriakwn ergwn","tmhma h/m ergwn kai shmatodothshs","ydraulikwn ergwn","sugkoinwniwn kai egkatastasewn","dhmotikh enothta plateos","dhmotikh enothta melikhs","dhmotikh enothta antigonidwn","dhmotikh enothta alejandreias",
"dieuqynsh dioikhtikwn yphresiwn","dieuqynsh texnikwn yphresiwn","dieuqynsh oikonomikwn uphresiwn","dieuqynsh paideias politismou kai aqlhtismou","dieuqynsh koinwnikwn yphresiwn","dieuqynsh proswpikou","dieuqynsh kaqariothtas","dieuqynsh khpwn denrostoixiwn paidikwn xarwn kai alswn","grafeio dhmarxou","grafeio genikou grammatea","dieuqynsh dhmotikhs astynomias","dieuqynsh kep","poleodomia","dhmotiko sumvoulio","oikonomikh epitroph","epitropoh poiothtas zwhs",
"tmhma promhqeiwn","sumvoulio dhmotikhs koinwnias","dieuqynsh dioikhtikwn yphresiwn","dieuqynsh oikonomikwn yphresiwn","antidhmarxia dioikhtikwn-oikonomikwn qematwn","dieuqynsh paideias politismou kai aqlhtismou","antidhmarxia programmatsimou diafaneias kai hlektronkhs diakyvernhshs","antidhmarxia koinwnikhs prostasias kai allhleggyhs","antidhmarxia astikou sxediasmou poleodomias kai xwrotajias","antidhmarxia kaqariothtas anakyklwshs","antidhmarxia kep kai dhmotikhs astynomias","antidhmarxia gewrgikhs anaptyjhs","antidhmarxia periballontos prasinou kai politikhs prostasias","antidhmarxia poleodomias","dhmotiko sumvoulio","dioikhtikh yposthrijh","dieuqynsh texnikwn yphresiwn","oikonomikh epitroph","epitroph poiothta zwhs","dieuqynsh programmatismou organwshs kai plhroforikhs","symvoiulio dhmotikhs koinothtas agiou kwn/nou","symvoiulio dhmotikhs koinothtas kainourgiou","dieuqynsh periballontos kai diaceirishs aporrimatwn","tmhma koinwnikhs prostasias kai allhleggyhs"," dieuqynsh meletwn sxediou polhs","dhmotiko sumvoulio panaitwliou",
"oikonomikh epitroph","grafeio dhmarxou","epitroph poiothtas zwhs","dhmotiko sumvoulio","oikonomikh uphresia",
"dioikhtikou","lhjiarxeiou","kaqariothtas","oikonomikou","dhmotikos symvoulio","oikonomikh epitroph",
"dhmotiko sumvoulio","oikonomikh epitroph","epitroph poiothtas zwhs","eketelestikh epitroph","topiko symvoulio dhmotikhs koinothas","topiko sumvoulio dhmotikhs koinothtas kamaterou","dioikhtikwn uphresiwn","texnikhs yphresias","oikonomikwn yphresiwn","diaxeirishs periballonots","epitroph diavouleushs","logisthrio","dhmotikoi brefonhpiakoi staqmoi","dh.k.e.a.a.","dhmotikh koinofelhs epixeirhshs kamaterou","epitroph dienergeias diagwnismwn ergwn","organismos neolaias kai aqlhshs ag.anargyrwn",
"dhmotiko symvoulio","dhmotikhs katastashs","allodapwn","logistikou","tameiakhs","esodwn","promhqeiwn","texnikwn yphresiwn","epriballontos","dhmotikhs astynomias","koinwnikhs merimnas","dhmarxos","mhxanografhshs","grammateias dioikhshs","politikhs prostasias","proswpikou","prolhpitkhs iatrikhs","ygeias kai pronoias","paidikwn ejoxwn","dioikhtiko","ekepaideutiko","kaqariothtas","prasinou-periballonots","oikonomikh epitroph","epitroph poiothas zwhs","meletwn kataskeuwn","sxediwn polews","h/m","nomikhs yphresias","sxolikh epitroph sxoleiwn b/qmias ekpaideushs","sxolikh epitroph sxoleiwn a/qmias ekpaideushs",
"dieuqynsh dioikhtikwn yphresiwn","dieuqynsh texnikwn yphresiwn","dieuqynsh periballontos","dieuqynsh oikonomikwn yphreswin","dieuqynsh dhmotikhs astynomias","tmhma koinwnikhs politikhs","tmhma paideias","grafeio dhmarxou","dieuqynsh poleodomias",
"dieuqynsh texnikwn yphresiwn kai periballontos","dieuqynsh dioikhtikwn kai oikonomikwn yphresiwn","dieuqynsh koinwnikwn kai politistikwn yphresiwn","oikonomikh epitroph","dhmotiko sumvoulio","epitroph poiothtas zwhs",
"dhmotiko sumvoulio","epitroph poiothas zwhs","oikonomikh epitroph","oikonomikh yphresia","koinwfelhs epixeirhsh kalycw","nomiko proswpo dhmosiou dikaiaou hrakleidhs",
"dhmotiko sumvoulio","oikonomikh epitroph",
"dhmarxos","grafeio antidhmarxou oikonomikwn","grafeio antidhmarxou texnikwn ergwn","grafeio antidhmarxou poleodomias","grafeio antidhmarxou kaqariothtas","grafeio antidhmarxou agrotikhs anaptyjhs","grafeio antidhmarxou dioikhshs kai strathgikou sxediasmou","grafeio antidhmarxou koinwnikhs politikhs","grafeio antidhmarxou hlektronikhs diakyvernhshs","grafeio antidhmarxou paideias neolaias","grafeio antidhmarxou eurwpaikwn programmatwn","dhmotiko sumvoulio","oikonomikh epitroph","epitroph poiothtas zwhs","1h dhmotikh koinothta","2h dhmatikh koinothta","3h dhmotikh koinothta","4h dhmotikh koinothta","dhmotikh koinothta alikarnassou","poleodomikwn leitourgiwn","texnikwn ergwn","koinwnikwn kai politistikwn yphresiwn","dhmotikos aqlhtikos organismoos","dokaph","programmatismou kai plhroforikhs","bikelaia dhmotikh vivlioqhkh",
"dioikhtikwn yphresiwn,dhmotikhs kai astikhs katastashs","texnikh yphresia","oikonomikh yphresia","epitroph poiothtas zwhs","oikonomikh epitroph","dhmotiko sumvoulio","nomiko proswpo dhmosiou dikaiou","b/qmia sxolikh epitroph","koinofelhs epixeirhsh","a/qmia sxolikh epitroph",
"dhmarxos","grafeio dhmotikou sumvouliou","dhmotikh epitroph diavouleushs","eketelestikh epitroph","epitroph poiothtas zwhs","oikonomikh epitroph","tmhma proswpikou","oikonomikh yphresia","texnikh yphresia","dhmotikh koinothta","dhmotikh epitroph paideias","dhmotikh astynomia",
"texnikwn yphresiwn","dioikhtikwn yphresiwn","oikonomikwn yphresiwn","kawariothtas periballontos kai prasinou","grafeio proedrou dhmotikou sumvouliou","tmhma adeiodothsewn kai ryqmishs emporikwn drasthriothtwn","dhmarxos","epitroph poiothtas zwhs","oikonomikh epitroph","tmhma tameiakhs yphresias","grafeio antidhmarxou dhmotikhs diakyvernhshs","koinwnikwn yphresiwn","tmhma pronoias-epoptoias kai elegxou",
"dhmos carwn","dhmotiko symvoulio","oikonomikh epitroph",
"dhmarxos","dhmotiko sumvoulio","oikonomikh epitroph","epitroph poiothtas zwhs","eketelestikh epitroph","dioikhtikwn","oikonomikwn","texnikwn","dhmotikh astynomia","dhmotikh koinothta","dhmotikh koinothta limena","dhmotikh koinothta maliwn","dhmotikh koinothta goubwn","dhmotikh koinothta episkophs","dhmotikh koinothta moxou","dhmotikh epitroph diavouleushs","dhmotikh koinothta anwpolhs",
"dioikhtikwn yphresiwn","oikonomikwn yphresiwn","kep","texnikwn yphresiwn","poleodomias","kaqariothtas","dhmotikhs astynomias","tmhma plhroforikhs kai newn texnologiwn","tmhma programmatismou kai eswterikou elegxou","tmhma dioikhtikhs yposthrijhs","tmhma anaptyjhs anqrwpinou dynamikoy","tmhma dhmotikhs katastashs","grafeio dhmatologiwn kai mhtrwou arrenwn","lhjiarxeio","tmhma politismou-aqlhtismou","dhmotikwn vivlioqhkwn","tmhma prosodwn","tmhma dapanwn","tmhma oikonomikhs diaxeirishs","tmhma dhmotkiwn sfageiwn-koimhthriwn kai laikwn agorwn","tmhma dhmotikou tameiou","tmhma meletwn","tmhma kataskewn","tmhma prasinou kai periballontos","tmhma programmatikhs symbashs palaias polhs","tmhma hlektrofotismou kai kykloforiakwn qematwn","tmhma poleodomikwn efarmogwn","tmhma oikodomikwn adeiwn","tmhma programmatismou kai anakyklwshs","tmhma apokomishs kai kaqarismwn","tmhma diaxeirhshs kai episkeuhs-sunthrhshs oxhmatwn","dhmotkh koinothta daratsou","dhmotikh koinothta soudas","dhmotikh koinothta tsikalariwn","dhmotikh koinothta apterwn","dhmotiko symvoulio","dhmotikh koinothta kounoupidianwn","dhmotikh koinothta arwneiou","dhmotikh koinothta sternwn","dhmotikh koinothta mouzoura","dhmotikh koinothta xordaikiou","sxolikh epitroph gymnasiou kounoupidianwn","dhmotikh epitroph paideias",
"dhmarxos",
"sxediasmou kai anaptyjhs","texnikwn yphresiwn","yposthrijhs ths mhmotikhs arxhs","dioikhtikwn yphresiwn kai anqrwpinou dynamikou","oikonomikhs diaxeirishs","periballontos","tmhma plhroforikhs","dhmosiwn sxesewn kai grammateias dhmarxou","lhjiarxeio","allodapwn","dhmotikhs kai astikhs katastashs","diaxeirhshs monimou proswpikou","misqodosias","esodwn","programmatismou","ajiologhshs diadikasiwn kai organwshs yphresiwn","tmhma dioikhtikhs yposthrijhs","diaxeirhshs proswpikou idiwtikou dikaiou","tameiakh yphresia","dhmotikhs sygkoinwnias","poleodomikwn efarmogwn","politikhs prostasias","dhmotikou koimhthriou","grammateias dhmotikwn organwn","koinwnikhs merimnas kai yposthrijhs eqelontismou","sxolikhs merimnas","logisthriou","ajiopoihshs ths dhmotikhs periousias","promhqeiwn kai diaxeirhshs ulikoy","dioikhtikhs uposthrijhs d/nshs texnikwn yphresiwn","meletwn","ergwn","texnikwn synergeiwn","tmhma hlektromhxanologikou","genikh dieuqunsh","grammateia genikhs dieuqynshs","dhmotiko sumvoulio","epitroph poiothtas zwhs","oikonomikh epitroph",
"oikonomikwn yphresiwn","dioikhtikwn uphresiwn","koinwnikhs politikhs","dhmotikhs astynomias","texnikhs yphresias","grafeiou dhmotikou symvouliou","dhmarxos","periballontos-ergatotexnikou proswpikou","grafeio proswpikou-misqodosias","poleodomias","oikonomikh epitroph","epitroph poiothtas zwhs","dhmotikh koinothta","dhmotikh koinothta anw losiwn","dhmotikh koinothta zefyriou","sxolikh epitroph a/qmias ekpaideushs","sxolikh epitroph b/qmias ekpaideushs","koinofelis epixeirhsh","paidikos staqmos","npdd parnhqa",
"dhmotiko sumvoulio","oikonomikh epitroph","dhmotiko sumvoulio","dhmos fournwn korsewn",
"aprosdioristo","antidhmarxos","dhmotiko sumvoulio","oikonomikh epitroph",
"dioikhtikwn yphresiwn","poleodomia","dhmotiko sumvoulio","dioikhtikwn -oikonomikwn yphresiwn perasmatos","oikonomiko","texniko","3o dhmotiko sxoleio","koinwnikhs proastasias kai allhleggyhs","oikonomikh epitroph","sumvoulio dhmotikhs koinothas flwrinas","koinwnikhs proastasias kai allhleggyhs politismou kai aqlhtismou","tomeas emporiou","koinwfelhs epixeirhsh","sxolikh epitroph a/qmias ekpaideushs","sxolikh epitroph b/qmias ekpaideushs","tomeas agrotikhs anaptyjhs-kthnotrofias-alieias","epitroph poiothtas zwhs",
"aprosdioristo","dhmotikh epitroph paideias","eketelestikh epitroph","dhmotiko sumvoulio","oikonomikh epitroph","epitroph poiothtas zwhs","epitroph synthrhshs kai episkeuhs oxhmatwn",
"dioikhtikwn yphresiwn","grafeio dhmarxou","oikonomikwn yphresiwn","texnikwn yphresiwn","plhroforikhs","kaqariothtas kai mhxanologikou","gewtexnikwn yphresiwn","kep","dhmotikhs astynomias","dioikhtikhs merimnas","proswpikou","dhmotikhs katastashs","allodapwn","koinwnikhs politikhs","dhmotikwn psosodwn","logisthriou","misqodosias kai asfalishs proswpikou","tameiakhs yphresias","promhqeiwn-diaxeirishs ulikou kai apoqhkhs","tmhma dhmotikou nekrotafeiou","tmhma progarammatismou meletwn-ergwn kai kataskeuwn","tmhma poleodomikwn qematwn","tmhma efarmogwn logismikou","tmhma texnikhs yposthrijhs","tmhma apomakrysmenwn yphresiwn","tmhma kaqariothtas koinoxrhstwn xwrwn","tmhma kinhshs kai maxanologikou ejoplismou","tmhma hlektrofwtismou","tmhma prasinou","tmhma alsous","tmhma prostasias periballontos","tmhma epikoinwneias me tous polites","tmhma eswterikhs antapokrishs","tmhma elgxou katasthmatwn,epixeirhsewn","tmhma elegxou kykloforias,staqmeyshs","dhmotiko sumvoulio","oikonomikh epitroph","epitroph poiothtas zwhs",
"grafeio programmatismou(agrotikh anaptyjh,organwsh kai plhroforikh)","dioikhtikwn kai oikonomikwn yphresiwn","dioikhtikwn uphresiwn","oikonomikwn uphresiwn","kep","texnikw yphresiwn kai periballontos","texnikwn ergw kai poleodomikwn efarmogwn","dhmotiko sumvoulio","ektelestikhs epitrophs","grafeio epitrophs poiothtas zwhs","oikonomikhs epitrophs","dhmotikhs koinothas","proswpikou","logisthriou,proupologismou-apologismou-kai promhqeiwn","typou kai epikoinwnias","sugkrothshs programmatismou-parakolouqhsh twn synergeiwn","organismos politismou-aqlhtismou-koinwnikhs prostasias-allhleggyhs",
"oikonomiko","dioikhtiko-grammateia dhmotikou sumvouliou","dioikhtikwn kai oikonomikwn yphresiwn","texnikwn yphresiwn",
"dioikhtikwn oikonomikwn uphresiwn","texnikwn yphresiwn kai periballontos","poleodomia","proswpikou","dhmotiko symvoulio","dhmotikh koinothta tympakiou","oikonomikh epitroph","epitroph poithtas zwhs","oikonomikh yphresia",
"dioikhtikwn yphresiwn","oikonomikwn uphresiwn",
"dioikhtikwn kai oikonomikwn uphresiwn","texnikwn yphresiwn kai periballontos",
"dhmarxos","oikonomikh epitroph","dhmotiko symvoulio","dhmotkh koinothta galata","tmhma promhqeiwn","grafeio kinhshs oxhmatwn","tmhma oikonomikou","topikh koinothta taktikoupolhs","proswpikou-proslhcewn","ektelestikh epitroph",
"kentikh yphresia","oikonomikh uphresia","genikos grammateas","texnikwn yphresiwn","dioikhtikwn yphresiwn","dhmotiko sumvoulio","epitroph poiothtas zwhs","oikonomikh epitroph","poleodomias kai xwrotajias","periballontos","ektelestikh epitroph","tmhma koinwnikhs pronoias","dhmotikhs astynomias","dhmotikh koinothta","ydreush kandhlas","epitroph ajiologhshs promhqeiwn","tmhma poleodomias kai ktiriodomikwn efarmogwn","epitroph prokhryjewn","tmhma ektelesews ergwn",
"dhmarxos","grafeio dioikhtikhs yposthrijhs dhmarxou kai antidhmarxwn","grafeio eidikwn symvoulwn","grafeio nomikhs yphresias","grafeio typou dhmosiwn sxesewn kai m.m.e.","grafeio giatrou ergasia kai texnikou asfaleias","genikos dieuqunths","dieuqynsh dioikhtikwn yphresiwn","dieuqynsh oikonomikwn yphresiwn","dieuqynsh texnikwn yphreswin kai poltikhs prostasias","dieuqynsh poleodomias","dieuqynsh prasinou kai khpotexnias","dieuqynsh kaqariothtas periballonots kai amajostasiou","dieuqynsh kep","dieuqynsh dhmotikhs astynomias","dieuqynsh programmatismou kai anaptyjhs","grafeio yposthrijhs dhm. ergou airetwn organwn kai dhm. epitropwn","grafeio proswpikou","tmhma eswterikhs yphresias","tmhma texnologiwn plhroforikhs kai epikoinwniwn","grafeio prwtokollou","grafeio klhthrwn,kawaristriwn,genikwn kaqhkontwn,odhgwn kai sxolikwn fylakwn","grafeio ypodoxhs politwn","grafeio dhmotikhs katastashs","grafeio dhmatologiwn","grafeio allodapwn","tmhma lhjiarxeiou kai politikwn gamwn","tmhma poleodomikwn efarmogwn","tmhma sxediou polhs","tmhma poleodomikou sxediasmou","tmhma programmatismou kai sxediasmou ergwn-meletwn","tmhma wrimanshs ergwn kai meletwn","tmhma ulopoihshs kai parakolouqhshs ergwn","tmhma synthrhsewn","tmhma politikhs prostasias","grafeio zwologikou khpou","grafeio periballontos","tmhma synthrhshs promhqeiwn","tmhma khpotexnikwn efarmogwn","grafeio prwtokollou poleodomias","tmhma dioikhtikhs yposthrijhs","dioikhtikh uposthrijh poleodomias","tmhma emporiou",
"dhmarxos","dhmotiko sumvoulio","oikonomikh epitroph","oikonomikh yphresia","epitroph poiothtas zwhs","ektelestikh epitroph","grafeio proswpikou","epitroph diavouleushs",
"tmhma programmatismou anaptyjhs kai organwshs","tmhma texnologiwn plhroforikhs kai epikoinwniwn","tmhma texnikwn yphresiwn","tmhma dhmarxou","oikonomikwn yphresiwn","grafeio dioikhtikhs uposthrijhs airetwn organwn","grafeio koinwnikhs merimnas","tmhma poleodomias","tmhma esodwn","tmhma proswpikou","grafeio adeiodothsewn","oikonomikh epitroph","dhmotikh koinothta thnou",
"oikonomikh epitroph","dhmotiko symvoulio","dhmarxos",
"grafeio dhmotikhs katastashs","dhmotiko symvoulio","texnikhs yphresias","grafeio ejodwn","grafeio misqodosias","grafeio esodwn","grafeio promhqeiwn","dhmotikh koinothta oinofutwn","tameio","n.p.d.d.",
"dhmarxos","dhmotiko symvoulio","oikonomikh epitroph","ektelestikh epitroph","antidhmarxos",
"dioikhtikwn kai oikonomikwn yphresiwn","dioikhtikwn kai oikonomikwn yphresiwn dhmotikhs enothtas poseidwnias","dioikhtikwn kai oikonomikwn yphresiwn dhmotikhs enothtas anw syrou","texnikwn yphresiwn","poleodomias","dhmotikhs astynomias","periballontos","programmatismou kai organwshs","agrotikhs anaptyjhs","nomikhs yposthrijhs","ygeias kai pronoias","oikonomikh epitroph","grafeio yposthrijhs airetwn organwn","dhmotikh enothta",
"dioikhtikwn kai oikonomikwn yphresiwn","texnikwn yphresiwn kai periballonotos","dhmarxos",
"dhmotikh enothta stylidas","dhmotikh enothta exinaiwn","dhmotikh enothta pelasgias",
"oikonomikh epitroph","dhmos spetswn","dhmotiko symvoulio","oikonomikh yphresia","dioikhtikwn-oikonomikwn yphresiwn","xorhghshs adeiwn katalhchs koinoxrhstwn xwrwn",
"dioikhtikwn yphresiwn","oikonomikwn yphresiwn","yposthrijhs dhmotikwn organwn","texnikh yphresia","poleodomias","sumvoulio dhmotikhs koinothtas spatwn","symvoulio dhmotikhs koinothtas artemidos","programmatismou plhroforikhs kai organwshs","epitroph poiothtas zwhs","dhmotiko sumvoulio",
"texnikwn yphresiwn kai periballontos","dioikhtikwn oikonomikwn yphresiwn","poleodomias","texnikwn ergwn","koinwnikhs pronoias","dhmotikhs astynomias","dioikhtikwn yphresiwn","oikonomikwn yphresiwn","programmatismou organwshs kai plhroforikhs","yposthrijhs airetwn organwn","epitroph paideias",
"texnikh yphresia","grafeio proswpikou","dhmtalogio","lhjiarxeio","dhmotiko sumvoulio","oikonomikh epitroph kai poithtas zwhs","logisthrio","esoda","tameio","oikonomikh uphresia","dioikhtikh yphresia","dhmarxos","oikonomikh epitroph","ektelestikh epitroph","epitroph poiothtas zwhs","epitroph paideias","grafeio dhmarxou",
"dhmos soufliou","oikonomikh epitroph","dhmotiko sumvoulio","oikonomikwn kai dioikhtikwn yphresiwn","texnikh yphresia",
"dhmarxos",
"dhmos skyrou","oikonomikh yphresia","oikonomikh epitroph","koi.p.a.p.","pe.a.p.",
"oikonomikh yphresia","dhmarxos","grafeio airetwn-dhmarxou","dh.k.e.","dh.k.e.a. menhidios","grafeio airetwn-antidhmarxou","oikonomikh epitroph","paidikos staqmos mandalou",
"dioikhtikwn kai oikonomikwn yphresiwn","texnikwn yphresiwn kai periballontos","grafeio dhmosiwn sxesewn kai enhmerwshs tou polith","dhmotikhs katastashs","proswpikou","dioikhtikwn yphresiwn","oikonomikwn yphresiwn","texnikwn yphresiwn","periballonots","grafeio prosodwn","grafeio logisthriou-proupologismou","grafeio tameiou","grafeio promhqeiwn kai diaxeirishs ulikou","mhxanografhshs kai plhroforikhs","dhmotikhs astynomias","grafeio meletwn kai kataskeuwn","grafeio kataskeuwn kai synthrhsewn h/m ergwn","poleodomias","kaqariothtas","dhmotikou koimhthriou","dhmotikou sfageiou","kinhshs mhxanhmatwn","politikhs prostasias","dhmotikou sumvoulio","oikonomikh epitroph","dhmarxos",
"grafeio proswpikou","dhmarxos-plwmariths nikolaos","grafeio dhmarxou","oikonomikh epitroph","proedros dhmotikou symvouliou","antidhmarxos dioikhtikwn kai oikonomikwn yphresiwn","poleodomias","proedreuwn dhmotikos symvoulos","dhmotikh epitroph paideias",
"dioikhtikwn kai oikonomikwn yphresiwn","oikonomikh yphresia","tameio","oikonomikh epitroph","dhmotikh kointhta apollwnias","topikh koinothta artemwna","dhmarxos","dhmotiko sumvoulio",
"dioikhtiko","oikonomiko","yposthrijhs airetwn organwn","periballontos","texniko","dhmotikh enothta feneou","dhmotikh enothta stymfalias","dioikhtikwn kai oikonomikwn yphresiwn","dhmotiko sumvoulio","programmatismou,organwshs,plhroforikhs,koinwnikwn kai politistikwn qematwn",
"tmhma esodwn","tmhma promhqeiwn","tmhma ejodwn","grafeio dhmarxou","tmhma uposthrijhs politikwn organwn","oikonomikou-dioikhtikou","dhmotikh koinothta nikhths","tmhma texnikwn ergwn","tmhma ydreushs-apoxeteushs","dhmotikh koinothta sarths","dhmotikh koinothta sykias","dhmotikh koinothta agiou nikolaou","dhmotikh koinothta n.marmara","texnikwn yphresiwn","epitroph ajiologhshs proslhchs epoxikou proswpikou gia tin sox 1/2011","epitroph synthrhshs kai episkeuhs oxhmatwn","epitroph ajiologhshs proslhchs epoxikou proswpikou gia tin sox 2/2011","epitroph ajiologhshs proslhchs epoxikou proswpikou gia tin sox 3/2011","epitroph arqrou 5 tou nomou 3345/2005",
"grafeio dhmarxou","dioikhtikwn kai oikonomikwn yphresiwn","texnikwn yphresiwn","kaqariothtas kai prasinou","dhmotikhs astynomias","dhmotiko symvoulio","oikonomikh epitroph","epitroph poiothtas zwhs","dhmotikh koinothta","a kaph","b kaph","mouseio fysikhs istorias","aqlhtikos organismos","kentro prosxolikhs agwghs","tmhma poleodomias-1 nom","tmhma poleodomias-2 dhmou","epitroph synthrhshs kai episkeuhs oxhmatwn",
"oikonomikh epitroph","dhmotiko sumvoulio","tmhma dioikhtikwn kai oikonomikwn yphresiwn",
"dioikhtikwn yphresiwn","oikonomikwn yphresiwn","texnikwn yphresiwn","yposthrijhs airetwn",
"texnikwn uphresiwn","anqrwpinou dunamikou","tmaeiakhs uphresias","dhmos sarwnikou","symvoulio dhmotikhs koinothtas anabyssou","symvoulio dhmotikhs koinothtas palaias fwkaias","symvoulio dhmotikhs koinothtas sarwnidas","symvoulio dhmotikhs koinothtas koubara","proupologismou-logisthriou-promhqeiwn","promhqeiwn","diplografikou logisthriou","symvoulio dhmotikhs koinothtas kalybiwn","oikonomikh epitroph","ektelestikh epitroph","dhmotiko symvoulio",
"grafeio dhmarxou","grafeio dhmotikou sumvouliou","grafeio oikonomikhs epitrophs","yphresia dioikhshs","oikonomikh yphresia","tmhma diafaneias","texnikh yphresia","tmhma pronoias","tmhma poleosomias","dhmotikh enothta pyqagoreiou","dhmotikh enothta karlobasou","dhmotikh enothta marauokampou","dhmotikh enothta baqeos","dhmotikh enothta karlobasou","dhmotikh enothta maraqokampou","dhmotikh enothta puqagoreiou","dhmotikh enothta mytilhniwn","dhmotikh enothta pagwnda","dhmotikh enothta samou","dhmotikhs astynomias","katasthmatwn","grammatea",
"texnikh yphresia","dioikhtikh-oikonomikh uphresia","programmatismou kai anaptyjhs",
"texnikwn yphresiwn","oikonomikwn uphresiwn","dioikhtikwn yphresiwn","periballontos kai piadikwn xarwn","dhmarxou","poleodomias","dhmotikh koinothta","lieniko tameio","n.p.d.d. aqlhshs, koinwnikhs politikhs kai paideias","n.p.d.d. sxolikh epitroph b.qmias ekpaideushs",
"dioikhtikwn yphresiwn kai poithtas zwhs","oikonomikwn kai tameiou","texnikwn yphresiwn","poleodomikwn efarmogwn","prostasias periballonots","strathgikou sxediasmou","mesaiwnikhs polhs kai arxaiologikwn xwrwn","dhmotikhs astynomias","oikonoikh epitroph","grafeia prwsopikou notias rodou","esodwn kai perisousias","dhmotiko sumvoulio","grafeio dhmarxou","epitroph poiothtas zwhs","dhmotikh enothta kalliqeas","dhmotikh koinotha emponas","sxolikh epitroph gymnasiou paradeisiou","protogeneis tomeas kai topikhs anaptyjhs","prosxolika kentra","epitroph gia thn paraxwrhsh qesewn apokleistikhs staqmeushs se amea kai gia fortoekfortwseis","troxaia ulikou kai mhxanhmatwn","dhmotikh koinothta afantou","koinwnikhs politikhs kai ygeias","b/qmia sxolikh epitroph","a/qmia sxolikh epitroph","emporiou-energeias kai biomhxanias","dhmotikh enothta ialysou-arxaggelou","plhroforikhs kai newn texnologiwn","koinwnikhs politikhs kai ygeias",
"proswpikou","dioikhtikwn kai oikonomikwn yphresiwn","texnikwn yphresiwn","aprosdioristo","katasthmatwn kai emporikwn drasthriothtwn","poleodomias","oikonomikh epitroph","dhmotiko sumvoulio","epitroph epiloghs proswpikou","grafeio ekpaideushs","epitroph poiothtas zwhs","dhmotikhs koinothtas","dhmarxos","plhjroforikhs","promhqeiwn","epitroph epiloghs proswpikou ths yp","epitroph epiloghs proswpikou ths up'kai prokhrujhs",
"texnikwn yphresiwn","oikonomiko tmhma","dioikhtiko","tameiakh yphresia","dioikhtikou-oikonomikou","uphresias kaqariothtas","periballontos kai prasinou","ydreushs","dhmos rafhnas-pikermiou","dhmos rafhnas-pikermiou","dhmotikh koinothta pikermiou attikhs",
"dioikhtikwn phresiwn","dhamrxos","antidhmarxos","oikonomikwn uphresiwn","texnikwn yphresiwn","oikonomikh epitroph","dhmotiko symvoulio",
"dhmotiko symvoulio","poleodomias","epitroph poiothtas zwhs","dhmotikh oinothta pylou","dhmotikh koinotha xwras","oikonomikh epitroph","tmhma texnikwn yphresiwn",
"dioikhtikou/ode","organwshs kai sxediasmou","qemata proswpikou","epitroph poiothtas zwhs","dioikhtikou/adeiwn katasthmatwn,epixeirhsewn kai emporiou","texnikwn ergw kai yphresiwn poleodomikwn qematwn","oikonomikh epitroph","dhmotiko symvoulio","genikes yphresies","dieuqynsh dioikhtikwn kai oikonomikws yphresiwn/oikonomikes uphresies","dieuqynsh dioikhtikwn kai oikonomikwn yphresiwn/dioikhtikes uphresies",
"oikonomikh epitroph","dieuqynsh dioikhtikwn-oikonomikwn yphresiwn","dhmotiko symvoulio","epitroph poiothtas zwhs","dhmarxos","dieuqynsh texnikwn yphresiwn","sxolikh epitroph",
"dioikhshs","texnikhs yphresias","symvoulio dhmotikhs koinothtas aiginiou","dhmotikos foreas politsmou-aqlhshs-periballontos kai oikogeneiakhs yposthrijhs","dhmotikh koinofelhs epixeirhsh","a/qmia sxolikh epitroph","b/qmia sxolikh epitroph",
"dioikhtikwn-oikonomikwn-texnikwn yphresiwn kai periballontos","tmhma oikonomikou","tmhma dioikhtikou","tmhma texnikw yphresiwn kai periballontos","tmhma kep","frageio afotikhs anptyjhs","epitroph poithtas zwhs","oikonomikh epitroph","ektelestikh epitroph","dhmotiko sumvoulio","dhmarxos","dhmotikh koinothta","t.o.e.b.","t.o.e.b. sitagrwn-mylopotamou",
"dhmarxos","dhmotiko sumvoulio","oikonomikhs epitrophs","ektelestikhs epitrophs","logisthriou",
"oikonomikh uphresia","dhmotiko sumvoulio","oikonomikh epitroph","ektelestikh epitroph","dioikhsh anqrwpinou dynamikou","proupologismou","promhqeiwn","tmaeiakh yphresia","texnikwn ergwn","poleodomias","politikhs prostasias","dhmotikhs katastashs","periballontos kai poiothtas zwhs","oikonomikhs anaptyjhs","dhmarxos",
"grafeio uposthrijhs politikwn organwn","tmhma texnikwn yphresiwn kai periballontos","oikonomikh yphresia",
"oikonomikh epitroph","epitroph poiothtas zwhs","dhmotiko sumvoulio","dhmarxos","tmhma logistiko","oikonomikh yphresia","dioikhtikh yphresia",
"tmhma dioikhtikou","dioikhtikwn yphresiwn","proswpikou","kep","kaqariothtas","oikonomikwn yphresiwn","programmatismou","texnikwn yphresiwn","sxediou polews kai poleodomias","epimeleias prasinou","periballontos","mhxanologikou","antidhmarxou oikonomikwn","dhmarxou","antidhmarxou poleodomias","antidhmarxou programmatismou texnikwn ergwn kai periballontos","antidhmarxou dhmotikhs astynomias kai koinwnikhs merimnas","antidhmarxou kaqariothtas","antidhmarxou paideias kai hlektronikhs diakybernhshs","antidhmarxou ergwn odopoiias","genikou grammatea","proedros dhmotikou sumvouliou","epitroph poiothtas zwhs","oikonomikh epitroph","tmhma plhroforikhs","tmhma tameiakhs yphresias","tmhma proupologismou","tmhma dhmatologiou-lhjiarxeiou","sxolikhs merimans","proswpikou","prwtokollou","esodwn","tmhma dapanwn","promhqeiwn apoqhkwn kai dhmotikhs periousias","dhmotikou koimhthtriou","aodhp","tmhma dhmotikou sumvouliou","grafeio typou","nomikh yphresia","dhmotikoi brefonhpiakoi staqmoi","dhmotikh epitroph paideias","prwhn ibsa","g.papadakhs","sxolikh epitroph 4ou dhmotikou sxoleiou-44ou nhp/geio","organismos prosxolikhs agwghs aqlhtismou kai pronoias",
"dioikhtikwn yphresiwn","dioikhtiko","proswpikou","dhmotikou sumvouliou kai dhmarxiakhs epitrophs","oikonomikwn yphresiwn","eidikhs tameiakhs yphresias","dhmotikwn prosodwn","logisthriou-proupologismou-diaxeirishs","promhqeiwn","misqodosias","texnikwn yphresiwn","meletwn","kataskeuwn","sunthrhshs mikroergwn","apoxeteushs-ydreushs-odopoiias","hlektromhxanologiko","poleodomias","kaqariothtas","kinhshs oxhmatwn","hlektrofwtismou","meletwn kai anaptyjhs prasinou","prasinou","dhmotikh koinwfelhs epixeirhsh","oikonomikh epitroph","poithtas zwhs","oikonomikh epitroph kai poiothtas zwhs","dhpais","dhmotikh epitroph paideias","sxolikh epitroph a/qmias ekpaideushs","sxolikh epitroph b/qmias ekpaideushs",
"dhmarxos","dioikhtikou kai anqrwpinou dynamikou","dioikhtikwn organwn","dioikhshs kai katasthmatwn","proswpikou","oikonomikwn uphresiwn","ejodwn kai logisthriou","esodwn","promhqeiwn","tameiakhs uphresias","astikhs kai dhmotikhs katastashs","texnikwn yphresiwn","poleodomikwn qematwn kai periballonots","ulopoihshs upodomwn","newn texnologiwn","xwrotajikou poleodomikou sxediasmou kai texnikwn ergwn","oikonomikh epitroph","epitroph poiothtas zwhs","dhmotiko sumvoulio","dhmotikh koinothta pentelhs","dhmotikh koinothta melissiwn","dhmotikh koinothta neas pentelhs","dhmarxos","antidhmarxos",
"dhmotiko sumvoulio","oikonomikh epitroph","epitroph poiothtas zwhs","ektelestikh epitroph","genikh grammateia","dioikhtikwn-oikonomikwn yphresiwn","texnikwn yphresiwn","poleodomias","proswpikou","dhmarxou","oikonomikwn yphresiwn","antidhmarxou dioikhtikwn kai oikonomikwn yphresiwn","antidhmarxou prasinou-khpotexnias","antidhmarxou dhmotikhs astynomias kai katasthmatwn ygeionomikou endiaferontos","antidhmarxou newn texnologiwn kai hlektronikhs diakyvernhshs","antidhmarxou brefwonhpiakwn staqmwn","antidhmarxou merimnas yperhlikwn","antidhmarxou odopoiias-hlektrologikou","antidhmarxou periballontos dhmosiwn kai dieqnwn sxesewn","b dhmotikh koinothta","dieuqynsh hlektronikhs diakybernhshs","arxitektonikou kai genikou sxediasmou polhs","odopoiias-apoxeteushs","a dhmotikh koinothta","dioikhshs","politismou","epitroph dienergeias diagwnismwn-misqwsewn-ekmisqwsewn-ekpoihsewn","kaqariothtas",
"dhmotikh enothta eukarpias","dhmotikh enothta polixnhs","dhmotikh enothta stauroupolhs","dioikhtikwn yphresiwn","texnikwn uphresiwn","kaqariothtas","politismou","koinwnikhs politikhs","dhmotikhs astynomias","dhmarxos","oikonomikh epitroph","epitroph poiothtas zwhs","oikonomikwn yphresiwn","dhmotiko sumvoulio",
"grafeio dhmarxou","dioikhshs kai anqrwpinou dynamikou","proswpikou","ygieinhs kai asfaleias","dioikhtikhs uposthrikjhs dhmotikou symvouliou","ejyphrethshs politwn-dhmotwn","dhmotikh koinothta paralias","dhmotikh koinothta obryas","dhmotikh koinothta arktikou tomea","dhmotikh koinothta anatolikou tomea","dhmotikh koinothta notiou tomea","dhmotikh koinothta kentrikou tomea","oikonomikhs diaxeirishs","prosodwn","promhqeiwn kai apoqhkwn","programmatismou","plhroforikhs","poleodomikou sxediasmou kai efarmogwn","ergwn","kaqariothtas","diaqeshs kai dieuqethshs aporrimatwn","periballontos kai prasinou","synthrhshs","koinwnikhs pronoias","paideias","ygeias","eqelontismou","dhmotikhs astynomias","poleodomias","prwhn tydk ths dieuqynshs aytod/shs kai apok/shs p.d.e.","dhmotikh koinothta riou","dhmotikh koinothta ag. basileiou","dhmotikh koinothta braxnapkwn","dhmotikh koinothta sarabaliou","dhmotikh koinothta elikistras","dhmotikh koinothta souliou","dhmotikh koinothta moira","dhmotikh koinothta aktaiou","dhmotikh koinothta plataniou","dhmotikh koinothta monodendriou","dhmotikh koinothta tsoukalapkwn","dhmotikh koinothta kaminiwn","dhmotikh koinothta qerianou","dhmotikh koinothta petrwtou","dhmotikh koinothta krhnhs","dhmotikh koinothta sellwn","dhmotikh koinothta argyras","dhmotikh koinothta pititsas","dhmotikh koinothta araxwbitikwn","dhmotikh koinothta drepanou","dhmotikh koinothta caqopurgou","dhmotikh koinothta anw kastritsiou","dhmotikh koinothta katw kastritisiou","dhmotikh koinothta mintilogliou","dhmotikh koinothta roitikwn","oikonomikh epitroph","epitroph poiothtas zwhs","dhmotiko symvoulio","dhmotikh koinothta roggtikwn","dhmotikh koinothta kalliqeas","ektelestikh epitroph","dhmotkh epitroph diavouleushs","symvoulio entajhs metanastwn",
"grafeio nomikhs yposthrijhs","dhmarxos","grafeio programmatismou","dioikhtikwn-oikonomikwn yphresiwn","texnikwn yphresiwn kai periballonots","dhmotikhs astynomias",
"dhmos parou","sxolikh epitroph dhmotikou sxoleiou kai nhpiagwgeiou naousas dhmou parou","sxolikh epitroph 1ou dhmotikou-1ou nhpiagwgeiou-3ounhpiagwgeiou paroikias","texnikwn yphresiwn kai periballonots","oikonomikh epitroph",
"oikonomikh yphresia","texnikh uphresia","dhmarxos","proedros dhmotikou symvouliou","dhmotikwn koinothtwn","topikwn koinothtwn","poiothtas zwhs","oikonomikh epitroph","dhmotiko symvoulio","dhmotikh epitroph paideias","poleodomia","kentro politismou","dhmotikh enothta kanalakiou","dhmotikoi paidikoi staqmoi","oikonomikh yphresia kentrou politismou","apofaseis dhmotikou sumvoulioy","apogaseis proedrou npdd",
"texnikh yphresia","oikonomikh yphresia","dioikhtikh yphresia","dhmotikou sumvouliou","oikonomikh epitroph",
"promhqeiwn-metaforwn","dioikhtikwn yphresiwn","oikonomikwn yphresiwn","texnikwn yphresiwn","periballontos","kep","logisthriou","esodwn-dhmotikhs periousias","tmaeiakhs yphresias","dhmarxos","dhmotiko symvoulio","epitroph poiothas zwhs","oikonomikh epitroph",
"dhmotiko symvoulio","oikonomikwn yphresiwn","dioikhtikwn yphresiwn","oikonomikh epitroph","ektelestikh epitroph","politistikes kai kallitexnikes ekdhlwseis","grafeio dhmarxou",
"texnikh yphresia","dhmarxos","ode","dioikhtikh kai oikonomikh yphresia","poleodomias","koinwnikhs pronoias","dhmotiko sumvoulio","7h sxolikh epitroph","oikonomikh epitroph","epitroph poiothtas zwhs","topiko symboulio geraka","apitroph poiothas zwhs","ektelestikh epitroph","dioikhtiko sumvoulio ppkp","kentro prosxolikhs agwghs","kaph anqousas","sxolikh epitroph b/qmias ekpaideushs","sxolikh epitroph a/qmias ekpaideushs",
"grafeio dhmarxou","oikonomikh epitroph","proedros d.s.","epitroph epiloghs proswpikou","epitroph poiothtas zwhs","epitroph paideias","grafeio adeiwn katasthmatwn","kose",
"dioikhtikwn yphresiwn","oikonomikwn yphresiwn","dhmotikwn prosodwn","texnikwn yphresiwn","periballontos kai prasinou","kaqariothtas","dhmarxos","epitroph poiothas zwhs","oikonomikh epitroph","dhmotiko sumvoulio","ektelestikh epitroph",
"oikonomikh yphresia","tameio","texnikh yphresia","dioikhtikwn yphresiwn","tmhma plhroforikhs","grammateia dhmotikou symvouliou","tmhma promhqeiwn","tmhma programmatismou","grafeio gewrgikhs anaptyjhs","tmhma poleodomia kai poleodomikwn efarmogwn","dhmotikh enothta ajioupolhs","organismos aqlhtismou politismou neas genias ajioupolhs","dhmos paionias","d.e.y.a.","ygeias-pronoias","koinwfelhs epixeirhshs","sxolikh epitroph a/qmias ekpaideushs","sxolikh epitroph b/qmias ekpaideushs",
"dioikhtikwn yphresiwn","oikonomikwn yphresiwn",":texnikwn yphresiwn","periballontos","dhmotikhs astynomias","tmhma dioikhshs","dhmotikhs arxhs","astikhs katastashs","keop","logisthriou kai promhqeiwn","esodwn","tmhma ejodwn kai tameiakhs yphresias","meletwn","ergwn","kaqariothtas","prasinou","apoxeteushs kai ydreushs","tmhma elegxou katasthmatwn","tmhma elegxou kykloforias-staqmeyshs oxhmatwn","tmhma mhxanorganwshs kai programmatismou","tmhma kep","dhmotikh koinothta glykwn nerwn","dhmotikh koinothta paianias","dhmotiko symvoulio","dhmarxos",
"dioikhtikou","oikonomikou","texnikwn yphresiwn","dhmarxou","dhmotiko sumvoulio",
"oikonomikwn yphresiwn","dioikhtikwn uphresiwn","texsnikwn yphresiwn kai periballonotos","grafeio kinhshs-episkeuhs kai synthrhshs oxhmatwn","programmatismou kai anaptyjhs","dhmotiko symvoulio","oikonomikh epitroph","dhmarxos",
"dioikhtikwn kai oikonomikwn yphresiwn","texnikwn yphresiwn","dhmarxou","dhmotikhs koinothtas argous orestikou","oikonomikh epitroph","ektelestikh epitroph","epitoph poiothas zwhs","dhmotiko symvoulio",
"dhmarxos","lhjiarxeio","poleodomias","logisthriou kai proupologismou","texnikwn yphresiwn","tmhma promhqeiwn kai paroxhs yphresiwn","grafeio praktikwn dhmotikou sumboulio kai epitropwn","tmhma proswpikou kai misqodosias","dhmotikh koinothta","grafeio ekdoshs adeiwn katasthmatwn","oikonomikh epitroph","tmhma agrotikhs paragwghs","tmhma poleodomias","texnikwn uphresiwn periballontos kai poleodomias","dhmotikh epitroph paideias","topiko symvoulio petrwtwn","topikh koinothta kyprinou","topikh koinothta zwnhs","topikh koinothta fylakiou","kose","topikh koinothta baltou","topikh koinothta byssas","topikh koinothta riziwn","topikh koinothta kastanewn","topikh koinothta sternas","topikh koinothta kavylhs","topikh koinothtaqouriou","topikh koinothta neou xeimwniou","topikh koinothta ampelakiwn","topikh koinothta arzou","topikh koinothta dikaiwn","topikh koinothta elaias","topikh koinothta qerapeiou","topikh koinothta komarwn","topikh koinothta marasiwn","topikh koinothta mhleas","topikh koinothta ormeniou","topikh koinothta pentalofou","topikh koinothta plaths","topikh koinothta pteleas","topikh koinothta sphlaiou","sxediasmou kai anaptyjhs","kaqariothtas kai prasinou","epitoph poiothtas zwhs","grafeio prosodwn kai dhmotikhs perisousias","poleodomias","texnikwn yphresiwn","tmhma ekdoshs oikodomikwn adeiwn","elegxou kataskeuwn","tmhma poleodomikwn efarmogwn",
"oikonomikh epitroph","dhmotiko symvoulio","eniaia sxolikh epitroph a/qmias ekpaideushs","eniaia sxolikh epitroph gymnasiou lykeiakwn tajewn kai epal",
"dhmarxos","dioikhtikwn kai oikonomikwn yphresiwn","dioikhtkwn ypresiwn","tmhma oikonomikwn yphresiwn","texnikwn yphresiwn","dhmotiko symvoulio","oikonomikh epitroph","tmhma poleodomias-dioikhtikh uposthrijh","poleodomias","epitroph poiothtas zwhs","ektelestikh epitroph","sumvoulio dhmotikhs koinothtas","anaplhrwths dhmarxou","dhmotikh koinotha kimmeriwn","dhmotikh koinotha eumoirou",
"sxolikh epitropj dhmou afetwn","sxolikh epitroph gymnasiou mhlewn","sxolikh epitroph gymnasiou-lykeiou argalasths","sxolikh epitroph 1ou nhpiagwgeiou mhlewn","sxolikh epitroph 1ou dhmotikou sxoleiou mhlewn","paragwgikh kai emporikh mhlewn ota","sxolikh epitroph 2ou nhpiagwgeiou afetwn sykhs","sxolikh epitroph dhmotikou nhpiagwgeiou argalasths","3o dhmotiko sxoleio kai nhpiagwgeio mhlewn","sxolikh epitroph gymnasiou lukeiou trikeriou","1o nhpiagwgeio afetwn neoxwriou","sxolikh epitroph dhmotiskou sxoleiou-nhpiagwgeiou mhlinas","politistikos kai aqlhtikos organismos","sxolikh epitroph dhmotikou sxoleiou-nhpiagwgeiou mhlinas","1o nhpiagwgeio afetwn newxoriou","poiothta zwhs","ydreushs-apoxeteyshs","sxolikh epitroph a/qmias ekpaideushs","sxolikh epitroph b/qmias ekpaideushs","anaptyjiakh mhlewn",
"dhmotikh koinothta lewnidiou",
"dhmos nisurou","do.ko.po.me.","oikonomikh epitroph",
"dhmotikh koinothta kompotiou","dhmotiko sumvoulio","oikonomikh yphresia","texnikh uphresia","dhmarxos","dhmotikh koinothta peta","oikonomikh epitroph","epitroph poiothtas zwhs","grafeio proswpikou","grafeio antidhmarxou",
"oikonomikwn","poleodomias","shmotikou sumvouliou","promhqeiwn","dhmotikh enothta nikaias","dhmarxos","proswpikou","epitroph poiothas zwhs","poiothtas zwhs kai periballontos","dhmotikh enothta renth","ektelestikh epitroph",
"dioikhtiko","oikonomiko","texnikhs yphresias","kaqariothtas","kep","dhmotiko symvoulio","dhmotikh epitroph diavouleushs","ektelestikh epitroph","oikonomikh epitroph","epitroph poiothtas zwhs","grafeio proswpikou","sxolikh epitroph",
"dhmos nestoriou",
"grafeio dhmarxou","dioikhtikwn kai oikonomikwn yphresiwn","dhmotiko sumvoulio","oikonomikh epitroph",
"oikonomikh epitroph","epitroph poiothtas zwhs","dhmotiko sumvoulio","dioikhtikou","dioikhtiko tmhma","tmhma astikhs katastashs","tmhma koinwnikhs politikhs","periballontos","oikonomikou","logistiko tmhma","tmhma dhmotikwn prosodwn","tmhma promhqeiwn","tmhma dhmotikhs periousias","txenikwn uphresiwn","dhmotikhs astynomias","ergwn kai poleodomikwn efarmogwn","programmatismou kai anaptyjhs","hlektofwtismou","mhxanografhshs","dhmarxos",
"dioikhtikwn yphresiwn","oikonomikwn yphresiwn","koinwnikhs politikhs","kaqariothtas kai mhxanologikou","anqrwpinou dynamikou","programmatismou kai leitourgiwn yposthrijhs","dhmotikhs katastashs","kep","gewtexnikwn yphresiwn","texnikhs yphresias","dhmotikhs astynomias","poleodomias","dhmotikou sumvouliou","oikonomikh epitroph","epitroph poiothtas zwhs",
"tmhma dioikhshs","dioikhtikwn kai oikonomikwn yphresiwn","texnikwn yphresiwn","periballontos","oikonomikh epitroph","epitroph poiothtas zwhs","dhmotikh koinothta neapolhs","dhmotikh koinothta agiou paulou","dhmotikh koinothta peukwn","dhmotikh koinothta sukewn","dhmotiko symvoulio","ektelestikh epitroph",
"eidikwn synergatwn","grafeio grammatea dhmarxou","yposthrijhs airetwn organwn","programmatismou,organwshs kai plhroforikhs","dioikhtikwn kai oikonomikwn yphresiwn","dioikhtikwn yphresiwn","oikonomikwn yphresiwn","tmhma epoptwn fylakwn sxolikwn ktiriwn","kep","dhmotikhs astynomias","texnikwn yphresiwn kai periballonots","poleodomias","dhmoseias ygeias kai pronoias","agrotikhs anaptyjhs","dhmotikhs enothtas asinhs","dhmotikhs enothtas mideas","dhmotikhs enothtas neas tirynqas","kep 345",
"dhmotikhs astynomias","dioikhtikwn yphresiwn","tmhma dioikhtiko","astikhs kai dhmotikhs katastashs","kep","allodapwn kai metanasteushs","texnikwn yphresiwn","ergwn kai meletwn","periballonots","promhqeiwn","poleodomias","oikonomikwn yphresiwn","tmhma oikonomiko","tameiakhs yphresias","programmatismou organwshs kai plhroforikhs","koinwnikhs pronoias","agrotikhs anaptyjhs","yposthrijhs airetwn organwn","dhmarxou","dhmotikoi paidikoi brefonhpiakoi staqmoi",
"dhmos naousas","dhmarxos","poleodomia kai domikes efarmoges","ekdoshs oikodomikwn adeiwn","epitroph poiothtas zwhs","grafeio sxediou polhs","diaxeirishs kai ekmetalleyshs daswn","dhmotiko sumvoulio","oikonomikh epitroph","proswpikou","grafeio poristamenou oikonomikou tmhmatos","logisthriou","grafeio misqodosias","grafeio promhqeiwn","proupologismou","texnikh yphresia","periballontos","ekdoshs oikodomikwn adeiwn",
"dioikhtikwn kai oikonomikwn yphresiwn","texnikwn uphresiwn","oikonomikwn yphresiwn","airetoi",
"texnikh yphresia","dioikhtikwn kai oikonomikwn yphresiwn",
"dhmotikh koinothta","kentrikh yphresia","dhmotikh koinothta anw meras","dhmotiko sumvoulio","oikonomikh epitroph",
"grafeio proswpikou","yposthrijhs politikwn organwn","oikonomikwn yphresiwn",
"dioikhtikwn yphresiwn","oikonomikwn yphresiwn","texnikwn yphresiwn","periballontos","dioikhtiko","ulikou","dhmarxou","dhmotikh koinothta mosxatou","dhmotiko sumvoulio","dhmotikh koinothta taurou","oikonomikh epitroph","epitroph poiothtas zwhs",
"diokhtikwn yphresiwn","oikonomikwn yphresiwn","texnikwn yphresiwn periballontos kai poleodomias","programmatismou organwshs plhroforikhs kai diafaneias","topikhs oikonomikh anaptyjhs","koinwnikhs prosstasias paideias kai politismou",
"texnikwn yphresiwn","dioikhtikwn kai oikonomikwn yphresiwn","poleodomikwn efarmogwn sxediasmou kai periballontos","dhmotikhs astynomias","oikonomiko","kep","frontidas eupaqwn omadwn","diokhtiko","esodwn","dioikhtikhs yposthrijhs-plhroforikhs","ergwn kai meletwn","periballonots","koinwnikhs arwghs","uposthrijhs airetwn","dhmarxou","antidhmarxwn","poleodomias","elegxou kataskeuwn","poleodomikwn sxediwn kai kanonwn","epitroph poiothtas zwhs-oikonomikh epitroph","dhmotko sumvoulio","dhmotikh koinotha elountas","dhmotikh koinothta ag. nikolaou","oikodomikwn adeiwn","dhmotikh koinothta kritsas","ektelestikhs epitrophs",
"poleodomia","dhmotiko sumvoulio","dhmotikh koinothta adamanta","dhmotikh koinothta triobasalou","dhmotikh koinothta tryphths","dhmotikh koinothta mhlou","dhmotikh koinothta pera triobasalou",
"dhmarxos","dioikhtikwn qematwn","oikonomikwn yphresiwn","texnikwn yphresiwn",
"tameiakh yphresia","dioikhshs","anqrwpinou dynamikou","lhjiarxeiou","eklogwn","genikh grammateia",
"dioikhtikwn kai oikonomikwn yphresiwn","texnikwn yphresiwn","dioikhtiko","oikonomiko","meletwn-ergwn","poleodomias","proswpikou","eklogwn","dhmotiko sumvoulio","oikonomikh epitroph","epitroph poiothtas zwhs","ektelestikh epitroph","dhmotikhs koinothtas megarwn","dhmotikhs koinothtas neas peramou","dhmotikhs epitrophs paideias","laikwn agorwn emporiou kai agrotikhs anaptyjhs","dhmotikhs periousias-dhmotikwn epixeirhsewn-nekrotafeiwn-sfageiwn","adeiwn leitourgias katasthmatwn","proupologismou-apologismou","promhqeiwn","ejwterikwn yphresiwn","epitroph diavouleushs",
"oikonomikh yphresia","texnikh uphresia","dhmotiko sumvoulio","epitroph apografhs","dhmarxos",
"dhmotikh koinothta","dhmos","oikonomikh epitroph","dhmotiko symvoulio","pleodomiko grafeio","epitroph poiothtas zwhs",
"dioikhtikwn yphresiwn","oikonomikwn yphresiwn","texnikwn yphresiwn kai periballontos","yposthrijhs sullogikwn organwn","grafeio proswpikou",
"texnikwn yphresiwn","oikonomikwn yphresiwn","dioikhtikwn yphresiwn","koinwfelhs dhmotikh epixeirhsh","poleodomias","n.p.d.d. koinwnikwn aqlhtikwn politistikwn kai periballontikwn drasthriothtwn braurwnios",
"dhmotiko sumvoulio","dhmotikh koinothta neas makrhs","dhmotikh koinothta maraqwnos","dhmotikh koinothta grammatikou","dhmotikh koinothta barnaba","kentrikh yphresia","oikonomikh epitroph","epitroph poiothtas zwhs","dhmotiko symvoulio","dhmarxos","dioikhtikwn uphresiwn","oikonomiwn yphresiwn","texnikhs yphresias","grafeio antidhmarxou poliutismou,aqlhtismou kai paideias",
"oikonomikwn yphresinw","dioikhtikwn yphresiwn","dhmarxou","dhmotiko sumvoulio","oikonomikh epitroph","epitroph poiothtas zwhs","ektelestikh epitroph","epitroph synthrhshs oxhmatwn",
"dioikhtikou","oikonomikou","texnikh yphresia","periballontos","dhamrxou","dhmotikhs astynomias","dhmotikh koinothta peukhs","dhmotikh koinothta lukovryshs","dhmotiko sumvoulio","oikonomikh epitroph","epitroph poiothtas zwhs","ektelestikh epitroph","epitroph diavouleushs","dhmotikh epitroph paideias",
"aprosdioristo","dhmarxos","antidhmarxos dioikhtikwn kai oikonomikwn yphresiwn","oikonomiko kai dioikhtiko","periballontos kaqariothtas kai prasinou","texnikwn yphresiwn","proistamenos texnikhs yphresias","proedros dhmotikoi sumvouliou","antidhmarxos texnikwn yphresiwn","antidhmarxos politismou-aqlhtismou-tourimsou kai hlektronikhs diakyvernhshs","oikonomikh epitroph","poleodomias","me ejousiodothsh ypallhlos tmhmatos poleodomias","dhmotikhs koinothtas ag qeodwrwn","proedros dhmotiksh koinothtas loutrakiou","dhmotikhs koinothtas isqmias","antidhmarxos agiwn qeodwrwn","epitroph poiothtas zwhs","antiproedros d.s","antiproedros d.s",
"dhmotiko symvoulio","oikonomikh epitroph","texnikh yphresia","oikonomikh uphresia","dhmarxos",
"dhmarxos","epitroph poiothtas zwhs","oikonomikh epitroph","dhmotiko sumvoulio","oikonomikh yphresia","texnikh yphresia","poleodomia","proswpikou","pronoias","ektelestikh epitroph","dhmatologia","ejuphrethsh tou dhmoth","dhmotikh epitroph diavouleushs","dhmotikh koinothta myrinas",
"dioikhtikwn yphresiwn","oikonomikwn yphresiwn","tmhma dioikhshs","tmhma logistikou","tameiakhs uphresia kai prosodwn","texnikwn yphresiwn","ergwn-meletwn-promhqeiwn-ergasiwn","poleodomikwn sxediwn","dhmotiko sumvoulio","oikonomikh epitroph","poleodomias kai periballontos","elegxou kataskeuwn","dhmarxou","ekdoshs oikodomikwn adeiwn","epitroph poiothtas zwhs","symvoulio dhmotikhs koinothtas","grafeia antidhmarxwn","programmatismou organwshs kai plhroforikhs",
"promhqeiwn kai apoqhkhs","meletwn kai epiblechs ergwn","texnikwn yphresiwn kai periballonots","dioikhtikwn yphresiwn","airetwn organwn","dhmotikh astynomia","dhmarxos","tmhma dapanwn","oikonomikh epitroph","ekdoshs oikodomikwn adeiwn",
"tameio","grammateia","dhmotiko sumvoulio",
"dioikhtikwn yphresiwn","oikonomikwn uphresiwn","texnikwn yphresiwn","periballontos kai kaqariothtas","poleodomias","tmhma oikonomikhs dioikhshs kai logistikou","dhmos lebadewn",
"oikonomikh yphresia","dioikhtikh yphresia","texnikwn ergwn","dhmotiko symvoulio-diatakths","dhmotiko sumvoulio","oikonomikh epitroph-diatakths","oikonomikh epitroph","dhkedhl","enel ae","epitroph poiothtas zwhs","politistiko kentro","nomiko proswpo dhmosiou dikaiou 'qorikos'",
"dhmotiko symvoulio","oikonomikh epitroph","epitroph poiothtas zwhs","dioikhtikou","oikonomikwn yphresiwn","texnikwn yphresiwn","kaqariothtas periballontos","gewtexnikwn yphresiwn","poleodomias","dhmotikou amajostasiou","epixeirhsiakou sxediamou","dhmotikhs astynomias","ekdoshs oikodomikwn adeiwn","prosodwn","epitroph etoimorropwn ktiriwn","poleodomias loipwn dhmwn","auqairetwn kataskeuwn","sxolikh epitroph b/qmias  ekpaideushs","sxolikh epitroph a/qmias  ekpaideushs","topikhs agrotikhs oikonomias","prasinou","pronoias","koinwnikwn drasewn","ejuphrethshs tou polith","poleodomikhs yposthrijhs loipwn dhmwn","dhmotikh epitroph paideias",
"oikonomikwn yphresiwn","dioikhtikwn yphresiwn","organwshs kai sxediasmou","kep","texnikwn yphresiwn","poleodomias","periballontos","dhmotikhs astynomias","koinwnikhs politikhs-aqlhtismou-politismou","dhmotiko sumvoulio","oikonomikh epitroph","epitroph poiothtas zwhs","dhmotikh koinothta","prosodwn","dhmotikh koinothta staurou","ektlestikh epitroph","dhmotikh koinothta roditsas",
"dhmos lagkada","dhmotiko sumvoulio","oikonomikh epitroph","oikonomikwn yphresiwn","promhqeiwn","dioikhtikwn yphresiwn","tameiakhs yphresias","texnikwn yphresiwn","poleodomia","dhmarxos","epitroph poiothtas zwhs","dhmotikh koinothta asshrou","politikhs prostasias",
"dioikhtikh","oikonomikwn","programmatismou organwshs aki plhroforikhs","oikonomikh epitroph","epitroph poiothtas zwhs","ektelestikh epitroph","texnikwn yphresiwn","dhmotiko symvoulio","dhmotikh koinothta","dhmotikh koinothta antimaxeias","dhmotikh koinothta kardamainas","dhmotikh koinothta kegalou","dhmotikh koinothta pyliou","dhmotikh koinothta asfendiou","poleodomias","epitroph ajiologhshs","koinwnikhs prostasias kai llhleggyhs",
"dioikhtikh yphresia","oikonomikh uphresia","texnikh uphresia",
"dhmarxos","oikonomikh epitroph","dhmotiko sumvoulio","tmhma dioikhtikou-oikonomikou","etairia koinwnikhs merimnas","thmma promhqeiwn","dhmotikh koinwfelhs epixeirhsh",
"dieuqynsh dioikhshs",
"dioikhtikwn yphresiwn","oikonomikwn uphresiwn","texnikwn yphresiwn","periballontos","dhmarxou","oikonomikh epitroph","epitropj poiothtas zwhs","dhmotiko sumvoulio","ektelestikh epitroph","epitroph sunthrhshs kai episkeuhs oxhmatwn","nppd sfhttos",
"dioikhtikwn yphresiwn","oikonomikwn yphresiwn","kataskeuwn ergwn","dhmotiko symvoulio","oikonomikh epitroph","epitroph poiothtas zwhs","meletwn aki kthmatologiou","koinwnikwn yphresiwn","epitroph paideias","sxolikh epitroph a/qmias ekpaideushs","sxolikh epitroph b/qmias ekpaideushs","programmatismou kai anaptyjhs",
"dioikhtikwn yphresiwn","oikonomikwn uphresiwn","texnikwn yphresiwn","poleodomias,astikhs anaptyjhs kai periballontos","dhmotiko sumvoulio","dhmotikh koinothta","oikonomikh epitroph","epitroph poiothtas zwhs","dhmotikh koinothta galatakiou","koinwnikhs kai ekpaideutikh politikhs","kep","dhmotikh enothta solugeias ",
"dhmarxos","polodomias(prwhn tmhma poleodomia naq)","oikonomikh epitroph","dhmotiko sumvoulio","poleodomias(prwhn tmhma poleodomias kordeliou-eleuqeriou)","epitroph poiothtas zwhs","symvoulio dhmotikhs koinothtas","antidhmarxia oikonomikwn yphresiwn","kaqariothtas kai prasinou","meletwn kai ergwn",
"programmatismou ependysewn kai upodomwn","dioikhtikwn yphresiwn","oikonomikwn yphresiwn","poiothtas zwhs kai periballontos","koinwnikhs anatyjhs kai allhleggyhs","kep","dhmotikhs astynomias","anqrwpinou dynamikou","dhmotikhs katastashs","dioikhtikhs merimnas","logistikou proupologismou","promhqeiwn diaxeirishs ylikou kai apoqhkwn","tameiakhs yphresias","dhmotikwn prosodwn","dhmotikhs periousias","poiothtas zwhs kai kaqariothtas","anakuklwshs kai meleths kai sxediasmou periballontikwn programmatwn","khpotenias kai prasinou","programmatismou-elegxou epiqewrhshs kai mhxanografhsews","meletwn kai kataskeywn texnikwn ergwn","meletwn kai kataskeywn ergwn synthrhshs","poleodomias","paideias kai neas genias","yphresiwn ygeias kai pronoias","koinwnikhs anaptyjhs kai ependyshs","tmhma ejyphrethshs politwn","poleodomias","pronoias","dhmarxos","dhmotiko sumvoulio","grafeio sumvouliou dhmotikhs koinothtas komothnhs",
"dhmotiko sumvoulio","dhmarxos","poleodomia","dhmotikhs astynomias","oikonomikes yphresies","promhqeiwn","proswpikou","diaxeirishs aporrimatwn","oikonomikh epitroph","texnikwn yphresiwn","dioikhtikwn kai oikonomikwn yphresiwn","grafeio ekdoshs adeiwn poleodomias","epitroph poiothtas zwhs",
"dieuqynsh","akinhta monometoxikh a.e.","koinwfelhs epixeirhsh mhqymnhs",
"mhtrwou arrenwn","dhmatologiou","lhjiarxeiou","tmhma oikonomikwn","tmhma dioikhtikwn",
"dioikhtikwn yphresiwn","oikonomikou","tameiakh uphresia","topikhs oikonomikhs anaptyjhs","periballontos kaqariothtas synthrhshs kai diaxeirishs oxhmatwn","poleodomias","poleodomikwn efarmogwn","sygkoinwniakwn ktiriakwn ergwn kai loipwn ypodomwn","ereunas epopteias oikonomikhs kai grammateiakhs yposthrijhs","kinhshs oxhmatwn kai kaqariothtas","tmhma agrotikhs paragwghs alieias kai ergwn prasinou","programmatismou,organwshs kai plhroforikhs","koinwnikhs prostasias","dioikhshs kai uposthrijhs politikwn organwn","dhmotikhs katastashs","logisthriou kai proupologismou","esodwn kai periousias","dioikhtikwn kai oikonomikwn yphresiwn gallikou","texnikwn yphresiwn gallikou","dioikhtikwn kai oikonomikwn yphresiwn doiranhs","dioikhtikwn kai oikonomikwn yphresiwn krousswn","tmhma dioikhtikwn krousswn","tmhma oikonomikwn krousswn","dioikhtikwn kai oikonomikwn yphresiwn pikrolimnhs","kep pikrolimnhs","e.k.e. kep","dioikhtikwn kai oikonomikwn yphresiwn xersou","sugkoinwniakwn,ktiriakwn ergwn kai loipwn upodomwn xersou","texnikwn yphresiwn","dhmarxos",
"dhmarxos","dhmotiko sumvoulio","antidhmarxou kaqariothtas kai prasinou","antidhmarxou politismou-aqlhtismou-koinwnikhs allhleggyhs-paidikhs merimnas","oikonomikh epitroph","epitroph poiothtas zwhs","epitroph laikwn agorwn","oikonomikh uphresia","epitroph proslhcewn","d.e.y.a.","ektelestikh epitroph","epitroph elegxou adeiwne ekmetaleushs peripterwn kulikeiwn kai kafeneiwn",
"oikonomikh epitroph","dhmotko sumvoulio","kentro koinwnikhs politikhs","grafeio dhmarxou","tmhma promhqeiwn","anqokomikh ekqesh","proswpikou","epitropj diavouleushs","proupologismou kai logistikhs parakolouqhshs","nomikhs yphresias kai katasthmatwn ygeionomikou endiaferontos","dhmotikh kointhta","dhmotikh kointhta neas eryqraias","epitroph poiothtas zwhs","9h sxolikh epitroph","politistiko kentro","sxolikh epitroph 1ou dhmotikou kai 1ou nhpiagwgeiou neas eryqraias","7h eniaia sxolikh epitroph","sxolikh epitroph 4ou dhmotikou","4h eniaia sxolikh epitroph","10h eniaia sxolikh epitroph","sxolikh epitroph 2ou nhpiagwgeiou","poleodomias","2h eniaia sxolikh epitroph","sxolikh epitroph 2ou kai 3ou dhmotikou-2ou nhpiagwgeiou n.eryqraias","sxolikh epitroph 1ou dhmotikou ekalhs","6h eniaia sxolikh epitroph","8h eniaia sxolikh epitroph","sxolikh epitroph 3ou lykeiou","sxolikh epitroph 3ou dhmotikou","sxolikh epitroph lukeiou n.eryqraias","5h eniaia sxolikh epitroph","1h eniaia sxolikh epitroph","sxolikh epitroph gymnasiou ekalhs","texnikh yphresia","11h eniaia sxolikh epitroph","sxolikh epitroph gymnasiou n.eryqraias","koinwnikh meriman","dhmhtrios bikelas","sxolikh epitroph 1ou dhmotikoukai nhpiagwgeiou ekalhs",
"dioikhtikou oikonomikou","dioikhtikwn yphresiwn","oikonomikwn yphresiwn","dhmotiko sumvoulio","dhmarxos","oikonomikhs epitrophs","epitrophs poiothtas zwhs","texnikwn yphresiwn","xwrotajias kai poleodomias","grafeio sumvouliou lhjouriou","epitroph poiothtas zwhs","aqlhtikos organismos palikhs","aqlhtikos organismos argostoliou","dhmotikh koinwfelhs epixeirhsh leibaqous","antidhmarxos palikhs","antidhmarxos pularou","grafeio antidhmarxou leibaqous","antidhmarxos leibaqous",
"oikonomikwn yphresiwn","dioikhtikwn yphresiwn","oikonomikh epitroph","epitroph poiothtas zwhs","texnikwn yphresiwn","dhmarxos","dhmotiko sumvoulio","poleodomias/prwhn nak","poleodomias(prwhn dhmou kerkuraiwn)","dhmotikh astynomia","d.e. paraliwn",
"aprosdioristo","dhmarxou","antidhmarxou kaqhmerinothtas tou polith","antidhmarxou paideias kai dia biou maqhshs","antidhmarxou diafaneias kai epikoinwneias tou polith","antidhmarxou anaptyjhs newn texnologiwn kai hlektronikhs diakybernhshs","antidhmarxou ygeias kai koinwnikhs pronoias","antidhmarxou","proedrou dhmotikou sumvouliou","dioikhtikwn yphresiwn","oikonomikwn yphresiwn","texnikwn yphresiwn","periballontos","dhmotikhs astynomias","genikou grammatea","antidhmarxou poiothtas zwhs kai periballonots","dhmotikh koinothta keratsiniou","oikonomikh epitroph","poleodomias","dhmotikou sumvouliou","dhmotikh koinothta drapetswnas","dh.ke.po.k.","dh.k.e.p.a.","epitroph poiothtas zwhs","dhkeprok","epitroph parakolouqhshs programmatos dietous xrhmatodothshs dh.k.e.p.o.k.","epitroph parakolouqhshs programmatos dietous xrhmatodothshs dhkeprok","politismou kai koinwnikwn yphresiwn","kaph","ke.d.ap.e.d.d.","dhmotikh vivlioqhkh keratsiniou","dhmotiko stadio keratsiniou","dhmotikoi paidikoi staqmoi keratsiniou","dhmotikoi paidikoi staqmoi drapetswnas","ektelestikh epitroph","tmhma promhqeiwn","epitroph diavouleushs","sxolikh epitroph b/qmias ekpaideushs","sxolikh epitroph a/qmias ekpaideushs","dhmotikh epitroph paideias","dhmotikh epitroph paideias",
"dhmotiko sumvoulio","oikonomikh epitroph","epitroph poiothtas zwhs","dhmarxos","ektelestikh epitroph",
"ota","dhmarxos","dioikhtikwn oikonomikwn yphresiwn kai programmatismou","texnikwn yphresiwn kai periballontos",
"dioikhtikwn oikonomikwn yphresiwn","texnikh uphresia","dioikhtikh yphresia","oikonomikh yphresia","agrotikhs paragwghs","kep","dhmotiko symvoulio","oikonomikh epitroph",
"aprosdioristo"};


//String units;


 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

String sub[]=new String[90000];
int[] costs = new int[3440];
int[] dap = new int[90000];
String doc[] = new String[90000];
int p=0;
int f=0;
int subcount=0;

Integer unitsuids[]={
10751,10752,10753,10754,13229,15725,10726,
9021,9022,9024,9025,9026,9027,9028,9029,9030,11286,12898,13899,13900,16936,
10580,10581,10587,10599,10755,11040,11171,11362,17662,
11136,11137,11140,11905,11908,11909,11911,11912,13855,14053,14919,
12195,13135,13176,13228,13464,13539,13678,13746,14410,15193,15264,16080,16434,17378,18799,
11529,11530,11532,11533,11534,11561,11568,11569,11571,11578,11584,11596,11601,11609,11620,11622,11631,12442,13126,13930,14643,15054,15385,15387,15388,15899,17055,18188,
11733,12120,13041,14247,14284,15587,15895,16233,18042,18147,
15159,15160,15161,15162,15271,17817,18005,
11323,11326,11327,11328,11331,13501,14987,
8028,8029,8918,8919,8921,8923,9233,9637,14802,
14210,14211,14212,14213,14214,14215,14216,14217,14218,14219,14220,14222,14225,14227,14229,14230,14260,14961,15052,15053,15896,15941,16021,16524,16624,17248,18131,18132,
9710,9711,11654,11658,11669,11673,11675,11676,12194,12201,12204,12205,12220,12230,12231,12232,12233,12234,12235,12236,12237,12238,12239,12240,12241,12242,12243,12244,12245,12246,12247,12248,12249,12250,12251,12252,12253,12254,12255,12256,12257,12258,12262,12263,15508,15529,16182,17062,
9118,9424,9425,9426,9427,9428,9429,9430,9431,9432,9433,9434,9435,9436,9437,9438,9439,11780,12209,12210,12211,12212,12213,12215,18216,
10706,10729,16081,
12033,12468,12470,12471,12864,14900,18038,
8359,8360,8361,8362,8363,8364,8365,8366,8367,8368,8369,8370,8371,8372,8373,8374,8375,8376,8377,8378,8379,8380,8381,11778,12565,12566,12567,14617,14930,15030,15849,15851,15923,
8728,8729,8731,8733,8735,8736,8737,11325,11330,11334,11378,11711,14865,14866,15976,16618,17352,17353,18165,
8720,8721,8722,8723,8724,8725,8726,8727,8730,8732,8734,9671,9672,16938,
12867,14599,14601,14602,15834,16272,16359,
15856,
10953,10955,10957,10963,10966,10971,10973,
8262,8268,8271,8275,8278,9090,9093,9094,9264,9265,10860,11921,18224,
9653,9654,9655,9656,9657,9659,9661,9662,9663,
11956,13391,
7969,7970,7971,7972,7973,7974,13072,13073,13074,13324,
9823,9824,9825,9826,9827,9828,12558,12825,18827,
10293,10294,10295,10296,10297,10298,10300,10334,10338,10339,10341,10342,10343,10344,10345,10346,10347,10348,10349,10350,10351,10352,10353,10354,10355,10356,10357,10358,10359,10360,10362,10363,10364,10366,10367,10368,10369,10370,10371,10372,10373,
11702,11703,11704,11706,11710,11712,11714,11715,11717,11718,11719,11720,11721,
9883,9890,9891,9898,9900,9905,9907,9909,9911,10175,10176,10177,12673,12676,13100,14442,
13177,13284,13285,13339,13340,13341,13343,13941,14019,14221,14257,14297,14430,14478,14659,14686,14687,14715,14717,14720,14759,14764,14784,14785,14886,15036,15466,15470,15516,15518,15526,15551,15663,15842,15843,15844,15897,15928,15931,16020,16090,16165,16184,16197,16311,16425,16428,16430,16435,16439,16440,16443,16446,16500,16502,16515,16530,16531,16533,16534,16535,16536,16537,16538,16539,16540,16542,16543,16580,16585,16868,16888,17311,
11526,11527,11528,11987,11988,13352,13385,13386,13387,13414,
9498,9500,9501,9503,9504,9506,9509,14740,14867,15022,15037,15461,16015,16309,16616,17101,
11287,11300,11314,11509,11966,13183,13203,13337,13426,13540,15070,15485,15620,15636,17907,18025,
8297,8298,8299,8300,8301,11104,11106,11107,11108,11109,12069,18735,
8128,8129,8130,8131,8132,8133,11726,11727,11728,11729,
9547,9552,9643,9644,9645,9646,9647,9648,9649,9650,9651,9652,11157,11689,11705,11708,17054,
11554,11591,11762,11833,11834,11835,11836,11842,11877,11881,11884,11886,11887,11888,11889,11890,11891,14287,14575,14581,14582,14583,14584,14586,14587,14588,14589,
9802,9805,9809,9811,9812,9814,9818,13972,16484,16586,16739,
8827,8828,8831,8841,8846,15281,15979,15980,15981,
9738,9741,9742,9743,9745,9748,9749,9750,
13395,13397,13398,13399,13401,13402,13403,13405,15502,15503,18013,
11735,11736,11737,11739,18209,
9520,11690,12080,14947,17420,
12874,12875,12876,
12017,120128,12019,12020,12021,13906,13907,13908,13909,13910,14321,14322,14323,14324,14501,14502,14503,14504,17853,17872,
11670,11671,11672,11674,11751,11752,11753,11754,12896,13778,14696,16448,17897,
9639,10041,10042,10043,10044,10045,10046,14275,14277,
11992,
11615,11617,11621,13681,15920,15938,15977,17411,
10995,10996,10997,10998,10999,13433,13435,13436,13510,18507,
13221,13222,13223,13513,14440,14762,15150,15479,17308,17309,18083,18137,
11297,12457,12458,12459,13282,14262,
14851,14852,14853,18662,
11546,11547,11548,11549,11551,12649,12650,15183,15399,16326,18105,
9125,9156,9158,9177,9178,9179,9182,9183,15046,18104,18295,18296,18532,18554,
10796,10771,10774,
10039,10040,10178,10179,15055,16032,18445,18446,18447,18448,18449,18451,18453,18454,18455,18456,18457,18458,18459,18460,18461,18462,18463,18464,18465,18466,18468,18469,18470,18471,18472,18473,18474,18524,
12859,12860,12861,12862,12881,12882,12899,13101,16241,17195,17214,
13217,13218,13219,
10131,10132,10133,10134,11440,11619,14012,14016,18045,
12878,12885,
10626,10627,10629,10630,10631,10632,10636,10637,13981,14147,14237,15224,15617,15630,15868,15922,16751,16843,
9544,9545,9546,9553,9557,9819,9899,15703,
11761,11767,14320,15263,15454,16695,16831,
12015,17491,17495,
7858,7859,7860,7861,7928,7929,7930,13235,16152,16305,16308,
8351,9471,9524,9525,9526,9527,18033,
14508,14509,14863,15151,15152,16436,
13194,13237,
12134,12451,13531,14308,14446,17855,
10699,10700,10701,10705,10707,10708,10709,10710,10713,10714,10717,10718,10719,10721,
10793,10807,10808,10809,10812,10848,10849,10856,13001,
8176,8845,8848,8849,8851,8853,8854,8855,8856,8857,8858,8859,8860,8861,8862,8863,8865,8866,8867,8868,8869,8870,8871,8873,8874,8875,8876,8877,8878,8879,8880,8881,8882,8883,8884,8885,8886,8887,8888,8889,8890,8891,8892,8893,8894,8895,8896,8897,8898,8899,9550,9929,10745,10746,10777,10778,10779,10781,10782,10784,10786,10787,12109,12110,12111,12113,12114,12115,12116,12612,13054,13331,13332,13390,13470,13655,14032,14419,16111,16112,16143,16292,16465,18552,
8095,8096,8097,8098,8099,8100,8101,8102,15832,16432,17038,
13948,13950,13952,13953,13954,13955,13956,13957,13958,13959,13961,13962,13965,14535,14536,14543,14544,14594,14612,14616,14621,14639,14712,14792,14834,14890,15226,15227,15228,16336,16738,
11442,11443,
8745,11398,11417,11565,11566,13071,13315,14674,14675,14676,15019,15039,15040,15041,18393,18394,18395,18396,18397,18398,18640,18870,
10805,10824,10827,10838,10843,10846,10889,10891,13335,15418,15419,15420,
12605,12606,12607,12629,13422,13877,13878,13881,13882,13883,13938,13940,14298,
11243,11244,11623,11624,11625,11626,11627,12093,12106,12107,12108,12188,12189,12440,12441,15028,16084,17881,17882,17883,18726,
11541,11542,11543,16045,16532,17886,
10146,10147,10148,10149,12823,16116,18608,18682,18689,18690,18736,
10047,10051,10054,10055,10056,10057,10058,10059,10138,10141,
15220,16608,16711,17869,
9533,9535,9539,9540,9549,9695,9699,9700,9701,9703,
13024,
10526,10527,10528,10529,18570,
8103,8116,8117,15707,15708,15709,
11039,
12076,14416,14681,14729,15010,15042,15180,15348,15406,15407,16853,17797,18050,18051,18052,18342,18504,
11863,11864,11872,
8963,8964,8965,8966,8967,8968,15581,17384,17518,17799,
13960,13963,
12652,13216,14578,15044,15512,18878,
13570,14719,14720,18141,
11226,11228,11235,11246,11313,11316,11320,11329,11332,11333,11336,11337,11338,11339,11341,11343,11345,11346,11348,11350,11352,11360,11361,11363,11364,11265,11367,11385,11387,11388,11390,11392,11394,11396,11397,11784,11785,11786,11787,14905,14921,
13202,13361,13427,13984,15853,16109,16775,17063,17593,17714,17801,18508,
11741,11742,11743,11744,11745,
8450,8451,8452,8787,8788,8789,8790,8791,8792,8793,8795,8797,8798,8799,8800,8801,8803,8804,11986,
13722,13724,16038,16039,
11961,14325,
9080,9081,9083,9084,9089,9658,9660,
12617,12621,12625,12630,12631,12632,12633,12634,12635,
9412,9414,11896,13409,14330,15912,16306,
7940,7941,7942,7943,7944,7945,7946,7947,7948,7949,7950,7951,7952,7953,7954,7955,7956,7957,7958,7959,7960,7961,7962,7963,7964,7965,9585,9942,9946,9947,9948,9949,9950,9951,9952,9953,9954,9955,9956,9957,9958,9959,9960,9961,16983,16984,16985,18439,
9107,9108,9109,9111,9189,9190,9191,9192,9193,9194,9195,9196,9837,12073,12074,12075,
9820,11687,11781,11933,11936,11967,11968,11969,11970,11971,11972,11973,11974,12519,13289,13333,14105,14420,14421,14752,15094,15153,15496,15933,16395,16968,
13514,13964,14406,14838,15749,
11914,11916,11917,11918,11924,14726,
8023,8024,8025,8154,8155,8156,8641,8642,8644,8645,10704,11550,13095,14647,15005,15318,15488,
8943,8944,8945,8946,8947,8948,8949,8950,8951,8952,8953,8954,8955,11091,11092,11099,11175,11176,11177,11179,11181,11189,11192,11194,11195,11196,11197,11198,11301,16784,16785,
9681,9682,9683,9684,9707,11993,13553,14928,14985,
9371,9380,9381,12889,13188,14279,
10383,14856,14859,15854,16497,16498,
13937,16996,
10135,10142,10523,10524,10535,11379,11380,11381,11382,11383,11384,11430,11432,11433,11756,11757,11758,11759,11760,11895,12016,13915,15750,16517,18407,18491,
11448,11452,11455,13415,13416,14545,17327,18357,18481,18490,
11707,13567,14604,14658,14882,14883,14896,14963,16834,17892,18060,18123,
8426,9085,9086,9087,10715,10933,15286,15969,15982,16617,18117,18650,18651,
11386,14192,15364,
11018,11019,11020,11021,11022,11023,11024,11025,11026,14549,14550,14551,14552,14553,14554,15135,15198,
11057,11058,11059,11060,11061,11062,11063,11064,11065,11066,11067,11068,11069,11070,11071,11072,11073,11074,11075,11076,11077,11078,11079,11080,11081,11082,11083,11084,11085,11086,11087,12595,13045,13046,13048,13115,13304,13305,13306,13307,13308,14417,15562,
12892,
8591,8597,8601,8604,8607,8608,8615,8616,8617,8618,8619,8620,8621,8622,8624,8625,8626,8627,8628,8629,8630,8631,8632,8930,8931,8932,8933,8934,8935,8936,8937,8938,8939,8940,8941,8942,9311,9312,9313,
11110,11111,11112,11113,11114,11115,11116,13726,13728,13730,13879,13880,17042,17044,17045,17576,17577,18420,18421,18422,
15389,15390,15391,16848,
11928,14030,14031,17890,
11422,11486,12904,13097,13195,13204,14534,14537,14862,16066,17159,17387,17756,18089,18090,18166,18301,
8961,13461,13706,14288,14392,15024,17267,
8208,8209,8210,8211,8212,8213,8214,8215,8216,8313,8314,8315,8316,8317,8318,8319,8320,8321,8322,8323,8324,8325,8326,8327,8328,8329,8330,8331,8332,8333,8334,8335,8336,8337,8338,8339,10653,10654,
12041,12043,12044,12045,12046,12047,12048,12050,12051,12052,12053,12054,12055,12057,12060,12065,15438,
13720,14750,15616,17604,
10098,10099,10102,11298,13703,14954,14960,15033,17335,
10049,10050,
11989,11990,
11496,11500,12229,13231,13901,13934,14742,15879,17407,18894,
10806,13106,13107,13270,13417,13634,13657,13787,13891,14315,14499,14734,14858,15057,16023,16036,16499,17290,18195,
9715,9716,9717,9718,9720,9721,9722,9767,9770,9775,9778,9782,9786,9789,9792,9795,14718,14808,14810,14818,15236,15237,15238,15240,15241,15242,15243,15244,15245,15246,15249,15250,15252,15253,15254,15255,15256,15257,15258,15260,16128,17573,17755,
8500,8501,13344,14151,16206,17777,18128,18700,
9408,9409,9410,9411,13444,13445,13446,13447,13448,13449,13835,14428,14656,
16481,16483,17599,
10624,10657,10885,10983,11321,11322,11324,11991,12112,17077,
13862,13896,13897,13898,18352,
11006,11007,11008,11009,11010,11011,11012,11013,11014,11015,11016,13157,13466,16879,
8540,8542,8543,
9640,9641,9642,
13064,13079,13163,15136,15194,16929,
7966,7967,7968,10643,10644,10648,10650,11691,15451,16319,
10724,10726,10728,10730,10731,10732,10734,10735,10736,10737,17726,
9868,9869,9870,9871,9872,9873,9874,9875,9876,10128,10129,13675,13679,13680,13682,15731,17644,
13744,13745,13747,14409,18562,
11125,
12022,14803,15753,18436,18658,
11494,11692,13463,14379,14387,14682,14813,15670,
8969,8974,8980,8981,8982,8983,8984,8985,8986,8987,8988,8989,8990,8991,8994,8995,9001,9002,9003,9004,9006,9007,9008,9016,17360,17361,
11709,11716,11722,12117,13658,13709,16191,17532,17559,
9180,9181,11535,11567,11599,11628,12198,13738,
8900,8902,8903,8904,8905,8906,8907,9092,13014,15654,
12482,13010,13028,13029,13062,13067,13236,13266,13267,13328,13329,13538,13872,15109,15316,18074,18321,18375,18480,
10725,10727,10757,10760,10763,10796,10798,10799,10801,10833,10835,10837,10870,10873,11366,13094,18208,
13428,13429,13430,
10530,10531,10532,10533,
9383,9385,9386,9387,9388,9389,9390,9391,9392,9393,9665,9669,13635,13659,13914,
10374,10375,10376,10377,10378,19379,10380,10381,10382,10477,10478,10480,10482,10483,10485,10486,10492,10493,10494,10515,10516,11514,
11765,11766,11768,
12435,12436,12438,12439,12820,13000,14228,15813,16864,18376,
11138,11143,11145,11148,11149,11150,11151,11153,13009,13334,13530,13734,13935,14289,14427,14651,14981,15453,16578,16939,17520,17574,17765,17781,17888,18566,18639,18749,18798,
11677,11683,11684,11724,12487,12560,13262,13369,13455,14403,15197,15500,15564,16201,16373,17910,17911,
10640,10642,10645,10646,10649,10892,10894,10896,10928,10929,14996,
10105,10106,10108,10109,10112,10113,10114,
11885,11963,13494,13495,13496,14326,18721,
10926,10946,12072,13936,14343,14350,14395,15792,17925,17926,17927,
10518,10519,10520,10521,10522,14944,16057,
7979,7980,13192,15718,16048,18262,18263,
11803,11804,11805,11806,11811,11812,13327,13360,13432,13903,13970,14194,15147,16237,
11389,11678,11679,11681,11682,
9882,9886,9904,9910,9912,9915,9916,9918,9920,9921,9922,9924,9926,9928,13102,
12172,13434,13529,
11317,11318,11457,11783,12166,13040,13667,
8010,8011,8044,8045,8046,8048,8049,8050,8051,8052,8053,8054,8083,8084,8085,8086,8087,8088,8089,8090,8091,8092,8114,8115,8180,8183,8184,8185,8186,8187,8188,8189,8190,8535,12084,12148,12870,13110,13705,13737,13785,13790,13794,14515,15699,
11282,11283,11284,11285,11288,11289,11290,11291,11292,11293,11294,11295,11296,11303,11304,11305,11306,11307,11308,11309,11310,11311,11910,12509,12510,12513,15840,18500,18501,18502,
8774,9278,9279,9281,9283,9284,9285,9286,9290,9292,9294,9301,9304,9308,9309,9310,9761,9777,9779,9804,9806,9807,10291,17319,
9685,9688,9689,9693,10540,10542,10544,12173,12555,12561,12562,12637,12640,12641,12642,12643,12644,12645,12646,14265,15043,15144,15145,15169,15306,15888,16285,16314,
10160,10162,10164,10166,10169,10172,10283,10284,10285,10286,10287,10288,10647,10652,
9329,9359,9362,9370,9373,9376,9566,9568,9569,9570,9571,9572,9573,9574,9575,9576,9577,9578,9579,9580,9581,9582,9582,9584,9603,9604,9605,9606,9607,9608,9611,9612,9613,9615,9616,9617,9618,9619,9620,9621,9622,9623,9624,9625,9626,9627,9628,9629,9630,9631,9632,9633,9634,9635,9636,12476,12477,12479,12522,13269,13380,15018,18429,
9686,9690,9691,9692,9694,9706,
10712,15846,16009,16207,17493,
11581,11583,11773,11774,11775,11776,15003,15006,15580,15590,15893,17241,17776,18151,18310,18660,18691,
11353,11355,11356,15007,17880,
8135,8136,8137,8441,8442,8443,8444,8445,8446,11505,11506,11507,11508,
11027,11028,11029,11049,11050,11051,11053,
11485,11487,11488,11490,11491,11492,13227,13438,14196,14198,14199,14200,14929,14971,15751,16456,17222,18803,
11141,11524,15004,15808,15984,16832,16833,18054,
9059,9061,9062,9063,9064,9065,11017,11685,13226,13683,18381,
11815,11816,11818,11820,11821,11822,11823,11824,11825,12517,13793,13796,14936,15748,16375,17472,18499,18505,
11858,11859,11860,11861,11862,11865,11867,11868,11869,11870,11871,11873,11874,11875,11876,11878,11879,11880,11882,11883,11925,11929,11930,13502,15661,
8411,8413,8415,8439,13256,
12460,12462,12463,12465,12467,14456,15143,15363,
11088,11090,12185,13946,14942,14943,15462,15994,
9384,9394,9395,9396,9397,9398,9399,9400,12005,12070,13108,13922,14314,14424,14459,15047,15421,15422,15423,15443,15482,16133,16134,16135,16136,16137,16138,16139,16140,16382,16383,16384,16385,16386,16387,16388,16389,16390,16391,16392,16393,17355,17388,17535,18594,18766,18767,18773,18774,18775,
13187,13649,18095,18358,
9860,11030,11031,11032,11033,11034,11035,11036,11037,11038,13424,14087,16818,16820,16821,
17973,17985,17991,18007,18008,18049,18057,18127,18130,18269,18271,18272,18273,18274,18275,18483,18523,18887,18888,18889,
16396,
12452,16321,16325,
13351,13507,13668,13669,13834,14746,15189,15763,16279,16830,
11950,13653,13971,14295,14433,15309,15455,16869,16870,17598,17752,
10070,10072,10073,10074,10075,11415,14095,14096,14097,14098,15207,16062,
8126,
11481,11482,11483,14959,
11586,11588,11589,11592,11594,11595,11597,11600,11602,11603,11604,11605,11606,11607,11608,11610,11611,11612,11613,11645,
9277,9280,9282,9287,9288,9289,9291,9293,9296,9300,9305,9314,10097,10103,10104,
11218,12826,12827,12828,12829,12830,13345,13346,13347,13348,14079,18389,
9586,9587,9588,9589,9590,9591,9592,9593,9594,9595,9596,9597,9598,9599,9600,9601,9602,10152,
8807,8808,8809,8810,8811,8812,8813,8814,8815,8816,8817,8818,8819,8820,8822,8823,8824,8825,8826,13310,
10185,10186,10187,10188,10190,10192,10194,10197,10198,10200,10202,10203,10204,10205,10206,15287,16857,18111,
9863,9864,9865,12010,
11096,11097,
11043,11044,11045,11046,11047,
13049,13890,14798,
8712,8713,8714,8715,8716,8717,8718,13354,13355,13359,16037,18142,
18879,18880,18881,18882,18883,18884,
9842,9843,9844,9846,9854,9856,9857,9858,9859,9861,9866,9867,10764,10770,10772,10773,10861,10864,10868,11923,12087,13078,13080,13491,17668,17753,
9821,14195,16476,16477,16478,16479,16480,
14017,14018,14020,14021,
11957,11958,11959,11960,11962,11964,
10553,10554,10555,10556,10557,10558,10559,10560,10561,10562,10563,10564,10565,10566,10567,10568,10569,10570,10571,10572,11841,14061,
14013,14014,14023,14119,16977,
14438,14722,15025,15027,15833,16841,
9098,9099,9100,9101,9102,
10633,10634,10635,16705,17122,18621,
8302,8303,8304,8305,8306,8307,8384,8387,
12647,12648,13441,13442,13443,14245,
11837,11839,11840,16527,16528,16529,18371,18898,
12028,12029,12030,12031,12032,12034,12035,12036,12037,15647,15648,15649,15650,17330,
10661,10694,10695,10696,10697,10698,10795,10797,10802,10890,11312,13174,13301,13330,14573,15409,16816,17526,18316,18317,
14452,14453,14454,14455,15158,
11204,11208,11214,11215,11216,11217,11219,11220,11223,11224,11278,14951,15138,17264,
9879,9884,9913,9919,9923,9925,10011,10012,10013,10014,10016,10537,13178,13230,13437,13884,16105,16690,
12866,12873,12877,12886,12887,12891,14296,14299,14441,17007,
13486,13488,13928,
8279,8280,8282,8283,8285,8286,8290,
10800,10803,10804,13026,13060,13189,14234,16714,16787,17070,17182,17558,
10181,10182,10183,10184,10189,10191,10193,10195,10196,10199,10201,10207,12009,12619,14881,15305,15459,17034,17035,18335,18336,18337,18338,18339,18340,18644,
10863,10867,10869,10872,10875,10876,10878,10879,10881,10985,13287,13288,14592,14906,15436,18248,18638,
9440,9441,9442,9443,9444,9445,9446,9447,9448,9449,13875,15016,17224,
9664,9668,9670,12264,12265,12266,12267,12268,13124,13125,13127,13128,13129,13130,15204,16627,18369,
9708,9709,9712,
13011,13012,13013,15558,16156,16159,16877,
13168,
8910,8911,10143,10145,11447,11450,11451,11453,15911,17074,17478,
8217,8218,8219,8220,8221,8222,9763,14945,15213,18563,18564,18606,
8294,8295,8296,8340,13275,13276,15202,15203,15398,15401,15755,15805,
11688,13845,13945,14570,14571,15324,15918,18378,18379,18380,
9724,9725,9726,9727,9728,9729,9730,10161,10163,10165,10167,10168,10170,10171,10212,10213,10214,10215,10216,10217,10218,10219,10220,10221,10222,10223,11795,11796,12871,12879,13849,
11172,11174,11178,11180,1182,11183,11184,11185,11186,11187,11188,11191,11203,
8080,15826,16026,
10904,10907,10910,10912,10914,
9187,9188,9206,9208,9209,910,9211,9212,9213,9214,9215,9216,9217,9218,9219,9220,9221,9222,9223,9224,9225,9226,9227,9228,9229,9230,9231,9232,9452,13004,
10921,10956,10960,10965,10980,10981,14797,15591,15674,15713,17116,18802,
12217,12379,13286,13366,13367,13456,13471,13732,14302,14496,14497,14706,15577,15795,15839,16012,16071,16072,16113,16114,16115,16188,16215,16216,16217,16253,16404,16405,16461,16462,16463,16512,16513,16526,16581,16582,16782,16863,17028,
10101,10107,10110,10118,10136,10137,10139,14523,15056,16030,16287,16412,16847,16890,17635,18203,18211,18212,
9115,9116,9261,9262,9263,10061,13170,14359,14850,16593,17802,
9555,9740,9752,9755,9757,9762,9771,9774,9797,9801,9810,9813,9815,9817,10573,10579,11423,13220,14351,14352,14660,14907,15108,15186,15233,15289,15507,15744,15766,16154,16261,16263,16266,16942,17282,17292,17715,18268,18423,18509,18510,
13672,13673,13674,13926,17758,
9723,13519,13520,13521,
9461,9462,9463,9464,9466,9467,9702,15476,
0};



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
                //String organizationId = jsons[i].getJSONObject("metadata").getString("organizationId");
                String organizationUnitId = jsons[i].getJSONObject("metadata").getString("organizationUnitId");
                String subject = jsons[i].getJSONObject("metadata").getString("subject");
                int orgunit=Integer.parseInt(organizationUnitId);


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
                            for(orgcount=0;orgcount<3440;orgcount++){
                            if(orgunit==unitsuids[orgcount]){costs[orgcount]=costs[orgcount]+sum1; break;}


                            }

                                                 }
               else if(value.isEmpty()){

                                                        }

               else if(value.equals(" ")){



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

   for(orgcount=0;orgcount<3440;orgcount++){
                            if(orgunit==unitsuids[orgcount]){costs[orgcount]=costs[orgcount]+sum2; break;}


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


    for (i=0; i<3440;i++){

        if(costs[i]>0){

        item = new org.jdom.Element("item");
        org.jdom.Element element = new org.jdom.Element("unit");
        String t = units[i];
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
