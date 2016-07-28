package com.components.yaml;

import com.iwaf.framework.BasePage

;

public class ListData {
	
	public String ListName;
	public String CatName;
	public int Pdt1;
	public int Pdt2;
	public int UnCatPdt1;
	public int UnCatPdt2;
	public int UnCatPdt3;
	public String FoodPrice;
	public String NonFoodPrice;
	public String FoodPdt1;
	public String NonFoodPdt1;
	
	@SuppressWarnings("deprecation")
	public static ListData fetch(String key){
		BasePage pageObj = new BasePage();
		ListData obj = pageObj.getCommand().loadYaml(key, "data-pool/List_Data.yaml");
		return obj;
	}
}

