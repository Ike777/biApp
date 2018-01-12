//绘制多边形
function addPolygon(){
	
	var points = [];
	var markers = [];
	
	//添加点击事件 获取坐标
	function drawItem(e){
		//alert(e.point.lng + ", " + e.point.lat);
		console.log(e.point.lng + ", " + e.point.lat);
		points.push(new BMap.Point(e.point.lng,e.point.lat));
		
		//
		var marker = new BMap.Marker(new BMap.Point(e.point.lng,e.point.lat));
		map.addOverlay(marker); 
		markers.push(marker);
		
		if(points.length == 4){
			var polygon = new BMap.Polygon(points,{strokeColor:"blue", strokeWeight:2, strokeOpacity:0.5});
			map.addOverlay(polygon);  
			
			points=[];
			
			for(let i = 0;i<markers.length;i++){
				map.removeOverlay(markers[i]);
			}
			markers=[];
		}
		
	}
	map.addEventListener("click", drawItem);
	
	//map.removeEventListener("click", showInfo);消除事件
	
	
}