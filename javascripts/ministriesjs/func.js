 var viewportwidth;
 var viewportheight;

 if (typeof window.innerWidth != 'undefined')
 {
      viewportwidth = window.innerWidth,
      viewportheight = window.innerHeight
 }

 else if (typeof document.documentElement != 'undefined'
     && typeof document.documentElement.clientWidth !=
     'undefined' && document.documentElement.clientWidth != 0)
 {
       viewportwidth = document.documentElement.clientWidth,
       viewportheight = document.documentElement.clientHeight
 }

 else
 {
       viewportwidth = document.getElementsByTagName('body')[0].clientWidth,
       viewportheight = document.getElementsByTagName('body')[0].clientHeight
 }


var options = {
placement:'left'
    };

jQuery('#searchmun').popover(options);
jQuery('#toptags').popover();
jQuery('#topdesicions').popover();
jQuery('#topmuns').popover(options);
jQuery('#dl1').tooltip();

jQuery('#tweet1').tooltip();

jQuery('#warn1').tooltip();

customleft=viewportwidth-85;
beta=document.getElementById('beta');
beta.setAttribute('style','margin-left:'+customleft+'px;position:absolute;z-index:22;');

customheight=viewportheight-90;
customleft=viewportwidth-180;
imgbg=document.getElementById('imgbg');
imgbg.setAttribute('style','width:'+customleft+'px;height:'+customheight+'px');

customwidth=viewportwidth/4.4;
loadimg=document.getElementById('loadimg');
loadimg.setAttribute('style','width:'+customwidth+'px');

customtop=viewportheight/2.8;
customleft=viewportwidth/2.8;
loading=document.getElementById('loading');
loading.setAttribute('style','top:'+customtop+'px;left:'+customleft+'px');

customtop=viewportheight/5.3;
myModal=document.getElementById('myModal');
myModal.setAttribute('style','margin: -'+customtop+'px 0 0 -280px');

myModal2=document.getElementById('myModal2');
myModal2.setAttribute('style','margin: -'+customtop+'px 0 0 -280px');

myModal3=document.getElementById('myModal3');
myModal3.setAttribute('style','margin: -'+customtop+'px 0 0 -280px');

myModal4=document.getElementById('myModal4');
myModal4.setAttribute('style','margin: -'+customtop+'px 0 0 -280px');

customheight=viewportheight-161;
customwidth=viewportwidth/6.2;
tags=document.getElementById('tags');
tags.setAttribute('style','height:'+customheight+'px;width:'+customwidth+'px');

customheight=viewportheight-194;
customwidth=viewportwidth/6.2;
customleft=viewportwidth/1.281;
municipalities=document.getElementById('municipalities');
municipalities.setAttribute('style','height:'+customheight+'px;width:'+customwidth+'px;left:'+customleft+'px');

custommargin=customwidth-129.45;
if(custommargin<0){custommargin=0;}
municipalitiesspan=document.getElementById('municipalitiesspan');
municipalitiesspan.setAttribute('style','margin-left:'+custommargin+'px');


customwidth=viewportwidth-37;
mynavbar=document.getElementById('mynavbar');
mynavbar.setAttribute('style','width:'+customwidth+'px');

customheight=viewportheight-124;
customwidth=viewportwidth/9.2;
if(viewportwidth==1280){customleft=viewportwidth/1.189;}
if(viewportwidth>=1100 &&viewportwidth<1280){customleft=viewportwidth/1.204;}
if(viewportwidth>=1000 &&viewportwidth<1100){customleft=viewportwidth/1.219;}
if(viewportwidth>900 &&viewportwidth<1000){customleft=viewportwidth/1.242;}
if(viewportwidth<=900){customleft=viewportwidth/1.249;}
if(viewportwidth>1280 &&viewportwidth<=1380){customleft=viewportwidth/1.174;}
if(viewportwidth>1380 &&viewportwidth<1480){customleft=viewportwidth/1.154;}
autocmp=document.getElementById('autocmp');
autocmp.setAttribute('style','width:'+customwidth+'px;left:'+customleft+'px;top:'+customheight+'px;');


customwidth=viewportwidth/12.3;
autocomplete=document.getElementById('autocomplete');
autocomplete.setAttribute('style','width:'+customwidth+'px');

customheight=viewportheight-46;
customwidth=viewportwidth-17;
footertitle=document.getElementById('footertitle');
footertitle.setAttribute('style','width:'+customwidth+'px;top:'+customheight+'px;');

