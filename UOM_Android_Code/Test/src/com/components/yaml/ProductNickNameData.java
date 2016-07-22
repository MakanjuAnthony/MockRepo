package com.components.yaml;

import com.iwaf.framework.BasePage;

public class ProductNickNameData {
	
	public String  NickName;
	
	
	@SuppressWarnings("deprecation")
	public static ProductNickNameData fetch(String key){
		BasePage pageObj = new BasePage();
		ProductNickNameData obj = pageObj.getCommand().loadYaml(key, "data-pool/ProductNickName_Data.yaml");
		return obj;
	}
}

