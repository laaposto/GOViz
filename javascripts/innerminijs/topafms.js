customwidthtoptags=(viewportwidth-114)/3.7;
var mun1gr;
var poso1;

var mun2gr;
var poso2;

var mun3gr;
var poso3;

var mun4gr;
var poso4;

var mun5gr;
var poso5;


jQuery.ajax({
				type: "GET",
				url: "InnerMunTopAfmMinistries?mun="+mun,
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
stop6=text.indexOf('+');
stop7=text.indexOf('*');
stop8=text.indexOf('>');
stop9=text.indexOf('!');


mun1gr=textgr.substring(0,stop1);
poso1=text.substring(stop1+1,stop2);

mun2gr=textgr.substring(stop2+1,stop3);
poso2=text.substring(stop3+1,stop4);

mun3gr=textgr.substring(stop4+1,stop5);
poso3=text.substring(stop5+1,stop6);

mun4gr=textgr.substring(stop6+1,stop7);
poso4=text.substring(stop7+1,stop8);

mun5gr=textgr.substring(stop8+1,stop9);
poso5=text.substring(stop9+1,text.length);






drawChart2();
			},
                                 async:   true
			});


function drawChart2() {

var data2 = new google.visualization.DataTable();
        data2.addColumn('string', 'ΑΦΜ');
        data2.addColumn('number', mun1gr);
        data2.addColumn('number', mun2gr);
        data2.addColumn('number', mun3gr);
        data2.addColumn('number', mun4gr);
        data2.addColumn('number', mun5gr);

        data2.addRows(1);
        data2.setValue(0, 0, "ΑΦΜ");

          posoint1=parseFloat(poso1);
          data2.setValue(0, 1, posoint1);

          posoint2=parseFloat(poso2);
          data2.setValue(0, 2, posoint2);

          posoint3=parseFloat(poso3);
          data2.setValue(0, 3, posoint3);

          posoint4=parseFloat(poso4);
          data2.setValue(0, 4, posoint4);

          posoint5=parseFloat(poso5);
          data2.setValue(0, 5, posoint5);




 var options = {
          colors:['green','yellow','red','blue','orange'],
          tooltip: {showColorCode:true},
          width:customwidthtoptags,
          height: 170,
          backgroundColor:'grey',
          legend:{position:'bottom'},
          hAxis:{textPosition:'none'},
          title:"Τα πιο δαπανηρά ΑΦΜ",
          titleTextStyle:{color: 'white',fontSize:11 }

        };

        var chart2 = new google.visualization.ColumnChart(document.getElementById('chart_div3'));
        chart2.draw(data2, options);
      }
