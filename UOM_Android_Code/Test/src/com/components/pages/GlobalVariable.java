package com.components.pages;

import io.appium.java_client.ios.IOSDriver;

import java.util.Set;

import org.testng.Assert;


import com.components.repository.SiteRepository;
import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;
import com.components.pages.HomePage;

public class GlobalVariable extends SitePage{

	public static String drivePath="/Users/jinita_jose/Desktop/ScreenShots_Android/WF/";
	public static String pathExtension=".png";
	
	public static String string1="Success";
	public static String string2="Issue";
	
	public GlobalVariable(SiteRepository repository)
	{
		super(repository);
	}

}


