package com.components.yaml;

import com.iwaf.framework.BasePage;

public class PrepItemData {
	
	public String  ProductName;
	public String  UPC ;
	public String  Pack;
	public String  Size;
	public String  Weight;
	public String  Price;
	public String  ProductBrand;
	
	@SuppressWarnings("deprecation")
	public static PrepItemData fetch(String key){
		BasePage pageObj = new BasePage();
		PrepItemData obj = pageObj.getCommand().loadYaml(key, "data-pool/PrepItem_Data.yaml");
		return obj;
	}
}

