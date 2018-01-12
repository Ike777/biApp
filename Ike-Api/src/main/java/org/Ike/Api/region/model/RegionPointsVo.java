package org.Ike.Api.region.model;

import java.io.Serializable;
import java.util.List;

import org.Ike.Api.points.model.MapPoints;

public class RegionPointsVo implements Serializable{

	private static final long serialVersionUID = 1L;

	private MapRegion mapRegion;
	
	private List<MapPoints> mapPoints;

	public MapRegion getMapRegion() {
		return mapRegion;
	}

	public void setMapRegion(MapRegion mapRegion) {
		this.mapRegion = mapRegion;
	}

	public List<MapPoints> getMapPoints() {
		return mapPoints;
	}

	public void setMapPoints(List<MapPoints> mapPoints) {
		this.mapPoints = mapPoints;
	}
	
	
	
}
