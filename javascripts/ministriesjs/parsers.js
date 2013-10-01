google.load('visualization', '1', {packages: ['geomap']});
var call;
var i;
var dimosout=new Array();
var posoout=new Array();
var latout=new Array();
var longout=new Array();
var tagout=new Array();
var posotagout=new Array();
var count=0;
var count2=0

var dimosout2=new Array();
var posoout2=new Array();
var latout2=new Array();
var longout2=new Array();
var count3=0;

jQuery.noConflict();

jQuery(document).ready(function(){

			 call=jQuery.ajax({
				type: "GET",
				url: "ParseGlobalAllMinistries",
				dataType: "xml",
				success: function(xml) {

                                        jQuery(xml).find('item').each(function(){


						var dimos = jQuery(this).find('dimos').text();
						var poso = jQuery(this).find('poso').text();
                                                var lat = jQuery(this).find('lat').text();
                                                var longi = jQuery(this).find('long').text();

                                               dimosout[count]=dimos;
                                               posoout[count]=poso;
                                               latout[count]=lat;
                                               longout[count]=longi;
                                               count++;
					});

                                        jQuery(xml).find('tags').each(function(){


						var tag = jQuery(this).find('tag').text();
						var posotag = jQuery(this).find('poso').text();


                                               tagout[count2]=tag;
                                               posotagout[count2]=posotag;
                                               count2++;
					});
    drawMap();
				},
                                 async:   true
			});
		});

function drawMap() {
if(count!=0){

      var data = new google.visualization.DataTable();
      data.addRows(count);
      data.addColumn('number', 'LATITUDE', 'Latitude');
      data.addColumn('number', 'LONGITUDE', 'Longitude');
      data.addColumn('string', 'HOVER', 'HoverText');
      data.addColumn('number', 'ΔΑΠΑΝΗ', 'COST');

      for(i=0;i<count;i++){

      posoint=parseFloat(posoout[i]);
      latfloat=parseFloat(latout[i]);
      longfloat=parseFloat(longout[i]);


      data.setValue(i, 0, latfloat);
      data.setValue(i, 1, longfloat);
      data.setValue(i, 3, posoint);

      var  str=dimosout[i].replace(/a/g,"Α")
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



      data.setValue(i, 2, str);



      }

      var options = {
      region: 'GR',
      displayMode: 'markers',
      colorAxis: {colors: ['#99FF66','#339900','#FFFF66','#FFFF00','#FF3300','#FF0000']},
      backgroundColor:'#ffffff',
      datalessRegionColor:'white',
      height:viewportheight-90,
      width: viewportwidth-180,
      sizeAxis:{maxSize:15,minSize:2},
      keepAspectRatio:false

    };

var geomap = new google.visualization.GeoChart(
      document.getElementById('map_canvas'));
  geomap.draw(data, options);



google.visualization.events.addListener(
geomap, 'ready', function() {
removeElement();
createtags();
createmunicipalities();


});


google.visualization.events.addListener(
geomap, 'select', function() {

   var clicked=geomap.getSelection();
   var item=clicked[0];
   location.href = "innermini.html?mun="+dimosout[item.row];

});

}
else{
    removeElement();
   jQuery('#myModal2').modal('toggle');
   }

}

function parsetags(tagnamepar){

count3=0;

    var erase=document.getElementById('erase');
    var map=document.getElementById('map_canvas');
    erase.removeChild(map);

    call.abort();

    var newdiv=document.createElement('div');
    newdiv.setAttribute('id','map_canvas');
    erase.appendChild(newdiv);

    jQuery("#loading").show();


    jQuery.noConflict();

jQuery(document).ready(function(){

			 call=jQuery.ajax({
				type: "GET",
				url: "ParseTagMinistries?tagname="+tagnamepar,
				dataType: "xml",
				success: function(xml) {

                                        jQuery(xml).find('item').each(function(){


						var dimos = jQuery(this).find('dimos').text();
						var poso = jQuery(this).find('poso').text();
                                                var lat = jQuery(this).find('lat').text();
                                                var longi = jQuery(this).find('long').text();

                                               dimosout2[count3]=dimos;
                                               posoout2[count3]=poso;
                                               latout2[count3]=lat;
                                               longout2[count3]=longi;
                                               count3++;
					});


    drawMap();
				},
                                 async:   true
			});
		});

function drawMap() {
if(count3!=0){

      var data = new google.visualization.DataTable();
      data.addRows(count3);
      data.addColumn('number', 'LATITUDE', 'Latitude');
      data.addColumn('number', 'LONGITUDE', 'Longitude');
      data.addColumn('string', 'HOVER', 'HoverText');
      data.addColumn('number', 'ΔΑΠΑΝΗ', 'COST');

      for(i=0;i<count3;i++){

      posoint=parseFloat(posoout2[i]);
      latfloat=parseFloat(latout2[i]);
      longfloat=parseFloat(longout2[i]);


      data.setValue(i, 0, latfloat);
      data.setValue(i, 1, longfloat);
      data.setValue(i, 3, posoint);

      var  str=dimosout2[i].replace(/a/g,"Α")
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



      data.setValue(i, 2, str);



      }

     var options = {
      region: 'GR',
      displayMode: 'markers',
      colorAxis: {colors: ['#99FF66','#339900','#FFFF66','#FFFF00','#FF3300','#FF0000']},
      backgroundColor:'#ffffff',
      datalessRegionColor:'white',
      height:viewportheight-90,
      width: viewportwidth-180,
      sizeAxis:{maxSize:15,minSize:2},
      keepAspectRatio:false

    };

var geomap = new google.visualization.GeoChart(
      document.getElementById('map_canvas'));
  geomap.draw(data, options);



google.visualization.events.addListener(
geomap, 'ready', function() {
removeElement();
createmunsintags();


});


google.visualization.events.addListener(
geomap, 'select', function() {

   var clicked=geomap.getSelection();
   var item=clicked[0];
   location.href = "innermini.html?mun="+dimosout2[item.row];

});

}
else{
    removeElement();
    jQuery('#myModal2').modal('toggle');
}

}




}

