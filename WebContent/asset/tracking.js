$(document).ready(
function(){
	
$('#btn').click(function(){
	$.getJSON("SearchByTrackingIdJSON",{ajax:true,tid:$('#tid').val()},function(data){
	var h='<table border=1>';
	h+='<tr><th>Trancation Id</th><th>Date</th><th>Time</th><th>Description</th><th>Location</th></tr>';
	$.each(data,function(i,item){
		h+='<tr><td>'+item.TRACKINGTRANSACTIONID+'</td><td>'+item.TDATE+'</td><td>'+item.TTIME+'</td><td>'+item.DESCRIPTION+'</td><td>'+item.LAT+","+item.LNG+"</td></tr>";
		
	});	 
    h+="</table>";	
	$('#result').html(h);	
	});

});	

});