customheight=viewportheight+6;
customwidth=viewportwidth-17;
footermain=document.getElementById('footermain');
footermain.setAttribute('style','width:'+customwidth+'px;top:'+customheight+'px;');




customwidth=(viewportwidth-114)/4;
greenline=document.getElementById('greenline');
greenline.setAttribute('style','width:'+customwidth+'px');

customwidth=(viewportwidth-114)/2.3;
customwidth2=(((viewportwidth-114)/4)*1.1)+57;
yellowline=document.getElementById('yellowline');
yellowline.setAttribute('style','width:'+customwidth+'px;margin-left:'+customwidth2+'px;');

customwidth=(viewportwidth-114)/4;
customwidth3=customwidth2+((viewportwidth-114)/2.3)*1.05;
redline=document.getElementById('redline');
redline.setAttribute('style','width:'+customwidth+'px;margin-left:'+customwidth3+'px;');

customwidth=(((viewportwidth-114)/4)*1.1)+57;
topdesicions=document.getElementById('topdesicions');
topdesicions.setAttribute('style','margin-left:'+customwidth+'px');

customwidth=customwidth2+((viewportwidth-114)/2.3)*1.05;
topmuns=document.getElementById('topmuns');
topmuns.setAttribute('style','margin-left:'+customwidth+'px');

chartdiv2=document.getElementById('chart_div2');
chartdiv2.setAttribute('style','margin-left:'+customwidth+'px');

customwidth=(((viewportwidth-114)/4)*1.1)+57;
customwidth1=(viewportwidth-114)/2.3;
line1=document.getElementById('line1');
line1.setAttribute('style','margin-left:'+customwidth+'px;width:'+customwidth1+'px;');

line2=document.getElementById('line2');
line2.setAttribute('style','margin-left:'+customwidth+'px;width:'+customwidth1+'px;');

line3=document.getElementById('line3');
line3.setAttribute('style','margin-left:'+customwidth+'px;width:'+customwidth1+'px;');

line4=document.getElementById('line4');
line4.setAttribute('style','margin-left:'+customwidth+'px;width:'+customwidth1+'px;');

line5=document.getElementById('line5');
line5.setAttribute('style','margin-left:'+customwidth+'px;width:'+customwidth1+'px;');

customwidth=(((viewportwidth-114)/4)*1.1)+57;
if(viewportwidth>=1280){customwidth1=((viewportwidth-114)/2.3)*0.68;}
if((viewportwidth<1280) && (viewportwidth>=1100)){customwidth1=((viewportwidth-114)/2.3)*0.65;}
if((viewportwidth<1100) && (viewportwidth>=950)){customwidth1=((viewportwidth-114)/2.3)*0.62;}
if((viewportwidth<950) && (viewportwidth>=800)){customwidth1=((viewportwidth-114)/2.3)*0.59;}
if(viewportwidth<800){customwidth1=((viewportwidth-114)/2.3)*0.53;}
dec1=document.getElementById('dec1');
dec1.setAttribute('style','margin-left:'+customwidth+'px;width:'+customwidth1+'px;');

dec2=document.getElementById('dec2');
dec2.setAttribute('style','margin-left:'+customwidth+'px;width:'+customwidth1+'px;');

dec3=document.getElementById('dec3');
dec3.setAttribute('style','margin-left:'+customwidth+'px;width:'+customwidth1+'px;');

dec4=document.getElementById('dec4');
dec4.setAttribute('style','margin-left:'+customwidth+'px;width:'+customwidth1+'px;');

dec5=document.getElementById('dec5');
dec5.setAttribute('style','margin-left:'+customwidth+'px;width:'+customwidth1+'px;');


customwidth2=customwidth1+customwidth+12;
if(viewportwidth<960){customwidth3=((viewportwidth-114)/2.3)*0.19;}
else{customwidth3=((viewportwidth-114)/2.3)*0.16;}
if(viewportwidth<811){customwidth3=((viewportwidth-114)/2.3)*0.22;}
cost1id=document.getElementById('cost1');
cost1id.setAttribute('style','margin-left:'+customwidth2+'px;width:'+customwidth3+'px;');

cost2id=document.getElementById('cost2');
cost2id.setAttribute('style','margin-left:'+customwidth2+'px;width:'+customwidth3+'px;');

cost3id=document.getElementById('cost3');
cost3id.setAttribute('style','margin-left:'+customwidth2+'px;width:'+customwidth3+'px;');

