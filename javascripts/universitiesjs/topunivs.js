var mun1gr;
var poso1mun;

var mun2gr;
var poso2mun;

var mun3gr;
var poso3mun;

var mun4gr;
var poso4mun;

var mun5gr;
var poso5mun;

jQuery(document).ready(function(){
     			 jQuery.ajax({
				type: "GET",
				url: "TopMunSortUniversities",
				dataType: "text",
				success: function(text2) {
var textgr2=text2;

           textgr2=textgr2.replace(/a/g,"Α")
           textgr2=textgr2.replace(/b/g,"Β")
           textgr2=textgr2.replace(/c/g,"Ψ")
           textgr2=textgr2.replace(/d/g,"Δ")
           textgr2=textgr2.replace(/e/g,"Ε")
           textgr2=textgr2.replace(/f/g,"Φ")
           textgr2=textgr2.replace(/g/g,"Γ")
           textgr2=textgr2.replace(/h/g,"Η")
           textgr2=textgr2.replace(/i/g,"Ι")
           textgr2=textgr2.replace(/j/g,"Ξ")
           textgr2=textgr2.replace(/k/g,"Κ")
           textgr2=textgr2.replace(/l/g,"Λ")
           textgr2=textgr2.replace(/m/g,"Μ")
           textgr2=textgr2.replace(/n/g,"Ν")
           textgr2=textgr2.replace(/o/g,"Ο")
           textgr2=textgr2.replace(/p/g,"Π")
           textgr2=textgr2.replace(/q/g,"Θ")
           textgr2=textgr2.replace(/r/g,"Ρ")
           textgr2=textgr2.replace(/s/g,"Σ")
           textgr2=textgr2.replace(/t/g,"Τ")
           textgr2=textgr2.replace(/u/g,"Υ")
           textgr2=textgr2.replace(/v/g,"Β")
           textgr2=textgr2.replace(/w/g,"Ω")
           textgr2=textgr2.replace(/x/g,"Χ")
           textgr2=textgr2.replace(/y/g,"Υ")
           textgr2=textgr2.replace(/z/g,"Ζ")

stop1=text2.indexOf('@');
stop2=text2.indexOf('#');
stop3=text2.indexOf('$');
stop4=text2.indexOf('%');
stop5=text2.indexOf('^');
stop6=text2.indexOf('&');
stop7=text2.indexOf('*');
stop8=text2.indexOf('(');
stop9=text2.indexOf('!');


mun1gr=textgr2.substring(0,stop1);
poso1mun=text2.substring(stop1+1,stop2);

mun2gr=textgr2.substring(stop2+1,stop3);
poso2mun=text2.substring(stop3+1,stop4);

mun3gr=textgr2.substring(stop4+1,stop5);
poso3mun=text2.substring(stop5+1,stop6);

mun4gr=textgr2.substring(stop6+1,stop7);
poso4mun=text2.substring(stop7+1,stop8);

mun5gr=textgr2.substring(stop8+1,stop9);
poso5mun=text2.substring(stop9+1,text2.length);



    drawChart2();

				},
                                 async:   true
			});
		});


function drawChart2() {

var data2 = new google.visualization.DataTable();
        data2.addColumn('string', 'ΔΗΜΟΙ');
        data2.addColumn('number', mun1gr);
        data2.addColumn('number', mun2gr);
        data2.addColumn('number', mun3gr);
        data2.addColumn('number', mun4gr);
        data2.addColumn('number', mun5gr);

      data2.addRows(1);
        data2.setValue(0, 0, "ΔΗΜΟΙ");

          posoint1=parseFloat(poso1mun);
          data2.setValue(0, 1, posoint1);

          posoint2=parseFloat(poso2mun);
          data2.setValue(0, 2, posoint2);

          posoint3=parseFloat(poso3mun);
          data2.setValue(0, 3, posoint3);

          posoint4=parseFloat(poso4mun);
          data2.setValue(0, 4, posoint4);

          posoint5=parseFloat(poso5mun);
          data2.setValue(0, 5, posoint5);




 var options = {
          colors:['green','yellow','red','blue','orange'],
          //focusTarget:'category',
          tooltip: {showColorCode:true},
          width:customwidthtopmuns,
          height: 170,
          backgroundColor:'grey',
          legend:{position:'bottom'},
          hAxis:{textPosition:'none'},
          title:"Τα πιο δαπανηρά πανεπιστήμια",
          titleTextStyle:{color: 'white',fontSize:11 }

        };

        var chart2 = new google.visualization.ColumnChart(document.getElementById('chart_div2'));
        chart2.draw(data2, options);
      }

