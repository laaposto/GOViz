google.load("visualization", "1", {packages:["corechart"]});
jQuery.noConflict();
var tag1gr;
var poso1;

var tag2gr;
var poso2;

var tag3gr;
var poso3;

var tag4gr;
var poso4;

var tag5gr;
var poso5;

jQuery(document).ready(function(){
     			 jQuery.ajax({
				type: "GET",
				url: "TopTagsSortUniversities",
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

stop1=text.indexOf('@');
stop2=text.indexOf('#');
stop3=text.indexOf('$');
stop4=text.indexOf('%');
stop5=text.indexOf('^');
stop6=text.indexOf('&');
stop7=text.indexOf('*');
stop8=text.indexOf('(');
stop9=text.indexOf('!');


tag1gr=textgr.substring(0,stop1);
poso1=text.substring(stop1+1,stop2);

tag2gr=textgr.substring(stop2+1,stop3);
poso2=text.substring(stop3+1,stop4);

tag3gr=textgr.substring(stop4+1,stop5);
poso3=text.substring(stop5+1,stop6);

tag4gr=textgr.substring(stop6+1,stop7);
poso4=text.substring(stop7+1,stop8);

tag5gr=textgr.substring(stop8+1,stop9);
poso5=text.substring(stop9+1,text.length);


    drawChart();

				},
                                 async:   true
			});
		});


function drawChart() {

var data = new google.visualization.DataTable();
        data.addColumn('string', 'ΕΝΟΤΗΕΣ');
        data.addColumn('number', tag1gr);
        data.addColumn('number', tag2gr);
        data.addColumn('number', tag3gr);
        data.addColumn('number', tag4gr);
        data.addColumn('number', tag5gr);

      data.addRows(1);
        data.setValue(0, 0, "ΕΝΟΤΗΤΕΣ");

          posoint1=parseFloat(poso1);
          data.setValue(0, 1, posoint1);

          posoint2=parseFloat(poso2);
          data.setValue(0, 2, posoint2);

          posoint3=parseFloat(poso3);
          data.setValue(0, 3, posoint3);

          posoint4=parseFloat(poso4);
          data.setValue(0, 4, posoint4);

          posoint5=parseFloat(poso5);
          data.setValue(0, 5, posoint5);




 var options = {
          colors:['green','yellow','red','blue','orange'],
          //focusTarget:'category',
          tooltip: {showColorCode:true},
          width:customwidthtoptags,
          height: 170,
          backgroundColor:'grey',
          legend:{position:'bottom'},
          hAxis:{textPosition:'none'},
          title:"Οι πιο δαπανηρές κατηγορίες",
          titleTextStyle:{color: 'white',fontSize:11 }

        };

        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }

