
function initShowMap(map){
	SysService.doPost({},SysService.urls.initMapRegionsUrl,function(res){
		console.log(res);
		if(res){
			var regionArr = res.regionPointsVoList;
			for(let i = 0;i<regionArr.length;i++){
				var tmpRegion = regionArr[i].mapRegion;
				var resPoints = regionArr[i].mapPoints;
				//map show 
				var tmpPoints = [];
				for(let j=0;j<resPoints.length;j++){
					tmpPoints.push(new BMap.Point(resPoints[j].lng,resPoints[j].lat));
				}
				
				
				var polygon = new BMap.Polygon(tmpPoints,{strokeColor:"blue", strokeWeight:2, strokeOpacity:0.5,fillColor:setLvl(tmpRegion.levelSt)});
				//polygon.setFillColor("CC0099");
				//polygon.setFillColor(setLvl(tmpRegion.levelSt));
				console.log(setLvl(tmpRegion.levelSt));
				
				initPol(polygon,tmpRegion,map,tmpPoints[0]);
				
				map.addOverlay(polygon);  
				
			}
		}
	});
}

function initPol(pol,tmpRegion,map,point){
	pol.addEventListener('click',function(){
		
	});
	
	pol.addEventListener('mouseover',function(){
		var opts = {
				  width : 200,     // 信息窗口宽度
				  height: 100,     // 信息窗口高度
				  title : "基本信息" , // 信息窗口标题
				  enableMessage:true//设置允许信息窗发送短息
				}
		var infoWindow = new BMap.InfoWindow("<label>名称</label>&nbsp;&nbsp;"+tmpRegion.regionName+"<br>"
				+"<label>编码</label>&nbsp;&nbsp;"+tmpRegion.regionCode+"<br>"
				+"<label>均价</label>&nbsp;&nbsp;"+tmpRegion.price+"<br>", opts); 
		map.openInfoWindow(infoWindow,point);
	});
	
	//pol.addEventListener('mouseout',function(){});
}

function setLvl(lvl){
	switch(lvl){
		case "1":{
			return "red";
		}
		case "2":{
			return "blue";
		}
		default:{
			return "66CCFF";
		}
	}
}









