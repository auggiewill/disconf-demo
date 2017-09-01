/**
 * Project Name:disconf-demo
 * File Name:InstantiationPostProcessor.java
 * Package Name:com.auggie.config
 * Date:2017年8月31日下午3:44:45
 * Copyright (c) 2017, All Rights Reserved.
 * Company:东方金融-上海房产
 *
*/

package com.auggie.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Describe:(描述).
 * ClassName:InstantiationPostProcessor <br/>
 * Date:     2017年8月31日 下午3:44:45 <br/>
 * @author   auggie
 * @version  
 * @since    JDK 1.8	 
 */
@Configuration
public class InstantiationPostProcessor implements ApplicationListener<ContextRefreshedEvent> {
	private static final Logger logger = LoggerFactory.getLogger(InstantiationPostProcessor.class);

	@Autowired
	private YmlConfig ymlConfig;
	
	@Autowired
	private ReloadConfig reloadConfig;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent() == null) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					try {
						while(true) {
							Thread.sleep(5000);
							logger.info("reload mes:{}", reloadConfig.getMes());
							logger.info("testyml mes:{}", ymlConfig.getYmlsay());
						}
					} catch (Exception e) {
					}
				}
			}).start();
		}
		
	}

}

