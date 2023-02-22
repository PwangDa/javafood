window.onload=function(){
	$("#cli").on("click",cli)
	
	}

function cli(){
	var tex = ($("select[name=option] option:selected").text());
	location.href="javafood?javafood=m$option="+tex+"&point="+$('#potion').val();
}