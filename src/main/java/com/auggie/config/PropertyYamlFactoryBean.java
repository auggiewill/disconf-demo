/**
 * Project Name:disconf-demo
 * File Name:PropertyYamlFactoryBean.java
 * Package Name:com.auggie.config
 * Date:2017年9月1日上午11:19:45
 * Copyright (c) 2017, All Rights Reserved.
 * Company:东方金融-上海房产
 *
*/

package com.auggie.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.auggie.utils.YamlUtils;
import com.baidu.disconf.client.store.DisconfStoreProcessor;
import com.baidu.disconf.client.store.DisconfStoreProcessorFactory;
import com.baidu.disconf.client.store.processor.model.DisconfValue;

/**
 * Describe:(描述).
 * ClassName:PropertyYamlFactoryBean <br/>
 * Date:     2017年9月1日 上午11:19:45 <br/>
 * @author   auggie
 * @version  
 * @since    JDK 1.8	 
 */
public class PropertyYamlFactoryBean {
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void injectLoactions(List<String> fileNames) {
		
		List<Resource> resources = new ArrayList<Resource>();
		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver =
                new PathMatchingResourcePatternResolver();
		DisconfStoreProcessor disconfStoreProcessor = DisconfStoreProcessorFactory.getDisconfStoreFileProcessor();
		fileNames.forEach(fileName -> {
			fileName = fileName.trim();
//			String realFileName = getFileName(fileName);
			try {
				Resource[] resourceList = pathMatchingResourcePatternResolver.getResources(fileName);
                for (Resource resource : resourceList) {
                    resources.add(resource);
                }
			} catch (IOException e) {
			}
			
		});
		resources.forEach(resource -> {
			PropertySource source;
			try {
				source = YamlUtils.loadResourceYamlMode(resource);
				disconfStoreProcessor.inject2Store("testyml.yml", new DisconfValue(null, (Map<String, Object>) source.getSource()));
			} catch (IOException e) {
			}
		});
	}
	
	private String getFileName(String fileName) {

        if (fileName != null) {
            int index = fileName.indexOf(':');
            if (index < 0) {
                return fileName;
            } else {

                fileName = fileName.substring(index + 1);

                index = fileName.lastIndexOf('/');
                if (index < 0) {
                    return fileName;
                } else {
                    return fileName.substring(index + 1);
                }

            }
        }
        return null;
    }

}

