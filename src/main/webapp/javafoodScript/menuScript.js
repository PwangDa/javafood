window.onload=function(){
	$("#cli").on("click",cli)
	
	}

function cli(){
	var tex = $('#opt').val();
	var pot = $('#pot').val();
	location.href="javafood?javafood=m&opt="+tex+"&pot="+pot;
}