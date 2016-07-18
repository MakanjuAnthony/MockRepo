package com.components.yaml;

import com.iwaf.framework.BasePage

;

public class LocationsData {
	
	public String LocationName;
	public String EditLocation;
	

	
	@SuppressWarnings("deprecation")
	public static LocationsData fetch(String key){
		BasePage pageObj = new BasePage();
		LocationsData obj = pageObj.getCommand().loadYaml(key, "data-pool/Locations_Data.yaml");
		return obj;
	}
}

