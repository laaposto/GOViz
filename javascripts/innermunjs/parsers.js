google.load("visualization", "1", {packages:["corechart"]});

customwidthchartdiv=viewportwidth*0.5;
customheightchartdiv=viewportheight*0.4;
if(viewportheight<529){customheightchartdiv=viewportheight*0.3;}
var i;
var tagout=new Array();
var posoout=new Array();

var count=0;
jQuery.noConflict();
var cou=1;
var twitcou=1;


jQuery(document).ready(function(){
     			 call=jQuery.ajax({
				type: "GET",
				url: "InnerMunTag?mun="+mun,
				dataType: "xml",
				success: function(xml) {

                                        jQuery(xml).find('item').each(function(){

						var tag = jQuery(this).find('tag').text();
						var poso = jQuery(this).find('poso').text();

                                               tagout[count]=tag;
                                               posoout[count]=poso;
                                               count++;
					});

                                         jQuery(xml).find('url').each(function(){


						var doc = jQuery(this).find('doc').text();
						var dap = jQuery(this).find('dap').text();
                                                var sub = jQuery(this).find('sub').text();
                                                
docen=doc.substring(34,doc.size);
doc2=doc.substring(34,doc.size);
           doc2=doc2.replace(/a/g,"Α")
           doc2=doc2.replace(/b/g,"Β")
           doc2=doc2.replace(/c/g,"Ψ")
           doc2=doc2.replace(/d/g,"Δ")
           doc2=doc2.replace(/e/g,"Ε")
           doc2=doc2.replace(/f/g,"Φ")
           doc2=doc2.replace(/g/g,"Γ")
           doc2=doc2.replace(/h/g,"Η")
           doc2=doc2.replace(/i/g,"Ι")
           doc2=doc2.replace(/j/g,"Ξ")
           doc2=doc2.replace(/k/g,"Κ")
           doc2=doc2.replace(/l/g,"Λ")
           doc2=doc2.replace(/m/g,"Μ")
           doc2=doc2.replace(/n/g,"Ν")
           doc2=doc2.replace(/o/g,"Ο")
           doc2=doc2.replace(/p/g,"Π")
           doc2=doc2.replace(/q/g,"Θ")
           doc2=doc2.replace(/r/g,"Ρ")
           doc2=doc2.replace(/s/g,"Σ")
           doc2=doc2.replace(/t/g,"Τ")
           doc2=doc2.replace(/u/g,"Υ")
           doc2=doc2.replace(/v/g,"Β")
           doc2=doc2.replace(/w/g,"Ω")
           doc2=doc2.replace(/x/g,"Χ")
           doc2=doc2.replace(/y/g,"Υ")
           doc2=doc2.replace(/z/g,"Ζ")
suben=sub;
           sub=sub.replace(/a/g,"Α")
           sub=sub.replace(/b/g,"Β")
           sub=sub.replace(/c/g,"Ψ")
           sub=sub.replace(/d/g,"Δ")
           sub=sub.replace(/e/g,"Ε")
           sub=sub.replace(/f/g,"Φ")
           sub=sub.replace(/g/g,"Γ")
           sub=sub.replace(/h/g,"Η")
           sub=sub.replace(/i/g,"Ι")
           sub=sub.replace(/j/g,"Ξ")
           sub=sub.replace(/k/g,"Κ")
           sub=sub.replace(/l/g,"Λ")
           sub=sub.replace(/m/g,"Μ")
           sub=sub.replace(/n/g,"Ν")
           sub=sub.replace(/o/g,"Ο")
           sub=sub.replace(/p/g,"Π")
           sub=sub.replace(/q/g,"Θ")
           sub=sub.replace(/r/g,"Ρ")
           sub=sub.replace(/s/g,"Σ")
           sub=sub.replace(/t/g,"Τ")
           sub=sub.replace(/u/g,"Υ")
           sub=sub.replace(/v/g,"Β")
           sub=sub.replace(/w/g,"Ω")
           sub=sub.replace(/x/g,"Χ")
           sub=sub.replace(/y/g,"Υ")
           sub=sub.replace(/z/g,"Ζ")

footermain=document.getElementById('decisions');

customwidth=(((viewportwidth-114)/4)*1.1)+57;
customwidth1=(viewportwidth-114)/2.3;
line=document.createElement('div');
line.innerHTML=('__________________________________________________________________________________________________');
line.setAttribute('id','line');
line.setAttribute('style','margin-left:'+customwidth+'px;width:'+customwidth1+'px;');
footermain.appendChild(line);

customwidth=(((viewportwidth-114)/4)*1.1)+57;
if(viewportwidth>=1280){customwidth1=((viewportwidth-114)/2.3)*0.68;}
if((viewportwidth<1280) && (viewportwidth>=1100)){customwidth1=((viewportwidth-114)/2.3)*0.65;}
if((viewportwidth<1100) && (viewportwidth>=950)){customwidth1=((viewportwidth-114)/2.3)*0.62;}
if((viewportwidth<950) && (viewportwidth>=800)){customwidth1=((viewportwidth-114)/2.3)*0.59;}
if(viewportwidth<800){customwidth1=((viewportwidth-114)/2.3)*0.53;}
dec=document.createElement('div');
dec.setAttribute('id','dec');
dec.setAttribute('style','margin-left:'+customwidth+'px;width:'+customwidth1+'px;');
dec.innerHTML=cou+"."+sub;
footermain.appendChild(dec);

customwidth2=customwidth1+customwidth+12;
if(viewportwidth<930){customwidth3=((viewportwidth-114)/2.3)*0.15;}
else{customwidth3=((viewportwidth-114)/2.3)*0.16;}
if(viewportwidth<826){customwidth3=((viewportwidth-114)/2.3)*0.12;}
cost=document.createElement('div');
cost.setAttribute('id','cost');
cost.innerHTML=dap+'&euro;';
cost.setAttribute('style','margin-left:'+customwidth2+'px;width:'+customwidth3+'px;');
footermain.appendChild(cost);

customwidth4=customwidth2+customwidth3+10;
dl=document.createElement('div');
a=document.createElement('a');
a.setAttribute('href','http://static.diavgeia.gov.gr/doc/'+doc2);
a.setAttribute('target','_blank');
img=document.createElement('img');
a.appendChild(img);
img.setAttribute('src','imgs/download.png');
dl.setAttribute('id','dl');
dl.setAttribute('style','margin-left:'+customwidth4+'px');
dl.setAttribute('data-original-title','Download the pdf');
dl.appendChild(a);
footermain.appendChild(dl);

jQuery('#dl').tooltip();

customwidth5=customwidth4+20;
warn=document.createElement('div');
warn.setAttribute('id','warn');
warn.setAttribute('style','margin-left:'+customwidth5+'px');
warn.setAttribute('data-original-title','Vote');
img2=document.createElement('img');
img2.setAttribute('src','imgs/warning_icon.png');
img2.setAttribute('onclick', "voted(" +'"' + docen +'"'+','+'"' + dap +'"'+','+'"' + suben +'"'+ ");");
img2.setAttribute('style','cursor:pointer');
warn.appendChild(img2);
footermain.appendChild(warn);

jQuery('#warn').tooltip();

customwidth6=customwidth5+20;
tweet=document.createElement('div');
tweet.setAttribute('id','tweet');
tweet.setAttribute('style','margin-left:'+customwidth6+'px;cursor:pointer;');
tweet.setAttribute('data-original-title','Share via Twitter');
tweet.setAttribute('onclick','tweetfunc("'+doc2+'")');
a2=document.createElement('a');
a2.setAttribute('id','twitter'+cou);
a2.setAttribute('target','_blank');
img3=document.createElement('img');
img3.setAttribute('src','imgs/twitter-bird.png');
a2.appendChild(img3);
tweet.appendChild(a2);
footermain.appendChild(tweet);

jQuery('#tweet').tooltip();

cou++;});

    drawChart3();

				},
                                 async:   true
			});
		});


