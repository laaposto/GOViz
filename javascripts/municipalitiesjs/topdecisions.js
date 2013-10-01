jQuery.ajax({
				type: "GET",
				url: "TopDecisionsSortMunicipalities",
				dataType: "text",
				success: function(text) {
var textgr=text;


           textgr=textgr.replace(/a/g,"Α")
           textgr=textgr.replace(/b/g,"Β")
           textgr=textgr.replace(/c/g,"Ψ")
           textgr=textgr.replace(/d/g,"Δ")
           textgr=textgr.replace(/e/g,"Ε")
           textgr=textgr.replace(/f/g,"Φ")
           textgr=textgr.replace(/g/g,"Γ")
           textgr=textgr.replace(/h/g,"Η")
           textgr=textgr.replace(/i/g,"Ι")
           textgr=textgr.replace(/j/g,"Ξ")
           textgr=textgr.replace(/k/g,"Κ")
           textgr=textgr.replace(/l/g,"Λ")
           textgr=textgr.replace(/m/g,"Μ")
           textgr=textgr.replace(/n/g,"Ν")
           textgr=textgr.replace(/o/g,"Ο")
           textgr=textgr.replace(/p/g,"Π")
           textgr=textgr.replace(/q/g,"Θ")
           textgr=textgr.replace(/r/g,"Ρ")
           textgr=textgr.replace(/s/g,"Σ")
           textgr=textgr.replace(/t/g,"Τ")
           textgr=textgr.replace(/u/g,"Υ")
           textgr=textgr.replace(/v/g,"Β")
           textgr=textgr.replace(/w/g,"Ω")
           textgr=textgr.replace(/x/g,"Χ")
           textgr=textgr.replace(/y/g,"Υ")
           textgr=textgr.replace(/z/g,"Ζ")


stop1=textgr.indexOf('@');
stop2=textgr.indexOf('@@');
stop3=textgr.indexOf('@@@');

ada1gr=textgr.substring(0,stop1);
ada1=text.substring(0,stop1);
cost1=textgr.substring(stop1+1,stop2);
title1gr=textgr.substring(stop2+2,stop3);

stop4=textgr.indexOf('@@@@');
stop5=textgr.indexOf('@@@@@');
stop6=textgr.indexOf('@@@@@@');

ada2gr=textgr.substring(stop3+3,stop4);
ada2=text.substring(stop3+3,stop4);
cost2=textgr.substring(stop4+4,stop5);
title2gr=textgr.substring(stop5+5,stop6);

stop7=textgr.indexOf('@@@@@@@');
stop8=textgr.indexOf('@@@@@@@@');
stop9=textgr.indexOf('@@@@@@@@@');

ada3gr=textgr.substring(stop6+6,stop7);
ada3=text.substring(stop6+6,stop7);
cost3=textgr.substring(stop7+7,stop8);
title3gr=textgr.substring(stop8+8,stop9);

stop10=textgr.indexOf('@@@@@@@@@@');
stop11=textgr.indexOf('@@@@@@@@@@@');
stop12=textgr.indexOf('@@@@@@@@@@@@');

ada4gr=textgr.substring(stop9+9,stop10);
ada4=text.substring(stop9+9,stop10);
cost4=textgr.substring(stop10+10,stop11);
title4gr=textgr.substring(stop11+11,stop12);

stop13=textgr.indexOf('@@@@@@@@@@@@@');
stop14=textgr.indexOf('@@@@@@@@@@@@@@');
stop15=textgr.indexOf('@@@@@@@@@@@@@@@');

ada5gr=textgr.substring(stop12+12,stop13);
ada5=text.substring(stop12+12,stop13);
cost5=textgr.substring(stop13+13,stop14);
title5gr=textgr.substring(stop14+14,stop15);


dec1=document.getElementById('dec1');
dec1.innerHTML="1."+title1gr;

dec2=document.getElementById('dec2');
dec2.innerHTML="2."+title2gr;

dec3=document.getElementById('dec3');
dec3.innerHTML="3."+title3gr;

dec4=document.getElementById('dec4');
dec4.innerHTML="4."+title4gr;

dec5=document.getElementById('dec5');
dec5.innerHTML="5."+title5gr;

cost1id=document.getElementById('cost1');
cost1id.innerHTML=cost1+' &euro;';

cost2id=document.getElementById('cost2');
cost2id.innerHTML=cost2+' &euro;';

cost3id=document.getElementById('cost3');
cost3id.innerHTML=cost3+' &euro;';

cost4id=document.getElementById('cost4');
cost4id.innerHTML=cost4+' &euro;';

cost5id=document.getElementById('cost5');
cost5id.innerHTML=cost5+' &euro;';

dl1=document.getElementById('dl1');
a=document.createElement('a');
dl1.appendChild(a);
a.setAttribute('href','http://static.diavgeia.gov.gr/doc/'+ada1gr);
a.setAttribute('target','_blank');
img=document.createElement('img');
a.appendChild(img);
img.setAttribute('src','imgs/download.png');
img.setAttribute('id','dlimg');

dl2=document.getElementById('dl2');
a=document.createElement('a');
dl2.appendChild(a);
a.setAttribute('href','http://static.diavgeia.gov.gr/doc/'+ada2gr);
a.setAttribute('target','_blank');
img=document.createElement('img');
a.appendChild(img);
img.setAttribute('src','imgs/download.png');
img.setAttribute('id','dlimg');

dl3=document.getElementById('dl3');
a=document.createElement('a');
dl3.appendChild(a);
a.setAttribute('href','http://static.diavgeia.gov.gr/doc/'+ada3gr);
a.setAttribute('target','_blank');
img=document.createElement('img');
a.appendChild(img);
img.setAttribute('src','imgs/download.png');
img.setAttribute('id','dlimg');

dl4=document.getElementById('dl4');
a=document.createElement('a');
dl4.appendChild(a);
a.setAttribute('href','http://static.diavgeia.gov.gr/doc/'+ada4gr);
a.setAttribute('target','_blank');
img=document.createElement('img');
a.appendChild(img);
img.setAttribute('src','imgs/download.png');
img.setAttribute('id','dlimg');

dl5=document.getElementById('dl5');
a=document.createElement('a');
dl5.appendChild(a);
a.setAttribute('href','http://static.diavgeia.gov.gr/doc/'+ada5gr);
a.setAttribute('target','_blank');
img=document.createElement('img');
a.appendChild(img);
img.setAttribute('src','imgs/download.png');


warn1=document.getElementById('warn1');
img=document.createElement('img');
warn1.appendChild(img);
img.setAttribute('src','imgs/warning_icon.png');
img.setAttribute('onclick', "voted(" +'"' + ada1 +'"'+ ");");
img.setAttribute('style','cursor:pointer');

warn2=document.getElementById('warn2');
img=document.createElement('img');
warn2.appendChild(img);
img.setAttribute('src','imgs/warning_icon.png');
img.setAttribute('onclick', "voted(" +'"' + ada2 +'"'+ ");");
img.setAttribute('style','cursor:pointer');

warn3=document.getElementById('warn3');
img=document.createElement('img');
warn3.appendChild(img);
img.setAttribute('src','imgs/warning_icon.png');
img.setAttribute('onclick', "voted(" +'"' + ada3 +'"'+ ");");
img.setAttribute('style','cursor:pointer');

warn4=document.getElementById('warn4');
img=document.createElement('img');
warn4.appendChild(img);
img.setAttribute('src','imgs/warning_icon.png');
img.setAttribute('onclick', "voted(" +'"' + ada4 +'"'+ ");");
img.setAttribute('style','cursor:pointer');

warn5=document.getElementById('warn5');
img=document.createElement('img');
warn5.appendChild(img);
img.setAttribute('src','imgs/warning_icon.png');
img.setAttribute('onclick', "voted(" +'"' + ada5 +'"'+ ");");
img.setAttribute('style','cursor:pointer');



var login = "laaposto";
var api_key = "R_10c97be6da0d44e2a62d0178fb4bf899";
var long_url = "http://et.diavgeia.gov.gr/f/all/ada/"+ada1gr;


get_short_url(long_url, login, api_key, function(short_url) {

jQuery.getScript("http://platform.twitter.com/widgets.js");
twitter1 = document.getElementById('twitter1');
twitter1.setAttribute('href', 'https://twitter.com/share?url='+short_url+'&text=Δείτε αυτή την απόφαση του Ελληνικού Δημοσίου(found via www.GOViz.gr)&via=GOViz&related=laaposto&lang=gr');
});

long_url = "http://et.diavgeia.gov.gr/f/all/ada/"+ada2gr;


get_short_url(long_url, login, api_key, function(short_url) {

jQuery.getScript("http://platform.twitter.com/widgets.js");
twitter2 = document.getElementById('twitter2');
twitter2.setAttribute('href', 'https://twitter.com/share?url='+short_url+'&text=Δείτε αυτή την απόφαση του Ελληνικού Δημοσίου(found via www.GOViz.gr)&via=GOViz&related=laaposto&lang=gr');
});

long_url = "http://et.diavgeia.gov.gr/f/all/ada/"+ada3gr;


get_short_url(long_url, login, api_key, function(short_url) {

jQuery.getScript("http://platform.twitter.com/widgets.js");
twitter3 = document.getElementById('twitter3');
twitter3.setAttribute('href', 'https://twitter.com/share?url='+short_url+'&text=Δείτε αυτή την απόφαση του Ελληνικού Δημοσίου(found via www.GOViz.gr)&via=GOViz&related=laaposto&lang=gr');
});

long_url = "http://et.diavgeia.gov.gr/f/all/ada/"+ada4gr;


get_short_url(long_url, login, api_key, function(short_url) {

jQuery.getScript("http://platform.twitter.com/widgets.js");
twitter4 = document.getElementById('twitter4');
twitter4.setAttribute('href', 'https://twitter.com/share?url='+short_url+'&text=Δείτε αυτή την απόφαση του Ελληνικού Δημοσίου(found via www.GOViz.gr)&via=GOViz&related=laaposto&lang=gr');
});


long_url = "http://et.diavgeia.gov.gr/f/all/ada/"+ada5gr;


get_short_url(long_url, login, api_key, function(short_url) {

jQuery.getScript("http://platform.twitter.com/widgets.js");
twitter5 = document.getElementById('twitter5');
twitter5.setAttribute('href', 'https://twitter.com/share?url='+short_url+'&text=Δείτε αυτή την απόφαση του Ελληνικού Δημοσίου(found via www.GOViz.gr)&via=GOViz&related=laaposto&lang=gr');
});
	},
                                 async:   true
			});


