// javascript ver. <--- vanilla JS (순수 자바스크립트, Pure Javascript)
// 버거메뉴 클릭하면 .vp-wrap를 display: block 하는 명령
const MOBILE = document.querySelector("#btn_menu");
const CLOSE = document.querySelector("#btn_close");
const VPWRAP = document.querySelector(".vp-wrap");

MOBILE.addEventListener("click", function(){
	VPWRAP.style.display="block";
});


CLOSE.addEventListener("click", function(){
	VPWRAP.style.display="none";
});
// jquery ver : jQuery CDN 먼저 호출! 그리고 나서~
/* var MOBILE = $("#m_open");
var VPWRAP = $(".vp-wrap");
MOBILE.click(function(){
	VPWRAP.css("display", "block");
}) */