function drawChart3() {
if(count!=0){
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'ΕΝΟΤΗΤΕΣ');
         for(i=0;i<count;i++){

   var   str=tagout[i].replace(/a/g,"Α")
         str=str.replace(/b/g,"Β")
         str=str.replace(/c/g,"Ψ")
         str=str.replace(/d/g,"Δ")
         str=str.replace(/e/g,"Ε")
         str=str.replace(/f/g,"Φ")
         str=str.replace(/g/g,"Γ")
         str=str.replace(/h/g,"Η")
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


        data.addColumn('number',str);
          }
        data.addRows(1);
        data.setValue(0, 0, "ΕΝΟΤΗΤΕΣ");
        for(i=1;i<=count;i++){
          posoint=parseFloat(posoout[i-1]);
          data.setValue(0, i, posoint);
      }


 var options = {
        colors:['green','yellow','red','blue','orange','grey','purple','olive','magenta','cyan','teal','black','navy','maroon','lime','violet','coral','sienna'],
          tooltip: {showColorCode:true},
          width:customwidthchartdiv,
          height: customheightchartdiv,
          legend:{position:'bottom'}
              };

        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        chart.draw(data, options);

google.visualization.events.addListener(
chart, 'ready', function() {
removeElement();
});

}
else{

     removeElement();
   jQuery('#myModal').modal('toggle');
}


      }


