///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
(function (){  
	document.onmousemove=function (e){ 
		var ob=document.getElementById("foo").style;
		ob.left=e.pageX+15+"px"; 
		ob.top=e.pageY+15+"px";
		}
	document.write("<img src='https://tistory1.daumcdn.net/tistory/4694508/skin/images/hai1.gif' id='foo' style='position:absolute; transition:all 0.3s ease-in; z-index: 1;'>");
	}());
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
function loging(){
			location.href='javafood?javafood=m';
	let time=3;
	$("#time").append(time);
	setInterval (function(){
		console.log(time);
		time--;
		$("#time").text(time);
		if (time==0){
		}
	},1000)
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
window.onload=function() {
	if(document.querySelector('.btnClear')!=null){
	    var btnClear = document.querySelector('.btnClear');
	    btnClear.addEventListener('click', function(){
			console.log('123');
	        btnClear.parentNode.querySelector('.tt').value = "";
	    })
	}
    
    $('.logo-img').on('click',function(){
		location.href='javafood?javafood=m'
	})
    
	$('#but').on(function (){
		var url = $("#form").attr("action");
		var form = $('#form')[0];
		var formData = new FormData(form);
		$.ajax({
			url: url,
			type: 'POST',
			data: formData,
			contentType: false,
			processData: false,
			cache: false,
			success: function () {
				alert("이미지 저장 성공")
				location.href='javafood?javafood=4&membership=O';
			},
			error: function () {
				alert("이미지 저장 실패")
			}
		})
	})
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	$('#re').on('click',function(){$('#end').attr('disabled',true);})
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	let c= false;
	function aj(key, callback, chak){
		let xml = new XMLHttpRequest();
	    xml.open('get','http://localhost:8080/javafood_team/aj?'+key);
	    xml.send();
	    xml.onload=function(){
	    	let z = 0;
	        c=xml.responseText;
	        if(c!=1){
	        	z=1;
	            alert('사용가능.');
	        }else{
	        	z=0;
	            alert('사용중입니다.');
	        }
	        callback(z,chak);
	    }
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	function fn(call,chak){
		call!=1?$(chak).prop('checked',false):$(chak).prop('checked',true);
		let j=0;
		for(let i =0; i<$('.ch').length; i++){
			if($('.ch')[i].checked==true)j++;
		}
		j==6?$('#end').attr('disabled',false):$('#end').attr('disabled',true);
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	$('#idbutt').on('click',function(){aj("id="+$('#Id1').val(), fn, '#ch1');})
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	$("#pwbutt").on("click",function(){
		if($("#pw1").val() == $("#pw2").val()){
			alert("비밀번호가 일치합니다.");
			fn(1,'#ch2');
		}else {
			alert("잘못입력 하셨습니다.");
			fn(0,'#ch2');
		}
	})
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	$("#nicbutt").on("click",function(){aj("nic="+$('#nic').val(), fn, '#ch3');})
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	$("#mailbutt").on("click",function(){aj('email='+$('#email').val(), fn, '#ch4')})
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	$("#pnbutt").on("click",function(){
		let pn = 'pn='+$('#pn1').val() +"-"+ $('#pn2').val();
		aj(pn,fn,'#ch6');
	})
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	$("#phonebutt").on("click",function(){
		let phone = 'phone='+$('#phone1').val() + "-" + $('#phone2').val()+ "-" + $('#phone3').val();
		aj(phone,fn,'#ch7');
	})
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	let search = document.querySelector("span.user_search");
	let search2=document.querySelector("div.search");
	search.addEventListener("click", function(){
		search2.classList.toggle("hidden");
	});
}
