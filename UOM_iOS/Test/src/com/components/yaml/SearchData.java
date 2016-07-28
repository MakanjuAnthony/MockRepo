package com.components.yaml;

import com.iwaf.framework.BasePage;

public class SearchData  {
	
	public String keyword;
	public String keyword2;
	public String keyword1;
	
	@SuppressWarnings("deprecation")
	public static SearchData fetch(String key){
	BasePage pageObj = new BasePage();
	SearchData obj = pageObj.getCommand().loadYaml(key, "data-pool/Search_Data.yaml");
		return obj;
	}
}
