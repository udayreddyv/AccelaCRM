package com.accelacrm.test.framework.selenium;

import com.accelacrm.test.framework.selenium.exception.FrameworkException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertiesLoader {

	private static final Logger log = LogManager.getLogger(PropertiesLoader.class);
	InputStream inputStream;

	public Properties loadProperties(String fileName) {
		log.info("Loading environment properties");
		Properties properties = new Properties();
		try {
			inputStream = PropertiesLoader.class.getResourceAsStream(fileName);
			properties.load(inputStream);
		} catch (Exception ex) {
			log.error("Failed to load environment properties");
			throw new FrameworkException(ex.toString());
		}
		return properties;
	}

	/**
	 * loadClassLevelData : To load class level data
	 * 
	 * @param iTestContext : ITestContext class object
	 * @return returns class level data map
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, String> loadClassLevelData(Class className) {
		log.info("Start of the method - loadClassLevelData");
		Map<String, String> classPropertiesDataMap = new HashMap<String, String>();
		try {
			log.info("Loading class level properties");
			log.info("**********CLASS NAME : " + className);
			String fileName = "/" + className.getName().replace(".", "/") + ".properties";
			log.info("**********FILE NAME : " + fileName);
			inputStream = PropertiesLoader.class.getResourceAsStream(fileName);
			Properties properties = new Properties();
			properties.load(inputStream);
			Map<Object, Object> classDataMap = properties;
			classPropertiesDataMap = (Map) classDataMap;
			inputStream.close();
			for (Entry<String, String> classPropertiesDataMapEntries : classPropertiesDataMap.entrySet()) {
				log.info(classPropertiesDataMapEntries.getKey() + " : " + classPropertiesDataMapEntries.getValue());
			}
		} catch (Exception ex) {
			log.error("Failed to load class level properties");
			log.error(ex.toString());
		}

		log.info("End of the method - loadClassLevelData");
		return classPropertiesDataMap;
	}

	/**
	 * loadMethodLevelData : To load method level data
	 * 
	 * @param iTestContext : ITestContext class object
	 * @return returns method level data map
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, String> loadMethodLevelData(Method method, ITestContext iTestContext) {
		log.info("Start of the method - loadMethodLevelData");
		Map<String, String> methodPropertiesDataMap = new HashMap<String, String>();
		try {
			log.info(String.format("Loading %s method level properties", method.getName()));
			String methodName = method.getName();
			String fileName = "/" + method.getDeclaringClass().getName().replace(".", "/") + "/"
					+ methodName + ".properties";
			log.info("FileName : " + fileName);
			inputStream = PropertiesLoader.class.getResourceAsStream(fileName);
			Properties properties = new Properties();
			properties.load(inputStream);
			Map<Object, Object> methodDataMap = properties;
			methodPropertiesDataMap = (Map) methodDataMap;
			inputStream.close();

			for (Entry<String, String> methodPropertiesDataMapEntries : methodPropertiesDataMap.entrySet()) {
				log.info(methodPropertiesDataMapEntries.getKey() + " : " + methodPropertiesDataMapEntries.getValue());
			}
		} catch (Exception ex) {
			log.error("Failed to load method level properties");
			log.error(ex.toString());
		}
		log.info("End of the method - loadMethodLevelData");
		return methodPropertiesDataMap;
	}
}
