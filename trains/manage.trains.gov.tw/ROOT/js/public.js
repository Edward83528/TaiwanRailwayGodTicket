$(document).ready(function(){
	//sidebarclick
	$a = 0;
	$("#top").click(function() {
		if($a == 0){
			$(".inner").animate({
				height : "0px",
				opacity : '0',			
			})
			$(".down").css({
				borderRight:"3px solid #fff",
 				borderBottom:"3px solid #fff",	
 				borderLeft:"0px",
 				borderTop:"0px",
 				top: "15px"				
			})
			$(".inner>a").css({"display":"none"})
			$a++;
		}else{
			$(".inner").animate({
				height : "107px",
				opacity : '1',			
			})
			$(".down").css({
				borderRight:"0px",
 				borderBottom:"0px",
 				borderLeft:"3px solid #fff",
 				borderTop:"3px solid #fff",	
 				top: "18px"					
			})
			$(".inner>a").css({"display":"inline-block"})
			$a--;
		}
	});

	$(".text1").fadeIn()
	$(".text2").delay(200).fadeIn()
	$(".text3").delay(400).fadeIn()
	$(".text4").delay(600).fadeIn()
	$(".text5").delay(800).fadeIn()
	$(".text6").delay(1000).fadeIn()
	$(".text7").delay(1200).fadeIn()

	$("#imgOne").fadeIn()
	$("#imgTwo").delay(300).fadeIn()
	$("#imgThr").delay(600).fadeIn()
	$("#imgFou").delay(900).fadeIn()
	$("#imgFiv").delay(1200).fadeIn()
})

