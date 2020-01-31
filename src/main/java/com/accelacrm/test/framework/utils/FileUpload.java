package com.accelacrm.test.framework.utils;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.accelacrm.test.framework.selenium.exception.FrameworkException;
import com.accelacrm.test.pages.BasePage;

public class FileUpload {

	private static final Logger log = LogManager.getLogger(FileUpload.class);

	/**
	 * getDocumentPath : To get document path
	 * 
	 * @param documentName : document name in string format
	 * @return returns document path
	 */
	public String getDocumentPath(String documentName) {
		String filePath = null;
		try {
			log.info(String.format("Getting %s document info", documentName));
			URL jarUrl = ClassLoader.getSystemClassLoader().getResource(".");
			String jarPath = URLDecoder.decode(jarUrl.getPath(), "UTF-8");
			File file = new File(jarPath + BasePage.documentLocation + documentName);
			filePath = file.getPath();

		} catch (Exception ex) {
			throw new FrameworkException(ex.toString());
		}
		return filePath;
	}
}
