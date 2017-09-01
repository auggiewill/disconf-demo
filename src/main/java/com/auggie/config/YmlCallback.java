/**
 * Project Name:disconf-demo
 * File Name:ReloadCallback.java
 * Package Name:com.auggie.config
 * Date:2017年8月31日上午10:42:50
 * Copyright (c) 2017, All Rights Reserved.
 * Company:东方金融-上海房产
 *
*/

package com.auggie.config;

import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Service;

import com.auggie.utils.YamlUtils;
import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import com.baidu.disconf.client.store.DisconfStoreProcessor;
import com.baidu.disconf.client.store.DisconfStoreProcessorFactory;
import com.baidu.disconf.client.store.processor.model.DisconfValue;

/**
 * Describe:(描述).
 * ClassName:ReloadCallback <br/>
 * Date:     2017年8月31日 上午10:42:50 <br/>
 * @author   auggie
 * @version  
 * @since    JDK 1.8	 
 */
@Service
@Scope("singleton")
@DisconfUpdateService(confFileKeys = "testyml.yml")
public class YmlCallback implements IDisconfUpdate {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void reload() throws Exception {
		PropertySource source = YamlUtils.loadNormalYamlMode("testyml.yml");
		
		DisconfStoreProcessor disconfStoreProcessor = DisconfStoreProcessorFactory.getDisconfStoreFileProcessor();
		
		//注解读取的field是从store中读取
		//所以reload需要将新的value inject到store中取
		disconfStoreProcessor.inject2Store("testyml.yml", new DisconfValue(null, (Map<String, Object>) source.getSource()));
		System.out.println("yml,reload");
	}

}

