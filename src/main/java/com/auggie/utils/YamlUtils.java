/**
 * Project Name:disconf-demo
 * File Name:YamlUtils.java
 * Package Name:com.auggie.utils
 * Date:2017年8月31日下午5:18:42
 * Copyright (c) 2017, All Rights Reserved.
 * Company:东方金融-上海房产
 *
*/

package com.auggie.utils;

import java.io.IOException;

import org.springframework.boot.env.PropertySourcesLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * Describe:(描述).
 * ClassName:YamlUtils <br/>
 * Date:     2017年8月31日 下午5:18:42 <br/>
 * @author   auggie
 * @version  
 * @since    JDK 1.8	 
 */
public class YamlUtils {

	public static PropertySource<?> loadNormalYamlMode(String yamlPath) throws IOException {
		
		PropertySource<?> propertySource = null;
		String location = "classpath:/" + yamlPath;
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource(location);
		String name = "applicationConfig: [" + location + "]";
		String group = "applicationConfig: [" + "profile=" + "]";
		propertySource = new PropertySourcesLoader().load(resource, group, name, null);
		return propertySource;
	}
	
public static PropertySource<?> loadResourceYamlMode(Resource resource) throws IOException {
		
		PropertySource<?> propertySource = null;
		resource.getFilename();
//		String location = "classpath:/" + yamlPath;
//		ResourceLoader resourceLoader = new DefaultResourceLoader();
//		Resource resource = resourceLoader.getResource(location);
//		String name = "applicationConfig: [" + location + "]";
//		String group = "applicationConfig: [" + "profile=" + "]";
		propertySource = new PropertySourcesLoader().load(resource, "", "", null);
		return propertySource;
	}
}