cost4id=document.getElementById('cost4');
cost4id.setAttribute('style','margin-left:'+customwidth2+'px;width:'+customwidth3+'px;');

cost5id=document.getElementById('cost5');
cost5id.setAttribute('style','margin-left:'+customwidth2+'px;width:'+customwidth3+'px;');

customwidth4=customwidth2+customwidth3+10;
dl1=document.getElementById('dl1');
dl1.setAttribute('style','margin-left:'+customwidth4+'px');

dl2=document.getElementById('dl2');
dl2.setAttribute('style','margin-left:'+customwidth4+'px');

dl3=document.getElementById('dl3');
dl3.setAttribute('style','margin-left:'+customwidth4+'px');

dl4=document.getElementById('dl4');
dl4.setAttribute('style','margin-left:'+customwidth4+'px');

dl5=document.getElementById('dl5');
dl5.setAttribute('style','margin-left:'+customwidth4+'px');

customwidth5=customwidth4+20;
warn1=document.getElementById('warn1');
warn1.setAttribute('style','margin-left:'+customwidth5+'px');
warn1.setAttribute('data-original-title','Vote');


warn2=document.getElementById('warn2');
warn2.setAttribute('style','margin-left:'+customwidth5+'px');
warn2.setAttribute('data-original-title','Vote');

warn3=document.getElementById('warn3');
warn3.setAttribute('style','margin-left:'+customwidth5+'px');
warn3.setAttribute('data-original-title','Vote');

warn4=document.getElementById('warn4');
warn4.setAttribute('style','margin-left:'+customwidth5+'px');
warn4.setAttribute('data-original-title','Vote');

warn5=document.getElementById('warn5');
warn5.setAttribute('style','margin-left:'+customwidth5+'px');
warn5.setAttribute('data-original-title','Vote');

customwidth6=customwidth5+20;
tweet1=document.getElementById('tweet1');
tweet1.setAttribute('style','margin-left:'+customwidth6+'px');
tweet1.setAttribute('data-original-title','Share via Twitter');


tweet2=document.getElementById('tweet2');
tweet2.setAttribute('style','margin-left:'+customwidth6+'px');
tweet2.setAttribute('data-original-title','Share via Twitter');


tweet3=document.getElementById('tweet3');
tweet3.setAttribute('style','margin-left:'+customwidth6+'px');
tweet3.setAttribute('data-original-title','Share via Twitter');

tweet4=document.getElementById('tweet4');
tweet4.setAttribute('style','margin-left:'+customwidth6+'px');
tweet4.setAttribute('data-original-title','Share via Twitter');

tweet5=document.getElementById('tweet5');
tweet5.setAttribute('style','margin-left:'+customwidth6+'px');
tweet5.setAttribute('data-original-title','Share via Twitter');

customwidthtoptags=(viewportwidth-114)/3.7;
customwidthtopmuns=(viewportwidth-114)/3.7;




function removeElement()
{
      jQuery("#loading").hide();
}

function createtags(){


    var tags = document.getElementById('tags');

    var newdiv=document.createElement('div');
    newdiv.setAttribute('class','tabbable tabs-left');
    tags.appendChild(newdiv);

    var newul=document.createElement('ul');
    newul.setAttribute('class','nav nav-tabs');
    newdiv.appendChild(newul);

    var newli=document.createElement('li');
    newli.setAttribute('class','active');
    newul.appendChild(newli);

    var newa=document.createElement('a');
    newa.setAttribute('href','#1');
    newa.setAttribute('data-toggle','tab');
    newa.setAttribute('onClick','parsetags("synolika")');
    newa.innerHTML="ΣΥΝΟΛΙΚΑ";
    newli.appendChild(newa);




for(tagcount=0;tagcount<count2;tagcount++){
    newli=document.createElement('li');
    newul.appendChild(newli);

    newa=document.createElement('a');
    newa.setAttribute('href','#2');
    newa.setAttribute('data-toggle','tab');
    newa.setAttribute('onClick','parsetags("'+tagout[tagcount]+'")');



     var  str=tagout[tagcount].replace(/a/g,"Α")
           str=str.replace(/b/g,"Β")
           str=str.replace(/c/g,"Ψ")
           str=str.replace(/d/g,"Δ")
           str=str.replace(/e/g,"Ε")
           str=str.replace(/f/g,"Φ")
           str=str.replace(/g/g,"Γ")
           str=str.replace(/h/g,"Η")
           str=str.replace(/i/g,"Ι")
           str=str.replace(/j/g,"Ξ")
           str=str.replace(/k/g,"Κ")
           str=str.replace(/l/g,"Λ")
           str=str.replace(/m/g,"Μ")
           str=str.replace(/n/g,"Ν")
           str=str.replace(/o/g,"Ο")
           str=str.replace(/p/g,"Π")
           str=str.replace(/q/g,"Θ")
           str=str.replace(/r/g,"Ρ")
           str=str.replace(/s/g,"Σ")
           str=str.replace(/t/g,"Τ")
           str=str.replace(/u/g,"Υ")
           str=str.replace(/v/g,"Β")
           str=str.replace(/w/g,"Ω")
           str=str.replace(/x/g,"Χ")
           str=str.replace(/y/g,"Υ")
           str=str.replace(/z/g,"Ζ")

    newa.innerHTML=str;
   newli.appendChild(newa);
                                          }

}

