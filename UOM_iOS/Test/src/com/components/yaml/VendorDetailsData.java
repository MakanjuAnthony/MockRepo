package com.components.yaml;

import com.iwaf.framework.BasePage;

public class VendorDetailsData {
	
	public String VendorName;
	public String PhoneNum;
	public String Address;
	public String ContactInfo;
	public String Email;
	public String Note;
	
	@SuppressWarnings("deprecation")
	public static VendorDetailsData fetch(String key){
		BasePage pageObj = new BasePage();
		VendorDetailsData obj = pageObj.getCommand().loadYaml(key, "data-pool/VendorDetails_Data.yaml");
		return obj;
	}
}

