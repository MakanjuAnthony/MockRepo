package com.components.yaml;

import com.iwaf.framework.BasePage

;

public class ListData {
	
	public String ListName;
	

	
	public static ListData fetch(String key){
		BasePage pageObj = new BasePage();
		ListData obj = pageObj.getCommand().loadYaml(key, "data-pool/List_Data.yaml");
		return obj;
	}
}