function parseunits(){
datefrom=document.getElementById("from").value;
dateto=document.getElementById("to").value;

var erase=document.getElementById('erase');
var chart=document.getElementById('chart_div');
erase.removeChild(chart);

var eraselinks=document.getElementById('eraselinks');
var decisions=document.getElementById('decisions');
eraselinks.removeChild(decisions);

    call.abort();

var newdiv=document.createElement('div');

if(viewportwidth>1300){
customwidth=25;
newdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

if(viewportwidth<1100){
customwidth=-25;
newdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

if(viewportwidth<1000){
customwidth=-35;
newdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

if(viewportwidth<890){
customwidth=-85;
newdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

if(viewportwidth<810){
customwidth=-105;
newdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

newdiv.setAttribute('id','chart_div');
erase.appendChild(newdiv);

newdiv=document.createElement('div');
newdiv.setAttribute('id','decisions');
customwidth5=(((viewportwidth-114)/4)*1.1)+57+((viewportwidth-114)/2.3)*1.05;
newdiv.setAttribute('style','width:'+customwidth5+'px;')
eraselinks.appendChild(newdiv);
////////////////////////////////////////

jQuery("#loading").show();


google.load("visualization", "1", {packages:["corechart"]});

var i;
var unitout=new Array();
var posoout=new Array();

var count=0;
jQuery.noConflict();
var cou=1;
twitcou=1;///////////////////////////////////////////////////////

jQuery(document).ready(function(){
     			call=jQuery.ajax({
				type: "GET",
				url: "InnerMunUnitParser?mun="+mun+"&datefrom="+datefrom+"&dateto="+dateto,
				dataType: "xml",
				success: function(xml) {

                                        jQuery(xml).find('item').each(function(){

						var unit = jQuery(this).find('unit').text();
						var poso = jQuery(this).find('poso').text();

                                               unitout[count]=unit;
                                               posoout[count]=poso;
                                               count++;
					});

                                         jQuery(xml).find('url').each(function(){


						var doc = jQuery(this).find('doc').text();
						var dap = jQuery(this).find('dap').text();
                                                var sub = jQuery(this).find('sub').text();
docen=doc.substring(34,doc.size);
doc2=doc.substring(34,doc.size);
           doc2=doc2.replace(/a/g,"Α")
           doc2=doc2.replace(/b/g,"Β")
           doc2=doc2.replace(/c/g,"Ψ")
           doc2=doc2.replace(/d/g,"Δ")
           doc2=doc2.replace(/e/g,"Ε")
           doc2=doc2.replace(/f/g,"Φ")
           doc2=doc2.replace(/g/g,"Γ")
           doc2=doc2.replace(/h/g,"Η")
           doc2=doc2.replace(/i/g,"Ι")
           doc2=doc2.replace(/j/g,"Ξ")
           doc2=doc2.replace(/k/g,"Κ")
           doc2=doc2.replace(/l/g,"Λ")
           doc2=doc2.replace(/m/g,"Μ")
           doc2=doc2.replace(/n/g,"Ν")
           doc2=doc2.replace(/o/g,"Ο")
           doc2=doc2.replace(/p/g,"Π")
           doc2=doc2.replace(/q/g,"Θ")
           doc2=doc2.replace(/r/g,"Ρ")
           doc2=doc2.replace(/s/g,"Σ")
           doc2=doc2.replace(/t/g,"Τ")
           doc2=doc2.replace(/u/g,"Υ")
           doc2=doc2.replace(/v/g,"Β")
           doc2=doc2.replace(/w/g,"Ω")
           doc2=doc2.replace(/x/g,"Χ")
           doc2=doc2.replace(/y/g,"Υ")
           doc2=doc2.replace(/z/g,"Ζ")

suben=sub;
           sub=sub.replace(/a/g,"Α")
           sub=sub.replace(/b/g,"Β")
           sub=sub.replace(/c/g,"Ψ")
           sub=sub.replace(/d/g,"Δ")
           sub=sub.replace(/e/g,"Ε")
           sub=sub.replace(/f/g,"Φ")
           sub=sub.replace(/g/g,"Γ")
           sub=sub.replace(/h/g,"Η")
           sub=sub.replace(/i/g,"Ι")
           sub=sub.replace(/j/g,"Ξ")
           sub=sub.replace(/k/g,"Κ")
           sub=sub.replace(/l/g,"Λ")
           sub=sub.replace(/m/g,"Μ")
           sub=sub.replace(/n/g,"Ν")
           sub=sub.replace(/o/g,"Ο")
           sub=sub.replace(/p/g,"Π")
           sub=sub.replace(/q/g,"Θ")
           sub=sub.replace(/r/g,"Ρ")
           sub=sub.replace(/s/g,"Σ")
           sub=sub.replace(/t/g,"Τ")
           sub=sub.replace(/u/g,"Υ")
           sub=sub.replace(/v/g,"Β")
           sub=sub.replace(/w/g,"Ω")
           sub=sub.replace(/x/g,"Χ")
           sub=sub.replace(/y/g,"Υ")
           sub=sub.replace(/z/g,"Ζ")

footermain=document.getElementById('decisions');

customwidth=(((viewportwidth-114)/4)*1.1)+57;
customwidth1=(viewportwidth-114)/2.3;
line=document.createElement('div');
line.innerHTML=('__________________________________________________________________________________________________');
line.setAttribute('id','line');
line.setAttribute('style','margin-left:'+customwidth+'px;width:'+customwidth1+'px;');
footermain.appendChild(line);

customwidth=(((viewportwidth-114)/4)*1.1)+57;
if(viewportwidth>=1280){customwidth1=((viewportwidth-114)/2.3)*0.68;}
if((viewportwidth<1280) && (viewportwidth>=1100)){customwidth1=((viewportwidth-114)/2.3)*0.65;}
if((viewportwidth<1100) && (viewportwidth>=950)){customwidth1=((viewportwidth-114)/2.3)*0.62;}
if((viewportwidth<950) && (viewportwidth>=800)){customwidth1=((viewportwidth-114)/2.3)*0.59;}
if(viewportwidth<800){customwidth1=((viewportwidth-114)/2.3)*0.53;}
dec=document.createElement('div');
dec.setAttribute('id','dec');
dec.setAttribute('style','margin-left:'+customwidth+'px;width:'+customwidth1+'px;');
dec.innerHTML=cou+"."+sub;
footermain.appendChild(dec);

customwidth2=customwidth1+customwidth+12;
if(viewportwidth<930){customwidth3=((viewportwidth-114)/2.3)*0.15;}
else{customwidth3=((viewportwidth-114)/2.3)*0.16;}
if(viewportwidth<826){customwidth3=((viewportwidth-114)/2.3)*0.12;}
cost=document.createElement('div');
cost.setAttribute('id','cost');
cost.innerHTML=dap+'&euro;';
cost.setAttribute('style','margin-left:'+customwidth2+'px;width:'+customwidth3+'px;');
footermain.appendChild(cost);

customwidth4=customwidth2+customwidth3+10;
dl=document.createElement('div');
a=document.createElement('a');
a.setAttribute('href','http://static.diavgeia.gov.gr/doc/'+doc2);
a.setAttribute('target','_blank');
img=document.createElement('img');
a.appendChild(img);
img.setAttribute('src','imgs/download.png');
dl.setAttribute('id','dl');
dl.setAttribute('style','margin-left:'+customwidth4+'px');
dl.setAttribute('data-original-title','Download the pdf');
dl.appendChild(a);
footermain.appendChild(dl);

jQuery('#dl').tooltip();

customwidth5=customwidth4+20;
warn=document.createElement('div');
warn.setAttribute('id','warn');
warn.setAttribute('style','margin-left:'+customwidth5+'px');
warn.setAttribute('data-original-title','Vote');
img2=document.createElement('img');
img2.setAttribute('src','imgs/warning_icon.png');
img2.setAttribute('onclick', "voted(" +'"' + docen +'"'+','+'"' + dap +'"'+','+'"' + suben +'"'+ ");");
img2.setAttribute('style','cursor:pointer');
warn.appendChild(img2);
footermain.appendChild(warn);

jQuery('#warn').tooltip();

customwidth6=customwidth5+20;
tweet=document.createElement('div');
tweet.setAttribute('id','tweet');
tweet.setAttribute('style','margin-left:'+customwidth6+'px;cursor:pointer;');
tweet.setAttribute('data-original-title','Share via Twitter');
tweet.setAttribute('onclick','tweetfunc("'+doc2+'")');
a2=document.createElement('a');
a2.setAttribute('id','twitter'+cou);
a2.setAttribute('target','_blank');
img3=document.createElement('img');
img3.setAttribute('src','imgs/twitter-bird.png');
a2.appendChild(img3);
tweet.appendChild(a2);
footermain.appendChild(tweet);

jQuery('#tweet').tooltip();


cou++;					});

    drawChart();

				},
                                 async:   true
			});
		});



function drawChart() {
if(count!=0){
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'ΜΟΝΑΔΑ');
        data.addColumn('number', 'ΔΑΠΑΝΗ');
        data.addRows(count);
        for(i=0;i<count;i++){


      posoint=parseFloat(posoout[i]);

   var   str=unitout[i].replace(/a/g,"Α")
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



      data.setValue(i, 0, str);
      data.setValue(i, 1, posoint);



      }


  var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
  chart.draw(data, {legend:'bottom',is3D:true,fontSize:12,width:customwidthchartdiv,
          height: customheightchartdiv,colors:['green','yellow','red','blue','orange','grey','purple','olive','magenta','cyan','teal','black','navy','maroon','lime','violet','coral','sienna']});

google.visualization.events.addListener(
chart, 'ready', function() {
removeElement();
});

}
else{

     removeElement();
    jQuery('#myModal').modal('toggle');
}


      }
}

function parsetags(){
datefrom=document.getElementById("from").value;
dateto=document.getElementById("to").value;

var erase=document.getElementById('erase');
var chart=document.getElementById('chart_div');
erase.removeChild(chart);

var eraselinks=document.getElementById('eraselinks');
var decisions=document.getElementById('decisions');
eraselinks.removeChild(decisions);

    call.abort();

var newdiv=document.createElement('div');

if(viewportwidth>1300){
customwidth=25;
newdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

if(viewportwidth<1100){
customwidth=-25;
newdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

if(viewportwidth<1000){
customwidth=-35;
newdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

if(viewportwidth<890){
customwidth=-85;
newdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

if(viewportwidth<810){
customwidth=-105;
newdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}
newdiv.setAttribute('id','chart_div');
erase.appendChild(newdiv);

newdiv=document.createElement('div');
newdiv.setAttribute('id','decisions');
customwidth5=(((viewportwidth-114)/4)*1.1)+57+((viewportwidth-114)/2.3)*1.05;
newdiv.setAttribute('style','width:'+customwidth5+'px;')
eraselinks.appendChild(newdiv);
////////////////////////////////////////

jQuery("#loading").show();

google.load("visualization", "1", {packages:["corechart"]});


var i;
var tagout=new Array();
var posoout=new Array();

var count=0;
jQuery.noConflict();
var cou=1;
twitcou=1;

jQuery(document).ready(function(){
     			call=jQuery.ajax({
				type: "GET",
				url: "InnerMunTagParser?mun="+mun+"&datefrom="+datefrom+"&dateto="+dateto,
				dataType: "xml",
				success: function(xml) {

                                        jQuery(xml).find('item').each(function(){

						var tag = jQuery(this).find('tag').text();
						var poso = jQuery(this).find('poso').text();

                                               tagout[count]=tag;
                                               posoout[count]=poso;
                                               count++;
					});

                                         jQuery(xml).find('url').each(function(){


						var doc = jQuery(this).find('doc').text();
						var dap = jQuery(this).find('dap').text();
                                                var sub = jQuery(this).find('sub').text();
docen=doc.substring(34,doc.size);
doc2=doc.substring(34,doc.size);
           doc2=doc2.replace(/a/g,"Α")
           doc2=doc2.replace(/b/g,"Β")
           doc2=doc2.replace(/c/g,"Ψ")
           doc2=doc2.replace(/d/g,"Δ")
           doc2=doc2.replace(/e/g,"Ε")
           doc2=doc2.replace(/f/g,"Φ")
           doc2=doc2.replace(/g/g,"Γ")
           doc2=doc2.replace(/h/g,"Η")
           doc2=doc2.replace(/i/g,"Ι")
           doc2=doc2.replace(/j/g,"Ξ")
           doc2=doc2.replace(/k/g,"Κ")
           doc2=doc2.replace(/l/g,"Λ")
           doc2=doc2.replace(/m/g,"Μ")
           doc2=doc2.replace(/n/g,"Ν")
           doc2=doc2.replace(/o/g,"Ο")
           doc2=doc2.replace(/p/g,"Π")
           doc2=doc2.replace(/q/g,"Θ")
           doc2=doc2.replace(/r/g,"Ρ")
           doc2=doc2.replace(/s/g,"Σ")
           doc2=doc2.replace(/t/g,"Τ")
           doc2=doc2.replace(/u/g,"Υ")
           doc2=doc2.replace(/v/g,"Β")
           doc2=doc2.replace(/w/g,"Ω")
           doc2=doc2.replace(/x/g,"Χ")
           doc2=doc2.replace(/y/g,"Υ")
           doc2=doc2.replace(/z/g,"Ζ")

           suben=sub;
           sub=sub.replace(/a/g,"Α")
           sub=sub.replace(/b/g,"Β")
           sub=sub.replace(/c/g,"Ψ")
           sub=sub.replace(/d/g,"Δ")
           sub=sub.replace(/e/g,"Ε")
           sub=sub.replace(/f/g,"Φ")
           sub=sub.replace(/g/g,"Γ")
           sub=sub.replace(/h/g,"Η")
           sub=sub.replace(/i/g,"Ι")
           sub=sub.replace(/j/g,"Ξ")
           sub=sub.replace(/k/g,"Κ")
           sub=sub.replace(/l/g,"Λ")
           sub=sub.replace(/m/g,"Μ")
           sub=sub.replace(/n/g,"Ν")
           sub=sub.replace(/o/g,"Ο")
           sub=sub.replace(/p/g,"Π")
           sub=sub.replace(/q/g,"Θ")
           sub=sub.replace(/r/g,"Ρ")
           sub=sub.replace(/s/g,"Σ")
           sub=sub.replace(/t/g,"Τ")
           sub=sub.replace(/u/g,"Υ")
           sub=sub.replace(/v/g,"Β")
           sub=sub.replace(/w/g,"Ω")
           sub=sub.replace(/x/g,"Χ")
           sub=sub.replace(/y/g,"Υ")
           sub=sub.replace(/z/g,"Ζ")

footermain=document.getElementById('decisions');

customwidth=(((viewportwidth-114)/4)*1.1)+57;
customwidth1=(viewportwidth-114)/2.3;
line=document.createElement('div');
line.innerHTML=('__________________________________________________________________________________________________');
line.setAttribute('id','line');
line.setAttribute('style','margin-left:'+customwidth+'px;width:'+customwidth1+'px;');
footermain.appendChild(line);

customwidth=(((viewportwidth-114)/4)*1.1)+57;
if(viewportwidth>=1280){customwidth1=((viewportwidth-114)/2.3)*0.68;}
if((viewportwidth<1280) && (viewportwidth>=1100)){customwidth1=((viewportwidth-114)/2.3)*0.65;}
if((viewportwidth<1100) && (viewportwidth>=950)){customwidth1=((viewportwidth-114)/2.3)*0.62;}
if((viewportwidth<950) && (viewportwidth>=800)){customwidth1=((viewportwidth-114)/2.3)*0.59;}
if(viewportwidth<800){customwidth1=((viewportwidth-114)/2.3)*0.53;}
dec=document.createElement('div');
dec.setAttribute('id','dec');
dec.setAttribute('style','margin-left:'+customwidth+'px;width:'+customwidth1+'px;');
dec.innerHTML=cou+"."+sub;
footermain.appendChild(dec);

customwidth2=customwidth1+customwidth+12;
if(viewportwidth<930){customwidth3=((viewportwidth-114)/2.3)*0.15;}
else{customwidth3=((viewportwidth-114)/2.3)*0.16;}
if(viewportwidth<826){customwidth3=((viewportwidth-114)/2.3)*0.12;}
cost=document.createElement('div');
cost.setAttribute('id','cost');
cost.innerHTML=dap+'&euro;';
cost.setAttribute('style','margin-left:'+customwidth2+'px;width:'+customwidth3+'px;');
footermain.appendChild(cost);

customwidth4=customwidth2+customwidth3+10;
dl=document.createElement('div');
a=document.createElement('a');
a.setAttribute('href','http://static.diavgeia.gov.gr/doc/'+doc2);
a.setAttribute('target','_blank');
img=document.createElement('img');
a.appendChild(img);
img.setAttribute('src','imgs/download.png');
dl.setAttribute('id','dl');
dl.setAttribute('style','margin-left:'+customwidth4+'px');
dl.setAttribute('data-original-title','Download the pdf');
dl.appendChild(a);
footermain.appendChild(dl);

jQuery('#dl').tooltip();

customwidth5=customwidth4+20;
warn=document.createElement('div');
warn.setAttribute('id','warn');
warn.setAttribute('style','margin-left:'+customwidth5+'px');
warn.setAttribute('data-original-title','Vote');
img2=document.createElement('img');
img2.setAttribute('src','imgs/warning_icon.png');
img2.setAttribute('onclick', "voted(" +'"' + docen +'"'+','+'"' + dap +'"'+','+'"' + suben +'"'+ ");");
img2.setAttribute('style','cursor:pointer');
warn.appendChild(img2);
footermain.appendChild(warn);

jQuery('#warn').tooltip();

customwidth6=customwidth5+20;
tweet=document.createElement('div');
tweet.setAttribute('id','tweet');
tweet.setAttribute('style','margin-left:'+customwidth6+'px;cursor:pointer');
tweet.setAttribute('data-original-title','Share via Twitter');
tweet.setAttribute('onclick','tweetfunc("'+doc2+'")');
a2=document.createElement('a');
a2.setAttribute('id','twitter'+cou);
a2.setAttribute('target','_blank');
img3=document.createElement('img');
img3.setAttribute('src','imgs/twitter-bird.png');
a2.appendChild(img3);
tweet.appendChild(a2);
footermain.appendChild(tweet);

jQuery('#tweet').tooltip();



cou++;						});

    drawChart();

				},
                                 async:   true
			});
		});

function drawChart() {
if(count!=0){
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'ΕΝΟΤΗΤΕΣ');
         for(i=0;i<count;i++){

   var   str=tagout[i].replace(/a/g,"Α")
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


        data.addColumn('number',str);
          }
        data.addRows(1);
        data.setValue(0, 0, "ΕΝΟΤΗΤΕΣ");
        for(i=1;i<=count;i++){
          posoint=parseFloat(posoout[i-1]);
          data.setValue(0, i, posoint);
      }


 var options = {
          colors:['green','yellow','red','blue','orange','grey','purple','olive','magenta','cyan','teal','black','navy','maroon','lime','violet','coral','sienna'],
          tooltip: {showColorCode:true},
          width:customwidthchartdiv,
          height: customheightchartdiv,
          legend:{position:'bottom'}

        };

        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        chart.draw(data, options);

google.visualization.events.addListener(
chart, 'ready', function() {
removeElement();
});

}
else{

     removeElement();
   jQuery('#myModal').modal('toggle');
}


      }


}

function parseafm(){
datefrom=document.getElementById("from").value;
dateto=document.getElementById("to").value;

var erase=document.getElementById('erase');
var chart=document.getElementById('chart_div');
erase.removeChild(chart);

var eraselinks=document.getElementById('eraselinks');
var decisions=document.getElementById('decisions');
eraselinks.removeChild(decisions);

    call.abort();

var newdiv=document.createElement('div');

if(viewportwidth>1300){
customwidth=25;
newdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

if(viewportwidth<1100){
customwidth=-25;
newdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

if(viewportwidth<1000){
customwidth=-35;
newdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

if(viewportwidth<890){
customwidth=-85;
newdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

if(viewportwidth<810){
customwidth=-105;
newdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}
newdiv.setAttribute('id','chart_div');
erase.appendChild(newdiv);

newdiv=document.createElement('div');
newdiv.setAttribute('id','decisions');
customwidth5=(((viewportwidth-114)/4)*1.1)+57+((viewportwidth-114)/2.3)*1.05;
newdiv.setAttribute('style','width:'+customwidth5+'px;')
eraselinks.appendChild(newdiv);
////////////////////////////////////////

jQuery("#loading").show();

google.load("visualization", "1", {packages:["corechart"]});

var i;
var afmout=new Array();
var posoout=new Array();

var count=0;
jQuery.noConflict();
var cou=1;
twitcou=1;

jQuery(document).ready(function(){
     			call=jQuery.ajax({
				type: "GET",
				url: "InnerMunAfmParser?mun="+mun+"&datefrom="+datefrom+"&dateto="+dateto,
				dataType: "xml",
				success: function(xml) {

                                        jQuery(xml).find('item').each(function(){

						var unit = jQuery(this).find('afm').text();
						var poso = jQuery(this).find('poso').text();

                                               afmout[count]=unit;
                                               posoout[count]=poso;
                                               count++;
					});

                                         jQuery(xml).find('url').each(function(){


						var doc = jQuery(this).find('doc').text();
						var dap = jQuery(this).find('dap').text();
                                                var sub = jQuery(this).find('sub').text();
docen=doc.substring(34,doc.size);
doc2=doc.substring(34,doc.size);
           doc2=doc2.replace(/a/g,"Α")
           doc2=doc2.replace(/b/g,"Β")
           doc2=doc2.replace(/c/g,"Ψ")
           doc2=doc2.replace(/d/g,"Δ")
           doc2=doc2.replace(/e/g,"Ε")
           doc2=doc2.replace(/f/g,"Φ")
           doc2=doc2.replace(/g/g,"Γ")
           doc2=doc2.replace(/h/g,"Η")
           doc2=doc2.replace(/i/g,"Ι")
           doc2=doc2.replace(/j/g,"Ξ")
           doc2=doc2.replace(/k/g,"Κ")
           doc2=doc2.replace(/l/g,"Λ")
           doc2=doc2.replace(/m/g,"Μ")
           doc2=doc2.replace(/n/g,"Ν")
           doc2=doc2.replace(/o/g,"Ο")
           doc2=doc2.replace(/p/g,"Π")
           doc2=doc2.replace(/q/g,"Θ")
           doc2=doc2.replace(/r/g,"Ρ")
           doc2=doc2.replace(/s/g,"Σ")
           doc2=doc2.replace(/t/g,"Τ")
           doc2=doc2.replace(/u/g,"Υ")
           doc2=doc2.replace(/v/g,"Β")
           doc2=doc2.replace(/w/g,"Ω")
           doc2=doc2.replace(/x/g,"Χ")
           doc2=doc2.replace(/y/g,"Υ")
           doc2=doc2.replace(/z/g,"Ζ")
suben=sub;
           sub=sub.replace(/a/g,"Α")
           sub=sub.replace(/b/g,"Β")
           sub=sub.replace(/c/g,"Ψ")
           sub=sub.replace(/d/g,"Δ")
           sub=sub.replace(/e/g,"Ε")
           sub=sub.replace(/f/g,"Φ")
           sub=sub.replace(/g/g,"Γ")
           sub=sub.replace(/h/g,"Η")
           sub=sub.replace(/i/g,"Ι")
           sub=sub.replace(/j/g,"Ξ")
           sub=sub.replace(/k/g,"Κ")
           sub=sub.replace(/l/g,"Λ")
           sub=sub.replace(/m/g,"Μ")
           sub=sub.replace(/n/g,"Ν")
           sub=sub.replace(/o/g,"Ο")
           sub=sub.replace(/p/g,"Π")
           sub=sub.replace(/q/g,"Θ")
           sub=sub.replace(/r/g,"Ρ")
           sub=sub.replace(/s/g,"Σ")
           sub=sub.replace(/t/g,"Τ")
           sub=sub.replace(/u/g,"Υ")
           sub=sub.replace(/v/g,"Β")
           sub=sub.replace(/w/g,"Ω")
           sub=sub.replace(/x/g,"Χ")
           sub=sub.replace(/y/g,"Υ")
           sub=sub.replace(/z/g,"Ζ")

footermain=document.getElementById('decisions');

customwidth=(((viewportwidth-114)/4)*1.1)+57;
customwidth1=(viewportwidth-114)/2.3;
line=document.createElement('div');
line.innerHTML=('__________________________________________________________________________________________________');
line.setAttribute('id','line');
line.setAttribute('style','margin-left:'+customwidth+'px;width:'+customwidth1+'px;');
footermain.appendChild(line);

customwidth=(((viewportwidth-114)/4)*1.1)+57;
if(viewportwidth>=1280){customwidth1=((viewportwidth-114)/2.3)*0.68;}
if((viewportwidth<1280) && (viewportwidth>=1100)){customwidth1=((viewportwidth-114)/2.3)*0.65;}
if((viewportwidth<1100) && (viewportwidth>=950)){customwidth1=((viewportwidth-114)/2.3)*0.62;}
if((viewportwidth<950) && (viewportwidth>=800)){customwidth1=((viewportwidth-114)/2.3)*0.59;}
if(viewportwidth<800){customwidth1=((viewportwidth-114)/2.3)*0.53;}
dec=document.createElement('div');
dec.setAttribute('id','dec');
dec.setAttribute('style','margin-left:'+customwidth+'px;width:'+customwidth1+'px;');
dec.innerHTML=cou+"."+sub;
footermain.appendChild(dec);

customwidth2=customwidth1+customwidth+12;
if(viewportwidth<930){customwidth3=((viewportwidth-114)/2.3)*0.15;}
else{customwidth3=((viewportwidth-114)/2.3)*0.16;}
if(viewportwidth<826){customwidth3=((viewportwidth-114)/2.3)*0.12;}
cost=document.createElement('div');
cost.setAttribute('id','cost');
cost.innerHTML=dap+'&euro;';
cost.setAttribute('style','margin-left:'+customwidth2+'px;width:'+customwidth3+'px;');
footermain.appendChild(cost);

customwidth4=customwidth2+customwidth3+10;
dl=document.createElement('div');
a=document.createElement('a');
a.setAttribute('href','http://static.diavgeia.gov.gr/doc/'+doc2);
a.setAttribute('target','_blank');
img=document.createElement('img');
a.appendChild(img);
img.setAttribute('src','imgs/download.png');
dl.setAttribute('id','dl');
dl.setAttribute('style','margin-left:'+customwidth4+'px');
dl.setAttribute('data-original-title','Download the pdf');
dl.appendChild(a);
footermain.appendChild(dl);

jQuery('#dl').tooltip();

customwidth5=customwidth4+20;
warn=document.createElement('div');
warn.setAttribute('id','warn');
warn.setAttribute('style','margin-left:'+customwidth5+'px');
warn.setAttribute('data-original-title','Vote');
img2=document.createElement('img');
img2.setAttribute('src','imgs/warning_icon.png');
img2.setAttribute('onclick', "voted(" +'"' + docen +'"'+','+'"' + dap +'"'+','+'"' + suben +'"'+ ");");
img2.setAttribute('style','cursor:pointer');
warn.appendChild(img2);
footermain.appendChild(warn);

jQuery('#warn').tooltip();

customwidth6=customwidth5+20;
tweet=document.createElement('div');
tweet.setAttribute('id','tweet');
tweet.setAttribute('style','margin-left:'+customwidth6+'px;cursor:pointer;');
tweet.setAttribute('data-original-title','Share via Twitter');
tweet.setAttribute('onclick','tweetfunc("'+doc2+'")');
a2=document.createElement('a');
a2.setAttribute('id','twitter'+cou);
a2.setAttribute('target','_blank');
img3=document.createElement('img');
img3.setAttribute('src','imgs/twitter-bird.png');
a2.appendChild(img3);
tweet.appendChild(a2);
footermain.appendChild(tweet);

jQuery('#tweet').tooltip();



cou++;					});

    drawChart();

				},
                                 async:   true
			});
		});

function drawChart() {
if(count!=0){
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'ΜΟΝΑΔΑ');
        data.addColumn('number', 'ΔΑΠΑΝΗ');
        data.addRows(count);
        for(i=0;i<count;i++){


      posoint=parseFloat(posoout[i]);

   var   str=afmout[i].replace(/a/g,"Α")
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



      data.setValue(i, 0, str);
      data.setValue(i, 1, posoint);



      }


  var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
  chart.draw(data, {legend:'bottom',is3D:true,fontSize:12,width:customwidthchartdiv,
          height: customheightchartdiv,colors:['green','yellow','red','blue','orange','grey','purple','olive','magenta','cyan','teal','black','navy','maroon','lime','violet','coral','sienna']});

google.visualization.events.addListener(
chart, 'ready', function() {
removeElement();
});

}
else{

     removeElement();
   jQuery('#myModal').modal('toggle');
}


      }

}

function parsedate(){

datefrom=document.getElementById("from").value;
dateto=document.getElementById("to").value;

if(datefrom==dateto){ jQuery('#myModal6').modal('toggle');}
else{
var erase=document.getElementById('erase');
var chart=document.getElementById('chart_div');
erase.removeChild(chart);

var eraselinks=document.getElementById('eraselinks');
var decisions=document.getElementById('decisions');
eraselinks.removeChild(decisions);

    call.abort();

var newdiv=document.createElement('div');

if(viewportwidth>1300){
customwidth=25;
newdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

if(viewportwidth<1100){
customwidth=-25;
newdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

if(viewportwidth<1000){
customwidth=-35;
newdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

if(viewportwidth<890){
customwidth=-85;
newdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

if(viewportwidth<810){
customwidth=-105;
newdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}
newdiv.setAttribute('id','chart_div');
erase.appendChild(newdiv);

newdiv=document.createElement('div');
newdiv.setAttribute('id','decisions');
customwidth5=(((viewportwidth-114)/4)*1.1)+57+((viewportwidth-114)/2.3)*1.05;
newdiv.setAttribute('style','width:'+customwidth5+'px;')
eraselinks.appendChild(newdiv);
////////////////////////////////////////

jQuery("#loading").show();

google.load("visualization", "1", {packages:["corechart"]});


var i;
var dateout=new Array();
var posoout=new Array();

var count=0;
jQuery.noConflict();
var cou=1;
twitcou=1;

jQuery(document).ready(function(){
     			call=jQuery.ajax({
				type: "GET",
				url: "InnerMunDateParser?mun="+mun+"&datefrom="+datefrom+"&dateto="+dateto,
				dataType: "xml",
				success: function(xml) {

                                        jQuery(xml).find('item').each(function(){

						var unit = jQuery(this).find('date').text();
						var poso = jQuery(this).find('poso').text();

                                               dateout[count]=unit;
                                               posoout[count]=poso;
                                               count++;
					});

                                         jQuery(xml).find('url').each(function(){


						var doc = jQuery(this).find('doc').text();
						var dap = jQuery(this).find('dap').text();
                                                var sub = jQuery(this).find('sub').text();
docen=doc.substring(34,doc.size);
doc2=doc.substring(34,doc.size);
           doc2=doc2.replace(/a/g,"Α")
           doc2=doc2.replace(/b/g,"Β")
           doc2=doc2.replace(/c/g,"Ψ")
           doc2=doc2.replace(/d/g,"Δ")
           doc2=doc2.replace(/e/g,"Ε")
           doc2=doc2.replace(/f/g,"Φ")
           doc2=doc2.replace(/g/g,"Γ")
           doc2=doc2.replace(/h/g,"Η")
           doc2=doc2.replace(/i/g,"Ι")
           doc2=doc2.replace(/j/g,"Ξ")
           doc2=doc2.replace(/k/g,"Κ")
           doc2=doc2.replace(/l/g,"Λ")
           doc2=doc2.replace(/m/g,"Μ")
           doc2=doc2.replace(/n/g,"Ν")
           doc2=doc2.replace(/o/g,"Ο")
           doc2=doc2.replace(/p/g,"Π")
           doc2=doc2.replace(/q/g,"Θ")
           doc2=doc2.replace(/r/g,"Ρ")
           doc2=doc2.replace(/s/g,"Σ")
           doc2=doc2.replace(/t/g,"Τ")
           doc2=doc2.replace(/u/g,"Υ")
           doc2=doc2.replace(/v/g,"Β")
           doc2=doc2.replace(/w/g,"Ω")
           doc2=doc2.replace(/x/g,"Χ")
           doc2=doc2.replace(/y/g,"Υ")
           doc2=doc2.replace(/z/g,"Ζ")

suben=sub;
           sub=sub.replace(/a/g,"Α")
           sub=sub.replace(/b/g,"Β")
           sub=sub.replace(/c/g,"Ψ")
           sub=sub.replace(/d/g,"Δ")
           sub=sub.replace(/e/g,"Ε")
           sub=sub.replace(/f/g,"Φ")
           sub=sub.replace(/g/g,"Γ")
           sub=sub.replace(/h/g,"Η")
           sub=sub.replace(/i/g,"Ι")
           sub=sub.replace(/j/g,"Ξ")
           sub=sub.replace(/k/g,"Κ")
           sub=sub.replace(/l/g,"Λ")
           sub=sub.replace(/m/g,"Μ")
           sub=sub.replace(/n/g,"Ν")
           sub=sub.replace(/o/g,"Ο")
           sub=sub.replace(/p/g,"Π")
           sub=sub.replace(/q/g,"Θ")
           sub=sub.replace(/r/g,"Ρ")
           sub=sub.replace(/s/g,"Σ")
           sub=sub.replace(/t/g,"Τ")
           sub=sub.replace(/u/g,"Υ")
           sub=sub.replace(/v/g,"Β")
           sub=sub.replace(/w/g,"Ω")
           sub=sub.replace(/x/g,"Χ")
           sub=sub.replace(/y/g,"Υ")
           sub=sub.replace(/z/g,"Ζ")

footermain=document.getElementById('decisions');

customwidth=(((viewportwidth-114)/4)*1.1)+57;
customwidth1=(viewportwidth-114)/2.3;
line=document.createElement('div');
line.innerHTML=('__________________________________________________________________________________________________');
line.setAttribute('id','line');
line.setAttribute('style','margin-left:'+customwidth+'px;width:'+customwidth1+'px;');
footermain.appendChild(line);

customwidth=(((viewportwidth-114)/4)*1.1)+57;
if(viewportwidth>=1280){customwidth1=((viewportwidth-114)/2.3)*0.68;}
if((viewportwidth<1280) && (viewportwidth>=1100)){customwidth1=((viewportwidth-114)/2.3)*0.65;}
if((viewportwidth<1100) && (viewportwidth>=950)){customwidth1=((viewportwidth-114)/2.3)*0.62;}
if((viewportwidth<950) && (viewportwidth>=800)){customwidth1=((viewportwidth-114)/2.3)*0.59;}
if(viewportwidth<800){customwidth1=((viewportwidth-114)/2.3)*0.53;}
dec=document.createElement('div');
dec.setAttribute('id','dec');
dec.setAttribute('style','margin-left:'+customwidth+'px;width:'+customwidth1+'px;');
dec.innerHTML=cou+"."+sub;
footermain.appendChild(dec);

customwidth2=customwidth1+customwidth+12;
if(viewportwidth<930){customwidth3=((viewportwidth-114)/2.3)*0.15;}
else{customwidth3=((viewportwidth-114)/2.3)*0.16;}
if(viewportwidth<826){customwidth3=((viewportwidth-114)/2.3)*0.12;}
cost=document.createElement('div');
cost.setAttribute('id','cost');
cost.innerHTML=dap+'&euro;';
cost.setAttribute('style','margin-left:'+customwidth2+'px;width:'+customwidth3+'px;');
footermain.appendChild(cost);

customwidth4=customwidth2+customwidth3+10;
dl=document.createElement('div');
a=document.createElement('a');
a.setAttribute('href','http://static.diavgeia.gov.gr/doc/'+doc2);
a.setAttribute('target','_blank');
img=document.createElement('img');
a.appendChild(img);
img.setAttribute('src','imgs/download.png');
dl.setAttribute('id','dl');
dl.setAttribute('style','margin-left:'+customwidth4+'px');
dl.setAttribute('data-original-title','Download the pdf');
dl.appendChild(a);
footermain.appendChild(dl);

jQuery('#dl').tooltip();

customwidth5=customwidth4+20;
warn=document.createElement('div');
warn.setAttribute('id','warn');
warn.setAttribute('style','margin-left:'+customwidth5+'px');
warn.setAttribute('data-original-title','Vote');
img2=document.createElement('img');
img2.setAttribute('src','imgs/warning_icon.png');
img2.setAttribute('onclick', "voted(" +'"' + docen +'"'+','+'"' + dap +'"'+','+'"' + suben +'"'+ ");");
img2.setAttribute('style','cursor:pointer');
warn.appendChild(img2);
footermain.appendChild(warn);

jQuery('#warn').tooltip();

customwidth6=customwidth5+20;
tweet=document.createElement('div');
tweet.setAttribute('id','tweet');
tweet.setAttribute('style','margin-left:'+customwidth6+'px;cursor:pointer;');
tweet.setAttribute('data-original-title','Share via Twitter');
tweet.setAttribute('onclick','tweetfunc("'+doc2+'")');
a2=document.createElement('a');
a2.setAttribute('id','twitter'+cou);
a2.setAttribute('target','_blank');
img3=document.createElement('img');
img3.setAttribute('src','imgs/twitter-bird.png');
a2.appendChild(img3);
tweet.appendChild(a2);
footermain.appendChild(tweet);

jQuery('#tweet').tooltip();


cou++;					});

    drawChart();

				},
                                 async:   true
			});
		});


function drawChart() {
if(count!=0){
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'ΜΟΝΑΔΑ');
        data.addColumn('number', 'ΔΑΠΑΝΗ');
        data.addRows(count);
        for(i=0;i<count;i++){


      posoint=parseFloat(posoout[i]);

      data.setValue(i, 0, dateout[i]);
      data.setValue(i, 1, posoint);



      }
var options = {
    colors:['blue','yellow'],
            focusTarget:'caregory',
            width:customwidthchartdiv,
          height: customheightchartdiv,
          legend:'bottom'
        };

       var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
        chart.draw(data, options);

google.visualization.events.addListener(
chart, 'ready', function() {
removeElement();
});

}
else{

     removeElement();
    jQuery('#myModal6').modal('toggle');
}


      }




}

}
