/**
 * Project Name:disconf-demo
 * File Name:ReloadConfig.java
 * Package Name:com.auggie.config
 * Date:2017年8月31日下午1:42:56
 * Copyright (c) 2017, All Rights Reserved.
 * Company:东方金融-上海房产
 *
*/

package com.auggie.config;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;

/**
 * Describe:(描述).
 * ClassName:ReloadConfig <br/>
 * Date:     2017年8月31日 下午1:42:56 <br/>
 * @author   auggie
 * @version  
 * @since    JDK 1.8	 
 */
@Service
@Scope("singleton")
@DisconfFile(filename = "testyml.yml")
public class YmlConfig {
	
//	private static YmlConfig ymlConfig;
	
//	public YmlConfig() {
//		
//	}
	
//	public static YmlConfig getInstance() {
//		if(ymlConfig == null){
//			synchronized (YmlConfig.class) {
//				if(ymlConfig == null){
//					ymlConfig = new YmlConfig();
//				}
//			}
//		}
//		return ymlConfig;
//	}
	
	private String ymlsay;
	
	@DisconfFileItem(name = "hello.ymlsay", associateField = "ymlsay")
	public String getYmlsay() {
		return ymlsay;
	}
	
	public void setYmlsay(String ymlsay) {
		this.ymlsay = ymlsay;
	}

}