function createmunicipalities(){


     var muns = document.getElementById('municipalities');

     var newdiv=document.createElement('div');
    newdiv.setAttribute('class','tabbable tabs-right');
    muns.appendChild(newdiv);

    var newul=document.createElement('ul');
    newul.setAttribute('class','nav nav-tabs');
    newdiv.appendChild(newul);

    for(orgcount=0;orgcount<count;orgcount++){

    newli=document.createElement('li');
    newul.appendChild(newli);

    newa=document.createElement('a');
    newa.setAttribute('href','innermini.html?mun='+dimosout[orgcount]);


     var  str=dimosout[orgcount].replace(/a/g,"Α")
           str=str.replace(/b/g,"Β")
           str=str.replace(/c/g,"Ψ")
           str=str.replace(/d/g,"Δ")
           str=str.replace(/e/g,"Ε")
           str=str.replace(/f/g,"Φ")
           str=str.replace(/g/g,"Γ")
           str=str.replace(/h/g,"Η")
           str=str.replace(/i/g,"Ι")
           str=str.replace(/j/g,"Ξ")
           str=str.replace(/k/g,"Κ")
           str=str.replace(/l/g,"Λ")
           str=str.replace(/m/g,"Μ")
           str=str.replace(/n/g,"Ν")
           str=str.replace(/o/g,"Ο")
           str=str.replace(/p/g,"Π")
           str=str.replace(/q/g,"Θ")
           str=str.replace(/r/g,"Ρ")
           str=str.replace(/s/g,"Σ")
           str=str.replace(/t/g,"Τ")
           str=str.replace(/u/g,"Υ")
           str=str.replace(/v/g,"Β")
           str=str.replace(/w/g,"Ω")
           str=str.replace(/x/g,"Χ")
           str=str.replace(/y/g,"Υ")
           str=str.replace(/z/g,"Ζ")

    newa.innerHTML=str;
    newli.appendChild(newa);

                                                }

}

