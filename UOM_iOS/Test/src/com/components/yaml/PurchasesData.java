package com.components.yaml;

import com.iwaf.framework.BasePage

;

public class PurchasesData {
	
	public String  InvoiceNumber;
	public String InvoiceTotal;

	public String Category1;
	public String Category2;
	public String ExpenseAmt1;
	public String ExpenseAmt2;
	public String Revenue1;
	public String Revenue2;
	public String ExpenseAmount;
	public String Day;
	public String Month;
	public String Year;
	public String InvTotal1;
	public String Suggcat;
	
	@SuppressWarnings("deprecation")
	public static PurchasesData fetch(String key){
		BasePage pageObj = new BasePage();
		PurchasesData obj = pageObj.getCommand().loadYaml(key, "data-pool/Purchases_Data.yaml");
		return obj;
	}
}

