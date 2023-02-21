
	(function (){  
	    document.onmousemove=function (e){ var ob=document.getElementById("foo").style; ob.left=e.pageX+15+"px"; ob.top=e.pageY+15+"px";}
	    document.write("<img src='https://tistory1.daumcdn.net/tistory/4694508/skin/images/hai1.gif' id='foo' style='position:absolute; transition:all 0.3s ease-in'>");
	 }());

	 let hitListPage = 0;
	 
	 let hitListNextButton = document.querySelector(".next");
	 let hitListPrevButton = document.querySelector(".prev");
	 let hitListContent = document.querySelector(".songContent");
	 
	 hitListNextButton.addEventListener("click", ()=>
	 {
		if(hitListPage >= 0 || hitListPage <= 4)
		{
			hitListPage++;
			
			hitListContent.classList.add("songContentPage" + hitListPage);
			
			for(let i = 0; i <= 4; i++)
			{
				if(i == hitListPage)
				{
					continue;
				}
				else
				{
					hitListContent.ClassList.remove("songContentPage" + i);
				}
			}
		}
	});
	
	hitListPrevButton.addEventListener("click", ()=>
	 {
		if(hitListPage >= 0 || hitListPage <= 4)
		{
			hitListPage--;
			
			hitListContent.classList.add("songContentPage" + hitListPage);
			
			for(let i = 0; i <= 4; i++)
			{
				if(i == hitListPage)
				{
					continue;
				}
				else
				{
					hitListContent.ClassList.remove("songContentPage" + i);
				}
			}
		}
	});