function createmunsintags(){

    var erase=document.getElementById('munserase');
    var muns=document.getElementById('municipalities');
    erase.removeChild(muns);

    var newdiv=document.createElement('div');
    newdiv.setAttribute('id','municipalities');
    erase.appendChild(newdiv);

    var newspan=document.createElement('span');
    newspan.setAttribute('id','municipalitiesspan');
    newspan.innerHTML='ΔΗΜΟΙ';
    newdiv.appendChild(newspan);

    if((count3*27)<(viewportheight-131)){

    muns = document.getElementById('municipalities');
    customheight=viewportheight-194;
    customleft=viewportwidth/1.319;
    customwidth=viewportwidth/6.2;
    muns.setAttribute('style','left:'+customleft+'px;height:'+customheight+'px;width:'+customwidth+'px;');

    custommargin=customwidth-102.45;
    if(custommargin<0){custommargin=0;}
    municipalitiesspan=document.getElementById('municipalitiesspan');
    municipalitiesspan.setAttribute('style','margin-left:'+custommargin+'px');
                                        }

    else{

    muns = document.getElementById('municipalities');
    customheight=viewportheight-194;
    customleft=viewportwidth/1.281;
    customwidth=viewportwidth/6.2;
    muns.setAttribute('style','left:'+customleft+'px;height:'+customheight+'px;width:'+customwidth+'px;');

    custommargin=customwidth-129.45;
    if(custommargin<0){custommargin=0;}
    municipalitiesspan=document.getElementById('municipalitiesspan');
    municipalitiesspan.setAttribute('style','margin-left:'+custommargin+'px');

        }
    newdiv=document.createElement('div');
    newdiv.setAttribute('class','tabbable tabs-right');
    muns.appendChild(newdiv);

    var newul=document.createElement('ul');
    newul.setAttribute('class','nav nav-tabs');
    newdiv.appendChild(newul);


    for(orgcount=0;orgcount<count3;orgcount++){
    newli=document.createElement('li');
    newul.appendChild(newli);

    newa=document.createElement('a');
    newa.setAttribute('href','innermini.html?mun='+dimosout2[orgcount]);

     var  str=dimosout2[orgcount].replace(/a/g,"Α")
           str=str.replace(/b/g,"Β")
           str=str.replace(/c/g,"Ψ")
           str=str.replace(/d/g,"Δ")
           str=str.replace(/e/g,"Ε")
           str=str.replace(/f/g,"Φ")
           str=str.replace(/g/g,"Γ")
           str=str.replace(/h/g,"Η")
           str=str.replace(/i/g,"Ι")
           str=str.replace(/j/g,"Ξ")
           str=str.replace(/k/g,"Κ")
           str=str.replace(/l/g,"Λ")
           str=str.replace(/m/g,"Μ")
           str=str.replace(/n/g,"Ν")
           str=str.replace(/o/g,"Ο")
           str=str.replace(/p/g,"Π")
           str=str.replace(/q/g,"Θ")
           str=str.replace(/r/g,"Ρ")
           str=str.replace(/s/g,"Σ")
           str=str.replace(/t/g,"Τ")
           str=str.replace(/u/g,"Υ")
           str=str.replace(/v/g,"Β")
           str=str.replace(/w/g,"Ω")
           str=str.replace(/x/g,"Χ")
           str=str.replace(/y/g,"Υ")
           str=str.replace(/z/g,"Ζ")

    newa.innerHTML=str;
    newli.appendChild(newa);

                                                    }

}

function checkmunicipalities(){

    mun=document.getElementById("autocomplete").value;

    var availablemunicipalities = [
                "ΔΙΟΙΚΗΤΙΚΗΣ ΜΕΤΑΡΡΥΘΜΙΣΗΣ","ΕΣΩΤΕΡΙΚΩΝ","ΘΑΛΛΑΣΙΩΝ ΥΠΟΘΕΣΕΩΝ","ΥΓΕΙΑΣ","ΠΡΟΣΤΑΣΙΑΣ ΤΟΥ ΠΟΛΙΤΗ","ΑΝΑΠΤΥΞΗΣ","ΠΟΛΙΤΙΣΜΟΥ","ΠΕΡΙΒΑΛΛΟΝΤΟΣ","ΟΙΚΟΝΟΜΙΚΩΝ","ΜΕΤΑΦΟΡΩΝ",
            "ΕΡΓΑΣΙΑΣ","ΕΞΩΤΕΡΙΚΩΝ","ΠΑΙΔΕΙΑΣ","ΑΜΥΝΑΣ","ΔΙΚΑΙΟΣΥΝΗΣ","ΑΓΡΟΤΙΚΗΣ ΑΝΑΠΤΥΞΗΣ"];

            var names=[
"dioikhtikhs metarryqmishs", "eswterikwn", "qallasiwn ypoqesewn","ygeias","prostasias toy polith","anaptyjhs","politismou","periballontos","oikonomikwn","metaforwn",
    "ergasias","ejwterikwn","paideias","amynas","dikaiosynhs","agrotikhs anaptyjhs"];

 var muncount;
 var found=0;
 var munvar;


 for(muncount=0;muncount<272;muncount++){
     if(mun==availablemunicipalities[muncount]){munvar=names[muncount];found=1; break;}
                                       }

  if(found==0){jQuery('#myModal').modal('toggle');}
  else{location.href = "innermini.html?mun="+munvar;}

}

function get_short_url(long_url, login, api_key, func)
{
    jQuery.getJSON(
        "http://api.bitly.com/v3/shorten?callback=?",
        {
            "format": "json",
            "apiKey": api_key,
            "login": login,
            "longUrl": long_url
        },
        function(response)
        {

            func(response.data.url);
        }
    );
}

function voted(doc){

  jQuery.ajax({
				type: "GET",
				url: "TopDecisionsVotedMinistries?ada="+doc,
				dataType: "text",
				success: function(text) {

if(!(text=="OK")){ jQuery('#myModal4').modal('toggle');}
else{jQuery('#myModal3').modal('toggle');}


			},
                                 async:   true
			});


}
