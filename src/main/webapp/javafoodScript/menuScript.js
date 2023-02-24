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
function outt(id){
	if (confirm('정말 로그아웃을 하겠습니까?')) 
		location.href = 'javafood?javafood=5&iid='+id
    else 
    	alert('취소하였습니다.');
    }

