package com.components.yaml;

import com.iwaf.framework.BasePage;

public class CategoryData {
	
	public String Name;
	public String Name1;
	
	
	public static CategoryData fetch(String key){
		BasePage pageObj = new BasePage();
		CategoryData obj = pageObj.getCommand().loadYaml(key, "data-pool/Category_Data.yaml");
		return obj;
	}
}

