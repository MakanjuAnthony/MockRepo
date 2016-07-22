package com.components.yaml;

import com.iwaf.framework.BasePage;

public class SearchData  {
	
	public String keyword;
	//public String itemCode;
	public String keyword1;
	public String keyword3;
	public String keyword2;
	
	@SuppressWarnings("deprecation")
	public static SearchData fetch(String key){
	BasePage pageObj = new BasePage();
	SearchData obj = pageObj.getCommand().loadYaml(key, "data-pool/Search_Data.yaml");
		return obj;
	}
}
