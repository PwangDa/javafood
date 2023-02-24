$("#di").hide();

$("#cli").on("click",function (){
	var tex = $('#opt').val();
	var pot = $('#pot').val();
	location.href="javafood?javafood=m&opt="+tex+"&pot="+pot
	})
		
$('#spa').on('mouseover',function(){
	$('#di').slideDown();
})

$('#di').on('mouseleave',function(){
	$('#di').slideUp();
})
