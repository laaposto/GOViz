var mun=gup('mun');
 mun=mun.replace(/%20/g," ");
           var  mungr=mun.replace(/a/g,"Α")
           mungr=mungr.replace(/b/g,"Β")
           mungr=mungr.replace(/c/g,"Ψ")
           mungr=mungr.replace(/d/g,"Δ")
           mungr=mungr.replace(/e/g,"Ε")
           mungr=mungr.replace(/f/g,"Φ")
           mungr=mungr.replace(/g/g,"Γ")
           mungr=mungr.replace(/h/g,"Η")
           mungr=mungr.replace(/i/g,"Ι")
           mungr=mungr.replace(/j/g,"Ξ")
           mungr=mungr.replace(/k/g,"Κ")
           mungr=mungr.replace(/l/g,"Λ")
           mungr=mungr.replace(/m/g,"Μ")
           mungr=mungr.replace(/n/g,"Ν")
           mungr=mungr.replace(/o/g,"Ο")
           mungr=mungr.replace(/p/g,"Π")
           mungr=mungr.replace(/q/g,"Θ")
           mungr=mungr.replace(/r/g,"Ρ")
           mungr=mungr.replace(/s/g,"Σ")
           mungr=mungr.replace(/t/g,"Τ")
           mungr=mungr.replace(/u/g,"Υ")
           mungr=mungr.replace(/v/g,"Β")
           mungr=mungr.replace(/w/g,"Ω")
           mungr=mungr.replace(/x/g,"Χ")
           mungr=mungr.replace(/y/g,"Υ")
           mungr=mungr.replace(/z/g,"Ζ")


var title=document.getElementById('title');
title.innerHTML=mungr;
title.setAttribute('style','float:right');

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

jQuery('#apo').popover(options);
jQuery('#toptags').popover();
jQuery('#desicions').popover();
jQuery('#topafms').popover(options);


customtop=viewportheight/5.3;
myModal=document.getElementById('myModal');
myModal.setAttribute('style','margin: -'+customtop+'px 0 0 -280px');

myModal2=document.getElementById('myModal2');
myModal2.setAttribute('style','margin: -'+customtop+'px 0 0 -280px');

myModal3=document.getElementById('myModal3');
myModal3.setAttribute('style','margin: -'+customtop+'px 0 0 -280px');

myModal4=document.getElementById('myModal4');
myModal4.setAttribute('style','margin: -'+customtop+'px 0 0 -280px');

myModal5=document.getElementById('myModal5');
myModal5.setAttribute('style','margin: -'+customtop+'px 0 0 -280px');

myModal6=document.getElementById('myModal6');
myModal6.setAttribute('style','margin: -'+customtop+'px 0 0 -280px');

customwidth=viewportwidth-37;
mynavbar=document.getElementById('mynavbar');
mynavbar.setAttribute('style','width:'+customwidth+'px');

customwidth=viewportwidth/4.4;
loadimg=document.getElementById('loadimg');
loadimg.setAttribute('style','width:'+customwidth+'px');

customtop=viewportheight/2.8;
customleft=viewportwidth/2.8;
if(viewportwidth<=787){customleft=viewportwidth/3.2;}
if(viewportheight<529){customtop=viewportheight/3.2;}
loading=document.getElementById('loading');
loading.setAttribute('style','top:'+customtop+'px;left:'+customleft+'px;');

