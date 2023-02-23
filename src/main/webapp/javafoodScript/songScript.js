/**
 * 
 */
 
		  function refresh() {
			 
				/* setTimeout('location.reload()', 60000); */
				window.scrollTo({ left: 0, top: 0, behavior: "smooth"});
		
		} 
////////////////////////////////////////////////////////////////////////////////////////		
		
		function nowtime() {
			let now = new Date();

			let hour = now.getHours();
			let minute = now.getMinutes();
			let second = now.getSeconds();

			if (hour < 10) {
				hour = "0" + hour;
			}
			if (minute < 10) {
				minute = "0" + minute;
			}
			if (second < 10) {
				second = "0" + second;
			}

			document.getElementById("timebox").value = hour + ":" + minute
					+ ":" + second;
				//console.log(123, document.getElementById("timebox"));
		}
		window.addEventListener("load", function() {
			//HTML이 다 load가 완료 됐을 때 실행됨
			nowtime();
			setInterval(function() {
			
				nowtime();
			}, 1000); //1초 단위
		})
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		function addhit(id,song) {
			console.log("id = "+id)
			console.log("song = "+song)
			location.href = 'javafood?javafood=2&play='+song+'&id='+id;
			
		}
		
		/*function playVideo() {
			
			const login = "${login}";
			const songnumber = "${dao.songnumber}";
			
			// 유튜브 동영상 ID 생성
			const videoId = "유튜브 동영상 ID를 여기에 입력하세요";
			// 유튜브 동영상 링크 생성
  			const videoUrl = `https://www.youtube.com/watch?v=${videoId}`;
  			// 새 창에서 유튜브 동영상 링크 열기
 			 window.open(videoUrl, '_blank');
		}*/
	let save = document.querySelectorAll("img.save");
	for(let i=0; i<save.length; i++){
		save[i].addEventListener("click",function(){
			console.log("담기 버튼 눌림");
			
			save[i].parentNode.target = "_blank";
			save[i].parentNode.submit();
		});
	}
//////////////////////////////////////////////////////////////////////////////////////////
			/* refresh(); */
			
			 let checkbox = document.querySelectorAll(".but");
		     let cont2 = document.getElementsByClassName("table3");

		        for(let x=0; x<checkbox.length; x++){
		            checkbox[x].addEventListener('click', function(event){
		                //부모의 부모가져오기
		                // console.log("커렌트타켓"+event.currentTarget.parentNode.parentNode);
		                let checked = checkbox[x].checked;
		    
		                for(let i=0; i<cont2.length; i++){
		                    if(checked == true){
		                        console.log(checked);
		                        event.currentTarget.parentNode.style.backgroundColor = 'rgba(86, 86, 86, 0.423)';           
		                    }else if(checked == false){
		                        console.log(checked);
		                        event.currentTarget.parentNode.style.backgroundColor = 'transparent';
		                    }
		            }
		            });
		        }
		
         (function (){  
            document.onmousemove=function (e){ var ob=document.getElementById("foo").style; ob.left=e.pageX+15+"px"; ob.top=e.pageY+15+"px";}
            document.write("<img src='https://tistory1.daumcdn.net/tistory/4694508/skin/images/hai1.gif' id='foo' style='position:absolute; transition:all 0.3s ease-in; z-index: 1;'>");
         }());
