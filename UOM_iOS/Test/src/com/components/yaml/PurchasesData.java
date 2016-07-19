package com.components.yaml;

import com.iwaf.framework.BasePage

;

public class PurchasesData {
	
	public String  InvoiceNumber;
	public String InvoiceTotal;
	public String ExpenseAmount;
	

	
	@SuppressWarnings("deprecation")
	public static PurchasesData fetch(String key){
		BasePage pageObj = new BasePage();
		PurchasesData obj = pageObj.getCommand().loadYaml(key, "data-pool/Purchases_Data.yaml");
		return obj;
	}
}