if(viewportwidth>1300){
customwidth=25;
chartdiv=document.getElementById('chart_div');
chartdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

if(viewportwidth<1100){
customwidth=-25;
chartdiv=document.getElementById('chart_div');
chartdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

if(viewportwidth<1000){
customwidth=-35;
chartdiv=document.getElementById('chart_div');
chartdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

if(viewportwidth<890){
customwidth=-65;
chartdiv=document.getElementById('chart_div');
chartdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

if(viewportwidth<810){
customwidth=-105;
chartdiv=document.getElementById('chart_div');
chartdiv.setAttribute('style','margin-left:'+customwidth+'px;');
}

customleft=viewportwidth-197;
datepickers=document.getElementById('datepickers');
datepickers.setAttribute('style','left:'+customleft+'px;');

customleft=viewportwidth-141;
show=document.getElementById('show');
show.setAttribute('style','left:'+customleft+'px;font:bold 12px Arial, "Helvetica Neue", Helvetica, Arial, sans-serif;');

customheight=viewportheight-268;//-41
customwidth=viewportwidth;//-17
if(viewportwidth<=1042){customheight=viewportheight-279};
footertitle=document.getElementById('footertitle');
footertitle.setAttribute('style','width:'+customwidth+'px;top:'+customheight+'px;');

customheight=viewportheight-216;//46
customwidth=viewportwidth;//-17
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

chartdiv3=document.getElementById('chart_div3');
chartdiv3.setAttribute('style','margin-left:'+customwidth3+'px;');

customwidth=viewportwidth*0.8;
load2=document.getElementById('load2');
load2.setAttribute('style','margin-left:'+customwidth+'px;');

customwidth=viewportwidth*0.13;
load=document.getElementById('load');
load.setAttribute('style','margin-left:'+customwidth+'px;');

customwidth4=(((viewportwidth-114)/4)*1.1)+57;
desicions=document.getElementById('desicions');
desicions.setAttribute('style','margin-left:'+customwidth4+'px');

customwidth5=customwidth2+((viewportwidth-114)/2.3)*1.05;
topafms=document.getElementById('topafms');
topafms.setAttribute('style','margin-left:'+customwidth5+'px');

customwidth=customwidth5;
decisions=document.getElementById('decisions');
decisions.setAttribute('style','width:'+customwidth+'px');





function gup( name )
{
  name = name.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
  var regexS = "[\\?&]"+name+"=([^&#]*)";
  var regex = new RegExp( regexS );
  var results = regex.exec( window.location.href );
  if( results == null )
    return "";
  else
    return results[1];
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

$(function() {
		var dates = jQuery( "#from, #to" ).datepicker({
                        dateFormat:'dd-mm-yy',
			maxDate: "+1",
                        minDate:'01-10-2010',
			numberOfMonths: 1,
			onSelect: function( selectedDate ) {
				var option = this.id == "from" ? "minDate" : "maxDate",
					instance = jQuery( this ).data( "datepicker" ),
					date = jQuery.datepicker.parseDate(
						instance.settings.dateFormat ||
						$.datepicker._defaults.dateFormat,
						selectedDate, instance.settings );
				dates.not( this ).datepicker( "option", option, date );
			}
		});
	});

function removeElement() {
         jQuery("#loading").hide();
}

function voted(doc,dap,sub){

  jQuery.ajax({
				type: "GET",
				url: "MunDecisionVotedMinistries?ada="+doc+"&dap="+dap+"&sub="+sub,
				dataType: "text",
				success: function(text) {

if(!(text=="OK")){ jQuery('#myModal4').modal('toggle');}
else{jQuery('#myModal3').modal('toggle');}


			},
                                 async:   true
			});


}

function vizclicked(vizby){

    var from=document.getElementById("from").value;
    var to=document.getElementById("to").value;

    if(from==""){ jQuery('#myModal2').modal('toggle');}
    else{if (to==""){jQuery('#myModal5').modal('toggle');}
            else{

   if(vizby=="uni"){parseunits();}
   if(vizby=="tag"){parsetags();}
   if(vizby=="afm"){parseafm();}
   if(vizby=="dat"){parsedate();}

           }
}
}

function showdate()
{

    var from=document.getElementById("from").value;
    var to=document.getElementById("to").value;

    if(from==""){ jQuery('#myModal2').modal('toggle');}
    else{if (to==""){jQuery('#myModal5').modal('toggle');}
            else{
var element = jQuery('.nav-tabs .active').html();

if(element[59]=="Μ"){parseunits();}
if(element[59]=="Θ"){parsetags();}
if(element[59]=="Α"){parseafm();}
if(element[59]=="Χ"){parsedate();}


           }
}

}

function tweetfunc(doc2){
    var login = "laaposto";
var api_key = "R_10c97be6da0d44e2a62d0178fb4bf899";
var long_url = "http://et.diavgeia.gov.gr/f/all/ada/"+doc2;

get_short_url(long_url, login, api_key, function(short_url) {
jQuery.getScript("http://platform.twitter.com/widgets.js");
window.open(
  'https://twitter.com/share?url='+short_url+'&text=Δείτε αυτή την απόφαση του Ελληνικού Δημοσίου(found via www.GOViz.gr)&via=GOViz&related=laaposto&lang=gr',
  '_blank'
);
});
}