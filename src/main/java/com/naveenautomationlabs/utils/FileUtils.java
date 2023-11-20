package com.naveenautomationlabs.utils;

import java.util.HashMap;
import java.util.Map;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

public class FileUtils {

	WebDriver driver;

	public void setupFileDownload() {

		ChromeOptions option = new ChromeOptions();

		Map<String, Object> pref = new HashMap<>();

		String downloadPath = System.getProperty("java.io.tmpdir");
		
		pref.put("download.default.directory", "C:\\Users\\rajeev\\Downloads");

		option.setExperimentalOption("prefs", pref);

	}

	public boolean isFileAvailable(String fileName, int secondsToDownload) {
		try {
			Thread.sleep(secondsToDownload);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	
		File folder = new File("C:\\Users\\rajeev\\Downloads");
		// List the files on that folder
		File[] listOfFiles = folder.listFiles();
		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				if (listOfFile.getName().contains(fileName)) {
					System.out.println(listOfFile.getName());
					listOfFile.delete();
					return true;
				}
			}
		}
		return false;
	}
	public void uploadFile(WebDriver wd,By by,String filePath) {
		wd.findElement(by).sendKeys(filePath);
	}
}
