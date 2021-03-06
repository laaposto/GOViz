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

@WebServlet(name = "InnerMunTagParser", urlPatterns = {"/InnerMunTagParser"})
public class InnerMunTagParser extends HttpServlet {



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

String sub[]=new String[90000];
int[] costs = new int[593];
int[] dap = new int[90000];
String doc[] = new String[90000];
int p=0;
int f=0;
int subcount=0;

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



int tagval=0;
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

                  String subject = jsons[i].getJSONObject("metadata").getString("subject");
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

                              dap[f]=sum1;
                              f++;
                            for(orgcount=0;orgcount<593;orgcount++){
                            if(tagval==tagsuids[orgcount]){costs[orgcount]=costs[orgcount]+sum1; break;}


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
                            if(tagval==tagsuids[orgcount]){costs[orgcount]=costs[orgcount]+sum2; break;}


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
