
function initMapRegions(map){
	SysService.doPost({},SysService.urls.initMapRegionsUrl,function(res){
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
				
				
				var polygon = new BMap.Polygon(tmpPoints,{strokeColor:"blue", strokeWeight:2, strokeOpacity:0.5});
				//polygon.setFillColor("FFFFCC");
				
				map.addOverlay(polygon);  
				
			}
		}
	});
}