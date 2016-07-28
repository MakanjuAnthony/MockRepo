package com.components.yaml;

import com.iwaf.framework.BasePage;

public class NonSyscoItemData {
	
	public String  ProductName;
	public String  UPC ;
	public String  Pack;
	public String  Size;
	public String  Weight;
	public String  Price;
	public String  ProductBrand;
	public String  Category1;
	public String  Category2;
	@SuppressWarnings("deprecation")
	public static NonSyscoItemData fetch(String key){
		BasePage pageObj = new BasePage();
		NonSyscoItemData obj = pageObj.getCommand().loadYaml(key, "data-pool/NonSyscoItem_Data.yaml");
		return obj;
	}
}

