$(document).ready(function(){
		(function getdata(){
			North = [];
			South = [];
			$.ajax({
				cache:false,
				type:"get",
				url: "http://www.trains.com.tw:8080/billboards.jsp",
				success:function(data){
					var json = JSON.parse(data);
					function time(row,data) {
						var trainType = data.TrainClassificationID;
						switch (trainType) {
						case "1107":
							trainType = "普悠瑪號";
							img = "image/trains/train00.PNG";
							break;
						case "1102":
							trainType = "太魯閣號";
							img = "image/trains/train01.PNG";
							break;
						case "1100": case "1101": case "1103": case "1108":
							trainType = "自強號";
							img = "image/trains/train02.PNG";
							break;
						case "1110": case "1111": case "1114": case "1115":
							trainType = "莒光號";
							img = "image/trains/train03.PNG";
							break;
						case "1120": case "1131": case "1132": case"1140":
							trainType = "區間車";
							img = "image/trains/train04.PNG";
							break;
						default:
							trainType = "";
						}
						if (row % 5 == 0) {
							$(".box" + row + " span").addClass("animation");
							$(".box" + row + " img").addClass("animation");
							$(".box" + row + " img").attr("src", img);
							$(".box" + row + " .trainname").text(trainType);
							setTimeout(function(){$(".box" + row + " span")
								.removeClass("animation")
							$(".box" + row + " img").removeClass("animation");},300)
						}else if((row % 5) - 1 == 0) {
							setTimeout(function(){
								$(".box" + row + " span").addClass("animation");
								$(".box" + row + " .trip").text(data.TrainNo);
								setTimeout(function(){$(".box" + row + " span")
								.removeClass("animation")},300)
							},200)
						}else if((row % 5) - 2 == 0) {
							var arriveTime = data.ScheduledArrivalTime.substring(0,5);
							setTimeout(function(){
								$(".box" + row + " span").addClass("animation");
								$(".box" + row + " .arrivetime").text(arriveTime);
								setTimeout(function(){$(".box" + row + " span")
								.removeClass("animation")},300)
							},400)
						}else if((row % 5) - 3 == 0) {
							setTimeout(function(){
								$(".box" + row + " span").addClass("animation");
								$(".box" + row + " .place").text(data.EndingStationName.Zh_tw);
								setTimeout(function(){$(".box" + row + " span")
								.removeClass("animation")},300)
							},600)
						}else if((row % 5) - 4 == 0) {
							setTimeout(function(){
								$(".box" + row + " span").addClass("animation");
								$(".box" + row + " .state").text("晚"+data.DelayTime+"分");
								if(data.DelayTime=="0"){
									$(".box" + row + " .state").text("準點");
								}
								setTimeout(function(){$(".box" + row + " span")
								.removeClass("animation")},300)
							},800)
						}
					}
					for(var i=0; i<json.length;i++){
						if(json[i].Direction == 0){
							North.push(json[i]);
						}else{
							South.push(json[i]);
						}
					}
					console.log(North);
					console.log(South);
					
					for(var i=0; i<5; i++){
						time(i,North[0]);
					}
					setTimeout(function(){
						for(var i=0; i<5; i++){
							time(i+5,North[1]);
						}
					},1000)
					setTimeout(function(){
						for(var i=0; i<5; i++){
							time(i+10,North[2]);
						}
					},2000)	
					setTimeout(function(){
						for(var i=0; i<5; i++){
							time(i+15,North[3]);
						}
					},3000)	
					setTimeout(function(){
						for(var i=0; i<5; i++){
							time(i+20,North[4]);
						}
					},4000)
					
					setTimeout(function(){
						for(var i=0; i<5; i++){
							time(i + 25,South[0]);
						}	
						setTimeout(function(){
							for(var i=0; i<5; i++){
								time(i+30,South[1]);
							}
						},1000)
						setTimeout(function(){
							for(var i=0; i<5; i++){
								time(i+35,South[2]);
							}
						},2000)				
						setTimeout(function(){
							for(var i=0; i<5; i++){
								time(i+40,South[3]);
							}
						},3000)
						setTimeout(function(){
							for(var i=0; i<5; i++){
								time(i+45,South[4]);
							}
						},4000)
					},2000)
						setTimeout(getdata,10000);
				},
				error:function() {
					alert("網頁發生錯誤");
				}
			})
		})();
	
	});