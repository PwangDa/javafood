 (function () {
            document.onmousemove = function (e) {
                var ob = document
                    .getElementById("foo")
                    .style;
                ob.left = e.pageX + 15 + "px";
                ob.top = e.pageY + 15 + "px";
            }
            document.write(
                "<img src='https://tistory1.daumcdn.net/tistory/4694508/skin/images/hai1.gif' i" +
                "d='foo' style='position:absolute; transition:all 0.3s ease-in; z-index: 1;'>"
            );
        }());
window.onload = function(){
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            $('#re').on('click', function () {
                $('#end').attr('disabled', true);
            })
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            let c = false;
            function aj(key, callback, chak) {
                let xml = new XMLHttpRequest();
                xml.open('get', 'http://localhost:8080/javafood_team/aj?' + key);
                xml.send();
                xml.onload = function () {
                    let z = 0;
                    c = xml.responseText;
                    if (c != 1) {
                        z = 1;
                        alert('사용가능.');
                    } else {
                        z = 0;
                        alert('사용중입니다.');
                    }
                    callback(z, chak);
                }
            }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            function fn(call, chak) {
                call != 1
                    ? $(chak).prop('checked', false)
                    : $(chak).prop('checked', true);
                let j = 0;
                for (let i = 0; i < $('.ch').length; i++) {
                    if ($('.ch')[i].checked == true) 
                        j++;
                    }
                j == 4
                    ? $('#end').attr('disabled', false)
                    : $('#end').attr('disabled', true);
            }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            $('#idbutt').on('click', function () {
                aj("id=" + $('#Id1').val(), fn, '#ch1');
            })
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            $("#pwbutt").on("click", function () {
                if ($("#pw1").val() == $("#pw2").val()) {
                    alert("비밀번호가 일치합니다.");
                    fn(1, '#ch2');
                } else {
                    alert("잘못입력 하셨습니다.");
                    fn(0, '#ch2');
                }
            })
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            $("#nicbutt").on("click", function () {
                aj("nic=" + $('#nic').val(), fn, '#ch3');
            })
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            $("#mailbutt").on("click", function () {
                aj('email=' + $('#email').val(), fn, '#ch4')
            })
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            $("#pnbutt").on("click", function () {
                let pn = 'pn=' + $('#pn1').val() + "-" + $('#pn2').val();
                aj(pn, fn, '#ch6');
            })
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            $("#phonebutt").on("click", function () {
                let phone = 'phone=' + $('#phone1').val() + "-" + $('#phone2').val() + "-" + $(
                    '#phone3'
                ).val();
                aj(phone, fn, '#ch7');
            })
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

function notlogin(){
	alert('로그인을 하셔야합니다.')
    location.href = 'javafood?javafood=4';
}

function urseout(out){
	if (out == 1)  alert('회원이 정상적으로 탈퇴되었습니다.')
	else alert('회원탈퇴가 실패하였습니다.')
	}
	
function but() {
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
            location.href = 'javafood?javafood=5&remove=1';
        },
        error: function () {
            alert("이미지 저장 실패")
        }
    })
}

function outt(id){
	if (confirm('정말 로그아웃을 하겠습니까?')) 
		location.href = 'javafood?javafood=5&iid='+id
    else 
    	alert('취소하였습니다.');
    }

        function out (id) {
            var li1 = confirm('정말로 회원탈퇴를 하실건가요?');
            var li2 = false;
            var li3 = false;
            var li4 = false;
            var li5 = false;
            var li6 = false;
            if (li1 === true) 
                li2 = confirm('한번 탈퇴하면 되돌릴수가 업습니다!')
            if (li2 === true) 
                li3 = confirm('그래도 하시겠습니까?')
            if (li3 === true) 
                li4 = confirm('다시한번 생각해 주세요.')
            if (li4 === true) 
                li5 = confirm('마지막 기회 입니다.')
            if (li5 === true) 
                li6 = confirm('진짜?')
            if (li6 === true) {
                alert('회원탈퇴를 합니다.ㅜㅜ')
                location.href = 'javafood?javafood=5&idd='+id;
            }
        }
        
function replay(id){
	location.href = 'javafood?javafood=5&usre='+id
}

function hit(num){
	var id = $('#id').val()
	console.log(num)
	console.log("실행");
	$.ajax({
		type : 'get',
		url : 'http://localhost:8080/javafood_team/aj?id1='+id+'&num='+num,
		data: 'text'
	})
}