/**
 * 
 */


function checkSelectAll() {

	const checkboxes = document.querySelectorAll('input[name="chk"]');
	const checked = document.querySelectorAll('input[name="chk"]:checked');
	const selectAll = document.querySelector('input[name="selectall"]');

	if (checkboxes.length === checked.length) {
		selectAll.checked = true;
	} else {
		selectAll.checked = false;
	}

}
function selectAll(selectAll) {
	console.log(selectAll.checked);
	const checkboxes = document.getElementsByName("chk");

	checkboxes.forEach((checkbox) => {
		checkbox.checked = selectAll.checked;
	})
}
// 체크박스에서 값 가져오기
function getCheckedValue() {
	const checkboxes = document.querySelectorAll('input[name="chk"]:checked');
	let checkedValue = [];
	checkboxes.forEach((checkbox) => {
		checkedValue.push(checkbox.value);
	})
	console.log(checkedValue)
	return checkedValue;
}
//
(function() {
	document.onmousemove = function(e) { var ob = document.getElementById("foo").style; ob.left = e.pageX + 15 + "px"; ob.top = e.pageY + 15 + "px"; }
	document.write("<img src='https://tistory1.daumcdn.net/tistory/4694508/skin/images/hai1.gif' id='foo' style='position:absolute; transition:all 0.3s ease-in; z-index: 1;'>");
}());