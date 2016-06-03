package com.components.yaml;

import com.iwaf.framework.BasePage

;

public class UOMQuantityData {
	
	public String Quantity;
	public String UOM;
	

	
	public static UOMQuantityData fetch(String key){
		BasePage pageObj = new BasePage();
		UOMQuantityData obj = pageObj.getCommand().loadYaml(key, "data-pool/UOMQuantity_Data.yaml");
		return obj;
	}
}

