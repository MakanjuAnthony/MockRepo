package com.components.pages;

import com.components.repository.SiteRepository;

public class GlobalVariable extends SitePage {

	public static String drivePath = "/Users/jinita_jose/Desktop/ScreenShots_Android/WF/";
	public static String pathExtension = ".png";

	public static String string1 = "Success";
	public static String string2 = "Issue";

	public GlobalVariable(SiteRepository repository) {
		super(repository);
	}

}
